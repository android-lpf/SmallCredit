package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class XingBaoActivity extends Activity implements OnClickListener {

	private Button btn,imgback;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.xingbao_activity);
		initview();
		initclick();
	}
	public void initview(){
		btn=(Button) findViewById(R.id.xingbao_btn);
		imgback=(Button) findViewById(R.id.xingbao_imgback);
	}
	public void initclick(){
		btn.setOnClickListener(this);
		imgback.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.xingbao_btn:
			
			Intent intent = new Intent(XingBaoActivity.this,XingbaoCredit_ApplicationActivity.class);
			startActivity(intent);
			break;

		case R.id.xingbao_imgback:
			
			finish();
			break;
		}
		
	}
}
