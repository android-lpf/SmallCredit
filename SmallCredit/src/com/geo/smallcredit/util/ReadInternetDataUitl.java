package com.geo.smallcredit.util;

import android.content.Context;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

public class ReadInternetDataUitl {

	/***
	 * 该方法只能是通过 useri mobileno获取数据
	 * 
	 */
	public static String getData(final Context context,String url){
		
		 final String str = null;
		 
		AjaxParams  params= new AjaxParams();
		params.put("mobileno", SharedPreferencesUtils.getString(context, "mobileno", null));
		params.put("userid", SharedPreferencesUtils.getString(context, "userid", null));

		FinalHttp fh=new FinalHttp();
		
		fh.get(url,params,new AjaxCallBack<String>() {

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
			}

			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);
				ToastUtil.show(context, "获取数据成功");
			}
		});
		return str;
		
	}

	
}
