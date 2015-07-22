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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;

import android.widget.Button;

import android.widget.EditText;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

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
import com.geo.smallcredit.vo.HouseBean;

public class House_Activity extends Activity implements OnClickListener,
		OnItemSelectedListener {

	private Button btnBack;
	private EditText detailAdress, houseName, mianji,
			housePrice;
	private TextView address, shopData;
	private Spinner sp, shangye, huankuandate;
	private Button btn;
	private String cityTxt;
	WheelMain wheelMain;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private LinearLayout mLine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(House_Activity.this);
		setContentView(R.layout.house_renzhneg);
		initView();
		initClick();
		getData();
		// 显示时间
		Calendar calendar = Calendar.getInstance();
		shopData.setText(calendar.get(Calendar.YEAR) + "-"+ (calendar.get(Calendar.MONTH) + 1) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "");
		
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
		btn.setOnClickListener(this);
		address.setOnClickListener(this);
		shopData.setOnClickListener(this);
		shangye.setOnItemSelectedListener(this);
		sp.setOnItemSelectedListener(this);
		huankuandate.setOnItemSelectedListener(this);
	}

	private void initView() {

		address = (TextView) findViewById(R.id.house_renzheng_shengshiquedit);
		detailAdress = (EditText) findViewById(R.id.housecreditApplication_house_adressedit);
		shopData = (TextView) findViewById(R.id.house_renzheng_dateedit);
		shangye = (Spinner) findViewById(R.id.house_shangye_spinner);
		sp = (Spinner) findViewById(R.id.housecreditApplication_housezhan_spinner);
		btn = (Button) findViewById(R.id.house_renzheng_savebtn);
		btnBack = (Button) findViewById(R.id.jinrong_backbtn);
		houseName = (EditText) findViewById(R.id.housecreditApplication_housename);
		mianji = (EditText) findViewById(R.id.house_renzheng_mianjiedit);
		housePrice = (EditText) findViewById(R.id.house_renzheng_houseprice);
		huankuandate = (Spinner) findViewById(R.id.house_renzhneg_huankuandate);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.jinrong_backbtn:

			finish();

			break;
			
			//弹出省市区
		case R.id.house_renzheng_shengshiquedit:
			hintKbTwo();
			View view = dialogm();
			final MyAlertDialog dialog1 = new MyAlertDialog(House_Activity.this)
					.builder().setView(view)
					.setNegativeButton("取消", new OnClickListener() {
						@Override
						public void onClick(View v) {
							
						}
					});
			dialog1.setPositiveButton("保存", new OnClickListener() {
				@Override
				public void onClick(View v) {

					address.setText(cityTxt);
				}
			});
			dialog1.show();
			break;
			//弹出日期
		case R.id.house_renzheng_dateedit:
			hintKbTwo();
			LayoutInflater inflater = LayoutInflater.from(House_Activity.this);
			final View timepickerview = inflater.inflate(R.layout.timepicker,
					null);
			ScreenInfo screenInfo = new ScreenInfo(House_Activity.this);
			wheelMain = new WheelMain(timepickerview);
			wheelMain.screenheight = screenInfo.getHeight();
			String time = shopData.getText().toString();
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
			new AlertDialog.Builder(House_Activity.this)
					.setTitle("选择时间")
					.setView(timepickerview)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									shopData.setText(wheelMain.getTime());
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

		case R.id.house_renzheng_savebtn:

			String house_addr_province = address.getText().toString().trim();
			String house_addr_detail = detailAdress.getText().toString().trim();
			String house_buy_date = shopData.getText().toString().trim();
			String house_ower = houseName.getText().toString().trim();
			String house_right_type = shangye.getSelectedItem().toString()
					.trim();
			String house_right_percent = sp.getSelectedItem().toString().trim();
			String house_area = mianji.getText().toString().trim();
			String house_price = housePrice.getText().toString().trim();
			String house_due_date = huankuandate.getSelectedItem().toString().trim();

			int netWorkType = CommonUtil.isNetworkAvailable(House_Activity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				AjaxParams params = new AjaxParams();

				params.put("house_addr_province", "北京");
				params.put("house_addr_city", "北京");
				params.put("house_addr_district", "朝阳区");

				params.put("house_addr_detail", house_addr_detail);
				params.put("house_buy_date", "2015-6-15");
				params.put("house_ower", house_ower);
				params.put("house_right_type", house_right_type);
				params.put("house_right_percent", house_right_percent);
				params.put("house_area", house_area);
				params.put("house_price", house_price);
				params.put("house_due_date", house_due_date);
				params.put("imei", AppConfig.getIMEI(House_Activity.this));
				params.put("androidid",
						AppConfig.getAndroidId(House_Activity.this));
				params.put("userid", SharedPreferencesUtils.getString(
						House_Activity.this, "userid", null));

				FinalHttp fh = new FinalHttp();
				fh.post(InternetURL.USER_HOUSE_RENZHENG_UPDATA, params,
						new AjaxCallBack<String>() {

							@Override
							public void onFailure(Throwable t, int errorNo,
									String strMsg) {
								super.onFailure(t, errorNo, strMsg);
								Log.i("mytag", "错误信息===" + strMsg);
								ToastUtil.show(House_Activity.this, "上传失败");
							}

							@Override
							public void onSuccess(String t) {
								super.onSuccess(t);
								Log.i("mytag", "房产返回===" + t.toString());
								ToastUtil.show(House_Activity.this, "上传成功");
								House_Activity.this.finish();
							}
						});

			} else {

				PromptManager.showNoNetWork(House_Activity.this);
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

		fh.get(InternetURL.USER_HOUSE_RENZHENG_READ, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);

						Log.i("mytag", "房产===返回==" + t.toString());

						ToastUtil.show(House_Activity.this, "获取数据成功");

						HouseBean house = GsonUtils.fromJson(t.toString(),
								HouseBean.class);

						Message msg = new Message();
						msg.what = 0x002;
						msg.obj = house;
						handler.sendMessage(msg);

					}
				});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x002:
				HouseBean house = (HouseBean) msg.obj;
				if (house != null || !"".equals(house)) {
					if (Integer.parseInt(house.getStatus()) == 0) {
						address.setText(house.getHouseAddrProvince()
								+ house.getHouseAddrCity()
								+ house.getHouseAddrDistrict());
						detailAdress.setText(house.getHouseAddrDetail());
						shopData.setText(house.getHouseBuyDate());
						houseName.setText(house.getHouseOwer());
						String zhufang = house.getHouseRightType();
						String percent = house.getHouseRightPercent();
						String dueDate = house.getHouseDueDate();
						if ("商业住房".equals(zhufang)) {

							shangye.setSelection(0, true);

						} else if ("公用设施用房".equals(zhufang)) {

							shangye.setSelection(0, true);

						} else if ("住宅".equals(zhufang)) {

							shangye.setSelection(0, true);

						}

						if ("10%".equals(percent)) {
							sp.setSelection(0, true);
						} else if ("20%".equals(percent)) {
							sp.setSelection(1, true);
						} else if ("30%".equals(percent)) {
							sp.setSelection(2, true);
						} else if ("40%".equals(percent)) {
							sp.setSelection(3, true);
						} else if ("50%".equals(percent)) {
							sp.setSelection(4, true);
						} else if ("60%".equals(percent)) {
							sp.setSelection(5, true);
						} else if ("70%".equals(percent)) {
							sp.setSelection(6, true);
						} else if ("80%".equals(percent)) {
							sp.setSelection(7, true);
						} else if ("90%".equals(percent)) {
							sp.setSelection(8, true);
						} else if ("100%".equals(percent)) {
							sp.setSelection(9, true);
						}

						mianji.setText(house.getHouseArea());
						housePrice.setText(house.getHousePrice());

						if ("1日".equals(dueDate)) {
							huankuandate.setSelection(0, true);
						} else if ("2日".equals(dueDate)) {
							huankuandate.setSelection(1, true);
						} else if ("3日".equals(dueDate)) {
							huankuandate.setSelection(2, true);
						} else if ("4日".equals(dueDate)) {
							huankuandate.setSelection(3, true);
						} else if ("5日".equals(dueDate)) {
							huankuandate.setSelection(4, true);
						} else if ("6日".equals(dueDate)) {
							huankuandate.setSelection(5, true);
						} else if ("7日".equals(dueDate)) {
							huankuandate.setSelection(6, true);
						} else if ("8日".equals(dueDate)) {
							huankuandate.setSelection(7, true);
						} else if ("9日".equals(dueDate)) {
							huankuandate.setSelection(8, true);
						} else if ("10日".equals(dueDate)) {
							huankuandate.setSelection(9, true);
						} else if ("11日".equals(dueDate)) {
							huankuandate.setSelection(10, true);
						} else if ("12日".equals(dueDate)) {
							huankuandate.setSelection(11, true);
						} else if ("13日".equals(dueDate)) {
							huankuandate.setSelection(12, true);
						} else if ("14日".equals(dueDate)) {
							huankuandate.setSelection(13, true);
						} else if ("15日".equals(dueDate)) {
							huankuandate.setSelection(14, true);
						} else if ("16日".equals(dueDate)) {
							huankuandate.setSelection(15, true);
						} else if ("17日".equals(dueDate)) {
							huankuandate.setSelection(16, true);
						} else if ("18日".equals(dueDate)) {
							huankuandate.setSelection(17, true);
						} else if ("19日".equals(dueDate)) {
							huankuandate.setSelection(18, true);
						} else if ("20日".equals(dueDate)) {
							huankuandate.setSelection(19, true);
						} else if ("21日".equals(dueDate)) {
							huankuandate.setSelection(20, true);
						} else if ("22日".equals(dueDate)) {
							huankuandate.setSelection(21, true);
						} else if ("23日".equals(dueDate)) {
							huankuandate.setSelection(22, true);
						} else if ("24日".equals(dueDate)) {
							huankuandate.setSelection(23, true);
						} else if ("25日".equals(dueDate)) {
							huankuandate.setSelection(24, true);
						} else if ("26日".equals(dueDate)) {
							huankuandate.setSelection(25, true);
						} else if ("27日".equals(dueDate)) {
							huankuandate.setSelection(26, true);
						} else if ("28日".equals(dueDate)) {
							huankuandate.setSelection(27, true);
						} else if ("29日".equals(dueDate)) {
							huankuandate.setSelection(28, true);
						} else if ("30日".equals(dueDate)) {
							huankuandate.setSelection(29, true);
						} else if ("31日".equals(dueDate)) {
							huankuandate.setSelection(30, true);
						}

					}
				}
				break;
			}

		};
	};

	private View dialogm() {
		View contentView = LayoutInflater.from(House_Activity.this).inflate(
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
