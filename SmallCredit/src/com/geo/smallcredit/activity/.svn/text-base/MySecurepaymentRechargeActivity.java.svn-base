package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.TimeButton;
import com.geo.smallcredit.vo.WuYouShouYI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MySecurepaymentRechargeActivity extends Activity implements
		OnClickListener, OnItemSelectedListener {

	private Button backBtn, addBtn, shuomingBtn, flushBtn;
	private EditText cardNum, rechargePrice, dealPwd, yanzheng;
	private CheckBox cb;
	private TextView price;
	private Spinner spinner;
	private TextView accountBalance;
	private Bundle savedInstanceState;
	private TimeButton yanBtn;
	private String ticket, advanceNo;
	private LinearLayout mReal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepayment_recharge);
		initView();
		initClick();
		getData();
		bankCardNumAddSpace(cardNum);
		// 点击外部键盘消失
		mReal = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mReal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

			}
		});
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		addBtn.setOnClickListener(this);
		shuomingBtn.setOnClickListener(this);
		flushBtn.setOnClickListener(this);
		cb.setOnClickListener(this);
		spinner.setOnItemSelectedListener(this);
		yanBtn.setOnClickListener(this);
	}

	private void initView() {
		spinner = (Spinner) findViewById(R.id.mysecurepayment_recharge_spinner);
		yanBtn = (TimeButton) findViewById(R.id.mysecurepayment_recharge_btn);
		backBtn = (Button) findViewById(R.id.mysecurepayment_recharge_backbtn);
		addBtn = (Button) findViewById(R.id.mysecurepayment_recharge_addbtn);
		shuomingBtn = (Button) findViewById(R.id.mysecurepayment_recharge_shuoming);
		flushBtn = (Button) findViewById(R.id.mysecurepayment_recharge_flushbtn);
		cardNum = (EditText) findViewById(R.id.mysecurepayment_recharge_cardnumedit);
		accountBalance = (TextView) findViewById(R.id.mysecurepayment_recharge_accountbalanceedit);
		rechargePrice = (EditText) findViewById(R.id.mysecurepayment_recharge_rechargepriceedit);
		dealPwd = (EditText) findViewById(R.id.mysecurepayment_recharge_dealpwdedit);
		cb = (CheckBox) findViewById(R.id.mysecurepayment_recharge_checkbox);
		price = (TextView) findViewById(R.id.mysecurepayment_recharge_price);
		yanzheng = (EditText) findViewById(R.id.mysecurepayment_recharge_ed1);
	}

	@Override
	public void onClick(View v) {
		String sp = spinner.getSelectedItem().toString().trim();
		String num = cardNum.getText().toString().trim();
		String balance = accountBalance.getText().toString().trim();
		String price = rechargePrice.getText().toString().trim();
		String pwd = dealPwd.getText().toString().trim();

		switch (v.getId()) {
		case R.id.mysecurepayment_recharge_backbtn:
			finish();
			break;

		case R.id.mysecurepayment_recharge_addbtn:
			Intent add = new Intent(MySecurepaymentRechargeActivity.this,
					MyAddBankActivity.class);
			startActivity(add);
			break;

		case R.id.mysecurepayment_recharge_shuoming:
			ToastUtil.show(MySecurepaymentRechargeActivity.this, "暂无信息,尽请期待");
			break;

		case R.id.mysecurepayment_recharge_flushbtn:

			int netWorkType = CommonUtil
					.isNetworkAvailable(MySecurepaymentRechargeActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {
				if ("".equalsIgnoreCase(sp) || sp == null) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"请选择所属的银行");

				} else if ("".equalsIgnoreCase(num) || num == null) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"卡号不能为空");

				} else if (num.length() < 16 || num.length() > 19) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"请您输入至少16位的卡号");

				} else if ("".equals(balance) || balance == null) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"验证码不能为空");

				} else if ("".equalsIgnoreCase(price) || price == null) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"充值金额不能为空");

				} else if ("".equalsIgnoreCase(pwd) || pwd == null) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"交易密码不能为空");

				} else if (!cb.isChecked()) {

					ToastUtil.show(MySecurepaymentRechargeActivity.this,
							"您必须阅读小信用服务协议");

				} else {
					/***
					 * 和后台交互 再进行下一步操作
					 * 
					 * 需要对网络判断
					 * 
					 */
					AjaxParams params = new AjaxParams();

					params.put("advance_no", advanceNo);
					params.put("ticket", ticket);
					params.put("authcode", yanzheng.getText().toString().trim());
					params.put("treade_password", pwd);
					params.put("userid", SharedPreferencesUtils.getString(
							MySecurepaymentRechargeActivity.this, "userid",
							null));
					params.put("androidid", AppConfig
							.getAndroidId(MySecurepaymentRechargeActivity.this));
					params.put("imei", AppConfig
							.getIMEI(MySecurepaymentRechargeActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHONGZHI, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									Log.i("mytag", strMsg);
									ToastUtil
											.show(MySecurepaymentRechargeActivity.this,
													"充值失败");
									Intent fail = new Intent(
											MySecurepaymentRechargeActivity.this,
											MySecurepaymentRechargeFailResultActivity.class);
									startActivity(fail);
								}

								@Override
								public void onSuccess(String t) {

									super.onSuccess(t);
									Log.i("mytag", "返回=" + t);
									try {

										JSONObject json = new JSONObject(t
												.toString());

										// GsonUtils.fromJson(t, classOfT);
										String status = json
												.getString("status");

										Log.i("mytag", "返回=" + t.toString());

										if (Integer.parseInt(status) == 0) {

											ToastUtil
													.show(MySecurepaymentRechargeActivity.this,
															"充值成功");

											Intent intent = new Intent(
													MySecurepaymentRechargeActivity.this,
													MySecurepaymentRechargeSussessResultActivity.class);
											startActivity(intent);
										}

									} catch (JSONException e) {
										e.printStackTrace();
									}

								}

							});

					break;
				}

			} else {

				PromptManager
						.showNoNetWork(MySecurepaymentRechargeActivity.this);
			}

			break;

		case R.id.mysecurepayment_recharge_checkbox:
			View view = LayoutInflater.from(this).inflate(
					R.layout.xiao_xing_yong_xie_yi, null);
			WebView wv = (WebView) view.findViewById(R.id.webview);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.loadUrl("file:///android_asset/xiaoxinyong.html");

			new AlertDialog.Builder(this)
					.setTitle("信用付款(小信用)服务协议")

					.setView(view)
					.setCancelable(false)
					.setPositiveButton("确认",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {

									cb.setChecked(true);
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									cb.setChecked(false);
								}
							}).create().show();

			break;
		case R.id.mysecurepayment_recharge_btn:
			// if (num!=null|| !"".equals(num)) {
			//
			// ToastUtil.show(MySecurepaymentRechargeActivity.this,
			// "请输入正确的卡号");
			//
			// } else if ("".equalsIgnoreCase(price) || price == null) {
			//
			// ToastUtil.show(MySecurepaymentRechargeActivity.this,
			// "充值金额不能为空");
			//
			// }else{

			yanBtn.onCreate(savedInstanceState);
			yanBtn.setTextAfter("秒后重新获取").setTextBefore("获取")
					.setLenght(60 * 1000);

			AjaxParams params = new AjaxParams();
			params.put("bank_name", sp);
			params.put("bank_card", num);
			params.put("refund_amount", price);
			params.put("treade_password", pwd);
			params.put("userid", SharedPreferencesUtils.getString(
					MySecurepaymentRechargeActivity.this, "userid", null));
			params.put("androidid", AppConfig
					.getAndroidId(MySecurepaymentRechargeActivity.this));
			params.put("imei",
					AppConfig.getIMEI(MySecurepaymentRechargeActivity.this));

			FinalHttp fh = new FinalHttp();

			fh.post(InternetURL.CHECK_CHONGZHI, params,
					new AjaxCallBack<String>() {
						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							super.onFailure(t, errorNo, strMsg);

						}

						@Override
						public void onSuccess(String t) {
							super.onSuccess(t);

							try {

								JSONObject json = new JSONObject(t.toString());

								ticket = json.getString("ticket");
								advanceNo = json.getString("advanceNo");

							} catch (JSONException e) {
								e.printStackTrace();
							}
						}

					});
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {

		TextView tv = (TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
		hintKbTwo();
		// String[] languages = getResources().getStringArray(
		// R.array.my_bankinfo_addbank_bankname_spinner);
		//
		// String str = languages[arg2];
		// Log.i("mytag", "spinner===点击的是===" + str);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	public void getData() {
		AjaxParams params = new AjaxParams();
		params.put("mobileno",
				SharedPreferencesUtils.getString(this, "mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(this, "userid", null));
		params.put("imei",
				AppConfig.getIMEI(MySecurepaymentRechargeActivity.this));
		params.put("androidid",
				AppConfig.getAndroidId(MySecurepaymentRechargeActivity.this));
		FinalHttp fh = new FinalHttp();
		fh.get(InternetURL.UWYOUHUANKUANG_QUERY, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						ToastUtil.show(MySecurepaymentRechargeActivity.this,
								"获取数据失败");
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);

//						WuYouShouYI shou = GsonUtils.fromJson(t.toString(),
//								WuYouShouYI.class);
//
//						Message msg = new Message();
//						msg.what = 0x006;
//						msg.obj = shou;
//						handler.sendMessage(msg);

					}
				});

	}

//	Handler handler = new Handler() {
//		public void handleMessage(Message msg) {
//			switch (msg.what) {
//			case 0x006:
//				WuYouShouYI shouyi = (WuYouShouYI) msg.obj;
//				if (shouyi != null || !"".equals(shouyi)) {
//
//					if (shouyi.getStatus() == 0) {
//
//						accountBalance.setText(shouyi.getBalance());
//					} else {
//
//						accountBalance.setText("余额为：" + "0.00");
//
//					}
//				}
//				break;
//			}
//
//		};
//	};

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

	/**
	 * 银行卡四位加空格
	 * 
	 * @param mEditText
	 */
	protected void bankCardNumAddSpace(final EditText mEditText) {
		mEditText.addTextChangedListener(new TextWatcher() {
			int beforeTextLength = 0;
			int onTextLength = 0;
			boolean isChanged = false;
			int location = 0;// 记录光标的位置
			private char[] tempChar;
			private StringBuffer buffer = new StringBuffer();
			int konggeNumberB = 0;

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				beforeTextLength = s.length();
				if (buffer.length() > 0) {
					buffer.delete(0, buffer.length());
				}
				konggeNumberB = 0;
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ' ') {
						konggeNumberB++;
					}
				}
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				onTextLength = s.length();
				buffer.append(s.toString());
				if (onTextLength == beforeTextLength || onTextLength <= 3
						|| isChanged) {
					isChanged = false;
					return;
				}
				isChanged = true;
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (isChanged) {
					location = mEditText.getSelectionEnd();
					int index = 0;
					while (index < buffer.length()) {
						if (buffer.charAt(index) == ' ') {
							buffer.deleteCharAt(index);
						} else {
							index++;
						}
					}

					index = 0;
					int konggeNumberC = 0;
					while (index < buffer.length()) {
						if ((index == 4 || index == 9 || index == 14 || index == 19)) {
							buffer.insert(index, ' ');
							konggeNumberC++;
						}
						index++;
					}

					if (konggeNumberC > konggeNumberB) {
						location += (konggeNumberC - konggeNumberB);
					}

					tempChar = new char[buffer.length()];
					buffer.getChars(0, buffer.length(), tempChar, 0);
					String str = buffer.toString();
					if (location > str.length()) {
						location = str.length();
					} else if (location < 0) {
						location = 0;
					}

					mEditText.setText(str);
					Editable etable = mEditText.getText();
					Selection.setSelection(etable, location);
					isChanged = false;
				}
			}
		});
	}

}
