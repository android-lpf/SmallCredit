package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import com.geo.smallcredit.R;
import com.geo.smallcredit.popwindow.SelectPicPopupWindow;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class XinbaoCreditpayment_JieActivity extends Activity implements
		OnClickListener, OnItemSelectedListener {

	private Spinner sp, daySpinner;
	private EditText price, miaoShu;
	private TextView fuWu, payment;
	private Button imgBack, telBtn, saveBtn;
	SelectPicPopupWindow menuWindow;
	private LinearLayout mReal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.xinbaocreditpayment_jiekuan);
		initView();
		initClick();

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
		sp.setOnItemSelectedListener(this);
		daySpinner.setOnItemSelectedListener(this);
		imgBack.setOnClickListener(this);
		telBtn.setOnClickListener(this);
		saveBtn.setOnClickListener(this);
	}

	private void initView() {
		sp = (Spinner) findViewById(R.id.xinbaocreditpayment_jiekuan_spinner1);
		daySpinner = (Spinner) findViewById(R.id.xinbaocreditpayment_jiekuan_dayspinner);
		imgBack = (Button) findViewById(R.id.xinbaocreditpayment_jiekuan_imgback);
		price = (EditText) findViewById(R.id.xinbaocreditpayment_jiekuan_price);
		miaoShu = (EditText) findViewById(R.id.xinbaocreditpayment_jiekuan_miaoshu);
		fuWu = (TextView) findViewById(R.id.xinbaocreditpayment_jiekuan_fuwufei);
		payment = (TextView) findViewById(R.id.xinbaocreditpayment_jiekuan_payment);
		telBtn = (Button) findViewById(R.id.xinbaocreditpayment_jiekuan_telbtn);
		saveBtn = (Button) findViewById(R.id.xinbaocreditpayment_jiekuan_savebtn);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2,
			long arg3) {
		String[] languages = getResources().getStringArray(R.array.mouth);
		String str = languages[arg2];
		Log.i("mytag", "spinner===点击的是===" + str);
		
		TextView tv = (TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	public void onClick(View v) {
		String qiXian = sp.getSelectedItem().toString().trim();
		String day = daySpinner.getSelectedItem().toString().trim();
		String jiePrice = price.getText().toString().trim();
		String miao = miaoShu.getText().toString().trim();
		String fuwufei = fuWu.getText().toString().trim();
		String datapayment = payment.getText().toString().trim();
		switch (v.getId()) {
		case R.id.xinbaocreditpayment_jiekuan_imgback:
			finish();
			break;

		case R.id.xinbaocreditpayment_jiekuan_telbtn:
			menuWindow = new SelectPicPopupWindow(
					XinbaoCreditpayment_JieActivity.this, itemsOnClick);
			// 显示窗口
			menuWindow.showAtLocation(XinbaoCreditpayment_JieActivity.this
					.findViewById(R.id.xinbaocreditpayment_jiekuan),
					Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置lay
			break;

		case R.id.xinbaocreditpayment_jiekuan_savebtn:
			int netWorkType = CommonUtil
					.isNetworkAvailable(XinbaoCreditpayment_JieActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(jiePrice) || jiePrice == null) {

					ToastUtil.show(XinbaoCreditpayment_JieActivity.this,
							"借款金额不能为空");

				} else if ("".equalsIgnoreCase(qiXian) || qiXian == null) {

					ToastUtil.show(XinbaoCreditpayment_JieActivity.this,
							"您还没有选择借款期限");

				} else if ("".equalsIgnoreCase(day) || day == null) {

					ToastUtil.show(XinbaoCreditpayment_JieActivity.this,
							"您还没有选择每月还款日");

				} else if ("".equals(miao) || miao == null) {

					ToastUtil.show(XinbaoCreditpayment_JieActivity.this,
							"借款描述不能为空");

				} else {
					/***
					 * 和后台交互 ，再进行下一步操作
					 * 
					 * 需要对网络判断 *
					 * 
					 */
					AjaxParams params = new AjaxParams();

					params.put("credit_amount", jiePrice);
					params.put("credit_term", qiXian);
					params.put("credit_refund_date", day);
					params.put("credit_desc", miao);
					params.put("credit_fee", fuwufei);
					params.put("credit_refund_amount", datapayment);
					params.put("userid", SharedPreferencesUtils.getString(
							XinbaoCreditpayment_JieActivity.this, "userid",
							null));
					params.put("androidid", AppConfig
							.getAndroidId(XinbaoCreditpayment_JieActivity.this));
					params.put("imei", AppConfig
							.getIMEI(XinbaoCreditpayment_JieActivity.this));

					Log.i("mytag",
							"===="
									+ AppConfig
											.getAndroidId(XinbaoCreditpayment_JieActivity.this)
									+ AppConfig
											.getIMEI(XinbaoCreditpayment_JieActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHECK_XINBAOPAYMENT, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);

									Log.i("mytag", strMsg);

									ToastUtil
											.show(XinbaoCreditpayment_JieActivity.this,
													"保存失败");
								}

								@Override
								public void onSuccess(String t) {

									super.onSuccess(t);
									try {

										JSONObject json = new JSONObject(t
												.toString());

										// GsonUtils.fromJson(t, classOfT);
										String status = json
												.getString("status");

										Log.i("mytag", "返回=" + t.toString());

										if (Integer.parseInt(status) == 0) {

											ToastUtil
													.show(XinbaoCreditpayment_JieActivity.this,
															"保存成功");
											finish();
										}

									} catch (JSONException e) {
										e.printStackTrace();
									}

								}

							});

					break;
				}

			} else {

				PromptManager
						.showNoNetWork(XinbaoCreditpayment_JieActivity.this);
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

}
