package com.geo.smallcredit.adapter;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @ClassName: ViewPagerAdapter
 * @Description: viewpager适配�?
 * @author A18ccms a18ccms_gmail_com
 * @date 2015�?1�?22�? 下午3:46:03
 *
 */
public class ViewPagerAdapter extends PagerAdapter{

	//界面列表  
	private List<View> views;

	public ViewPagerAdapter (List<View> views){  
		this.views = views;  
	}  

	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));   
	}

	@Override
	public int getCount() {
		if (views != null){  
			return views.size();  
		}  

		return 0;
	}

	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);  

		return views.get(position);
	}

	@Override
	public void finishUpdate(View container) {
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View container) {
	}


}
