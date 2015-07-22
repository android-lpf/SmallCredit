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
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.BaseBean;
import com.geo.smallcredit.vo.Popuw;
import com.geo.smallcredit.vo.ShenfengBean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HouseCreditApplication_jiekuan_Activity extends Activity implements
		OnClickListener, OnItemSelectedListener {

	private Spinner sp;
	private EditText price, miaoShu;
	private TextView shenQing, fuWu, payment;
	private Button imgBack,telBtn, saveBtn;
	private LinearLayout mReal;
	SelectPicPopupWindow menuWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.housecreditapplication_jiekuan_activity);
		initview();
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

	public void initview() {

		sp = (Spinner) findViewById(R.id.housecreditApplication_jiekuan_spinner1);
		imgBack = (Button) findViewById(R.id.housecreditApplication_jiekuan_imgback);
		price = (EditText) findViewById(R.id.housecreditApplication_jiekuan_price);
		miaoShu = (EditText) findViewById(R.id.housecreditApplication_jiekuan_miaoshu);
		fuWu = (TextView) findViewById(R.id.housecreditApplication_jiekuan_fuwufei);
		payment = (TextView) findViewById(R.id.housecreditApplication_jiekuan_payment);
		telBtn = (Button) findViewById(R.id.housecreditApplication_jiekuan_telbtn);
		saveBtn = (Button) findViewById(R.id.housecreditApplication_jiekuan_savebtn);
	}

	public void initClick() {

		sp.setOnItemSelectedListener(this);
		imgBack.setOnClickListener(this);
		telBtn.setOnClickListener(this);
		saveBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		String jiePrice = price.getText().toString().trim();
		String qiXian = sp.getSelectedItem().toString().trim();
		String miao = miaoShu.getText().toString().trim();
		String fuwufei = fuWu.getText().toString().trim();
		String datapayment = payment.getText().toString().trim();

		switch (v.getId()) {
		case R.id.housecreditApplication_jiekuan_imgback:
			finish();
			break;
		case R.id.housecreditApplication_jiekuan_telbtn:

			menuWindow = new SelectPicPopupWindow(
					HouseCreditApplication_jiekuan_Activity.this, itemsOnClick);
			// 显示窗口
			menuWindow.showAtLocation(
					HouseCreditApplication_jiekuan_Activity.this
							.findViewById(R.id.housecreditApplication_jiekuan),
					Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置lay
			break;

		case R.id.housecreditApplication_jiekuan_savebtn:
			int netWorkType = CommonUtil
					.isNetworkAvailable(HouseCreditApplication_jiekuan_Activity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(jiePrice) || jiePrice == null) {

					ToastUtil.show(
							HouseCreditApplication_jiekuan_Activity.this,
							"借款金额不能为空");

				} else if ("".equalsIgnoreCase(qiXian) || qiXian == null) {

					ToastUtil.show(
							HouseCreditApplication_jiekuan_Activity.this,
							"您还没有选择借款期限");

				} else if ("".equals(miao) || miao == null) {

					ToastUtil.show(
							HouseCreditApplication_jiekuan_Activity.this,
							"借款描述不能为空");

				} else {
					/***
					 * 和后台交互 ，再进行下一步操作
					 * 
					 * 需要对网络判断 * 姓名：username 手机号：mobileno IMEI：imei
					 * 
					 */
					AjaxParams params = new AjaxParams();

					params.put("credit_amount", jiePrice);
					params.put("credit_term", qiXian);
					params.put("credit_desc", miao);
					params.put("credit_fee", fuwufei);
					params.put("credit_refund_amount", datapayment);
					params.put("userid", SharedPreferencesUtils.getString(
							HouseCreditApplication_jiekuan_Activity.this,
							"userid", null));
					params.put(
							"androidid",
							AppConfig
									.getAndroidId(HouseCreditApplication_jiekuan_Activity.this));
					params.put("imei",AppConfig.getIMEI(HouseCreditApplication_jiekuan_Activity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHECK_HOUSEPAYMENT, params,
							new AjaxCallBack<String>() {
								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);

									ToastUtil.show(HouseCreditApplication_jiekuan_Activity.this,"保存失败");
								}

								@Override
								public void onSuccess(String t) {

									super.onSuccess(t);

									try {

										JSONObject json = new JSONObject(t
												.toString());

										// GsonUtils.fromJson(t, classOfT);
										String status = json.getString("status");

										if (Integer.parseInt(status) == 0) {

											ToastUtil.show(HouseCreditApplication_jiekuan_Activity.this,
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
						.showNoNetWork(HouseCreditApplication_jiekuan_Activity.this);
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

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2,
			long arg3) {

		String[] languages = getResources().getStringArray(R.array.languages);

		String str = languages[arg2];
		Log.i("mytag", "spinner===点击的是===" + str);
		TextView tv = (TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
}
