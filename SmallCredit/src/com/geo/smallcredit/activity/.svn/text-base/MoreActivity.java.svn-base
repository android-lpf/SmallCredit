package com.geo.smallcredit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.SharedPreferencesUtils;

public class MoreActivity extends Activity implements OnClickListener {

	private RelativeLayout mRelativeLayout_login, mRelativeLayout_jiaoyi,
			mRelativeLayout_shoushi, mRelativeLayout_fankui,
			mRelativeLayout_guanyu;
	private Button imgback;
	private Button esc_btn;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.more_activity);
		initview();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
	}

	public void initview() {
		mRelativeLayout_login = (RelativeLayout) findViewById(R.id.more_realtive1);
		mRelativeLayout_jiaoyi = (RelativeLayout) findViewById(R.id.more_realtive2);
		mRelativeLayout_shoushi = (RelativeLayout) findViewById(R.id.more_realtive3);
		mRelativeLayout_fankui = (RelativeLayout) findViewById(R.id.more_realtive4);
		mRelativeLayout_guanyu = (RelativeLayout) findViewById(R.id.more_realtive5);
		imgback=(Button) findViewById(R.id.more_imgback);
		esc_btn=(Button) findViewById(R.id.more_activity_btn);
		backtext=(TextView) findViewById(R.id.more_backtext);
	}

	public void initClick() {
		mRelativeLayout_login.setOnClickListener(this);
		mRelativeLayout_jiaoyi.setOnClickListener(this);
		mRelativeLayout_shoushi.setOnClickListener(this);
		mRelativeLayout_fankui.setOnClickListener(this);
		mRelativeLayout_guanyu.setOnClickListener(this);
		imgback.setOnClickListener(this);
		esc_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.more_realtive1:
			
			Intent reviselogin=new Intent(MoreActivity.this,ReviseLoginPaw.class);
			reviselogin.putExtra("backText", "更多");
			startActivity(reviselogin);
			
			break;

		case R.id.more_realtive2:
			Intent revisetransaction=new Intent(MoreActivity.this,ReviseTransactionActivity.class);
			revisetransaction.putExtra("backText", "更多");
			startActivity(revisetransaction);
			
			break;
		case R.id.more_realtive3:
			Intent paw=new Intent(MoreActivity.this,PasswordActivity.class);
			paw.putExtra("backText", "更多");
			startActivity(paw);
			break;
		case R.id.more_realtive4:
			Intent suggestion=new Intent(MoreActivity.this,SuggestionActivity.class);
			suggestion.putExtra("backText", "更多");
			startActivity(suggestion);
			break;
		case R.id.more_realtive5:
			Intent about=new Intent(MoreActivity.this,AboutActivity.class);
			about.putExtra("backText", "更多");
			startActivity(about);
			break;
		case R.id.more_imgback:
			this.finish();
			break;
		case R.id.more_activity_btn:
			SharedPreferencesUtils.saveString(MoreActivity.this, "userid", null);					
			SharedPreferencesUtils.saveString(MoreActivity.this, "mobileno", null);
			SharedPreferencesUtils.saveString(MoreActivity.this, "score", null);
			Intent intent = new Intent();
			intent.setClass(MoreActivity.this, MainActivity.class);
			startActivity(intent);
			
			finish();
			break;
		}

	}
}
