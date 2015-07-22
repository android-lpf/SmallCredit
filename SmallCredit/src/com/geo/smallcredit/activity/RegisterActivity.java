package com.geo.smallcredit.activity;

import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.MD5Util;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.TimeButton;

public class RegisterActivity extends Activity implements OnClickListener {

	private Button register;
	private TimeButton register_btn;
	// 手机号 用户名 验证码
	private EditText register_username, register_phone_number, register_paw,
			register_surepwd;
	private Bundle savedInstanceState;
	// private String userPhone,userName_str,userNumber;
	private LinearLayout mRela;
	private int PHONE_LENGTH = 11;
	public static RegisterActivity instance = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(RegisterActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register_yi);
		initview();
		instance = this;
		btn_onclick();
	}

	public void initview() {

		register = (Button) findViewById(R.id.register);
		register_btn = (TimeButton) findViewById(R.id.register_btn);
		register_username = (EditText) findViewById(R.id.register_username);
		register_phone_number = (EditText) findViewById(R.id.register_phone_number);
		register_paw = (EditText) findViewById(R.id.register_paw);
		register_surepwd = (EditText) findViewById(R.id.register_surepaw);
		mRela = (LinearLayout) findViewById(R.id.traceroute_rootview);
	}

	public void btn_onclick() {

		register_btn.setOnClickListener(this);
		register.setOnClickListener(this);
		mRela.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		String userPhone = register_username.getText().toString().trim();
		String phoneNumber = register_phone_number.getText().toString().trim();
		String paw = register_paw.getText().toString().trim();
		String surePwd = register_surepwd.getText().toString().trim();
		String mpaw = MD5Util.string2MD5(paw);// md5 加密

		switch (v.getId()) {

		case R.id.register:

			Intent intent = new Intent(RegisterActivity.this,CreditpayActivity.class);
			intent.putExtra("backText","注册");
			startActivity(intent);

			// 立即注册
			int netWorkType = CommonUtil.isNetworkAvailable(RegisterActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(userPhone) || userPhone == null) {

					ToastUtil.show(RegisterActivity.this, "手机号不能为空");

				} else if ("".equals(phoneNumber) || phoneNumber == null) {

					ToastUtil.show(RegisterActivity.this, "验证码不能为空");

				} else if ("".equalsIgnoreCase(paw) || paw == null) {

					ToastUtil.show(RegisterActivity.this, "密码不能为空");

				} else if (paw.length() < 6 || paw.length() > 18) {

					ToastUtil.show(RegisterActivity.this, "请输入6到18位的密码");

				} else if (!paw.equals(surePwd)) {

					ToastUtil.show(RegisterActivity.this, "对不起,确认密码和密码不一致");

				} else if ("".equalsIgnoreCase(surePwd) || surePwd == null) {

					ToastUtil.show(RegisterActivity.this, "确认密码不能为空");

				} else if (userPhone.length() != PHONE_LENGTH) {

					ToastUtil.show(RegisterActivity.this, "请输入11位的手机号");

				} else {

					/***
					 * 和后台交互 判断验证码是否正确 正确了，再进行下一步操作
					 * 
					 * 需要对网络判断 * 姓名：username 手机号：mobileno IMEI：imei
					 * 
					 */
					AjaxParams params = new AjaxParams();

					params.put("mobileno", userPhone);
					params.put("imei", AppConfig.getIMEI(RegisterActivity.this));
					params.put("password", mpaw);
					params.put("authcode", phoneNumber);
					params.put("androidid",
							AppConfig.getAndroidId(RegisterActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.REGISTER, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil.show(RegisterActivity.this,
											"注册失败");
								}

								@Override
								public void onSuccess(String t) {

									super.onSuccess(t);
									try {

										JSONObject json = new JSONObject(t
												.toString());

										// GsonUtils.fromJson(t, classOfT);
										String status = json
												.getString("status");
										String userid=json.getString("userId");
										SharedPreferencesUtils.saveString(RegisterActivity.this,"userid",userid);
										Log.i("mytag", "注册返回====" + t);

										if (Integer.parseInt(status) == 0) {

											ToastUtil.show(RegisterActivity.this,"注册成功但未绑卡,请绑定您的银行卡");
											Intent intent = new Intent(
													RegisterActivity.this,
													CreditpayActivity.class);
											intent.putExtra("backText","注册");
											startActivity(intent);
										} else if (Integer.parseInt(status) == 2) {

											ToastUtil.show(
													RegisterActivity.this,
													"对不起，您的手机号已经被注册过了");
										} else if (Integer.parseInt(status) == 1) {
											
											ToastUtil.show(
													RegisterActivity.this,
													"对不起，您输入的验证码有误");
										}

									} catch (JSONException e) {
										e.printStackTrace();
									}

								}

							});

					break;
				}

			} else {

				PromptManager.showNoNetWork(RegisterActivity.this);
			}
			break;

		case R.id.register_btn:

			// 给后台发送网络请求

			/***
			 * 判断是否有网络
			 */
			int netWork = CommonUtil.isNetworkAvailable(RegisterActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equalsIgnoreCase(userPhone) || userPhone == null) {

					ToastUtil.show(this, "手机号不能为空");

				} else if (userPhone.length() != 11) {

					ToastUtil.show(RegisterActivity.this, "请输入11位的手机号");

				} else {
					// 该设置是获取验证码
					register_btn.onCreate(savedInstanceState);
					register_btn.setTextAfter("秒后重新获取").setTextBefore("获取")
							.setLenght(60 * 1000);
					AjaxParams params = new AjaxParams();
					params.put("mobileno", userPhone);
					params.put("business_code", "1");
					params.put("imei", AppConfig.getIMEI(RegisterActivity.this));
					params.put("androidid",
							AppConfig.getAndroidId(RegisterActivity.this));

					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.CHECKPHONE, params,
							new AjaxCallBack<String>() {
								@Override
								public void onSuccess(String t) {
									Toast.makeText(RegisterActivity.this,
											"验证码发送成功", Toast.LENGTH_SHORT)
											.show();
								}


						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Log.i("mytag","验证码发送失败"+strMsg);
							Toast.makeText(RegisterActivity.this, "验证码发送失败",
									Toast.LENGTH_SHORT).show();
						}
					});

				}
			} else {
				PromptManager.showNoNetWork(RegisterActivity.this);
			}

			break;

		// case R.id.register_checkbox:
		//
		// View view = LayoutInflater.from(this).inflate(
		// R.layout.xiao_xing_yong_xie_yi, null);
		// WebView wv = (WebView) view.findViewById(R.id.webview);
		// wv.getSettings().setJavaScriptEnabled(true);
		// wv.loadUrl("file:///android_asset/xiaoxinyong.html");
		//
		// new AlertDialog.Builder(this)
		// .setTitle("信用付款(小信用)服务协议")
		//
		// .setView(view)
		// .setCancelable(false)
		// .setPositiveButton("确认",
		// new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface arg0,
		// int arg1) {
		//
		// register_checkbox.setChecked(true);
		// }
		// })
		// .setNegativeButton("取消",
		// new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface arg0,
		// int arg1) {
		// register_checkbox.setChecked(false);
		// }
		// }).create().show();
		//
		// break;
		case R.id.traceroute_rootview:
			// 点击外部键盘消失
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			break;
		}

	}

	@Override
	protected void onDestroy() {

		register_btn.onDestroy();

		super.onDestroy();
	}

}
