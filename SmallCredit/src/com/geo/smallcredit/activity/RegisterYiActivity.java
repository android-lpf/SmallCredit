package com.geo.smallcredit.activity;



import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class RegisterYiActivity extends Activity implements OnClickListener {

	private EditText userName, shenfenNum;
	private Button nextBtn, loginBtn;
	private static RegisterYiActivity instance=null;	
	private LinearLayout mLinearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register_yi);
		initView();
		instance=this;
		initCLick();
	}

	private void initCLick() {
		
		nextBtn.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
		mLinearLayout.setOnClickListener(this);
	}

	private void initView() {

		userName = (EditText) findViewById(R.id.register_yi_username_edit);
		shenfenNum = (EditText) findViewById(R.id.register_yi_shenfennum_edit);
		nextBtn = (Button) findViewById(R.id.register_yi_nextbtn);
		loginBtn = (Button) findViewById(R.id.register_yi_loginbtn);
		mLinearLayout=(LinearLayout) findViewById(R.id.register_yi_id);
	}

	@Override
	public void onClick(View v) {
		
		String name=userName.getText().toString().trim();
		String num=shenfenNum.getText().toString().trim();
		
		switch (v.getId()) {
		case R.id.register_yi_id:
			AppConfig.CloseKey(RegisterYiActivity.this, v);
			break;
		case R.id.register_yi_nextbtn:

			int netWorkType = CommonUtil.isNetworkAvailable(RegisterYiActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(name) || name == null) {

					ToastUtil.show(RegisterYiActivity.this, "姓名不能为空");

				}  else if (num.length() != 18) {

					ToastUtil.show(RegisterYiActivity.this, "请输入18位的身份证号");

				} else {

					Intent registerYi = new Intent(RegisterYiActivity.this,
							RegisterSecondActivity.class);
					registerYi.putExtra("name", name);
					registerYi.putExtra("num", num);
					startActivity(registerYi);
					
					break;
				}

			} else {

				PromptManager.showNoNetWork(RegisterYiActivity.this);
			}
			break;

		case R.id.register_yi_loginbtn:
			Intent login = new Intent(RegisterYiActivity.this,
					BeginActivity.class);
			startActivity(login);
			break;
		}
	}
}
