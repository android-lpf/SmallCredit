package com.geo.smallcredit.activity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.geo.smallcredit.view.wheelview.JudgeDate;
import com.geo.smallcredit.view.wheelview.ScreenInfo;
import com.geo.smallcredit.view.wheelview.WheelMain;
import com.geo.smallcredit.vo.WorkBean;

public class WorkActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private Button imgBack, saveBtn;
	private EditText work_name,  work_telphone, work_adress_desc;
	private TextView address,work_time;
	private LinearLayout mLine;
	private Spinner work_xingzhi, work_salary, work_salary_other, home_revenue;
	private String cityTxt;
	WheelMain wheelMain;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(WorkActivity.this);
		setContentView(R.layout.work_info);
		initView();
		initClick();
		getData();

		// 显示时间
		Calendar calendar = Calendar.getInstance();
		work_time.setText(calendar.get(Calendar.YEAR) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH) + "");

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
		imgBack.setOnClickListener(this);
		saveBtn.setOnClickListener(this);
		address.setOnClickListener(this);
		work_time.setOnClickListener(this);
		work_xingzhi.setOnItemSelectedListener(this);
		work_salary.setOnItemSelectedListener(this);
		work_salary_other.setOnItemSelectedListener(this);
		home_revenue.setOnItemSelectedListener(this);
	}

	private void initView() {

		imgBack = (Button) findViewById(R.id.work_btn_back_do);
		saveBtn = (Button) findViewById(R.id.work_info_savebtn);
		work_name = (EditText) findViewById(R.id.work_info_companyeditname);
		work_telphone = (EditText) findViewById(R.id.work_info_telphone_edit);
		address = (TextView) findViewById(R.id.work_info_propertyadressedit);
		work_time = (TextView) findViewById(R.id.work_info_Entrytimeedit);
		work_adress_desc = (EditText) findViewById(R.id.work_info_propertyadressinfo_edit);
		work_xingzhi = (Spinner) findViewById(R.id.work_info_property_spinner);
		work_salary = (Spinner) findViewById(R.id.work_info_incomemouth_spinner);
		work_salary_other = (Spinner) findViewById(R.id.work_info_othermouthincome_spinner);
		home_revenue = (Spinner) findViewById(R.id.work_info_familyyearincome_spinner);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.work_btn_back_do:
			finish();
			break;

		case R.id.work_info_propertyadressedit:
			View view = dialogm();
			final MyAlertDialog dialog = new MyAlertDialog(WorkActivity.this);
			String live = address.getText().toString();
			final MyAlertDialog dialog1 = new MyAlertDialog(WorkActivity.this)
					.builder().setView(view)
					.setNegativeButton("取消", new OnClickListener() {
						@Override
						public void onClick(View v) {

						}
					});
			dialog1.setPositiveButton("保存", new OnClickListener() {
				@Override
				public void onClick(View v) {

					Toast.makeText(getApplicationContext(), cityTxt, 1).show();
					address.setText(cityTxt);
				}
			});
			dialog1.show();
			break;
		// 弹出选择时间
		case R.id.work_info_Entrytimeedit:
			LayoutInflater inflater = LayoutInflater.from(WorkActivity.this);
			final View timepickerview = inflater.inflate(R.layout.timepicker,
					null);
			ScreenInfo screenInfo = new ScreenInfo(WorkActivity.this);
			wheelMain = new WheelMain(timepickerview);
			wheelMain.screenheight = screenInfo.getHeight();
			String time = work_time.getText().toString();
			Calendar calendar = Calendar.getInstance();
			if (JudgeDate.isDate(time, "yyyy-MM-dd")) {
				try {
					calendar.setTime(dateFormat.parse(time));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			wheelMain.initDateTimePicker(year, month, day);
			new AlertDialog.Builder(WorkActivity.this)
					.setTitle("选择时间")
					.setView(timepickerview)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									work_time.setText(wheelMain.getTime());
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();
			break;

		case R.id.work_info_savebtn:
			String str_work_name = work_name.getText().toString().trim();
			String str_work_telphone = work_telphone.getText().toString()
					.trim();
			String str_shenfen_adress = work_adress_desc.getText().toString()
					.trim();
			String str_address = address.getText().toString().trim();
			String str_work_time = work_time.getText().toString().trim();
			String str_work_xingzhi = work_xingzhi.getSelectedItem().toString()
					.trim();

			String str_work_salary = work_salary.getSelectedItem().toString()
					.trim();
			String str_work_salary_other = work_salary_other.getSelectedItem()
					.toString().trim();
			String str_home_revenue = home_revenue.getSelectedItem().toString()
					.trim();

			int netWorkType = CommonUtil.isNetworkAvailable(WorkActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(str_work_name) || str_work_name == null) {

					Toast.makeText(WorkActivity.this, "对不起，工作单位不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_work_telphone)
						|| str_work_telphone == null) {

					Toast.makeText(WorkActivity.this, "对不起，电话不能为空",
							Toast.LENGTH_SHORT).show();

				} else if (str_work_telphone.length() < 7
						|| str_work_telphone.length() > 10) {

					Toast.makeText(WorkActivity.this, "对不起，请输入正确的单位电话号",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_shenfen_adress)
						|| str_shenfen_adress == null) {
					Toast.makeText(WorkActivity.this, "对不起，单位详址不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_address)
						|| str_address == null) {
					ToastUtil.show(WorkActivity.this, "对不起，单位地址不能为空");
				} else if ("".equalsIgnoreCase(str_work_time)
						|| str_work_time == null) {
					ToastUtil.show(WorkActivity.this, "对不起，您的入职时间没有填写");
				} else if ("".equalsIgnoreCase(str_work_xingzhi)
						|| str_work_xingzhi == null) {
					ToastUtil.show(WorkActivity.this, "对不起，您的单位性质没有填写");
				} else {

					AjaxParams params = new AjaxParams();
					params.put("work_name", str_work_name);
					params.put("work_category", str_work_xingzhi);
					params.put("work_tel", str_work_telphone);
					params.put("work_addr_province", "");
					params.put("work_addr_city", "");
					params.put("work_addr_district", "");
					params.put("work_addr_detail", str_shenfen_adress);
					params.put("work_join_date", str_work_time);
					params.put("work_salary", str_work_salary);
					params.put("work_salary_other", str_work_salary_other);
					params.put("home_revenue", str_home_revenue);
					params.put("androidid",
							AppConfig.getAndroidId(WorkActivity.this));
					params.put("imei", AppConfig.getIMEI(WorkActivity.this));
					params.put("userid", SharedPreferencesUtils.getString(
							WorkActivity.this, "userid", null));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.USER_WORK_RENZHENG_UPDATA, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil.show(WorkActivity.this, "上传失败");
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);

									Toast.makeText(WorkActivity.this, "上传成功",
											Toast.LENGTH_SHORT).show();
									finish();
								}

							});
				}

			} else {

				PromptManager.showNoNetWork(WorkActivity.this);

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

		fh.get(InternetURL.USER_WORK_RENZHENG_READ, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);

						Log.i("mytag", "工作===返回==" + t.toString());

						ToastUtil.show(WorkActivity.this, "获取数据成功");

						WorkBean work = GsonUtils.fromJson(t.toString(),
								WorkBean.class);

						Message msg = new Message();
						msg.what = 0x001;
						msg.obj = work;
						handler.sendMessage(msg);

					}
				});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {

			switch (msg.what) {

			case 0x001:

				WorkBean work_data = (WorkBean) msg.obj;

				if (work_data != null || !"".equals(work_data)) {
					if (Integer.parseInt(work_data.getStatus()) == 0) {

						work_name.setText(work_data.getWorkName());
						work_telphone.setText(work_data.getWorkTel());

						String work_xing = work_data.getWorkCategory();
						String salary = work_data.getWorkSalary();
						String salary_other = work_data.getWorkSalaryOther();
						String revenue = work_data.getHomeRevenue();

						if ("普通企业".equals(work_xing)) {
							work_xingzhi.setSelection(0, true);
						} else if ("个体工商户".equals(work_xing)) {

							work_xingzhi.setSelection(1, true);
						} else if ("公务员/事业单位".equals(work_xing)) {
							work_xingzhi.setSelection(2, true);

						} else if ("大型国企".equals(work_xing)) {

							work_xingzhi.setSelection(3, true);
						} else if ("世界500强".equals(work_xing)) {
							work_xingzhi.setSelection(4, true);

						} else if ("上市企业".equals(work_xing)) {
							work_xingzhi.setSelection(5, true);

						} else if ("其他".equals(work_xing)) {
							work_xingzhi.setSelection(6, true);
						}

						work_adress_desc.setText(work_data.getWorkAddrDetail());

						address.setText(work_data.getWorkAddrDistrict() + "上海市");

						work_time.setText(work_data.getWorkJoinDate());

						if ("15000以上".equals(salary)) {
							work_salary.setSelection(0, true);
						} else if ("10000-15000".equals(salary)) {

							work_salary.setSelection(1, true);
						} else if ("5000-10000".equals(salary)) {
							work_salary.setSelection(2, true);

						} else if ("5000以下".equals(salary)) {

							work_salary.setSelection(3, true);
						}

						if ("15000以上".equals(salary_other)) {
							work_salary_other.setSelection(0, true);
						} else if ("10000-15000".equals(salary_other)) {

							work_salary_other.setSelection(1, true);
						} else if ("5000-10000".equals(salary_other)) {
							work_salary_other.setSelection(2, true);

						} else if ("5000以下".equals(salary_other)) {

							work_salary_other.setSelection(3, true);
						}

						if ("20万以上".equals(revenue)) {
							home_revenue.setSelection(0, true);
						} else if ("15万-20万".equals(revenue)) {

							home_revenue.setSelection(1, true);
						} else if ("10万-15万".equals(revenue)) {
							home_revenue.setSelection(2, true);

						} else if ("5万-10万".equals(revenue)) {

							home_revenue.setSelection(3, true);
						} else if ("5万以下".equals(revenue)) {

							home_revenue.setSelection(4, true);
						}

					}

				}
				break;
			}

		};
	};

	private View dialogm() {
		View contentView = LayoutInflater.from(WorkActivity.this).inflate(
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
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2,
			long arg3) {
		TextView tv = (TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
		hintKbTwo();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
	
	//此方法只是关闭软键盘
		public  void hintKbTwo() {
		 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);            
		 if(imm.isActive()&&getCurrentFocus()!=null){
		    if (getCurrentFocus().getWindowToken()!=null) {
		    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		    }             
		 }
		}
}
