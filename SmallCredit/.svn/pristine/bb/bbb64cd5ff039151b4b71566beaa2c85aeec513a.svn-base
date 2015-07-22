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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class bangBankActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {

	private Spinner dataSp;
	private RelativeLayout bank;
	private TextView bank_4num, bank_name;
	private Button backbtn, nextBtn;
	private Intent intent;
	private String bankname, banknum, plan_bankcard, str_bankname;
	private int REQUEST_CODE = 0;
	private LinearLayout mLinearLayout;
	private EditText money;
	public static bangBankActivity instance = null;
	private TextView backtxt, xieyi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bangbank_activity);
		initview();
		instance = this;
		initclick();
		Intent it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
	}

	public void initview() {
		backtxt = (TextView) findViewById(R.id.bangbank_backtext);
		bank = (RelativeLayout) findViewById(R.id.bangbank_rl);
		dataSp = (Spinner) findViewById(R.id.bangbank_dataSp);
		backbtn = (Button) findViewById(R.id.bangbank_backbtn);
		bank_4num = (TextView) findViewById(R.id.bangbank_banknum);
		bank_name = (TextView) findViewById(R.id.bangbank_bankSp);
		nextBtn = (Button) findViewById(R.id.bangbank_nextbtn);
		mLinearLayout = (LinearLayout) findViewById(R.id.bangbank_id);
		money = (EditText) findViewById(R.id.bangbank_money);
		xieyi = (TextView) findViewById(R.id.bangbank_xieyi);
	}

	public void initclick() {

		bank.setOnClickListener(this);
		backbtn.setOnClickListener(this);
		nextBtn.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);
		dataSp.setOnItemSelectedListener(this);
		xieyi.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// Intent intent1 = new Intent(bangBankActivity.this,
		// Bangbank_two_Activity.class);
		// startActivity(intent1);
		String str_4_bum = bank_4num.getText().toString().trim();
		final String str_money = money.getText().toString().trim();
		final String str_dataSp = dataSp.getSelectedItem().toString().trim();
		switch (v.getId()) {
		case R.id.bangbank_rl:

			if (SharedPreferencesUtils.getString(bangBankActivity.this,
					"userid", null) == null) {

				ToastUtil.show(bangBankActivity.this, "您还没有登录");

				Intent intent = new Intent(bangBankActivity.this,
						BeginActivity.class);
				startActivity(intent);

			} else {

				Intent intent = new Intent(bangBankActivity.this,
						Mysecurepayment_addbankActivity.class);
				intent.putExtra("backText", "绑定转入卡");
				startActivityForResult(intent, REQUEST_CODE);

			}
			break;

		case R.id.bangbank_backbtn:
			finish();
			break;

		case R.id.bangbank_xieyi:

			Intent xieyi = new Intent(bangBankActivity.this,
					MypaymentBangXieyiActivity.class);
			xieyi.putExtra("backText", "绑定转入卡");
			startActivity(xieyi);

			break;

		case R.id.bangbank_nextbtn:

			int netWork = CommonUtil.isNetworkAvailable(bangBankActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {
				
				if ("".equals(str_4_bum) || str_4_bum == null) {

					ToastUtil.show(bangBankActivity.this, "您还没有选择银行卡");

				} else if ("".equals(str_money) || str_money == null) {

					ToastUtil.show(bangBankActivity.this, "请输入您的还款金额");

				} else {

					AjaxParams params = new AjaxParams();
					Log.i("mytag", str_money + plan_bankcard);
					params.put("plan_bankcard", plan_bankcard);// 转入卡号
					params.put("plan_amount", str_money);// plan_amount 转入金额，
					params.put("plan_repayment_date", str_dataSp);// plan_repayment_date
																	// 还款日期
					params.put("userid", SharedPreferencesUtils.getString(
							bangBankActivity.this, "userid", null));
					params.put("imei", AppConfig.getIMEI(bangBankActivity.this));
					params.put("androidid",
							AppConfig.getAndroidId(bangBankActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.WU_YOU_ONE, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									Log.i("mytag", "失败了======" + strMsg);
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									// {"status":0,"userId":"ea215678-2523-11e5-8e40-643e8cc25414","mobileno":null,"desc":"转入卡添加成功","planBankcardIn":"6214850104864878"}

									ToastUtil.show(bangBankActivity.this,
											"转入卡添加成功");
									Intent intent1 = new Intent(
											bangBankActivity.this,
											Bangbank_two_Activity.class);
									intent1.putExtra("backText", "绑定转入卡");
									intent1.putExtra("plan_bankcard",
											plan_bankcard);
									intent1.putExtra("str_dataSp", str_dataSp);
									intent1.putExtra("str_money", str_money);
									intent1.putExtra("str_bankname",
											str_bankname);
									startActivity(intent1);
								}
							});
				}
			} else {
				PromptManager.showNoNetWork(bangBankActivity.this);
			}
			break;

		case R.id.bangbank_id:

			AppConfig.CloseKey(bangBankActivity.this, v);

			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			str_bankname = data.getStringExtra("bankname");
			bank_name.setText(str_bankname);
			plan_bankcard = data.getStringExtra("bankNum");
			bank_4num.setText("尾号 " + plan_bankcard.substring(12, 16));
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
