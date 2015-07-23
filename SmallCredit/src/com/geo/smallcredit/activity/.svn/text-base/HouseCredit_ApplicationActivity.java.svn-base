package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

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

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.PersonInformationAdapter;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.PersonInformation;

public class HouseCredit_ApplicationActivity extends Activity implements
		OnItemClickListener, OnClickListener {

	private Button imageBack;
	private List<PersonInformation> list;
	private PersonInformationAdapter adapter;
	private ListView listview;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.housecredit_application_activity);
		initview();
		getData();
		adapter = new PersonInformationAdapter(
				HouseCredit_ApplicationActivity.this, list);
		listview.setAdapter(adapter);
		initClick();
	}

	public void initview() {

		imageBack = (Button) findViewById(R.id.housecreditApplication_imgback);
		listview = (ListView) findViewById(R.id.houseApplication_listview);
		btn = (Button) findViewById(R.id.houseApplication_btn);
	}

	public void initClick() {

		imageBack.setOnClickListener(this);
		listview.setOnItemClickListener(this);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.housecreditApplication_imgback:
			finish();
			break;
		case R.id.houseApplication_btn:
			String  type="2";//测试用的
			if(!"2".equals(type)){
				
				
				Intent intent = new Intent(HouseCredit_ApplicationActivity.this,SuccessShenqingActivity.class);
				
				startActivity(intent);
				
			}else {
				
				ToastUtil.show(HouseCredit_ApplicationActivity.this,"您的认证信息不完整,无法申请,请完善您的认证信息");
				
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
		list.add(new PersonInformation("房产信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("银行卡信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("资料上传", R.drawable.enter_arrow));

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switch (arg2) {

		case 0:

			Intent intent = new Intent(HouseCredit_ApplicationActivity.this,
					HouseCreditApplication_jiekuan_Activity.class);
			startActivity(intent);

			break;

		case 1:
			Intent intent1 = new Intent(HouseCredit_ApplicationActivity.this,
					ShenFenActivity.class);
			startActivity(intent1);

			break;
		case 2:
			Intent intent2 = new Intent(HouseCredit_ApplicationActivity.this,
					LianxiActivity.class);
			startActivity(intent2);
			break;

		case 3:
			Intent intent3 = new Intent(HouseCredit_ApplicationActivity.this,
					WorkActivity.class);
			startActivity(intent3);
			break;
		case 4:
			Intent intent4 = new Intent(HouseCredit_ApplicationActivity.this,
					House_Activity.class);
			startActivity(intent4);
			break;
		case 5:
			Intent intent5 = new Intent(HouseCredit_ApplicationActivity.this,
					CarBankInfoActivity.class);
			startActivity(intent5);
			break;
		case 6:
			Intent intent6 = new Intent(HouseCredit_ApplicationActivity.this,
					MeansUploadActivity.class);
			startActivity(intent6);
			break;

		}
	}

}
