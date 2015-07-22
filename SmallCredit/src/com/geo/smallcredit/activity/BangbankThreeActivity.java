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
import com.geo.smallcredit.vo.BangBankVo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BangbankThreeActivity extends Activity implements OnClickListener {

	private Button nextbtn, backBtn;
	private View view;
	private Intent intent;
	private ImageView img;
	private TextView backtxt, wei_two, wei_one, bankname_two, bankname_one,
			data_one, data_two, money, bei;
	public BangBankVo bangbankvo = new BangBankVo();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bangbank_three_activity);
		initview();
		intent = getIntent();

		bangbankvo = (BangBankVo) intent.getSerializableExtra("bangbank");
		backtxt.setText(intent.getStringExtra("backText"));
		showDate();

		initclick();
	}

	public void initview() {
		view = LayoutInflater.from(BangbankThreeActivity.this).inflate(
				R.layout.tishidialog_huan, null);
		nextbtn = (Button) findViewById(R.id.bangbankthree_nextbtn);
		backBtn = (Button) findViewById(R.id.bangbankthree_backbtn);
		img = (ImageView) view.findViewById(R.id.bangbank_img);

		wei_two = (TextView) findViewById(R.id.bangbank_weihao_two);
		wei_one = (TextView) findViewById(R.id.bangbank_weihao_one);

		bankname_two = (TextView) findViewById(R.id.bangbank_name_two);
		bankname_one = (TextView) findViewById(R.id.bangbank_name_one);

		data_one = (TextView) findViewById(R.id.bangbank_data_one);
		data_two = (TextView) findViewById(R.id.bangbank_data_two);

		money = (TextView) findViewById(R.id.bangbank_money_two);
		bei = (TextView) findViewById(R.id.bangbank_bei_two);

		backtxt = (TextView) findViewById(R.id.bangbankthree_backtext);
	}

	public void initclick() {
		nextbtn.setOnClickListener(this);
		backBtn.setOnClickListener(this);
		img.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bangbankthree_nextbtn:

			new AlertDialog.Builder(BangbankThreeActivity.this).setView(view)
					.setCancelable(false).create().show();
			break;

		case R.id.bangbankthree_backbtn:
			finish();
			break;
		case R.id.bangbank_img:

			int netWork = CommonUtil
					.isNetworkAvailable(BangbankThreeActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				AjaxParams params = new AjaxParams();

				params.put("plan_bankcard_in", bangbankvo.getPlan_bankcard());// plan_bankcard_in
																				// 转入卡

				params.put("userid", SharedPreferencesUtils.getString(
						BangbankThreeActivity.this, "userid", null));
				params.put("imei",
						AppConfig.getIMEI(BangbankThreeActivity.this));
				params.put("androidid",
						AppConfig.getAndroidId(BangbankThreeActivity.this));

				FinalHttp fh = new FinalHttp();
				fh.post(InternetURL.WU_YOU_THREE, params,
						new AjaxCallBack<String>() {

							@Override
							public void onFailure(Throwable t, int errorNo,
									String strMsg) {
								super.onFailure(t, errorNo, strMsg);
							}

							@Override
							public void onSuccess(String t) {
								super.onSuccess(t);
								ToastUtil.show(BangbankThreeActivity.this,
										"还款计划添加成功");
							}

						});

			} else {
				PromptManager.showNoNetWork(BangbankThreeActivity.this);
			}

			Intent payment1 = new Intent(BangbankThreeActivity.this,
					MySecurePaymentActivity.class);
			startActivity(payment1);
			finish();
			Bangbank_two_Activity.instance.finish();
			bangBankActivity.instance.finish();
			MySecurepaymentInfoActivity.instance.finish();
			break;
		}
	}

	public void showDate() {
		wei_two.setText("尾号:"
				+ bangbankvo.getPlan_bankcard_out().substring(12, 16));
		wei_one.setText("尾号:"
				+ bangbankvo.getPlan_bankcard().subSequence(12, 16));

		bankname_two.setText(bangbankvo.getBankname_two());
		bankname_one.setText(bangbankvo.getStr_bankname());

		data_one.setText(bangbankvo.getStr_dataSp());
		data_two.setText(bangbankvo.getSuggest_repayment_date());

		money.setText(bangbankvo.getPlan_amount());
		bei.setText(bangbankvo.getStr_bei());
	}
}
