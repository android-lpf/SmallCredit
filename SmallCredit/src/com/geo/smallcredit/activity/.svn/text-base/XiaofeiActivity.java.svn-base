package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.activity.MainActivity.MainViewPagerAdapter;
import com.geo.smallcredit.adapter.ImageAdapter;
import com.geo.smallcredit.circle.CircleFlowIndicator;
import com.geo.smallcredit.circle.ViewFlow;
import com.geo.smallcredit.fragment.FinancialFragment;
import com.geo.smallcredit.fragment.GouFragment;
import com.geo.smallcredit.fragment.HomeFragmentTwo;
import com.geo.smallcredit.fragment.LiveFragment;
import com.geo.smallcredit.fragment.LvXingFragment;
import com.geo.smallcredit.fragment.PersonalFragment;
import com.geo.smallcredit.fragment.SelectFragment;
import com.geo.smallcredit.fragment.ZhuangxiuFragment;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.ThirdMain;

public class XiaofeiActivity extends FragmentActivity implements
		android.view.View.OnClickListener {
	private Button btnBack;
//	private ViewFlow viewFlow;
//	private CircleFlowIndicator indic;
	private FrameLayout mFram;
	private List<Fragment> list;
	private LvXingFragment lvxing;
	private GouFragment gou;
	private ZhuangxiuFragment zhuang;
	private LiveFragment live;

	private RadioButton third_lvxing, third_gou, third_zhuang, third_live;

	public static final int TAB_LVXING = 0;
	public static final int TAB_GOU = 1;
	public static final int TAB_ZHUANG = 2;
	public static final int TAB_ZHUSU = 3;
	private ViewPager mPager;
	private static boolean isExit = false;
	private Intent intent;
	private TextView backtext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(XiaofeiActivity.this);
		setContentView(R.layout.third_more);

	//	viewWork();
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		addListener();
		ThirdMainAdapter adapter = new ThirdMainAdapter(
				getSupportFragmentManager());
		mPager.setAdapter(adapter);

		third_lvxing.setChecked(true);
	}

	private void addListener() {
		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				switch (id) {
				case TAB_LVXING:
					third_lvxing.setChecked(true);
					break;

				case TAB_GOU:
					third_gou.setChecked(true);
					break;

				case TAB_ZHUANG:
					third_zhuang.setChecked(true);
					break;

				case TAB_ZHUSU:
					third_live.setChecked(true);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void initClick() {
		mFram.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		third_lvxing.setOnClickListener(this);
		third_gou.setOnClickListener(this);
		third_zhuang.setOnClickListener(this);
		third_live.setOnClickListener(this);
	}

	public void initView() {
		mFram = (FrameLayout) findViewById(R.id.third_more_framelayout);
		btnBack = (Button) findViewById(R.id.btn_back_do);
		third_lvxing = (RadioButton) findViewById(R.id.third_more_lvxingbtn);
		third_gou = (RadioButton) findViewById(R.id.third_more_gou);
		third_zhuang = (RadioButton) findViewById(R.id.third_more_zhuang);
		third_live = (RadioButton) findViewById(R.id.third_more_live);
		backtext=(TextView) findViewById(R.id.third_more_backtext);
		mPager = (ViewPager) findViewById(R.id.vPager);
		mPager.setOffscreenPageLimit(4);
	}

//	private void viewWork() {
//
//		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
//		viewFlow.setAdapter(new ImageAdapter(this));
//		viewFlow.setmSideBuffer(4); // 实际图片张数， 我的ImageAdapter实际图片张数为4
//
//		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
//		viewFlow.setFlowIndicator(indic);
//		viewFlow.setTimeSpan(4500);
//		viewFlow.setSelection(3 * 1000); // 设置初始位置
//		viewFlow.startAutoFlowTimer(); // 启动自动播放
//
//	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back_do:
			finish();
			break;
			
		case R.id.third_more_framelayout:
			Intent it = new Intent(XiaofeiActivity.this, WebViewActivity.class);
			it.putExtra("url", "http://m.weicaifu.com");
			it.putExtra("title", "微财富");
			startActivity(it);
			break;
			
		case R.id.third_more_lvxingbtn:
			mPager.setCurrentItem(TAB_LVXING);
			break;

		case R.id.third_more_gou:
			mPager.setCurrentItem(TAB_GOU);
			break;

		case R.id.third_more_zhuang:
			mPager.setCurrentItem(TAB_ZHUANG);
			break;

		case R.id.third_more_live:
			mPager.setCurrentItem(TAB_ZHUSU);
			break;
		}
	}

	public class ThirdMainAdapter extends FragmentPagerAdapter {
		public static final int TAB_COUNT = 4;

		public ThirdMainAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int id) {
			switch (id) {
			case XiaofeiActivity.TAB_LVXING:
				lvxing = new LvXingFragment();
				return lvxing;

			case XiaofeiActivity.TAB_GOU:
				gou = new GouFragment();
				return gou;
			case XiaofeiActivity.TAB_ZHUANG:
				zhuang = new ZhuangxiuFragment();
				return zhuang;
			case XiaofeiActivity.TAB_ZHUSU:
				live = new LiveFragment();
				return live;
			}
			return null;
		}

		@Override
		public int getCount() {

			return TAB_COUNT;
		}
	}
}
