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

public class Bankinfo_UserxieyiActivity extends Activity implements
		OnClickListener {

	private Button backBtn;
	private TextView tx, xieyiTxt;;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bankinfo_userxieyi);
		initVIew();
		initClick();
		ToDBC("tx");
		intent = getIntent();
		xieyiTxt.setText(intent.getStringExtra("backText"));
	}

	private void initClick() {

		backBtn.setOnClickListener(this);

	}

	private void initVIew() {

		backBtn = (Button) findViewById(R.id.bankinfo_userxieyi_backbtn);
		xieyiTxt = (TextView) findViewById(R.id.bankinfo_userxieyi_backtxt);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bankinfo_userxieyi_backbtn:
			this.finish();
			break;

		default:
			break;
		}
	}

	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}
}
