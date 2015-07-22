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
import android.widget.ListView;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyBillDetailAdapter;
import com.geo.smallcredit.vo.Bill;

public class MyBillPayDetailActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	private Button backBtn;
	private ListView lv;
	private List<Bill> list;
	private MyBillDetailAdapter adapter;
	private TextView backtxt;
	private Intent it;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mybill_item_paydetail);
		it = getIntent();
		backtxt.setText(it.getStringExtra("backText"));
		initView();
		initClick();
		getData();
		adapter = new MyBillDetailAdapter(MyBillPayDetailActivity.this, list);
		lv.setAdapter(adapter);
	}

	private void getData() {
		list = new ArrayList<Bill>();
		list.add(new Bill("旅游分期(第12期)", "待还款", "2015-07-01", "1200.00元",
				"等额本息", "12", "0   天", "0.00   元", "0.00   元"));
		list.add(new Bill("旅游分期(第11期)", "已还款", "2015-06-01", "1200.00元",
				"等额本息", "11", "0   天", "0.00   元", "0.00   元"));
		list.add(new Bill("旅游分期(第10期)", "已还款", "2015-05-01", "1200.00元",
				"等额本息", "11", "0   天", "0.00   元", "0.00   元"));

	}

	private void initClick() {

		backBtn.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.mybill_item_paydetail_backbtn);
		lv = (ListView) findViewById(R.id.mybill_item_paydetail_listview);
		backtxt = (TextView) findViewById(R.id.mybill_item_paydetail_backtext);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.mybill_item_paydetail_backbtn:
			MyBillPayDetailActivity.this.finish();
			break;
		}
	}
}
