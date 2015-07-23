package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.geo.smallcredit.R;
import com.geo.smallcredit.popwindow.SelectPicPopupWindow;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;

public class CarBankInfoActivity extends Activity implements OnClickListener {

	private Button backBtn, telBtn, saveBtn;
	private ImageButton imgBtn;
	private EditText bankName, num;
	// 自定义的弹出框类
	SelectPicPopupWindow menuWindow;
	private LinearLayout mLiner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.car_bankinfo);
		initView();
		initClick();
		bankCardNumAddSpace(num);
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

	private void initClick() {
		backBtn.setOnClickListener(this);
		telBtn.setOnClickListener(this);
		saveBtn.setOnClickListener(this);
		imgBtn.setOnClickListener(this);
	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.car_bankinfo_backbtn);
		telBtn = (Button) findViewById(R.id.car_bankinfo_telbtn);
		saveBtn = (Button) findViewById(R.id.car_bankinfo_savebtn);
		imgBtn = (ImageButton) findViewById(R.id.car_bankinfo_addimgbtn);
		bankName = (EditText) findViewById(R.id.car_bankinfo_banknameedit);
		num = (EditText) findViewById(R.id.car_bankinfo_banknumedit);
	}

	@Override
	public void onClick(View v) {

		String name = bankName.getText().toString().trim();
		String cardNum = num.getText().toString().trim();

		switch (v.getId()) {
		case R.id.car_bankinfo_backbtn:
			finish();
			break;

		case R.id.car_bankinfo_telbtn:
			// 实例化SelectPicPopupWindow
			menuWindow = new SelectPicPopupWindow(CarBankInfoActivity.this,
					itemsOnClick);
			// 显示窗口
			menuWindow.showAtLocation(
					CarBankInfoActivity.this.findViewById(R.id.car_bankinfo),
					Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
			break;

		case R.id.car_bankinfo_addimgbtn:

			Intent add = new Intent(CarBankInfoActivity.this,
					MyAddBankActivity.class);
			startActivity(add);

			break;

		case R.id.car_bankinfo_savebtn:
			int netWorkType = CommonUtil
					.isNetworkAvailable(CarBankInfoActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(name) || name == null) {

					ToastUtil.show(CarBankInfoActivity.this, "银行不能为空");

				} else if ("".equals(cardNum) || cardNum == null) {

					ToastUtil.show(CarBankInfoActivity.this, "卡号不能为空");

				} else if (cardNum.length() < 16 || cardNum.length() > 19) {

					ToastUtil.show(CarBankInfoActivity.this, "请输入正确的卡号");

				} else {
					/***
					 * 和后台交互
					 * 
					 * 需要对网络判断 *
					 * 
					 */
					AjaxParams params = new AjaxParams();

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.REGISTER, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil.show(CarBankInfoActivity.this,
											"保存失败");
								}

								@Override
								public void onSuccess(String t) {

									super.onSuccess(t);

									ToastUtil.show(CarBankInfoActivity.this,
											"保存成功");
									finish();

								}

							});

					break;
				}

			} else {

				PromptManager.showNoNetWork(CarBankInfoActivity.this);
			}
			break;
		}
	}

	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
		}
	};

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
