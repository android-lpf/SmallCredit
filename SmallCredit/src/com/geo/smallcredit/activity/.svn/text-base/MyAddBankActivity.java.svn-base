package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.TimeButton;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
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
import android.widget.Toast;

public class MyAddBankActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {

	private Button backBtn, saveBtn;
	private TimeButton send;
	private EditText name, num, mobile, verify;
	private TextView agree;
	private CheckBox cb;
	private Bundle savedInstanceState;
	private String androidId;
	private int PHONE_LENGTH = 11;
	private Spinner useSp, banktype, Ktype;
	private TelephonyManager tm;
	private LinearLayout mReal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_bankinfo_addbank);
		tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);// 由于获取手机唯一ID
		androidId = Secure.getString(this.getContentResolver(),
				Secure.ANDROID_ID);
		initView();
		initClick();
		bankCardNumAddSpace(num);
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
		send.setOnClickListener(this);
		saveBtn.setOnClickListener(this);
		useSp.setOnItemSelectedListener(this);
		banktype.setOnItemSelectedListener(this);
		Ktype.setOnItemSelectedListener(this);
		cb.setOnClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.my_bankinfo_addbank_backbtn);
		name = (EditText) findViewById(R.id.my_bankinfo_addbank_bankpersonname_edit);// 持卡人
		num = (EditText) findViewById(R.id.my_bankinfo_addbank_banknum_edit);// 卡号
		mobile = (EditText) findViewById(R.id.my_bankinfo_addbank_mobileedit);// 手机号
		verify = (EditText) findViewById(R.id.my_bankinfo_addbank_verifyedit);// 验证码
		send = (TimeButton) findViewById(R.id.my_bankinfo_addbank_sendverify);
		agree = (TextView) findViewById(R.id.my_bankinfo_addbank_agree);
		cb = (CheckBox) findViewById(R.id.my_bankinfo_addbank_checkbox);
		saveBtn = (Button) findViewById(R.id.my_bankinfo_addbank_savebtn);
		useSp = (Spinner) findViewById(R.id.my_bankinfo_addbank_usespinner);// 用途
		banktype = (Spinner) findViewById(R.id.my_bankinfo_addbank_banktype_spinner);// 银行
		Ktype = (Spinner) findViewById(R.id.my_bankinfo_addbank_banktypespinner);// 卡类型

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void onClick(View v) {

		String verifyEdit = verify.getText().toString().trim();// 验证码
		String cardName = name.getText().toString().trim();
		String cardNum = num.getText().toString().trim();
		String telphone = mobile.getText().toString().trim();

		String str_useSp = useSp.getSelectedItem().toString().trim();
		String str_banktype = banktype.getSelectedItem().toString().trim();
		String str_Ktype = Ktype.getSelectedItem().toString().trim();
		if ("借记卡".equals(str_Ktype)) {
			str_Ktype = "";
		} else {
			str_Ktype = "";
		}
		switch (v.getId()) {
		case R.id.my_bankinfo_addbank_backbtn:
			finish();
			break;

		case R.id.my_bankinfo_addbank_sendverify:
			/***
			 * 判断是否有网络
			 */
			int netWork = CommonUtil.isNetworkAvailable(MyAddBankActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equalsIgnoreCase(telphone) || telphone == null) {

					ToastUtil.show(this, "手机号不能为空");

				} else if (telphone.length() != 11) {

					ToastUtil.show(MyAddBankActivity.this, "请输入11位的手机号");

				} else {
					// 该设置是获取验证码
					send.setTextAfter("秒后重新获取").setTextBefore("获取")
							.setLenght(60 * 1000);
					FinalHttp fh = new FinalHttp();

					AjaxParams params = new AjaxParams();
					params.put("card_category", str_Ktype);
					params.put("card_ower", cardName);
					params.put("card_bank", str_banktype);
					params.put("card_number", cardNum);
					params.put("card_use", str_useSp);
					params.put("card_mobileno", telphone);
					params.put("imei",
							AppConfig.getIMEI(MyAddBankActivity.this));
					params.put("androidid",
							AppConfig.getAndroidId(MyAddBankActivity.this));
					// params.put("authcode", "验证码");

					fh.post(InternetURL.USER_BANK_RENZHENG_UPDATA, params,
							new AjaxCallBack<Object>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									Log.i("mytag", "添加银行卡 验证码返回--==" + strMsg);

									ToastUtil.show(MyAddBankActivity.this,
											"发送失败");
								}

								@Override
								public void onSuccess(Object t) {
									super.onSuccess(t);
									ToastUtil.show(MyAddBankActivity.this,
											"发送成功");
								}
							});

				}
			} else {
				PromptManager.showNoNetWork(MyAddBankActivity.this);
			}

			break;
		case R.id.my_bankinfo_addbank_checkbox:

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
		case R.id.my_bankinfo_addbank_savebtn:
			int netWorkType = CommonUtil
					.isNetworkAvailable(MyAddBankActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(telphone) || telphone == null) {

					ToastUtil.show(MyAddBankActivity.this, "手机号不能为空");

				} else if ("".equals(verifyEdit) || verifyEdit == null) {

					ToastUtil.show(MyAddBankActivity.this, "验证码不能为空");

				} else if ("".equalsIgnoreCase(cardName) || cardName == null) {

					ToastUtil.show(MyAddBankActivity.this, "持卡人不能为空");

				} else if (telphone.length() != PHONE_LENGTH) {

					ToastUtil.show(MyAddBankActivity.this, "请输入11位的手机号");

				} else if (!cb.isChecked()) {

					ToastUtil.show(MyAddBankActivity.this, "您必须阅读小信用服务协议");

				} else {
					/**
					 * 和后台交互
					 */
					Intent it = new Intent(MyAddBankActivity.this,
							MyTificationBankActivity.class);
					startActivity(it);

				}

			} else {

				PromptManager.showNoNetWork(MyAddBankActivity.this);
			}

			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {
		TextView tv = (TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
		hintKbTwo();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

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
