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

public class Mypayment_info_xieyiActivity extends Activity implements
		OnClickListener {

	private Button backBtn;
	private TextView backtxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mypayment_info_xieyi);
		initView();
		initClick();
		Intent it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
	}

	private void initView() {

		backtxt = (TextView) findViewById(R.id.mypayment_info_xieyi_backtext);
		backBtn = (Button) findViewById(R.id.mypayment_info_xieyi_backbtn);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mypayment_info_xieyi_backbtn:
			finish();
			break;
		}
	}
}
