package com.geo.smallcredit.activity;

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
import android.widget.RadioButton;
import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.fragment.FinancialFragment;
import com.geo.smallcredit.fragment.PersonalFragment;
import com.geo.smallcredit.fragment.SelectFragment;
import com.geo.smallcredit.interfaces.OnGetResultListener;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;

public class MainActivity extends FragmentActivity implements
		android.view.View.OnClickListener, OnGetResultListener {

	private RadioButton main_home, main_select, main_financial, main_personal;

	public static final int TAB_SELECTOR = 0;
	public static final int TAB_FINAO = 1;
	public static final int TAB_MY = 2;
	private ViewPager mPager;
	private static boolean isExit = false;

	public SelectFragment select;
	public FinancialFragment finan;
	public PersonalFragment my;
	public Intent intent;
	private String select_str;// 判断是否是从selectfrationactivity调转过来

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(MainActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		intent = getIntent();
		select_str = intent.getStringExtra("select");
		int id = intent.getIntExtra("tab2", -1);
		main_select.setChecked(true);
		initClick();
		addListener();

		MainViewPagerAdapter adapter = new MainViewPagerAdapter(
				getSupportFragmentManager());
		mPager.setAdapter(adapter);
		if ("select".equals(select_str)) {

			mPager.setCurrentItem(TAB_SELECTOR);
			main_select.setChecked(true);
		} else if (id == 0) {
			mPager.setCurrentItem(TAB_FINAO);
			main_financial.setChecked(true);

		} 
//			else if (SharedPreferencesUtils.getString(MainActivity.this,
//				"userid", null) != null) {
//			Intent intent = new Intent(MainActivity.this,
//					PasswordActivity.class);
//			startActivity(intent);
//		}


	}

	private void initView() {

		main_select = (RadioButton) findViewById(R.id.main_select);
		main_financial = (RadioButton) findViewById(R.id.main_financial);
		main_personal = (RadioButton) findViewById(R.id.main_personal);
		mPager = (ViewPager) findViewById(R.id.vPager);
		mPager.setOffscreenPageLimit(3);

	}

	private void initClick() {
		main_select.setOnClickListener(this);
		main_financial.setOnClickListener(this);
		main_personal.setOnClickListener(this);
	}

	private void addListener() {
		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				switch (id) {
				case TAB_SELECTOR:
					main_select.setChecked(true);
					break;

				case TAB_FINAO:
					main_financial.setChecked(true);
					break;

				case TAB_MY:
					main_personal.setChecked(true);
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_select:
				
			mPager.setCurrentItem(TAB_SELECTOR);
			
			break;

		case R.id.main_financial:

			mPager.setCurrentItem(TAB_FINAO);

			break;

		case R.id.main_personal:

			mPager.setCurrentItem(TAB_MY);

			break;
		}
	}

	// 退出应用
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			exit();
			break;
		}
		return true;
	}

	// 退出应用

	private void exit() {
		if (!isExit) {
			// isExit = true;
			// Toast.makeText(getApplicationContext(), "再按一次退出", 1).show();
			AlertDialog.Builder builder = new Builder(this);
			builder.setIcon(R.drawable.logo)
					//
					.setTitle(R.string.app_name).setCancelable(false)
					//
					.setMessage("是否退出应用")
					.setPositiveButton(R.string.is_positive,
							new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									MainApplication.getInstance()
											.removeActivity();
									System.exit(0);
								}
							}).setNegativeButton("取消", null).show();

		}
	}

	public class MainViewPagerAdapter extends FragmentPagerAdapter {
		public static final int TAB_COUNT = 3;

		public MainViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int id) {
			switch (id) {
			case MainActivity.TAB_SELECTOR:
				select = new SelectFragment();
				return select;
			case MainActivity.TAB_FINAO:
				finan = new FinancialFragment();
				return finan;
			case MainActivity.TAB_MY:
				my = new PersonalFragment();
				return my;
			}
			return null;
		}

		@Override
		public int getCount() {

			return TAB_COUNT;
		}

	}

	@Override
	public void onGetResult(String content) {

		if ("content".equals(content)) {
			mPager.setCurrentItem(TAB_SELECTOR);
			main_select.setChecked(true);
		} else if ("cont".equals(content)) {
			mPager.setCurrentItem(TAB_FINAO);
			main_financial.setChecked(true);
		}
	}
}
