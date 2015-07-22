package com.geo.smallcredit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.geo.smallcredit.R;

public class RegisterShouquanActivity extends Activity implements
		OnClickListener {
	private Button backBtn, shouqunBtn;
	private static RegisterShouquanActivity instance=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register_shouquan);
		initView();
		instance=this;
		initClick();
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		shouqunBtn.setOnClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.register_shouquan_backbtn);
		shouqunBtn = (Button) findViewById(R.id.register_shouquan_shouquanbtn);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register_shouquan_backbtn:
			RegisterShouquanActivity.this.finish();
			break;

		case R.id.register_shouquan_shouquanbtn:
			Intent it=new Intent(RegisterShouquanActivity.this,RegisterBindbankActivity.class);
			startActivity(it);
			break;
		}
	}
}
