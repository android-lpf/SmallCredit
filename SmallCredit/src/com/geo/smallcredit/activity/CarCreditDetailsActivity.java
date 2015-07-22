package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class CarCreditDetailsActivity extends Activity implements OnClickListener{
private Button imgback;
private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.carcreditdetails_activity);
		initview();
		initclick();
	}
	public void initview(){
		
		imgback=(Button) findViewById(R.id.carcredit_imgback);
		btn=(Button) findViewById(R.id.car_btn);
	}
	public void initclick(){
		imgback.setOnClickListener(this);
		btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.carcredit_imgback:
			finish();
			break;

		case R.id.car_btn:
			
			Intent intent = new Intent(CarCreditDetailsActivity.this,CarCredit_ApplicationActivity.class);
			
			startActivity(intent);
			
			break;
		}
	}
}
