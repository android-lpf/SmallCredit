package com.geo.smallcredit.activity;


import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.MD5Util;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.BaseBean;

public class BeginActivity extends Activity implements OnClickListener {

	private Button begin_login_in;
	private EditText login_username, login_userpaw;
	private TextView begin_Forgot_password,to_reg;
	private LinearLayout mLeal;
	public static BeginActivity instance = null;
	private BaseBean mBaseBean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(BeginActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.begin_activity);
		initview();
		instance = this;
		onclick_btn();
	}

	public void initview() {

		begin_login_in = (Button) findViewById(R.id.begin_login_in);
		login_username = (EditText) findViewById(R.id.login_username);
		login_userpaw = (EditText) findViewById(R.id.login_userpaw);
		begin_Forgot_password = (TextView) findViewById(R.id.begin_Forgot_password);
		mLeal = (LinearLayout) findViewById(R.id.traceroute_rootview);
		to_reg=(TextView) findViewById(R.id.login_to_reg);
	}

	public void onclick_btn() {
		begin_login_in.setOnClickListener(this);
		begin_Forgot_password.setOnClickListener(this);
		mLeal.setOnClickListener(this);
		to_reg.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()) {
		case R.id.login_to_reg:
			Intent to_reg=new Intent(BeginActivity.this,RegisterYiActivity.class);
			startActivity(to_reg);
			break;
		case R.id.traceroute_rootview:
			// 点击外部键盘消失
			AppConfig.CloseKey(BeginActivity.this, arg0);
			break;
		case R.id.begin_login_in:

			final String username_str = login_username.getText().toString().trim();
			final String userpaw_str = login_userpaw.getText().toString().trim();

			String mpaw = MD5Util.string2MD5(userpaw_str);

			int netWorkType = CommonUtil.isNetworkAvailable(BeginActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(username_str) || username_str == null) {

					Toast.makeText(BeginActivity.this, "对不起，用户名不也能为空",
							Toast.LENGTH_SHORT).show();

				} else if(username_str.length()!=11){
					ToastUtil.show(BeginActivity.this,"请输入11位手机号");
				}else if ("".equalsIgnoreCase(userpaw_str)
						|| userpaw_str == null) {

					Toast.makeText(BeginActivity.this, "对不起，用户密码不也能为空",
							Toast.LENGTH_SHORT).show();

				}else {

					AjaxParams params = new AjaxParams();
					params.put("phone", username_str);
					params.put("password", mpaw);
					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.USER_LOGIN, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil.show(BeginActivity.this,"请求数据失败");
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									//{"code":200,"token":"MDAwMDAwMDAwMIK1yN6vh6mzssyJsIR1qnU","info":"\u767b\u5f55\u6210\u529f"}
									if(!"".equals(t.toString())||t.toString()!=null){
										mBaseBean=GsonUtils.fromJson(t.toString(), BaseBean.class);
										if(mBaseBean.getCode()==200){
											ToastUtil.show(BeginActivity.this,mBaseBean.getInfo());
											SharedPreferencesUtils.saveString(BeginActivity.this,"token", mBaseBean.getToken());
											SharedPreferencesUtils.saveString(BeginActivity.this,"phone", mBaseBean.getPhone());
											SharedPreferencesUtils.saveString(BeginActivity.this,"userid", mBaseBean.getUserid());
											Intent main_activity_intent=new Intent(BeginActivity.this,MainActivity.class);
											startActivity(main_activity_intent);
										}
										else{
											ToastUtil.show(BeginActivity.this,mBaseBean.getInfo());
										}
									}
								}

							});
				}

			} else {

				PromptManager.showNoNetWork(BeginActivity.this);

			}
			break;
		case R.id.begin_Forgot_password:
			
			Intent intent1 = new Intent(BeginActivity.this,
					FindPwdActivity.class);
			startActivity(intent1);

			break;
		}

	}

//	Handler handler = new Handler() {
//
//		public void handleMessage(Message msg) {
//
//			switch (msg.what) {
//
//			case 0x000:
//
//				final BaseBean bean = (BaseBean) msg.obj;
//
//				switch (bean.getStatus()) {
//
//				case 0:// {"status":0,"userId":"b4a95d62-05a5-11e5-8e40-643e8cc25414","desc":"登录成功"}
//					SharedPreferencesUtils.saveString(BeginActivity.this,
//							"userid", null);// 首先初始化 第一个用户 和第二个用户的数据混淆
//					SharedPreferencesUtils.saveString(BeginActivity.this,
//							"mobileno", null);
//
//					SharedPreferencesUtils.saveString(BeginActivity.this,
//							"userid", bean.getUserId());
//					SharedPreferencesUtils.saveString(BeginActivity.this,
//							"mobileno", bean.getMobileno());
//
//					// Toast.makeText(BeginActivity.this, "登录成功",
//					// Toast.LENGTH_SHORT).show();
//
//					AjaxParams params = new AjaxParams();
//					params.put("userid", SharedPreferencesUtils.getString(
//							BeginActivity.this, "userid", null));
//					FinalHttp fh = new FinalHttp();
//					fh.get(InternetURL.CEHCK_USER_BANK, params,
//							new AjaxCallBack<String>() {
//								@Override
//								public void onSuccess(String t) {
//									super.onSuccess(t);
//									Log.i("mytag", "绑卡了吗？" + t.toString());
//									try {// {"status":0,"desc":"银行卡列表获取成功","bankCardList":[]}
//										JSONObject jo = new JSONObject(t
//												.toString());
//										String status = jo.getString("status");
//										if ("0".equals(status)) {
//											JSONArray bankCardList = jo
//													.getJSONArray("bankCardList");
//											if (bankCardList.length() == 0) {
//												ToastUtil
//														.show(BeginActivity.this,
//																"对不起,您还没有绑定银行卡,请绑定您的银行卡");
//												Intent intent = new Intent(
//														BeginActivity.this,
//														CreditpayActivity.class);
//												startActivity(intent);
//												finish();
//											} else {
//												for (int i = 0; i < bankCardList
//														.length(); i++) {
//													JSONObject jos = bankCardList
//															.getJSONObject(i);
//
//													Intent intent = new Intent(
//															BeginActivity.this,
//															PasswordActivity.class);
//													startActivity(intent);
//													finish();
//												}
//											}
//										} else {
//											ToastUtil.show(BeginActivity.this,
//													"获取数据失败");
//										}
//
//									} catch (JSONException e) {
//										e.printStackTrace();
//									}
//								}
//							});
//					break;
//
//				case 1:// {"status":1,"userId":"","desc":"用户名或密码错误"}
//
//					ToastUtil.show(BeginActivity.this, "登录失败,用户名或密码错误");
//
//					break;
//				}
//
//				break;
//
//			}
//		};
//	};
//	
}
