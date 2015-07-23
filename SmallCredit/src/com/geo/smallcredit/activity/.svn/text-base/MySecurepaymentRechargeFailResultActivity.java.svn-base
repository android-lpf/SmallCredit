package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MySecurepaymentRechargeFailResultActivity extends Activity
		implements OnClickListener {

	private Button backBtn, failBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepaymentrecharge_faileresult);
		initView();
		initCLick();
	}

	private void initCLick() {
		backBtn.setOnClickListener(this);
		failBtn.setOnClickListener(this);
	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.mysecurepaymentrecharge_failresult_backbtn);
		failBtn = (Button) findViewById(R.id.mysecurepaymentrecharge_failresult_failbtn);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mysecurepaymentrecharge_failresult_backbtn:
			finish();
			break;

		case R.id.mysecurepaymentrecharge_failresult_failbtn:
			finish();
			break;
		}
	}
}
