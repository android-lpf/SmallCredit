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

public class MypaymentBangXieyiActivity extends Activity implements
		OnClickListener {
	private Button backBtn;
	private TextView backtxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mypayment_bang_xieyi);
		initVIew();
		initClick();
		Intent it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
	}

	private void initClick() {
		
		backBtn.setOnClickListener(this);
	
	}

	private void initVIew() {

		backBtn = (Button) findViewById(R.id.mypayment_bang_xieyi_backbtn);
		backtxt = (TextView) findViewById(R.id.mypayment_bang_xieyi_backtext);
	
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mypayment_bang_xieyi_backbtn:
			finish();
			break;
		}
	}
}
