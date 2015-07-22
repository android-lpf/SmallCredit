package com.geo.smallcredit.adapter;


import com.geo.smallcredit.activity.MainActivity;
import com.geo.smallcredit.fragment.FinancialFragment;
import com.geo.smallcredit.fragment.PersonalFragment;
import com.geo.smallcredit.fragment.SelectFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
	public static final int TAB_COUNT = 3;

	public MainViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int id) {
		switch (id) {
		case MainActivity.TAB_SELECTOR:
			SelectFragment select = new SelectFragment();
			return select;
		case MainActivity.TAB_FINAO:
			FinancialFragment finan = new FinancialFragment();
			return finan;
		case MainActivity.TAB_MY:
			PersonalFragment my = new PersonalFragment();
			return my;
		}
		return null;
	}

	@Override
	public int getCount() {

		return TAB_COUNT;
	}

}