package com.geo.smallcredit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.geo.smallcredit.R;

public class MySecurepaymentRechargeSussessResultActivity extends Activity
		implements OnClickListener {

	private Button backBtn, sussessBtn;
	private TextView price, data, accountName, bankName, cardNum, jiaoyiData,
			jiaoyiTime, liushuiHao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepaymentrechargesussesresult);
		initView();
		initClick();

	}

	private void initClick() {

		backBtn.setOnClickListener(this);
		sussessBtn.setOnClickListener(this);
	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.mysecurepaymentrechargesussessresult_backbtn);
		sussessBtn = (Button) findViewById(R.id.mysecurepaymentrechargesussesresult_sussessbtn);
		price = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_price);
		data = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_yujidata);
		accountName = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_accountname);
		bankName = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_bankname);
		cardNum = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_cardnum);
		jiaoyiData = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_jiaoyidata);
		jiaoyiTime = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_jiaoyitime);
		liushuiHao = (TextView) findViewById(R.id.mysecurepaymentrechargesussesresult_liushuihao);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mysecurepaymentrechargesussessresult_backbtn:
			finish();
			break;

		case R.id.mysecurepaymentrechargesussesresult_sussessbtn:
			finish();
			break;
		}
	}
}
