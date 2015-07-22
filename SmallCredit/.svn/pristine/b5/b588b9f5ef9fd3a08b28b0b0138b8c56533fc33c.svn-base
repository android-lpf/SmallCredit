package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyCreditpayActivity extends Activity implements OnClickListener {

	private Button imgBack, nextBtn;
	private EditText bankNum;
	private LinearLayout mLinearLayout;
	public static MyCreditpayActivity instance = null;
	private TextView backtxt;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_creditpay_unbindbank);
		initview();
		intent=getIntent();
		backtxt.setText(intent.getStringExtra("backText"));
		instance = this;
		initclick();
		bankCardNumAddSpace(bankNum);
		// 点击外部键盘消失
		mLinearLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
		});
	}

	public void initview() {
		imgBack = (Button) findViewById(R.id.my_creditpay_imgback);
		nextBtn = (Button) findViewById(R.id.my_creditpay_unbindbank_nextbtn);
		bankNum = (EditText) findViewById(R.id.my_creditpay_unbindbank_edit);
		mLinearLayout = (LinearLayout) findViewById(R.id.my_creditpay_id);
		backtxt=(TextView)findViewById(R.id.my_creditpay_backtxt);
	}

	public void initclick() {
		imgBack.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_creditpay_imgback:
			this.finish();
			break;
		case R.id.my_creditpay_unbindbank_nextbtn:
			String str_bankNum = bankNum.getText().toString().trim();
			int netWorkType = CommonUtil
					.isNetworkAvailable(MyCreditpayActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {
				if ("".equals(str_bankNum) || str_bankNum == null) {

					ToastUtil.show(MyCreditpayActivity.this, "请输入您的银行卡卡号");

				} else if (str_bankNum.length() < 16
						|| str_bankNum.length() > 23) {
					ToastUtil.show(MyCreditpayActivity.this, "请输入18位的银行卡卡号");

				} else {
					Intent intent = new Intent(MyCreditpayActivity.this,
							BankInfoNewActivity.class);
					intent.putExtra("backText", "开通信用账户");
					startActivity(intent);
				}
			} else {

				PromptManager.showNoNetWork(MyCreditpayActivity.this);
			}
			break;
		case R.id.my_creditpay_id:
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
