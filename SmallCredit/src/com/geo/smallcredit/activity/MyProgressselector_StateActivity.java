package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.popwindow.SelectPicPopupWindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyProgressselector_StateActivity extends Activity implements
		OnClickListener {

	private Button backBtn;
	// 自定义的弹出框类
	SelectPicPopupWindow menuWindow;
	private TextView backtxt;
	private Intent it;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myprogressselector_state);
		it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
		initView();
		initClick();
	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.myprogressselector_state_backbtn);
		backtxt = (TextView) findViewById(R.id.myprogressselector_state_backtext);

	}

	private void initClick() {
		backBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.myprogressselector_state_backbtn:
			this.finish();
			break;

		}
	}
}
