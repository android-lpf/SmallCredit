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
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Bangbank_two_Activity extends Activity implements OnClickListener,
		OnItemSelectedListener {

	private Button backbtn, nextBtn;
	private EditText money, beizhu;
	private RelativeLayout mRelativeLayout;
	private TextView bank_name, bank_4num;
	private int REQUEST_CODE = 0;
	public static Bangbank_two_Activity instance = null;
	private LinearLayout mLinearLayout;
	private Spinner sp;
	private TextView backtxt, xieyi;
	private Intent intent;
	private String plan_bankcard, plan_bankcard_out, str_dataSp, str_money,
			str_bankname, bankname_two;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bangbank_two_activity);
		initview();
		intent = getIntent();
		plan_bankcard = intent.getStringExtra("plan_bankcard");
		str_dataSp = intent.getStringExtra("str_dataSp");
		str_money = intent.getStringExtra("str_money");
		str_bankname = intent.getStringExtra("str_bankname");
		backtxt.setText(intent.getStringExtra("backText"));
		instance = this;
		initclick();
	}

	public void initview() {
		backtxt = (TextView) findViewById(R.id.bangbanktwo_backtext);
		xieyi = (TextView) findViewById(R.id.bangbanktwo_xieyi);
		sp = (Spinner) findViewById(R.id.bangbanktwo_dataSp);
		backbtn = (Button) findViewById(R.id.bangbanktwo_backbtn);
		nextBtn = (Button) findViewById(R.id.bangbanktwo_nextbtn);
		money = (EditText) findViewById(R.id.bangbanktwo_money);
		beizhu = (EditText) findViewById(R.id.bangbanktwo_zhu);
		mRelativeLayout = (RelativeLayout) findViewById(R.id.bangbanktwo_rl);
		bank_name = (TextView) findViewById(R.id.bangbanktwo_bankSp);
		bank_4num = (TextView) findViewById(R.id.bangbanktwo_banknum);
		mLinearLayout = (LinearLayout) findViewById(R.id.bangbank_id);
	}

	public void initclick() {
		xieyi.setOnClickListener(this);
		sp.setOnItemSelectedListener(this);
		backbtn.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		mRelativeLayout.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		final String plan_amount = money.getText().toString().trim();
		final String str_bei = beizhu.getText().toString().trim();
		final String suggest_repayment_date = sp.getSelectedItem().toString()
				.trim();

		switch (v.getId()) {
		case R.id.bangbanktwo_backbtn:
			finish();
			break;

		case R.id.bangbanktwo_xieyi:
			Intent xieyi = new Intent(Bangbank_two_Activity.this,
					BangbankTwoXieyiActivity.class);
			xieyi.putExtra("backText", "绑定还款卡");
			startActivity(xieyi);
			break;

		case R.id.bangbanktwo_nextbtn:
			int netWork = CommonUtil
					.isNetworkAvailable(Bangbank_two_Activity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {
				if ("".equals(str_money) || str_money == null) {
					ToastUtil.show(Bangbank_two_Activity.this, "还款金额不能为空");
				} else if ("".equals(str_bei) || str_bei == null) {
					ToastUtil.show(Bangbank_two_Activity.this, "备注不能为空");
				} else if ("".equals(plan_bankcard_out)
						|| plan_bankcard_out == null) {
					ToastUtil.show(Bangbank_two_Activity.this, "转入卡不能为空");
				} else if ("".equals(suggest_repayment_date)
						|| suggest_repayment_date == null) {
					ToastUtil.show(Bangbank_two_Activity.this, "建议还款日不能为空");
				} else {

					AjaxParams params = new AjaxParams();

					params.put("plan_bankcard_in", plan_bankcard);// plan_bankcard_in
																	// 转入卡
					params.put("plan_bankcard_out", plan_bankcard_out);// plan_bankcard_out
																		// 转出卡
					params.put("suggest_repayment_date", suggest_repayment_date);// suggest_repayment_date
																					// 建议还款日期
					params.put("memo", str_bei);// memo 备注
					params.put("plan_amount", plan_amount);

					params.put("userid", SharedPreferencesUtils.getString(
							Bangbank_two_Activity.this, "userid", null));
					params.put("imei",
							AppConfig.getIMEI(Bangbank_two_Activity.this));
					params.put("androidid",
							AppConfig.getAndroidId(Bangbank_two_Activity.this));
					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.WU_YOU_TWO, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									// {"status":0,"userId":"ea215678-2523-11e5-8e40-643e8cc25414","mobileno":null,"desc":"转出卡添加成功"}
									ToastUtil.show(Bangbank_two_Activity.this,
											"转出卡添加成功");
									Intent intent1 = new Intent(
											Bangbank_two_Activity.this,
											BangbankThreeActivity.class);
									BangBankVo bangbank = new BangBankVo(
											plan_bankcard, str_dataSp,
											str_money, str_bankname,
											plan_bankcard_out, str_bei,
											plan_amount, bankname_two,
											suggest_repayment_date);
									// intent1.putExtra("plan_bankcard",
									// plan_bankcard);
									// intent1.putExtra("str_dataSp",
									// str_dataSp);
									// intent1.putExtra("str_money", str_money);
									// intent1.putExtra("str_bankname",str_bankname);
									//
									//
									// intent1.putExtra("plan_bankcard_out",
									// plan_bankcard_out);
									// intent1.putExtra("str_bei", str_bei);
									// intent1.putExtra("plan_amount",
									// plan_amount);
									// intent1.putExtra("bankname_two",
									// bankname_two);
									// intent1.putExtra("suggest_repayment_date",
									// suggest_repayment_date);
									intent1.putExtra("backText", "绑定还款卡");
									intent1.putExtra("bangbank", bangbank);
									startActivity(intent1);
								}

							});
				}

			} else {

				PromptManager.showNoNetWork(Bangbank_two_Activity.this);

			}
			break;
		case R.id.bangbanktwo_rl:

			Intent intent = new Intent(Bangbank_two_Activity.this,
					Mysecurepayment_addbankActivity.class);
			startActivityForResult(intent, REQUEST_CODE);

			break;
		case R.id.bangbank_id:

			AppConfig.CloseKey(Bangbank_two_Activity.this, v);

			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			bankname_two = data.getStringExtra("bankname");
			bank_name.setText(bankname_two);
			plan_bankcard_out = data.getStringExtra("bankNum");
			bank_4num.setText("尾号 " + plan_bankcard_out.substring(12, 16));
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {
		TextView t = (TextView) v;
		t.setTextColor(getResources().getColor(R.color.white));
		t.setTextSize(12);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
}
