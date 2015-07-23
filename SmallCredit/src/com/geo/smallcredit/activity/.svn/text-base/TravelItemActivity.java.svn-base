package com.geo.smallcredit.activity;


import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.TravelItemActivity_ImageAdapter;
import com.geo.smallcredit.circle.CircleFlowIndicator;
import com.geo.smallcredit.circle.ViewFlow;
import com.geo.smallcredit.util.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TravelItemActivity extends Activity implements OnClickListener{

	private ViewFlow viewFlow;
	private CircleFlowIndicator indic;
	private Button imgback;
	private RelativeLayout rl1,rl2;
	private Intent intent;
	private String title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.travelitem_activity);
		initview();
		intent=getIntent();
		title=intent.getStringExtra("title");
		
		 viewWork();
		initClick();
	}
	public void initview(){
		
		imgback=(Button) findViewById(R.id.travelitem_activity_imgback);
		rl1=(RelativeLayout) findViewById(R.id.travelitem_activity_rl1);
		rl2=(RelativeLayout) findViewById(R.id.travelitem_activity_rl2);
	}
	public void initClick(){
		
		imgback.setOnClickListener(this);
		rl1.setOnClickListener(this);
		rl2.setOnClickListener(this);
	}
	private void viewWork() {
		viewFlow = (ViewFlow) findViewById(R.id.travelitem_activity_viewflow);
		viewFlow.setAdapter(new TravelItemActivity_ImageAdapter(TravelItemActivity.this));
		viewFlow.setmSideBuffer(4); // 实际图片张数， 我的ImageAdapter实际图片张数为4
		indic = (CircleFlowIndicator) findViewById(R.id.travelitem_activity_viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(4500);
		viewFlow.setSelection(3 * 1000); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.travelitem_activity_imgback:
			finish();
			break;

		case R.id.travelitem_activity_rl1:
			
			Intent intent = new Intent(TravelItemActivity.this,WebViewActivity.class);
			intent.putExtra("url", "http://eqxiu.com/s/GlpAN431");
			intent.putExtra("title", title);
			startActivity(intent);
			
			break;
		case R.id.travelitem_activity_rl2:
			
			Intent intent2 = new Intent(TravelItemActivity.this,LvShenqingActivity.class);
			
			startActivity(intent2);
			
			break;
		}
	}
}
