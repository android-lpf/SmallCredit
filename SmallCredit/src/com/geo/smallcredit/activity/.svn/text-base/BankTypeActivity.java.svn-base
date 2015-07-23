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
import android.widget.ImageView;
import android.widget.ListView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.adapter.MyBankTypeAdapter;
import com.geo.smallcredit.vo.Bank;

public class BankTypeActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	private ImageView imgBack;
	private ListView lv;
	private List<Bank> list;
	private MyBankTypeAdapter adp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(BankTypeActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mybanktype_type);
		getData();
		initView();
		initClick();
		adp = new MyBankTypeAdapter(BankTypeActivity.this, list);
		lv.setAdapter(adp);
	}

	private void getData() {
		list = new ArrayList<Bank>();
		list.add(new Bank(R.drawable.zhaoshangbank, "招商银行", "借记卡", "****",
				"****", "****", "****"));
		list.add(new Bank(R.drawable.zhaoshangbank, "招商银行", "借记卡", "****",
				"****", "****", "****"));
	
	}

	private void initClick() {
		imgBack.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		imgBack = (ImageView) findViewById(R.id.mybanktype_backbtn);
		lv = (ListView) findViewById(R.id.mybanktype_listview);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mybanktype_backbtn:
			finish();
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		Intent it = new Intent(BankTypeActivity.this, MyBankInfoActivity.class);
		startActivity(it);
	}
}

