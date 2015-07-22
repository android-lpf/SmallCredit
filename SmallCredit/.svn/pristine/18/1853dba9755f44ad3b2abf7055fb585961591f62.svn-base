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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.Mysecurepayment_AddbankAdapter;
import com.geo.smallcredit.vo.BankManger;
import com.geo.smallcredit.vo.Wu;

public class Mysecurepayment_addbankActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	private Button backBtn;
	private RelativeLayout addReal;
	private ListView lv;
	// private List<BankManger> list;
	private List<Wu> list;
	private ImageButton addImg;
	private Mysecurepayment_AddbankAdapter adapter;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepayment_addbank);
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		getData();
		adapter = new Mysecurepayment_AddbankAdapter(
				Mysecurepayment_addbankActivity.this, list);
		lv.setAdapter(adapter);
	}

	private void getData() {

		list = new ArrayList<Wu>();
		// list.add(new BankManger("无忧还款", "中国建设银行", "借记卡",
		// "6214850104864878"));
		// list.add(new BankManger("无忧还款", "中国招行", "借记卡",
		// "6214850104864878"));

		list.add(new Wu("暂无绑定银行卡"));

	}

	private void initClick() {

		backBtn.setOnClickListener(this);
		addReal.setOnClickListener(this);
		lv.setOnItemClickListener(this);
		addImg.setOnClickListener(this);

	}

	private void initView() {

		backBtn = (Button) findViewById(R.id.mysecurepayment_addbank_backbtn);
		addReal = (RelativeLayout) findViewById(R.id.mysecurepayment_addbank_addrelative);
		lv = (ListView) findViewById(R.id.mysecurepayment_addbank_listview);
		addImg = (ImageButton) findViewById(R.id.mysecurepayment_addbank_addbtn);
		backtext=(TextView) findViewById(R.id.mysecurepayment_addbank_backtext);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

		// Intent intent =new
		// Intent(Mysecurepayment_addbankActivity.this,bangBankActivity.class);
		// intent.putExtra("bankname",list.get(arg2).getBankName());
		// intent.putExtra("bankNum",list.get(arg2).getBankNum());
		// setResult(RESULT_OK,intent);
		// finish();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mysecurepayment_addbank_backbtn:
			Mysecurepayment_addbankActivity.this.finish();
			break;

		case R.id.mysecurepayment_addbank_addrelative:

			Intent it = new Intent(Mysecurepayment_addbankActivity.this,
					MyCreditpayActivity.class);
			it.putExtra("backText", "银行卡管理");
			startActivity(it);

			break;
		case R.id.mysecurepayment_addbank_addbtn:

			Intent it1 = new Intent(Mysecurepayment_addbankActivity.this,
					MyCreditpayActivity.class);
			it1.putExtra("backText", "银行卡管理");
			startActivity(it1);

			break;
		}
	}
}
