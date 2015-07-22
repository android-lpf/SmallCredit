package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;

public class ResetPwdActivity extends Activity implements OnClickListener,
		android.widget.CompoundButton.OnCheckedChangeListener {
	private EditText newPwd, newSurePwd;
	private Button sureBnt;
	private TelephonyManager tm; // 获取手机 imei
	private LinearLayout mLine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(ResetPwdActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.resetpwd);
		initView();
		initClick();
		tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
		
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

	private void initView() {
		newPwd = (EditText) findViewById(R.id.resetpwd_newpwd);
		newSurePwd = (EditText) findViewById(R.id.resetpwd_newsurepwd);
		sureBnt = (Button) findViewById(R.id.resetpwd_surebtn);
	}

	private void initClick() {
		sureBnt.setOnClickListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton v, boolean isChecked) {
		switch (v.getId()) {
//		case R.id.resetpwd_checkbox:
//			if (isChecked) {
//				// 显示密码
//				newPwd.setInputType(InputType.TYPE_CLASS_TEXT);
//				newSurePwd.setInputType(InputType.TYPE_CLASS_TEXT);
//			} else {
//				newPwd.setInputType(InputType.TYPE_CLASS_TEXT
//						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
//				newSurePwd.setInputType(InputType.TYPE_CLASS_TEXT
//						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
//			}
//
//			CharSequence text = newPwd.getText();
//
//			if (text instanceof Spannable) {
//				Spannable spanText = (Spannable) text;
//				Selection.setSelection(spanText, text.length());
//			}
//			CharSequence txt = newSurePwd.getText();
//			if (txt instanceof Spannable) {
//				Spannable span = (Spannable) txt;
//				Selection.setSelection(span, txt.length());
//			}
//			break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {

		String newPassword = newPwd.getText().toString().trim();
		String newSurePassword = newSurePwd.getText().toString().trim();

		switch (v.getId()) {

		case R.id.resetpwd_surebtn:

			int netWorkType = CommonUtil
					.isNetworkAvailable(ResetPwdActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equals(newPassword) || newPassword == null) {

					ToastUtil.show(ResetPwdActivity.this, "请输入新密码");

				} else if ("".equals(newSurePassword)
						|| newSurePassword == null) {

					ToastUtil.show(ResetPwdActivity.this, "请输入确认密码");

				} else if (!(newPassword).equals(newSurePassword)) {

					ToastUtil.show(ResetPwdActivity.this, "两次密码不一致");

				} else {
					/**
					 * password IMEI： imei
					 */
					AjaxParams params = new AjaxParams();
					params.put("password", newPassword);

					params.put("imei", tm.getDeviceId());

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHECK_FORGETPWD, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil.show(ResetPwdActivity.this,
											"密码重置失败");
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									ToastUtil.show(ResetPwdActivity.this,
											"密码重置成功");
								}
							});
					Intent it = new Intent(ResetPwdActivity.this,
							BeginActivity.class);
					startActivity(it);
					this.finish();
				}

			} else {

				PromptManager.showNoNetWork(ResetPwdActivity.this);
			}

			break;
		}
	}
}