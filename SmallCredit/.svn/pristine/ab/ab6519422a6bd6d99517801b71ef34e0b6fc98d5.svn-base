package com.geo.smallcredit.vo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import com.geo.smallcredit.R;

public class Receiver extends BroadcastReceiver {  
	
    @Override  
    public void onReceive(Context context, Intent intent) {  
    	 
    	View view=LayoutInflater.from(context).inflate(R.layout.activity_main,null);
    	ViewPager vp=(ViewPager) view.findViewById(R.id.vPager);
    	final RadioButton btn=(RadioButton) view.findViewById(R.id.main_select);
    	vp.setCurrentItem(2);
    	btn.setChecked(true);
    
//        final RadioButton  Rbtn=(RadioButton) view.findViewById(R.id.main_financial);
//        Log.i("mytag", "==id===="+R.id.main_select);
//		Rbtn.setChecked(true);
    	  
    	vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
					Log.i("mytag","============Ö´ÐÐÁËÂð£¿£¿");
					
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				Log.i("mytag", "==id===="+arg0);
			}
		});
		 Log.i("mytag", "==id===="+R.id.main_select);
		 
//        context.startActivity(intent);  
    }  
  
}  