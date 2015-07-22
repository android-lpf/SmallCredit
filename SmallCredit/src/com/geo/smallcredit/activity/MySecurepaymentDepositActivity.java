package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.DespoitBank;
import com.geo.smallcredit.vo.TimeButton;
import com.google.gson.JsonArray;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MySecurepaymentDepositActivity extends Activity implements
		OnClickListener, OnItemSelectedListener {

	private Button backBtn, submitBtn;
	private TimeButton sendBtn;
	private EditText depositPrice, dealPwd, verifyEdit;
	private TextView backtxt,accountBlance,shouXu,prompt;
	private TelephonyManager tm;
	private Bundle savedInstanceState;
	private String androidId;
	private int PHONE_LENGTH = 11;
	private Spinner sp;
	private String yue;
	DespoitBank depo;
	private LinearLayout mLine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepayment_deposit);
		Intent intent = getIntent();
		yue = intent.getStringExtra("yue");
		initView();
		initClick();
		backtxt.setText(intent.getStringExtra("backText"));
		accountBlance.setText(yue);
		getDatas();

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

		sp.setOnItemSelectedListener(this);
		backBtn.setOnClickListener(this);
		sendBtn.setOnClickListener(this);
		submitBtn.setOnClickListener(this);

	}

	private void initView() {
		backtxt=(TextView)findViewById(R.id.mysecurepayment_deposit_backtext);
		sp = (Spinner) findViewById(R.id.mysecurepayment_deposit_depositaccount_spinner);
		backBtn = (Button) findViewById(R.id.mysecurepayment_deposit_backbtn);
		sendBtn = (TimeButton) findViewById(R.id.mysecurepayment_deposit_sendverifybtn);
		submitBtn = (Button) findViewById(R.id.mysecurepayment_deposit_submitbtn);
		depositPrice = (EditText) findViewById(R.id.mysecurepayment_deposit_depositpriceedit);
		shouXu = (TextView) findViewById(R.id.mysecurepayment_deposit_shouxufeiedit);
		dealPwd = (EditText) findViewById(R.id.mysecurepayment_deposit_dealpwdedit);
		verifyEdit = (EditText) findViewById(R.id.mysecurepayment_deposit_verifyedit);
		accountBlance = (TextView) findViewById(R.id.mysecurepayment_deposit_balanceedit);
		prompt = (TextView) findViewById(R.id.mysecurepayment_deposit_prompt);
	}

	@Override
	public void onClick(View v) {

		String spinner = sp.getSelectedItem().toString().trim();
		String price = depositPrice.getText().toString().trim();
		String fei = shouXu.getText().toString().trim();
		String pwd = dealPwd.getText().toString().trim();
		String verify = verifyEdit.getText().toString().trim();

		switch (v.getId()) {
		case R.id.mysecurepayment_deposit_backbtn:
			MySecurepaymentDepositActivity.this.finish();
			break;

		case R.id.mysecurepayment_deposit_sendverifybtn:
			/***
			 * 判断是否有网络
			 */
			int netWork = CommonUtil
					.isNetworkAvailable(MySecurepaymentDepositActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {
				//
				// if ("".equalsIgnoreCase(userPhone) || userPhone == null) {
				//
				// ToastUtil.show(this, "手机号不能为空");
				//
				// } else if (userPhone.length() != 11) {
				//
				// ToastUtil.show(MySecurepaymentDepositActivity.this,
				// "请输入11位的手机号");
				//
				// } else {
				// // 该设置是获取验证码
				// sendBtn.onCreate(savedInstanceState);
				// sendBtn.setTextAfter("秒后重新获取").setTextBefore("获取")
				// .setLenght(60 * 1000);
				// FinalHttp fh = new FinalHttp();
				//
				// fh.get(InternetURL.CHECKPHONE + userPhone,
				// new AjaxCallBack() {
				// @Override
				// public void onSuccess(Object t) {
				// Toast.makeText(MySecurepaymentDepositActivity.this,
				// "验证码发送成功", Toast.LENGTH_SHORT)
				// .show();
				// }
				//
				// @Override
				// public void onFailure(Throwable t, int errorNo,
				// String strMsg) {
				// Toast.makeText(MySecurepaymentDepositActivity.this,
				// "验证码发送失败", Toast.LENGTH_SHORT)
				// .show();
				// }
				// });
				// }
			} else {
				PromptManager
						.showNoNetWork(MySecurepaymentDepositActivity.this);
			}
			break;

		case R.id.mysecurepayment_deposit_submitbtn:

			int netWorkType = CommonUtil
					.isNetworkAvailable(MySecurepaymentDepositActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(spinner) || spinner == null) {

					ToastUtil.show(MySecurepaymentDepositActivity.this,
							"请您选择要提现的账户");

				} else if ("".equalsIgnoreCase(price) || price == null) {

					ToastUtil.show(MySecurepaymentDepositActivity.this,
							"请输入要提现的金额");

				} else if (price.equals(0)) {

					ToastUtil.show(MySecurepaymentDepositActivity.this,
							"提现的金额不能为0");

				} else if ("".equalsIgnoreCase(fei) || fei == null) {

					ToastUtil.show(MySecurepaymentDepositActivity.this,
							"提现的手续费不能为空");

				} else if ("".equals(verify) || verify == null) {

					ToastUtil.show(MySecurepaymentDepositActivity.this,
							"验证码不能为空");

				} else if ("".equalsIgnoreCase(pwd) || pwd == null) {

					ToastUtil.show(MySecurepaymentDepositActivity.this,
							"交易密码不能为空");

				} else {
					/***
					 * 和后台交互 再进行下一步操作
					 * 
					 */
					AjaxParams params = new AjaxParams();
					params.put("bank_card", depo.getBankcard_binding_id());
					Log.i("mytag", "depo======" + depo.getBankcard_binding_id());
					params.put("withdraw_amount", price);
					params.put("withdraw_fee", fei);
					params.put("trade_password", pwd);
					params.put("userid", SharedPreferencesUtils
							.getString(MySecurepaymentDepositActivity.this,
									"userid", null));
					params.put("androidid", AppConfig
							.getAndroidId(MySecurepaymentDepositActivity.this));
					params.put("imei", AppConfig
							.getIMEI(MySecurepaymentDepositActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHECK_TIXIAN, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil
											.show(MySecurepaymentDepositActivity.this,
													"提现失败");

									finish();
								}

								@Override
								public void onSuccess(String t) {

									super.onSuccess(t);
									Log.i("mytag", "返回=" + t);
									try {

										JSONObject json = new JSONObject(t
												.toString());

										String status = json
												.getString("status");

										Log.i("mytag", "返回=" + t.toString());

										if (Integer.parseInt(status) == 0) {
											ToastUtil
													.show(MySecurepaymentDepositActivity.this,
															"提现成功");

											Intent intent = new Intent(
													MySecurepaymentDepositActivity.this,
													MySecurepaymentDespoitResultActivity.class);
											intent.putExtra("backText", "提现");
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
						.showNoNetWork(MySecurepaymentDepositActivity.this);
			}
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2,
			long arg3) {

		TextView tv=(TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
		hintKbTwo();
//		String[] languages = getResources().getStringArray(
//				R.array.my_bankinfo_addbank_bankname_spinner);
//
//		String str = languages[arg2];
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	public void getDatas() {
		int netWorkType = CommonUtil
				.isNetworkAvailable(MySecurepaymentDepositActivity.this);

		if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

			AjaxParams params = new AjaxParams();

			params.put("userid", SharedPreferencesUtils.getString(
					MySecurepaymentDepositActivity.this, "userid", null));
			params.put("androidid",
					AppConfig.getAndroidId(MySecurepaymentDepositActivity.this));
			params.put("imei",
					AppConfig.getIMEI(MySecurepaymentDepositActivity.this));

			FinalHttp fh = new FinalHttp();

			fh.get(InternetURL.CHECK_TIXIANBANK, params,
					new AjaxCallBack<String>() {
						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							super.onFailure(t, errorNo, strMsg);
							Log.i("mytag", strMsg);
						}

						@Override
						public void onSuccess(String t) {

							super.onSuccess(t);
							Log.i("mytag", "返回=" + t);
							try {

								JSONObject json = new JSONObject(t.toString());

								// GsonUtils.fromJson(t, classOfT);
								String status = json.getString("status");
								String desc = json.getString("desc");

								JSONArray ja = json
										.getJSONArray("bankCardList");

								for (int i = 0; i < ja.length(); i++) {
									depo = new DespoitBank();
									JSONObject jso = ja.getJSONObject(i);
									depo.setBankcard_binding_id(jso
											.getString("bankcard_binding_id"));
									depo.setBankcardNumber(jso
											.getString("bankcardNumber"));
									depo.setStatus(status);
									depo.setDesc(desc);
								}

							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					});

		} else {

			PromptManager.showNoNetWork(MySecurepaymentDepositActivity.this);
		}
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
