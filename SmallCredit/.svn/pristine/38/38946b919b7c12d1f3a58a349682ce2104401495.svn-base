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
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.adapter.JieProgressInfoAdapter;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.JieProgressInfo;
import com.geo.smallcredit.vo.Wu;

public class MySelectorProgressInfoActivity extends Activity implements
		OnClickListener, OnItemClickListener {
	private Button imgBack;
	private ListView lv;
	// private List<JieProgressInfo> list;
	private List<Wu> list;
	private JieProgressInfoAdapter adapter;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(
				MySelectorProgressInfoActivity.this);
		setContentView(R.layout.myselectorprogressinfo);
		getData();
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		adapter = new JieProgressInfoAdapter(
				MySelectorProgressInfoActivity.this, list);
		lv.setAdapter(adapter);
	}

	private void initClick() {
		imgBack.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		imgBack = (Button) findViewById(R.id.jieprogressinfo_backbtn);
		lv = (ListView) findViewById(R.id.jieprogressinfo_listview);
		backtext=(TextView) findViewById(R.id.myselecttor_backtext);
	}

	private void getData() {
		// list = new ArrayList<JieProgressInfo>();
		// list.add(new JieProgressInfo("\t房贷代还业务","0", "初审审核中", "2015-5-29",
		// "12,000元", "1个月", "急需资金周转"));
		// list.add(new JieProgressInfo("\t车贷代还业务", "1", "终审通过,待客户确认",
		// "2015-5-29", "12,000元", "1个月", "急需资金周转"));
		list = new ArrayList<Wu>();
		list.add(new Wu("暂无查询记录"));
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		switch (position) {
		case 0:
			ToastUtil.show(MySelectorProgressInfoActivity.this, "暂无信息，尽请期待。。。");
			break;

		case 1:

			Intent it = new Intent(MySelectorProgressInfoActivity.this,
					MyProgressselector_StateActivity.class);
			it.putExtra("backText", "进度查询");
			startActivity(it);

			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.jieprogressinfo_backbtn:
			MySelectorProgressInfoActivity.this.finish();
			break;
		}
	}
}
