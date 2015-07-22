package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.MainActivity.MainViewPagerAdapter;
import com.geo.smallcredit.fragment.FinancialFragment;
import com.geo.smallcredit.fragment.PersonalFragment;
import com.geo.smallcredit.fragment.SelectFragment;
import com.geo.smallcredit.fragment.ShowPersonFragment;
import com.geo.smallcredit.fragment.ShowYibiaoFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainShowfenInfoActivity extends FragmentActivity implements OnClickListener{
	
	private Button backBtn;
	private RadioButton rb1,rb2;
	private RelativeLayout mReal,mReal2,mReal3;
	public static final int TAB_SHOWFEN = 0;
	public static final int TAB_SHOWFEN2 = 1;
	private ViewPager mPager;
	private static boolean isExit = false;
	private ShowYibiaoFragment yibiao;
	private ShowPersonFragment shenfenInfo;
	private TextView companyname;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_main_showfen);
		initView();
		rb1.setChecked(true);
		initClick();
		addListener();
		InfoViewPagerAdapter adapter = new InfoViewPagerAdapter(
				getSupportFragmentManager());
		mPager.setAdapter(adapter);
	}


	private void addListener() {
		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				switch (id) {
				case TAB_SHOWFEN2:
					rb2.setChecked(true);
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

		backBtn.setOnClickListener(this);
		rb1.setOnClickListener(this);
		rb2.setOnClickListener(this);
		mReal.setOnClickListener(this);
		mReal2.setOnClickListener(this);
		mReal3.setOnClickListener(this);

	}


	private void initView() {

		backBtn = (Button) findViewById(R.id.second_main_showfen_backbtn);
		companyname = (TextView) findViewById(R.id.second_main_showfen_companyname);
		rb1 = (RadioButton) findViewById(R.id.second_main_showfen_select);
		rb2 = (RadioButton) findViewById(R.id.second_main_showfen_financial);
		mReal = (RelativeLayout) findViewById(R.id.second_main_showfen_real2);
		mReal2 = (RelativeLayout) findViewById(R.id.second_main_showfen_real3);
		mReal3 = (RelativeLayout) findViewById(R.id.second_main_showfen_real4);
		mPager = (ViewPager) findViewById(R.id.second_main_showfen_vPager);
		mPager.setOffscreenPageLimit(2);

	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.second_main_showfen_select:
			mPager.setCurrentItem(TAB_SHOWFEN);
			break;

		case R.id.second_main_showfen_financial:
			mPager.setCurrentItem(TAB_SHOWFEN2);
			break;
		}
	}
	public class InfoViewPagerAdapter extends FragmentPagerAdapter {
		public static final int TAB_COUNT = 2;

		public InfoViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int id) {
			switch (id) {
			case MainShowfenInfoActivity.TAB_SHOWFEN:
				yibiao=new ShowYibiaoFragment();
				return yibiao;
			case MainShowfenInfoActivity.TAB_SHOWFEN2:
				shenfenInfo=new ShowPersonFragment();
				return shenfenInfo;
			}
			return null;
		}

		@Override
		public int getCount() {

			return TAB_COUNT;
		}

	}
}
