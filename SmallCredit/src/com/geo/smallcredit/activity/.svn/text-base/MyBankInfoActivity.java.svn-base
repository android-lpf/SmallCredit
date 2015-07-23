package com.geo.smallcredit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;

public class MyBankInfoActivity extends Activity implements OnClickListener {
	private Button backBtn;
	private ImageButton barBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(MyBankInfoActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mybank_info);
		initView();
		initClick();

	}

	private void initClick() {
		backBtn.setOnClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.bankinfo_backbtn);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bankinfo_backbtn:
			finish();
			break;

		default:
			break;
		}
	}

}
