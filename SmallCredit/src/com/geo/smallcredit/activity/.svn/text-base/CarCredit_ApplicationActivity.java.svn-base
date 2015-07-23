package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.PersonInformationAdapter;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.PersonInformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class CarCredit_ApplicationActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	private ListView listview;
	private Button btn;
	private Button imgback;
	private List<PersonInformation> list;
	private PersonInformationAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.carcredit_application_activity);
		initview();
		getData();
		initclick();
		adapter = new PersonInformationAdapter(
				CarCredit_ApplicationActivity.this, list);
		listview.setAdapter(adapter);
	}

	public void initview() {
		imgback = (Button) findViewById(R.id.carcreditApplication_imgback);
		btn = (Button) findViewById(R.id.carApplication_btn);
		listview = (ListView) findViewById(R.id.carApplication_listview);
	}

	public void initclick() {
		imgback.setOnClickListener(this);
		btn.setOnClickListener(this);
		listview.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.carcreditApplication_imgback:
			finish();
			break;

		case R.id.carApplication_btn:
			String str="1";
			if("1".equals(str)){
				ToastUtil.show(CarCredit_ApplicationActivity.this,"您的认证信息不够完整,无法申请");
			}else {
				Intent intent = new Intent(CarCredit_ApplicationActivity.this,
						SuccessShenqingActivity.class);
				startActivity(intent);
				
			}
			break;
		}

	}

	private void getData() {
		list = new ArrayList<PersonInformation>();
		list.add(new PersonInformation("借款信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("身份信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("联系人信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("工作/收入信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("银行卡信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("资料上传", R.drawable.enter_arrow));

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		switch (arg2) {

		case 0:

			Intent intent = new Intent(CarCredit_ApplicationActivity.this,
					CarCreaitpayment_JieActivity.class);
			startActivity(intent);

			break;

		case 1:
			Intent intent1 = new Intent(CarCredit_ApplicationActivity.this,
					ShenFenActivity.class);
			startActivity(intent1);

			break;
		case 2:
			Intent intent2 = new Intent(CarCredit_ApplicationActivity.this,
					LianxiActivity.class);
			startActivity(intent2);
			break;

		case 3:
			Intent intent3 = new Intent(CarCredit_ApplicationActivity.this,WorkActivity.class);
			startActivity(intent3);
			break;
		case 4:
			Intent intent5 = new Intent(CarCredit_ApplicationActivity.this,
					CarBankInfoActivity.class);
			startActivity(intent5);
			break;
		case 5:
			Intent intent6 = new Intent(CarCredit_ApplicationActivity.this,
					MeansUploadActivity.class);
			startActivity(intent6);
			break;

		}
	}

}
