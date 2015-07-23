package com.geo.smallcredit.activity;

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

public class MyAddpaymentPlanActivity extends Activity implements
		OnClickListener, OnItemSelectedListener {

	private Button backBtn, sureBtn;
	private EditText planName, payCard, payPrice;
	private CheckBox cb, cb2;
	private TextView backtxt,payCardBtn, shiPayDataBtn, jianPayData, jianPayDataBtn;
	private Spinner bankName, shiPayData;
	private LinearLayout mReal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myaddpaymentplan);
		initView();
		initClick();
		Intent intent = getIntent();
		backtxt.setText(intent.getStringExtra("backText"));
		bankCardNumAddSpace(payCard);
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
		// addBtn.setOnClickListener(this);
		sureBtn.setOnClickListener(this);
		cb.setOnClickListener(this);
		cb2.setOnClickListener(this);
		bankName.setOnItemSelectedListener(this);
		shiPayData.setOnItemSelectedListener(this);

	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.myaddpaymentplan_backbtn);
		// addBtn = (Button) findViewById(R.id.myaddpaymentplan_addbtn);
		sureBtn = (Button) findViewById(R.id.myaddpaymentplan_surebtn);
		planName = (EditText) findViewById(R.id.myaddpaymentplan_nameedit);
		payCard = (EditText) findViewById(R.id.myaddpaymentplan_cardnumedit);
		bankName = (Spinner) findViewById(R.id.myaddpaymentplan_banknamespinner);
		payPrice = (EditText) findViewById(R.id.myaddpaymentplan_paypriceedit);
		shiPayData = (Spinner) findViewById(R.id.myaddpaymentplan_shijipaydataspinner);
		jianPayData = (TextView) findViewById(R.id.myaddpaymentplan_jianyipaydataedit);
		cb = (CheckBox) findViewById(R.id.myaddpaymentplan_checkbox);
		cb2 = (CheckBox) findViewById(R.id.myaddpaymentplan_outcheckbox);
		payCardBtn = (TextView) findViewById(R.id.myaddpaymentplan_cardnumebtn);
		backtxt=(TextView)findViewById(R.id.myaddpaymentplan_backtext);
	}

	@Override
	public void onClick(View v) {
		String shiData = shiPayData.getSelectedItem().toString().trim();
		String str_planName = planName.getText().toString().trim();
		String str_payCard = payCard.getText().toString().trim();
		String str_bankName = bankName.getSelectedItem().toString().trim();
		String str_payPrice = payPrice.getText().toString().trim();
		String str_jianPayDataString = jianPayData.getText().toString().trim();

		switch (v.getId()) {
		case R.id.myaddpaymentplan_backbtn:
			this.finish();
			break;

		// case R.id.myaddpaymentplan_addbtn:
		// Intent add = new Intent(MyAddpaymentPlanActivity.this,
		// MyAddBankActivity.class);
		// startActivity(add);
		// break;

		case R.id.myaddpaymentplan_surebtn:

			int netWork = CommonUtil
					.isNetworkAvailable(MyAddpaymentPlanActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equals(str_planName) || str_planName == null) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，您的计划名称没有填写");

				} else if ("".equals(str_payCard) || str_payCard == null) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，请填写您的还款卡号");

				} else if (str_payCard.length() < 16
						|| str_payCard.length() > 19) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，请输入至少16位还款卡号");

				} else if ("".equals(str_bankName) || str_bankName == null) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，请选择您的所属银行");

				} else if ("".equals(str_payPrice) || str_payPrice == null) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，请填写您的还款金额");

				} else if ("".equals(shiData) || shiData == null) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，您还没有选择实际还款日");

				} else if ("".equals(str_jianPayDataString)
						|| str_jianPayDataString == null) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"对不起，请填写您的建议还款日");

				} else if (!cb.isChecked()) {

					ToastUtil.show(MyAddpaymentPlanActivity.this,
							"您必须阅读《定期还款服务协议》");
				} else {

					AjaxParams params = new AjaxParams();
					params.put("plan_name", str_planName);
					params.put("plan_bankcard", str_payCard);
					params.put("plan_bank", str_bankName);
					params.put("plan_amount", str_payPrice);
					params.put("plan_repayment_date", shiData);
					params.put("suggest_repayment_date", str_jianPayDataString);
					params.put("userid", SharedPreferencesUtils.getString(
							MyAddpaymentPlanActivity.this, "userid", null));
					params.put("imei",
							AppConfig.getIMEI(MyAddpaymentPlanActivity.this));
					params.put("androidid", AppConfig
							.getAndroidId(MyAddpaymentPlanActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.HUAN_KUAN_ADD, params,
							new AjaxCallBack<Object>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);

									ToastUtil.show(
											MyAddpaymentPlanActivity.this,
											"上传失败");
								}

								@Override
								public void onSuccess(Object t) {
									super.onSuccess(t);

									ToastUtil.show(
											MyAddpaymentPlanActivity.this,
											"上传成功");

									Intent intent = new Intent(
											MyAddpaymentPlanActivity.this,
											MyPaymentPlanActivity.class);
									startActivity(intent);
								}

							});

				}
			} else {
				PromptManager.showNoNetWork(MyAddpaymentPlanActivity.this);
			}

			break;

		case R.id.myaddpaymentplan_checkbox:

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
		case R.id.myaddpaymentplan_outcheckbox:

			View vv = LayoutInflater.from(this).inflate(
					R.layout.xiao_xing_yong_xie_yi, null);
			WebView web = (WebView) vv.findViewById(R.id.webview);
			web.getSettings().setJavaScriptEnabled(true);
			web.loadUrl("file:///android_asset/xiaoxinyong.html");

			new AlertDialog.Builder(this)
					.setTitle("信用付款(小信用)服务协议")
					.setView(vv)
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
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {

		String[] languages = getResources().getStringArray(R.array.mouth);

		String str = languages[arg2];

		TextView t = (TextView) v;
		t.setTextColor(getResources().getColor(R.color.white));
		t.setTextSize(12);

		// 获取的日期
		String shiData = shiPayData.getSelectedItem().toString().trim();

		String jianyi = shiData.substring(2, 4);
		int ins = Integer.parseInt(jianyi);
		if (ins == 01) {
			jianPayData.setText("本月28日");
		} else if (ins == 02) {
			jianPayData.setText("本月28日");
		} else if (ins == 03) {
			jianPayData.setText("本月28日");
		} else {
			jianPayData.setText(ins - 3 + "日");
		}
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
