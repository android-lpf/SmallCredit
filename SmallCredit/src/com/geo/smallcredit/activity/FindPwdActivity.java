package com.geo.smallcredit.activity;


import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.TimeButton;

public class FindPwdActivity extends Activity implements OnClickListener {

	private EditText etphone, verifyEt;
	private Button  nextBtn;
	private TimeButton phoneTextView;
	private Bundle savedInstanceState;
	private String tel, verify;
	private LinearLayout mLine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(FindPwdActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forgetpwd_find);
		initView();
		initClick();
	}

	private void initClick() {
		phoneTextView.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		mLine.setOnClickListener(this);
	}

	private void initView() {
		etphone = (EditText) findViewById(R.id.forgetpwd_find_edit);
		verifyEt = (EditText) findViewById(R.id.forgetpwd_find_verifyedit);
		phoneTextView = (TimeButton) findViewById(R.id.forgetpwd_find_verifybtn);
		nextBtn = (Button) findViewById(R.id.forgetpwd_find_nextbtn);
		mLine = (LinearLayout) findViewById(R.id.forgetpaw_id);
	}

	@Override
	public void onClick(View v) {
		
		verify = verifyEt.getText().toString().trim();
		tel = etphone.getText().toString().trim();
		Log.i("mytag","shoujihao"+tel+"==="+verify);
		
		switch (v.getId()) {
		case R.id.forgetpaw_id:
			// 点击外部键盘消失
			AppConfig.CloseKey(FindPwdActivity.this, v);
			break;
		case R.id.forgetpwd_find_verifybtn:
			/***
			 * 判断是否有网络
			 */
			int netWork = CommonUtil.isNetworkAvailable(FindPwdActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equals(tel) || tel == null) {
					ToastUtil.show(this, "手机号不能为空");
				} else if (tel.length() != 11) {
					ToastUtil.show(FindPwdActivity.this, "请输入11位的手机号");
				} else {
					// 该设置是获取验证码
					phoneTextView.onCreate(savedInstanceState);
					phoneTextView.setTextAfter("秒后重新获取").setTextBefore("获取").setLenght(60 * 1000);
					AjaxParams params = new AjaxParams();
					params.put("phone", tel);
					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.CHECKPHONE, params,
							new AjaxCallBack<String>() {
								@Override
								public void onSuccess(String t) {
									Toast.makeText(FindPwdActivity.this,
											"验证码发送成功", Toast.LENGTH_SHORT)
											.show();
									Log.i("mytag", "返回" + t);
								}

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									Toast.makeText(FindPwdActivity.this,"验证码发送失败", Toast.LENGTH_SHORT).show();
								}
							});
				}
			} else {
				PromptManager.showNoNetWork(FindPwdActivity.this);
			}
			break;

		case R.id.forgetpwd_find_nextbtn:
		
			int netWorkType = CommonUtil
					.isNetworkAvailable(FindPwdActivity.this);
			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {
				if ("".equals(tel) || tel == null) {
					ToastUtil.show(FindPwdActivity.this, "手机号不能为空");

				} else if (tel.length() != 11) {
					ToastUtil.show(FindPwdActivity.this, "请输入11位的手机号");

				}else if ("".equals(verify) || verify == null) {
					ToastUtil.show(FindPwdActivity.this, "验证码不能为空");

				} else if (verify.length()!=6) {
					ToastUtil.show(FindPwdActivity.this, "请输入6位验证码");

				} else {
					Intent it = new Intent(FindPwdActivity.this, ResetPwdActivity.class);
					startActivity(it);
				}
			} else {

				PromptManager.showNoNetWork(FindPwdActivity.this);
			}
			break;
		}
	}

	@Override
	protected void onDestroy() {

		phoneTextView.onDestroy();

		super.onDestroy();
	}
}
