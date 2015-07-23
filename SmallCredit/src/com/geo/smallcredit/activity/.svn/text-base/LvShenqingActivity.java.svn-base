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
import com.geo.smallcredit.utils.net.InternetURL;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LvShenqingActivity extends Activity implements OnClickListener {

	private Button btn;
	private Button imgback;
	private EditText name, num, mobile, mail, workName;
	private CheckBox cb;
	private TextView productName, productPrice;
	private LinearLayout mLiner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lvshenqing_activity);
		initview();
		initclick();
		
		// 点击外部键盘消失
		mLiner = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mLiner.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				
			}
		});
		
	}

	public void initview() {
		productName = (TextView) findViewById(R.id.lvshenqing_productname);
		productPrice = (TextView) findViewById(R.id.lvshenqing_productprice);
		imgback = (Button) findViewById(R.id.lvshenqing_imgback);
		btn = (Button) findViewById(R.id.lvshenqing_btn);
		name = (EditText) findViewById(R.id.lvshenqing_nameedit);
		num = (EditText) findViewById(R.id.lvshenqing_numedit);
		mobile = (EditText) findViewById(R.id.lvshenqing_mobileedit);
		mail = (EditText) findViewById(R.id.lvshenqing_mailedit);
		workName = (EditText) findViewById(R.id.lvshenqing_worknameedit);
		cb = (CheckBox) findViewById(R.id.lvshenqing_checkbox);
	}

	public void initclick() {
		imgback.setOnClickListener(this);
		btn.setOnClickListener(this);
		cb.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String proName = productName.getText().toString().trim();
		String proPrice = productPrice.getText().toString().trim();
		String xinMing = name.getText().toString().trim();
		String cardNum = num.getText().toString().trim();
		String phone = mobile.getText().toString().trim();
		String email = mail.getText().toString().trim();
		String work = workName.getText().toString().trim();

		switch (v.getId()) {
		case R.id.lvshenqing_imgback:
			finish();
			break;

		case R.id.lvshenqing_checkbox:

			View view = LayoutInflater.from(this).inflate(
					R.layout.xiao_xing_yong_xie_yi, null);
			WebView wv = (WebView) view.findViewById(R.id.webview);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.loadUrl("file:///android_asset/xiaoxinyong.html");

			new AlertDialog.Builder(this)
					.setTitle("小信用旅游产品服务协议")

					.setView(view)
					.setCancelable(false)
					.setPositiveButton("确认",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {

									cb.setChecked(true);
									mLiner = (LinearLayout) findViewById(R.id.traceroute_rootview);
									mLiner.setOnClickListener(new View.OnClickListener() {

										@Override
										public void onClick(View v) {
											InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
											imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
											
										}
									});
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									cb.setChecked(false);
									mLiner = (LinearLayout) findViewById(R.id.traceroute_rootview);
									mLiner.setOnClickListener(new View.OnClickListener() {

										@Override
										public void onClick(View v) {
											InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
											imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
											
										}
									});
								}
							}).create().show();
			break;

		case R.id.lvshenqing_btn:
			int netWorkType = CommonUtil
					.isNetworkAvailable(LvShenqingActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(xinMing) || xinMing == null) {

					Toast.makeText(LvShenqingActivity.this, "对不起，姓名也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(cardNum) || cardNum == null) {

					Toast.makeText(LvShenqingActivity.this, "对不起，身份证也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if (cardNum.length() < 18 || cardNum.length() > 18) {

					ToastUtil.show(LvShenqingActivity.this, "对不起，请输入18位身份证号");

				} else if ("".equalsIgnoreCase(phone) || phone == null) {
					Toast.makeText(LvShenqingActivity.this, "对不起，手机号不能为空",
							Toast.LENGTH_SHORT).show();

				} else if (phone.length() < 11 || phone.length() > 11) {

					ToastUtil.show(LvShenqingActivity.this, "对不起，请输入11位手机号");

				} else if ("".equalsIgnoreCase(email) || email == null) {

					ToastUtil.show(LvShenqingActivity.this, "对不起，邮箱不能为空");

				} else if (!cb.isChecked()) {

					ToastUtil.show(LvShenqingActivity.this, "您必须阅读小信用旅游产品服务协议");

				} else {

					AjaxParams params = new AjaxParams();
					params.put("product_name", proName);
					params.put("product_price", proPrice);
					params.put("userid", SharedPreferencesUtils.getString(
							LvShenqingActivity.this, "userid", null));
					params.put("androidid",
							AppConfig.getAndroidId(LvShenqingActivity.this));
					params.put("imei",
							AppConfig.getIMEI(LvShenqingActivity.this));

					Log.i("mytag",
							"=="
									+ AppConfig
											.getAndroidId(LvShenqingActivity.this)
									+ AppConfig
											.getIMEI(LvShenqingActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHECK_TRAVER_SHENQING, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									Log.i("mytag", strMsg);
									ToastUtil.show(LvShenqingActivity.this,
											"申请失败");
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									try {
										JSONObject json = new JSONObject(t
												.toString());

										String status = json
												.getString("status");

										Log.i("mytag", "返回====" + t);

										ToastUtil.show(LvShenqingActivity.this,
												"获取数据成功");

										if (Integer.parseInt(status) == 0) {

											ToastUtil.show(
													LvShenqingActivity.this,
													"旅游分期申请成功");
											Intent intent = new Intent(
													LvShenqingActivity.this,
													SuccessShenqingActivity.class);
											startActivity(intent);
										}
									} catch (JSONException e) {
										e.printStackTrace();
									}
								}
							});

				}

			} else {

				PromptManager.showNoNetWork(LvShenqingActivity.this);

			}

			break;
		}
	}

}
