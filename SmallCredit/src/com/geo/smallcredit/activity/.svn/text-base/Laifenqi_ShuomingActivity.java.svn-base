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

public class Laifenqi_ShuomingActivity extends Activity implements
		OnClickListener {
	private Button nextNow, backbtn;
	private Intent intent1, title_intent;
	private String title_str, str_url;
	public static Laifenqi_ShuomingActivity instance = null;
	private TextView backtext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.laifenqi_shuoming);
		initview();
		instance = this;
		title_intent = getIntent();
		title_str = title_intent.getStringExtra("title");
		str_url = title_intent.getStringExtra("url");
		backtext.setText(title_intent.getStringExtra("backText"));
		initclick();
	}

	public void initview() {
		nextNow = (Button) findViewById(R.id.laifenqi_nextnow_btn);
		backbtn = (Button) findViewById(R.id.laifenqi_backbtn);
		backtext=(TextView) findViewById(R.id.laifenqi_backtext);
	}

	public void initclick() {
		nextNow.setOnClickListener(this);
		backbtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.laifenqi_nextnow_btn:
			intent1 = new Intent(Laifenqi_ShuomingActivity.this,
					WebViewActivity.class);
			intent1.putExtra("url", str_url);
			intent1.putExtra("title", title_str);
			intent1.putExtra("tag","laifenqi");
			intent1.putExtra("backText","消费分期");
			startActivity(intent1);
			break;

		case R.id.laifenqi_backbtn:
			finish();
			break;
		}
	}

}
