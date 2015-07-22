package com.geo.smallcredit.activity;

import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.util.myDialog;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.TimeButton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BankInfoNewActivity extends Activity implements OnClickListener {

	private Button backBtn, nextBtn, phoneBtn;
	private TimeButton verifybtn;
	private EditText name, shenfen, mobile, verifyEdit;
	private CheckBox cb;
	private TextView xieyi, nowBtn, bankType, cartype, nowBtntwo,backtext;
	private Bundle savedInstanceState;
	private LinearLayout mLinearLayout;
	private View view, view_ka, viewBank;
	private AlertDialog.Builder builder;
	private ImageView img;
	private myDialog mydialog;
	private Intent data;
	private int REQUEST_CODE = 0;
	private String str_bankNum, ticket;

	private ImageButton ganTan1, ganTan2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bankinfo);
		view = LayoutInflater.from(BankInfoNewActivity.this).inflate(
				R.layout.tishidialog, null);
		view_ka = LayoutInflater.from(BankInfoNewActivity.this).inflate(
				R.layout.tishidialog_ka, null);
		viewBank = LayoutInflater.from(BankInfoNewActivity.this).inflate(
				R.layout.tishibankdialog, null);
		initView();

		data = getIntent();
		bankType.setText(data.getStringExtra("bankname"));
		cartype.setText(data.getStringExtra("cardType"));
		str_bankNum = data.getStringExtra("str_bankNum");// 银行卡号
		backtext.setText(data.getStringExtra("backText"));
		Log.i("mytag", "银行卡号："+str_bankNum);
		initClick();
	}

	public void initClick() {

		backBtn.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		verifybtn.setOnClickListener(this);
		phoneBtn.setOnClickListener(this);
		cb.setOnClickListener(this);
		xieyi.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);
		nowBtn.setOnClickListener(this);
		img.setOnClickListener(this);
		ganTan1.setOnClickListener(this);
		ganTan2.setOnClickListener(this);
		nowBtntwo.setOnClickListener(this);
	}

	public void initView() {

		backBtn = (Button) findViewById(R.id.bankinfo_backbtn);
		nextBtn = (Button) findViewById(R.id.bankinfo_nextbtn);
		verifybtn = (TimeButton) findViewById(R.id.bankinfo_verify_btn);
		bankType = (TextView) findViewById(R.id.bankinfo_banktype_edit);
		name = (EditText) findViewById(R.id.bankinfo_bankname_edit);
		phoneBtn = (Button) findViewById(R.id.bankinfo_phonebtn);
		shenfen = (EditText) findViewById(R.id.bankinfo_shenfennum_edit);
		mobile = (EditText) findViewById(R.id.bankinfo_mobile_edit);
		verifyEdit = (EditText) findViewById(R.id.bankinfo_verify_edit);
		cb = (CheckBox) findViewById(R.id.bankinfo_checkbox);
		xieyi = (TextView) findViewById(R.id.bankinfo_xieyitxt);
		mLinearLayout = (LinearLayout) findViewById(R.id.bankinfo_id);
		nowBtn = (TextView) view.findViewById(R.id.tishidialog_now);
		img = (ImageView) view_ka.findViewById(R.id.tishidialog_img);
		ganTan1 = (ImageButton) findViewById(R.id.bankinfo_bankname_btn);
		ganTan2 = (ImageButton) findViewById(R.id.bankinfo_bankname_btn2);
		cartype = (TextView) findViewById(R.id.bankinfo_cartype);
		nowBtntwo = (TextView) viewBank.findViewById(R.id.tishibankdialog_now);
		backtext=(TextView) findViewById(R.id.bankinfo_backtext);
	}

	@Override
	public void onClick(View v) {

		String type = bankType.getText().toString().trim();
		final String username = name.getText().toString().trim();
		final String num = shenfen.getText().toString().trim();
		String telphone = mobile.getText().toString().trim();
		String verify = verifyEdit.getText().toString().trim();

		switch (v.getId()) {
		case R.id.bankinfo_backbtn:
			this.finish();
			
			break;
		case R.id.bankinfo_id:
			AppConfig.CloseKey(BankInfoNewActivity.this, v);// 点击外部键盘消失
			break;
		case R.id.tishidialog_img:

			BankInfoNewActivity.this.finish();
			CreditpayActivity.instance.finish();
			RegisterActivity.instance.finish();
			BeginActivity.instance.finish();

			break;

		case R.id.bankinfo_bankname_btn:
			mydialog = new myDialog(BankInfoNewActivity.this);

			mydialog.showDialog(R.layout.tishidialog, 0, 0);

			break;

		case R.id.bankinfo_bankname_btn2:
			mydialog = new myDialog(BankInfoNewActivity.this);

			mydialog.showDialog(R.layout.tishibankdialog, 0, 0);

			break;

		case R.id.tishibankdialog_now:

			if (mydialog.isShowing()) {

				mydialog.dismiss();

			}

			break;
		case R.id.bankinfo_verify_btn:

			/***
			 * 判断是否有网络
			 */

			int netWork = CommonUtil
					.isNetworkAvailable(BankInfoNewActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equals(username) || username == null) {

					ToastUtil.show(BankInfoNewActivity.this, "姓名不能为空");

				} else if (num.length() < 18 || num.length() > 18) {

					ToastUtil.show(BankInfoNewActivity.this, "请输入18位身份证号");

				} else if ("".equalsIgnoreCase(telphone) || telphone == null) {

					ToastUtil.show(BankInfoNewActivity.this, "手机号不能为空");

				} else if (telphone.length() != 11) {

					ToastUtil.show(BankInfoNewActivity.this, "请输入11位手机号");

				} else {
					// 该设置是获取验证码
					verifybtn.onCreate(savedInstanceState);
					verifybtn.setTextAfter("秒后重新获取").setTextBefore("获取")
							.setLenght(60 * 1000);
					AjaxParams params = new AjaxParams();
					params.put("imei",
							AppConfig.getIMEI(BankInfoNewActivity.this));
					params.put("androidid",
							AppConfig.getAndroidId(BankInfoNewActivity.this));
					params.put("card_mobileno",telphone);
					params.put("card_number", str_bankNum);
					params.put("card_holder", username);
					params.put("id_number", num);
		           	Log.i("mytag",str_bankNum+username);
					params.put("userid",SharedPreferencesUtils.getString(BankInfoNewActivity.this,"userid", null));
					

					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.USER_BANK_RENZHENG_UPDATA, params,
							new AjaxCallBack<String>() {
								@Override
								public void onSuccess(String t) {
									Toast.makeText(BankInfoNewActivity.this,
											"验证码发送成功", Toast.LENGTH_SHORT)
											.show();
									try {// {"status":0,"userId":"ea215678-2523-11e5-8e40-643e8cc25414","ticket":null,"mobileNo":"18301371189","desc":"绑卡成功！"}
										JSONObject json = new JSONObject(t
												.toString());
										String status = json
												.getString("status");
										if ("0".equals(status)) {
											ticket = json.getString("ticket");
										}
									} catch (JSONException e) {
										e.printStackTrace();
									}
								}

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									Log.i("mytag", "验证失败--" + strMsg);
									Toast.makeText(BankInfoNewActivity.this,
											"验证码发送失败", Toast.LENGTH_SHORT)
											.show();
								}
							});
				}
			} else {
				PromptManager.showNoNetWork(BankInfoNewActivity.this);
			}
			break;

		case R.id.bankinfo_checkbox:

			break;

		case R.id.bankinfo_xieyitxt:

			Intent xieyi = new Intent(BankInfoNewActivity.this,
					Bankinfo_UserxieyiActivity.class);
			xieyi.putExtra("backText", "银行卡信息");
			startActivity(xieyi);

			break;
		case R.id.bankinfo_phonebtn:
			// 照相机

			// builder = new Builder(BankInfoNewActivity.this);
			// builder.setView(view);
			// builder.create().show();
			break;

		case R.id.bankinfo_nextbtn:

			builder = new Builder(BankInfoNewActivity.this);
			builder.setView(view);
			builder.create().show();

			break;

		case R.id.tishidialog_now:
			// 往后台提交银行卡 数据 成功后弹出dialog

			int netWorkType = CommonUtil
					.isNetworkAvailable(BankInfoNewActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				AjaxParams params = new AjaxParams();
				params.put("imei", AppConfig.getIMEI(BankInfoNewActivity.this));
				params.put("androidid",
						AppConfig.getAndroidId(BankInfoNewActivity.this));
				params.put("ticket", ticket);
				params.put("authcode", verify);

				FinalHttp fh = new FinalHttp();

				fh.post(InternetURL.USER_BANK_SUBMIT, params,
						new AjaxCallBack<String>() {
							@Override
							public void onFailure(Throwable t, int errorNo,
									String strMsg) {
								super.onFailure(t, errorNo, strMsg);

							}

							@Override
							public void onSuccess(String t) {

								super.onSuccess(t);
								Log.i("mytag", "==------" + t.toString());
								try {

									JSONObject json = new JSONObject(t
											.toString());

									// GsonUtils.fromJson(t, classOfT);
									String status = json.getString("status");

									if (Integer.parseInt(status) == 0) {
										// 注册成功后保存用户姓名 和身份证号
										SharedPreferencesUtils.saveString(
												BankInfoNewActivity.this,
												"username", username);
										SharedPreferencesUtils.saveString(
												BankInfoNewActivity.this,
												"shenfenId", num);

										new AlertDialog.Builder(
												BankInfoNewActivity.this)
												.setView(view_ka)
												.setCancelable(false).create()
												.show();

									} else if (Integer.parseInt(status) == 1) {

									} else if (Integer.parseInt(status) == 2) {

									}
								} catch (JSONException e) {
									e.printStackTrace();
								}

							}

						});
			}
			break;
		}
	}
}
