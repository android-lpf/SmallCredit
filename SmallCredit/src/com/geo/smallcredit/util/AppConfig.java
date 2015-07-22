package com.geo.smallcredit.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class AppConfig {

	public static TelephonyManager tm;
	public static String androidId;
	/***
	 * 该类用于获取按androidid imei
	 * 
	 * @param context
	 */
	public static String getAndroidId(Context context) {

		return androidId = Secure.getString(context.getContentResolver(),
				Secure.ANDROID_ID);
	}

	public static String getIMEI(Context context) {

		tm = (TelephonyManager) context
				.getSystemService(context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}
	public static void CloseKey(Context context,View v){
		
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}
	
}
