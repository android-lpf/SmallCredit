package com.geo.smallcredit.activity;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.adapter.ViewPagerAdapter;
import com.geo.smallcredit.util.SharedPreferencesUtils;

public class HomeStartupActivity extends Activity implements OnPageChangeListener, OnClickListener{

	private ViewPager vp;  
	private ViewPagerAdapter vpAdapter;  
	private List<View> views;
	private boolean isExit;  

	//引导图片资源  
	private static final int[] pics = {R.drawable.lp1,  
		R.drawable.lp2, R.drawable.lp3, R.drawable.lp4
	}; 

	//记录当前选中位置  
	private int currentIndex;
	private TextView tx_startup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MainApplication.getInstance().addActivity(HomeStartupActivity.this);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.home_startup_activity);

		tx_startup = (TextView) findViewById(R.id.tx_startup);
		views = new ArrayList<View>();  

		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,  
				LinearLayout.LayoutParams.WRAP_CONTENT);  

		for(int i = 0; i < pics.length; i++){
			ImageView iv = new ImageView(this);  
			iv.setLayoutParams(mParams); 
			iv.setBackgroundResource(pics[i]);
			views.add(iv);  
		}

		vp = (ViewPager) findViewById(R.id.viewPager);  
		//初始化Adapter  
		vpAdapter = new ViewPagerAdapter(views);  
		vp.setAdapter(vpAdapter);  
		//绑定回调  
		vp.setOnPageChangeListener(this);  
	}


	/** 
	 *设置当前的引导页  
	 */  
	private void setCurView(int position)  
	{  
		if (position < 0 || position >= pics.length) {  
			return;  
		}
		vp.setCurrentItem(position);  
	}  


	@Override
	public void onClick(View v) {
		int position = (Integer)v.getTag();  
		setCurView(position);  
	}

	//当滑动状态改变时调用  
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	//当当前页面被滑动时调�?  
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

		if(arg0 == pics.length-1){
			tx_startup.setVisibility(View.VISIBLE);
			onClickMethod();
		}else{
			tx_startup.setVisibility(View.GONE);
		}

	}

	private void onClickMethod(){
		tx_startup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferencesUtils.saveBoolean(HomeStartupActivity.this, "HomeStartUp", true);
				startActivity(new Intent(HomeStartupActivity.this, WelcomActivity.class));
				finish();
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {  
			exit();  
			return false;  
		} else {  
			return super.onKeyDown(keyCode, event);  
		}  
	}
	public void exit(){  
		if (!isExit) {  
			isExit = true;  
			Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();  
			mHandler.sendEmptyMessageDelayed(0, 2000);  
		} else {  
			Intent intent = new Intent(Intent.ACTION_MAIN);  
			intent.addCategory(Intent.CATEGORY_HOME);  
			startActivity(intent);  
			System.exit(0);  
		}  
	}  
	Handler mHandler = new Handler() {  

		@Override  
		public void handleMessage(Message msg) {  
			super.handleMessage(msg);  
			isExit = false;  
		}  

	};

}
