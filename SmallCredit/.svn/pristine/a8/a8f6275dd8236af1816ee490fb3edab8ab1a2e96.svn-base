package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyCreditRecordAdapter;
import com.geo.smallcredit.vo.CreditRecord;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MyCreditRecordActivity extends Activity implements
		OnClickListener, OnItemClickListener {
	private Button bactBtn;

	private ListView lv;
	private MyCreditRecordAdapter adapter;
	private List<CreditRecord> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_creditrecord);
		initView();
		initClick();
		getData();
		adapter = new MyCreditRecordAdapter(MyCreditRecordActivity.this, list);
		lv.setAdapter(adapter);
	}

	private void getData() {
		list = new ArrayList<CreditRecord>();
		list.add(new CreditRecord("中智诚信用分", "最近一次查询", "2015-05-29", "721",
				"由中智诚征信有限公司提供"));
		list.add(new CreditRecord("考拉信用分", "最近一次查询", "2015-05-28", "721",
				"由考拉征信有限公司提供"));
	}

	private void initClick() {
		bactBtn.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		bactBtn = (Button) findViewById(R.id.my_creditrecord_backbtn);
		lv = (ListView) findViewById(R.id.my_creditrecord_listview);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_creditrecord_backbtn:
			finish();
			break;

		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

	}
}
