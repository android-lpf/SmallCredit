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
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.adapter.ImageAdapter;
import com.geo.smallcredit.adapter.JieAdapter;
import com.geo.smallcredit.adapter.ThridAdapter;
import com.geo.smallcredit.circle.CircleFlowIndicator;
import com.geo.smallcredit.circle.ViewFlow;
import com.geo.smallcredit.vo.ThirdMain;
import com.geo.smallcredit.vo.Travel;

public class JieActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	private Button btnBack;
	// private ViewFlow viewFlow;
	// private CircleFlowIndicator indic;
	private JieAdapter adapter;
	private List<Travel> list;
	private ListView lv;
	private FrameLayout img;
	private TextView backtext;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(JieActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_jie);
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		// viewWork();
		getData();
		adapter = new JieAdapter(JieActivity.this, list);
		lv.setAdapter(adapter);
	}

	// private void viewWork() {
	//
	// viewFlow.setAdapter(new ImageAdapter(JieActivity.this));
	// viewFlow.setmSideBuffer(4); // 实际图片张数， 我的ImageAdapter实际图片张数为4
	// viewFlow.setFlowIndicator(indic);
	// viewFlow.setTimeSpan(4500);
	// viewFlow.setSelection(3 * 1000); // 设置初始位置
	// viewFlow.startAutoFlowTimer(); // 启动自动播放
	//
	// }

	private void getData() {
		list = new ArrayList<Travel>();
		list.add(new Travel("\t小信用为您提供", R.drawable.third_jie_xiaoxinyong,
				"急需用钱找小信用帮忙", "(敬请期待)", R.drawable.enter_arrow,
				R.drawable.zhitong));
		list.add(new Travel("\t小信用为您推荐", R.drawable.third_jie_pinganyidai,
				"平安易贷", "无抵押,放款快,贷你没商量", R.drawable.enter_arrow,
				R.drawable.tuijian));
		list.add(new Travel("\t小信用为您推荐", R.drawable.third_jie_paipaidai, "拍拍贷",
				"高效,快捷,借的到", R.drawable.enter_arrow, R.drawable.tuijian));
	}

	private void initClick() {
		btnBack.setOnClickListener(this);
		lv.setOnItemClickListener(this);
		img.setOnClickListener(this);
	}

	private void initView() {
		btnBack = (Button) findViewById(R.id.btn_back_do);
		img = (FrameLayout) findViewById(R.id.third_jie_framelayout);
		lv = (ListView) findViewById(R.id.third_jie_listview);
		// viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		// indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		backtext=(TextView) findViewById(R.id.third_jie_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back_do:
			this.finish();
			break;
		case R.id.third_jie_framelayout:
			Intent it = new Intent(JieActivity.this, WebViewActivity.class);
			it.putExtra("url", "http://m.weicaifu.com");
			it.putExtra("title", "微财富");
			startActivity(it);	
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}

}
