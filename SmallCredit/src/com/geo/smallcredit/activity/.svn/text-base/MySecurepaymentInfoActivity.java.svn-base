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
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;

public class MySecurepaymentInfoActivity extends Activity implements
		OnClickListener {

	private Button backBtn, flusBtn;
	public static MySecurepaymentInfoActivity instance = null;
	private TextView backtxt, xieYi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepayment_info);
		initView();
		instance = this;
		initClick();
		Intent it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
	}

	private void initClick() {

		backBtn.setOnClickListener(this);
		flusBtn.setOnClickListener(this);
		xieYi.setOnClickListener(this);

	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.mysecurepayment_info_backbtn);
		flusBtn = (Button) findViewById(R.id.mysecurepayment_info_kaitongbtn);
		xieYi = (TextView) findViewById(R.id.mysecurepayment_info_xieyi);
		backtxt = (TextView) findViewById(R.id.mysecurepayment_info_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mysecurepayment_info_backbtn:
			finish();
			break;

		case R.id.mysecurepayment_info_xieyi:
			Intent xieyi = new Intent(MySecurepaymentInfoActivity.this,
					Mypayment_info_xieyiActivity.class);
			xieyi.putExtra("backText", "无忧还款");
			startActivity(xieyi);
			break;

		case R.id.mysecurepayment_info_kaitongbtn:
			// Intent it = new Intent(MySecurepaymentInfoActivity.this,
			// MySecurePaymentActivity.class);
			// startActivity(it);
			if (SharedPreferencesUtils.getString(
					MySecurepaymentInfoActivity.this, "userid", null) == null) {

				ToastUtil.show(MySecurepaymentInfoActivity.this, "您还没有登录");

				Intent intent = new Intent(MySecurepaymentInfoActivity.this,
						BeginActivity.class);

				startActivity(intent);

			} else {
				Intent it = new Intent(MySecurepaymentInfoActivity.this,
						bangBankActivity.class);
				it.putExtra("backText", "无忧还款");
				startActivity(it);
				break;
			}
		}
	}
}
