package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.dialog.widget.MyAlertDialog;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.view.wheelcity.AddressData;
import com.geo.smallcredit.view.wheelcity.OnWheelChangedListener;
import com.geo.smallcredit.view.wheelcity.WheelView;
import com.geo.smallcredit.view.wheelcity.adapters.AbstractWheelTextAdapter;
import com.geo.smallcredit.view.wheelcity.adapters.ArrayWheelAdapter;
import com.geo.smallcredit.view.wheelview.WheelMain;
import com.geo.smallcredit.vo.ShenfengBean;

public class ShenFenActivity extends Activity implements OnClickListener,
		OnItemClickListener, OnItemSelectedListener {
	private Button btnBack, saveBtn;
	private TextView liveAdress, hujiAdress, lifeAddress;
	private EditText name, num, phoneNum, lifeAddress_desc;
	private TelephonyManager tm;// 获取手机 imei
	private LinearLayout mLine;
	private Spinner xueli, hunyin;
	private String cityTxt;
	private WheelMain wheelMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(ShenFenActivity.this);
		setContentView(R.layout.shenfen_info);
		tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
		initView();
		initClick();
		getData();
		// 点击外部键盘消失
		mLine = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mLine.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
		});
	}

	private void initClick() {

		btnBack.setOnClickListener(this);
		saveBtn.setOnClickListener(this);
		lifeAddress.setOnClickListener(this);

		xueli.setOnItemSelectedListener(this);
		hunyin.setOnItemSelectedListener(this);

	}

	private void initView() {

		btnBack = (Button) findViewById(R.id.shenfen_btn_back_do);
		saveBtn = (Button) findViewById(R.id.shenfen_info_savebtn);
		name = (EditText) findViewById(R.id.shenfen_info_name_edit);
		num = (EditText) findViewById(R.id.shenfen_info_shenfennum_edit);
		phoneNum = (EditText) findViewById(R.id.shenfen_info_mobile_edit);
		// address = (EditText) findViewById(R.id.shenfen_info_liveinfo_edit);
		// desc_address = (EditText)
		// findViewById(R.id.shenfen_info_household_info_edit);
		xueli = (Spinner) findViewById(R.id.shenfen_info_higheducation_spinner);
		hunyin = (Spinner) findViewById(R.id.shenfen_info_marry_spinner);
		lifeAddress = (TextView) findViewById(R.id.shenfen_info_liveaddresstxt);
		lifeAddress_desc = (EditText) findViewById(R.id.shenfen_info_liveinfo_edit);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.shenfen_btn_back_do:
			finish();
			break;

		case R.id.shenfen_info_liveaddresstxt:
			View view = dialogm();
			// final MyAlertDialog dialog = new
			// MyAlertDialog(ShenFenActivity.this);
			// String live = lifeAddress.getText().toString();
			final MyAlertDialog dialog1 = new MyAlertDialog(
					ShenFenActivity.this).builder().setView(view)
					.setNegativeButton("取消", new OnClickListener() {
						@Override
						public void onClick(View v) {

						}
					});
			dialog1.setPositiveButton("保存", new OnClickListener() {
				@Override
				public void onClick(View v) {

					// Toast.makeText(getApplicationContext(), cityTxt,
					// 1).show();
					lifeAddress.setText(cityTxt);
				}
			});
			dialog1.show();
			break;
		case R.id.shenfen_info_savebtn:
			/***
			 * 
			 * 姓名： username 身份证号： id_number 所在省： address_province 所在市：
			 * address_city 所在区县： address_district 详细地址： address_detail 邮箱：
			 * email userId:23233423-34-234-23-423-4-23
			 */
			String str_name = name.getText().toString().trim();
			String str_num = num.getText().toString().trim();
			String str_phoneNum = phoneNum.getText().toString().trim();
			String str_xueli = xueli.getSelectedItem().toString().trim();
			String str_hunyin = hunyin.getSelectedItem().toString().trim();
			String str_lifeAddress = lifeAddress.getText().toString().trim();
			String str_lifeAddress_desc = lifeAddress_desc.getText().toString()
					.trim();

			int netWorkType = CommonUtil
					.isNetworkAvailable(ShenFenActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(str_name) || str_name == null) {

					Toast.makeText(ShenFenActivity.this, "对不起，姓名也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_num) || str_num == null) {

					Toast.makeText(ShenFenActivity.this, "对不起，身份证也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_phoneNum)
						|| str_phoneNum == null) {
					Toast.makeText(ShenFenActivity.this, "对不起，手机号不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_xueli) || str_xueli == null) {
					Toast.makeText(ShenFenActivity.this, "对不起，您的学历没有填写",
							Toast.LENGTH_SHORT).show();
				} else if ("".equalsIgnoreCase(str_hunyin)
						|| str_hunyin == null) {
					Toast.makeText(ShenFenActivity.this, "对不起，您的婚姻状况没有填写",
							Toast.LENGTH_SHORT).show();
				} else if ("".equalsIgnoreCase(str_lifeAddress)
						|| str_lifeAddress == null) {
					ToastUtil.show(ShenFenActivity.this, "对不起，您的居住地址为空");
				} else if ("".equalsIgnoreCase(str_lifeAddress_desc)
						|| str_lifeAddress_desc == null) {
					ToastUtil.show(ShenFenActivity.this, "对不起，您的居住详址为空");
				} else {

					AjaxParams params = new AjaxParams();
					params.put("username", str_name);
					params.put("id_number", str_num);
					params.put("mobileno", str_phoneNum);
					params.put("education", str_xueli);
					params.put("marital_status", str_hunyin);
					params.put("residence_province", "");// 省市区
					params.put("residence_city", "");
					params.put("residence_districe", str_lifeAddress);
					params.put("residence_detail", str_lifeAddress_desc);// 详细地址
					params.put("userid", SharedPreferencesUtils.getString(
							ShenFenActivity.this, "userid", null));
					params.put("androidid",
							AppConfig.getAndroidId(ShenFenActivity.this));
					params.put("imei", AppConfig.getIMEI(ShenFenActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.USER_SHENGFEN_UPDATA, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil
											.show(ShenFenActivity.this, "上传失败");
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									Log.i("mytag", "身份认证返回===" + t.toString());
									ToastUtil
											.show(ShenFenActivity.this, "上传成功");
									finish();
								}

							});
				}

			} else {

				PromptManager.showNoNetWork(ShenFenActivity.this);

			}
			break;
		}
	}

	public void getData() {
		AjaxParams params = new AjaxParams();
		params.put("mobileno",
				SharedPreferencesUtils.getString(this, "mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(this, "userid", null));

		FinalHttp fh = new FinalHttp();

		fh.get(InternetURL.USER_SHENGFEN_READ, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);

						Log.i("mytag", "身份===返回==" + t.toString());

						ToastUtil.show(ShenFenActivity.this, "获取数据成功");

						ShenfengBean sf = GsonUtils.fromJson(t.toString(),
								ShenfengBean.class);

						Message msg = new Message();
						msg.what = 0x000;
						msg.obj = sf;
						handler.sendMessage(msg);

					}
				});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {

			case 0x000:

				ShenfengBean sfdata = (ShenfengBean) msg.obj;

				if (sfdata != null || !"".equals(sfdata)) {
					if (Integer.parseInt(sfdata.getStatus()) == 0) {
						name.setText(sfdata.getUsername());
						num.setText(sfdata.getIdNumber());
						phoneNum.setText(sfdata.getMobile());

						String xue = sfdata.getEducation();
						String hun = sfdata.getMaritalStatus();
						if ("初中".equals(xue)) {
							xueli.setSelection(0, true);
						} else if ("高中".equals(xue)) {
							xueli.setSelection(1, true);
						} else if ("中专".equals(xue)) {
							xueli.setSelection(2, true);
						} else if ("大专".equals(xue)) {
							xueli.setSelection(3, true);
						} else if ("本科".equals(xue)) {
							xueli.setSelection(4, true);
						} else if ("硕士".equals(xue)) {
							xueli.setSelection(5, true);
						} else if ("博士".equals(xue)) {
							xueli.setSelection(6, true);
						} else if ("博士后".equals(xue)) {
							xueli.setSelection(7, true);
						}

						if ("未婚".equals(hun)) {
							hunyin.setSelection(0, true);
						} else if ("已婚有子".equals(xue)) {
							hunyin.setSelection(1, true);
						} else if ("已婚无子".equals(xue)) {
							hunyin.setSelection(2, true);
						} else if ("其他".equals(xue)) {
							hunyin.setSelection(3, true);
						} // else if ("丧偶".equals(xue)) {
							// hunyin.setSelection(4, true);
							// }
						lifeAddress.setText(sfdata.getResidenceDistrict());
						lifeAddress_desc.setText(sfdata.getResidenceDetail());
					} else if (Integer.parseInt(sfdata.getStatus()) == 1) {
						ToastUtil
								.show(ShenFenActivity.this, "您还没有认证,请填写您的身份信息");
					}
				}
				break;
			}
		};
	};

	private View dialogm() {
		View contentView = LayoutInflater.from(ShenFenActivity.this).inflate(
				R.layout.wheelcity_cities_layout, null);
		final WheelView country = (WheelView) contentView
				.findViewById(R.id.wheelcity_country);
		country.setVisibleItems(3);
		country.setViewAdapter(new CountryAdapter(this));

		final String cities[][] = AddressData.CITIES;
		final String ccities[][][] = AddressData.COUNTIES;
		final WheelView city = (WheelView) contentView
				.findViewById(R.id.wheelcity_city);
		city.setVisibleItems(0);

		// 地区选择
		final WheelView ccity = (WheelView) contentView
				.findViewById(R.id.wheelcity_ccity);
		ccity.setVisibleItems(0);// 不限城市

		country.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				updateCities(city, cities, newValue);
				cityTxt = AddressData.PROVINCES[country.getCurrentItem()]
						+ " | "
						+ AddressData.CITIES[country.getCurrentItem()][city
								.getCurrentItem()]
						+ " | "
						+ AddressData.COUNTIES[country.getCurrentItem()][city
								.getCurrentItem()][ccity.getCurrentItem()];
			}
		});

		city.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				updatecCities(ccity, ccities, country.getCurrentItem(),
						newValue);
				cityTxt = AddressData.PROVINCES[country.getCurrentItem()]
						+ " | "
						+ AddressData.CITIES[country.getCurrentItem()][city
								.getCurrentItem()]
						+ " | "
						+ AddressData.COUNTIES[country.getCurrentItem()][city
								.getCurrentItem()][ccity.getCurrentItem()];
			}
		});

		ccity.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				cityTxt = AddressData.PROVINCES[country.getCurrentItem()]
						+ " | "
						+ AddressData.CITIES[country.getCurrentItem()][city
								.getCurrentItem()]
						+ " | "
						+ AddressData.COUNTIES[country.getCurrentItem()][city
								.getCurrentItem()][ccity.getCurrentItem()];
			}
		});

		country.setCurrentItem(1);// 设置北京
		city.setCurrentItem(1);
		ccity.setCurrentItem(1);
		return contentView;
	}

	/**
	 * Updates the city wheel
	 */
	private void updateCities(WheelView city, String cities[][], int index) {
		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(this,
				cities[index]);
		adapter.setTextSize(18);
		city.setViewAdapter(adapter);
		city.setCurrentItem(0);
	}

	/**
	 * Updates the ccity wheel
	 */
	private void updatecCities(WheelView city, String ccities[][][], int index,
			int index2) {
		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(this,
				ccities[index][index2]);
		adapter.setTextSize(18);
		city.setViewAdapter(adapter);
		city.setCurrentItem(0);
	}

	/**
	 * Adapter for countries
	 */
	private class CountryAdapter extends AbstractWheelTextAdapter {
		// Countries names
		private String countries[] = AddressData.PROVINCES;

		/**
		 * Constructor
		 */
		protected CountryAdapter(Context context) {
			super(context, R.layout.wheelcity_country_layout, NO_RESOURCE);
			setItemTextResource(R.id.wheelcity_country_name);
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			return view;
		}

		@Override
		public int getItemsCount() {
			return countries.length;
		}

		@Override
		protected CharSequence getItemText(int index) {
			return countries[index];
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {

		// String[] languages = getResources().getStringArray(R.array.mouth);
		// String str = languages[position];
		// Log.i("mytag","你点击了"+position+" ============   "+str);
		TextView t = (TextView) v;
		t.setTextColor(getResources().getColor(R.color.white));
		t.setTextSize(12);
		hintKbTwo();

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	// 此方法只是关闭软键盘
	public void hintKbTwo() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive() && getCurrentFocus() != null) {
			if (getCurrentFocus().getWindowToken() != null) {
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
	}
}
