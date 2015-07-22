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

public class HouseCreditDetailsActivity extends Activity implements OnClickListener {

	private Button btnback,btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.housecredit_activity);
		initview();
		initClick();
	}

	public void initview() {
		btnback = (Button) findViewById(R.id.housecredit_imgback);
		btn = (Button) findViewById(R.id.house_btn);
	}

	public void initClick() {
		btnback.setOnClickListener(this);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.housecredit_imgback:
			finish();
			break;

		case R.id.house_btn:
			
			Intent intent = new Intent(HouseCreditDetailsActivity.this,HouseCredit_ApplicationActivity.class);
			startActivity(intent);
			
			break;
		}

	}
}
