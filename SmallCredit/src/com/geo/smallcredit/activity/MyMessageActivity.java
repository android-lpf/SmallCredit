package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyMessageAdapter;
import com.geo.smallcredit.vo.Message;
import com.geo.smallcredit.vo.Wu;

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

public class MyMessageActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private Button imgBack;
	private ListView lv;
	private MyMessageAdapter adapter;
	// private List<Message> list;
	private List<Wu> list;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_message);
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		getData();
		adapter = new MyMessageAdapter(this, list);
		lv.setAdapter(adapter);
	}

	private void getData() {
		// list = new ArrayList<Message>();
		// list.add(new Message("\t�������֪ͨ", "2015-06-01 10:02:56",
		// "����2015��5��30���ύ�ķ�������ҵ������������ͨ�����뾡�졾ȷ�ϡ���"));
		// list.add(new Message("\t������֪ͨ", "2015-06-01 10:02:56",
		// "2015��5��30�����ǻ������ÿ�»��������Զ�����ɹ���"));

		list = new ArrayList<Wu>();
		list.add(new Wu("����֪ͨ"));

	}

	private void initClick() {
		imgBack.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		imgBack = (Button) findViewById(R.id.my_message_backbtn);
		lv = (ListView) findViewById(R.id.my_message_listview);
		backtext=(TextView) findViewById(R.id.my_message_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_message_backbtn:
			finish();
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}
}
