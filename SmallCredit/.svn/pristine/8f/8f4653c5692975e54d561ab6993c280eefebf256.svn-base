package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class My_MyInformationActivity extends Activity implements
		OnClickListener {

	private Button backBtn;
	private TextView name, sex, data, shenfen,backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_myinformation);
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
	}

	private void initClick() {

		backBtn.setOnClickListener(this);

	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.my_myinformation_backbtn);
		name = (TextView) findViewById(R.id.my_myinformation_name);
		sex = (TextView) findViewById(R.id.my_myinformation_sex);
		data = (TextView) findViewById(R.id.my_myinformation_data);
		shenfen = (TextView) findViewById(R.id.my_myinformation_shenfennumber);
		backtext=(TextView) findViewById(R.id.my_myinfomation_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_myinformation_backbtn:
			My_MyInformationActivity.this.finish();
			break;
		}
	}
}
