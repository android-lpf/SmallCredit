package com.geo.smallcredit.util;

import android.content.Context;
import android.content.SharedPreferences;

/**  
* @Title: SharedPreferencesUtils.java
* @Package 
* @Description: TODO(用一句话描述该文件做�?�?)
* @author
* @date 
* @version V1.0  
*

/**
 * @ClassName: SharedPreferencesUtils
 * @Description: 本地缓存 SharedPreferencesUtils 管理
 * @author 
 * @date 
 *
 */
public class SharedPreferencesUtils {
	
	public static final String SP_NAME = "config";
	private static SharedPreferences sp;

	public static void saveBoolean(Context ct, String key, boolean value) {
		if (sp == null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		sp.edit().putBoolean(key, value).commit();	}

	public static boolean getBoolean(Context ct, String key, boolean defValue) {
		if (sp == null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		return sp.getBoolean(key, defValue);

	}
	public static void saveString(Context ct, String key, String value) {
		if (sp == null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		sp.edit().putString(key, value).commit();
	}

	public static String getString(Context ct, String key, String defValue) {
		if (sp == null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		return sp.getString(key, defValue);
	}
	
	public static void saveInt(Context ct, String key, int value){
		if(sp!=null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		sp.edit().putInt(key, value).commit();
	}
	public static int getInt(Context ct, String key, int defValue){
		if (sp == null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		return sp.getInt(key, defValue);
	}
	
	public static void clearSharePrefere(Context ct){
		if (sp != null){
			sp = ct.getSharedPreferences(SP_NAME, 0);
		}
		sp.edit().clear().commit();
	}

}
