package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.CheckBank;

public class CreditpayActivity extends Activity implements OnClickListener {

	private Button imgBack, nextBtn;
	private EditText bankNum;
	private LinearLayout mLinearLayout;
	public static CreditpayActivity instance = null;
	private TextView backtext;
	private Intent  intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.creditpay_unbind_bank);
		initview();
		instance = this;
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initclick();
		bankCardNumAddSpace(bankNum);
	}

	public void initview() {
		imgBack = (Button) findViewById(R.id.creditpay_imgback);
		nextBtn = (Button) findViewById(R.id.creditpay_unbindbank_nextbtn);
		bankNum = (EditText) findViewById(R.id.creditpay_unbindbank_edit);
		mLinearLayout = (LinearLayout) findViewById(R.id.creditpay_id);
		backtext=(TextView) findViewById(R.id.creditpay_unbind_backtext);
	}

	public void initclick() {
		imgBack.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);  
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.creditpay_imgback:
			finish();
			break;
		case R.id.creditpay_unbindbank_nextbtn:

			final String str_bankNum=bankNum.getText().toString().trim();
			Log.i("mytag","===----"+str_bankNum.substring(0,4)+str_bankNum.substring(5,9)+str_bankNum.substring(10,14)+str_bankNum.substring(15,19));
			int netWorkType = CommonUtil
					.isNetworkAvailable(CreditpayActivity.this);


			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {
				if ("".equals(str_bankNum) || str_bankNum == null) {

					ToastUtil.show(CreditpayActivity.this, "请输入您的银行卡卡号");

				} else if (str_bankNum.length() < 16||str_bankNum.length() > 23) {
					ToastUtil.show(CreditpayActivity.this, "请输入至少16-19位的银行卡卡号");

				} else {
					AjaxParams params = new AjaxParams();
					params.put("imei",
							AppConfig.getIMEI(CreditpayActivity.this));
					params.put("androidid",
							AppConfig.getAndroidId(CreditpayActivity.this));
					params.put("card_number", str_bankNum.substring(0,4)+str_bankNum.substring(5,9)+str_bankNum.substring(10,14)+str_bankNum.substring(15,19));
					FinalHttp fh = new FinalHttp();
					fh.get(InternetURL.CHECK_BANK, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									Log.i("mytag", "==----" + strMsg);
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									Log.i("mytag","验证卡号："+t.toString());
									if (!"".equals(t.toString())) {
										CheckBank cb = GsonUtils.fromJson(t,
												CheckBank.class);
										if (!"借记卡".equals(cb.getCardType())) {
											ToastUtil.show(
													CreditpayActivity.this,
													"目前仅支持借记卡");
										} else if (!"Y".equals(cb.getIsSupport())) {
											ToastUtil.show(
													CreditpayActivity.this,
													"目前不支持该行");
										} else {

											Intent intent = new Intent(
													CreditpayActivity.this,
													BankInfoNewActivity.class);
											intent.putExtra("backText","开通信用账户");
											intent.putExtra("bankname",
													cb.getBankName());
											intent.putExtra("cardType",
													cb.getCardType());
											intent.putExtra("str_bankNum",
													str_bankNum.substring(0,4)+str_bankNum.substring(5,9)+str_bankNum.substring(10,14)+str_bankNum.substring(15,19));
											startActivity(intent);
										}
									} else {
										ToastUtil.show(CreditpayActivity.this,"您输入的银行卡有误");
									}
								}

							});
				}
			} else {

				PromptManager.showNoNetWork(CreditpayActivity.this);
			}
			break;
		case R.id.creditpay_id:
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			break;
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
