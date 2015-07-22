package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.fragment.HomeFragmentTwo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends Activity implements OnClickListener {
	private Button btn;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about_activity);
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();

	}

	private void initClick() {
		btn.setOnClickListener(this);
	}

	private void initView() {
		backtext=(TextView) findViewById(R.id.about_backtext);
		btn = (Button) findViewById(R.id.about_imgback);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.about_imgback:
			this.finish();
			break;
		}
	}
}
