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

public class MySecurepaymentDespoitResultActivity extends Activity implements
		OnClickListener {

	private Button backBtn;
	private TextView backtxt;
	private Intent it;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepaymentdepositresult);
		it=getIntent();
		backtxt.setText(it.getStringExtra("backText"));
		initView();
		initClick();
		
	}

	private void initClick() {

		backBtn.setOnClickListener(this);
	}

	private void initView() {
		backtxt = (TextView) findViewById(R.id.mysecurepaymentdepositresult_backtext);
		backBtn = (Button) findViewById(R.id.mysecurepaymentdepositresult_backbtn);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mysecurepaymentdepositresult_backbtn:
			finish();
			break;
		}
	}

}
