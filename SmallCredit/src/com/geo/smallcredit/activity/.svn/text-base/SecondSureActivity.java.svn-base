package com.geo.smallcredit.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;

public class SecondSureActivity extends Activity implements OnClickListener {

	private Button backBtn, btn_sure;
	private String name, info;
	private EditText second_name, num;
	private LinearLayout mLine;
	private Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(SecondSureActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_sure);

		initview();
		Intent intent = getIntent();
		if (intent != null) {
			name = intent.getStringExtra("name");
			info = intent.getStringExtra("info");
			bitmap=intent.getParcelableExtra("image");
		}

		btn_onclick();
		// 点击外部键盘消失
		mLine = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mLine.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

			}
		});
	} 

	public void initview() {
		backBtn = (Button) findViewById(R.id.second_sure_btn_back_do);
		btn_sure = (Button) findViewById(R.id.btn_sure);
		second_name = (EditText) findViewById(R.id.second_sure_namedeit);
		num = (EditText) findViewById(R.id.second_sure_numedit);
	}

	public void btn_onclick() {

		backBtn.setOnClickListener(this);
		btn_sure.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		String seName = second_name.getText().toString().trim();
		String number = num.getText().toString().trim();

		switch (v.getId()) {

		case R.id.second_sure_btn_back_do:

			finish();

			break;
		case R.id.btn_sure:
			int type = CommonUtil.isNetworkAvailable(SecondSureActivity.this);

			if (type == 1 || type == 2 || type == 3) {

				if ("".equalsIgnoreCase(seName) || seName == null) {

					ToastUtil.show(SecondSureActivity.this, "姓名不能为空");
				} else if ("".equalsIgnoreCase(number) || number == null) {

					ToastUtil.show(SecondSureActivity.this, "身份证不能为空");

				}else if(number.length()<18||number.length()>18){
					
					ToastUtil.show(SecondSureActivity.this, "请输入18位身份证号");
					
				} else {

					Intent intent = new Intent(SecondSureActivity.this,
							SelectFrationActivity.class);
					intent.putExtra("name", name);
					intent.putExtra("info", info);
					intent.putExtra("image", bitmap);
					intent.putExtra("second_name", seName);
					intent.putExtra("num", number);
					startActivity(intent);
				}

			} else {
				PromptManager.showNoNetWork(SecondSureActivity.this);
			}
			break;
		}
	}

}
