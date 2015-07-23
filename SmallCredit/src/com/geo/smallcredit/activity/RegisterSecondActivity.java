package com.geo.smallcredit.activity;

import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.MD5Util;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.RegisterVo;
import com.geo.smallcredit.vo.TimeButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterSecondActivity extends Activity implements OnClickListener{
	
	private Button eyeBtn,nextBtn;
	private TimeButton verifyBtn;
	private EditText mobileEdit,verifyEdit,passwordEdit;
	private TextView xieyi;
	private Bundle savedInstanceState;
	public static RegisterSecondActivity instance = null;
	private String username,shenfennum;
	private int PHONE_LENGTH=11;
	private RegisterVo mRegisterVo;
	private LinearLayout mLinearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register_er);
		initView();
		initClick();
		Intent it=getIntent();
		username=it.getStringExtra("name");
		shenfennum=it.getStringExtra("num");
	}

	private void initClick() {
		
		verifyBtn.setOnClickListener(this);
		eyeBtn.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		xieyi.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);
	}

	private void initView() {

		verifyBtn = (TimeButton) findViewById(R.id.register_er_sendverifybtn);
		eyeBtn = (Button) findViewById(R.id.register_er_eyebtn);
		nextBtn = (Button) findViewById(R.id.register_er_nextbtn);
		mobileEdit = (EditText) findViewById(R.id.register_er_phonenumber_edit);
		verifyEdit = (EditText) findViewById(R.id.register_er_verify_edit);	
		passwordEdit = (EditText) findViewById(R.id.register_er_userpwd_edit);
		xieyi = (TextView) findViewById(R.id.register_er_xieyi);
		mLinearLayout=(LinearLayout) findViewById(R.id.register_er_id);
	
	}

	@Override
	public void onClick(View v) {
		
		String mobile=mobileEdit.getText().toString().trim();
		String verify=verifyEdit.getText().toString().trim();
		String pwd=passwordEdit.getText().toString().trim();
		switch (v.getId()) {
		case R.id.register_er_id:
		AppConfig.CloseKey(RegisterSecondActivity.this, v);
		break;
		case R.id.register_er_sendverifybtn:
			int netWork = CommonUtil.isNetworkAvailable(RegisterSecondActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equalsIgnoreCase(mobile) || mobile == null) {

					ToastUtil.show(this, "手机号不能为空");

				} else if (mobile.length() != 11) {

					ToastUtil.show(RegisterSecondActivity.this, "请输入11位的手机号");

				} else {
					// 该设置是获取验证码
					verifyBtn.onCreate(savedInstanceState);
					verifyBtn.setTextAfter("秒后重新获取").setTextBefore("获取")
							.setLenght(60 * 1000);
					AjaxParams params = new AjaxParams();
					params.put("phone", mobile);
					
					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.CHECKPHONE, params,
							new AjaxCallBack<String>() {
								@Override
								public void onSuccess(String t) {
										Toast.makeText(RegisterSecondActivity.this,
												"验证码发送成功", Toast.LENGTH_SHORT)
												.show();
								}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Log.i("mytag","验证码发送失败"+strMsg);
							Toast.makeText(RegisterSecondActivity.this, "验证码发送失败",
									Toast.LENGTH_SHORT).show();
						}
					});

				}
			} else {
				PromptManager.showNoNetWork(RegisterSecondActivity.this);
			}
			break;
		case R.id.register_er_eyebtn:

			break;
			
		case R.id.register_er_xieyi:
			Intent xiyyi=new Intent(RegisterSecondActivity.this, Bankinfo_UserxieyiActivity.class);
			startActivity(xiyyi);
			break;

		case R.id.register_er_nextbtn:
			// 立即注册
						int netWorkType = CommonUtil.isNetworkAvailable(RegisterSecondActivity.this);

						if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

							if ("".equalsIgnoreCase(mobile) || mobile == null) {

								ToastUtil.show(RegisterSecondActivity.this, "手机号不能为空");

							} else if ("".equals(verify) || verify == null) {

								ToastUtil.show(RegisterSecondActivity.this, "验证码不能为空");

							} else if ("".equalsIgnoreCase(pwd) || pwd == null) {

								ToastUtil.show(RegisterSecondActivity.this, "密码不能为空");

							} else if (pwd.length() < 6 || pwd.length() > 18) {

								ToastUtil.show(RegisterSecondActivity.this, "请输入6到18位的密码");

							} else if (mobile.length() != PHONE_LENGTH) {

								ToastUtil.show(RegisterSecondActivity.this, "请输入11位的手机号");

							} else {

								/***
								 * 和后台交互 判断验证码是否正确 正确了，再进行下一步操作
								 * 
								 * 需要对网络判断 * 姓名：username 手机号：mobileno IMEI：imei
								 * 
								 */
								AjaxParams params = new AjaxParams();
								params.put("name", username);
								params.put("phone", mobile);
								params.put("imei", AppConfig.getIMEI(RegisterSecondActivity.this));
								params.put("password",MD5Util.string2MD5(pwd));
								params.put("code",verify);
								params.put("phonekey",AppConfig.getAndroidId(RegisterSecondActivity.this));

								FinalHttp fh = new FinalHttp();

								fh.post(InternetURL.USER_REGISTER, params,
										new AjaxCallBack<String>() {
											@Override
											public void onFailure(Throwable t, int errorNo,
													String strMsg) {
												super.onFailure(t, errorNo, strMsg);
												ToastUtil.show(RegisterSecondActivity.this,"注册失败");
											}

											@Override
											public void onSuccess(String t) {

												super.onSuccess(t);
												Log.i("mytag","注册成功返回"+t.toString());
												if(!"".equals(t.toString())||t.toString()!=null){
													mRegisterVo=GsonUtils.fromJson(t.toString(),RegisterVo.class);
													int code=mRegisterVo.getCode();
													if(code==200){
														ToastUtil.show(RegisterSecondActivity.this,mRegisterVo.getInfo());
														SharedPreferencesUtils.saveString(RegisterSecondActivity.this,"token",mRegisterVo.getToken());
														SharedPreferencesUtils.saveString(RegisterSecondActivity.this,"phone",mRegisterVo.getPhone());
													}else if(code==400){
														ToastUtil.show(RegisterSecondActivity.this,mRegisterVo.getInfo());
													}else if(code==402){
														ToastUtil.show(RegisterSecondActivity.this,mRegisterVo.getInfo());
													}else if(code==405){
														ToastUtil.show(RegisterSecondActivity.this,mRegisterVo.getInfo());
													}else if(code==406){
														ToastUtil.show(RegisterSecondActivity.this,mRegisterVo.getInfo());
													}
												}
												
											}

										});

								break;
							}

						} else {

							PromptManager.showNoNetWork(RegisterSecondActivity.this);
						}
			break;
		}
	}
}
