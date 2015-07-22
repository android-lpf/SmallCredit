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

public class ZhongZhiCheng_xieyiActivity extends Activity implements
		OnClickListener {

	private Button backBtn;
	private TextView backtxt, name, shenfenNum;
	private Intent it;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.zhongzhicheng_userxieyi);
		initView();
		it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
		initClick();
	}

	private void initClick() {

		backBtn.setOnClickListener(this);

	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.zhongzhicheng_userxieyi_backbtn);
		name = (TextView) findViewById(R.id.zhongzhicheng_userxieyi_name);
		shenfenNum = (TextView) findViewById(R.id.zhongzhicheng_userxieyi_shenfennum);
		backtxt = (TextView) findViewById(R.id.zhongzhicheng_userxieyi_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.zhongzhicheng_userxieyi_backbtn:
			finish();
			break;
		}
	}
}
