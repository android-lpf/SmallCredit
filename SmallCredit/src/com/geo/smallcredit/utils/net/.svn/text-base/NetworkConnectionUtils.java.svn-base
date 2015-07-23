package com.geo.smallcredit.utils.net;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.content.Context;

import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;

public class NetworkConnectionUtils {

	private static Context ct;
	private NetworkConnectionUtils(){}
	private static NetworkConnectionUtils instance = new NetworkConnectionUtils();
	public static NetworkConnectionUtils getInstance(Context context){
		ct = context;
		return instance;
	}

	@SuppressWarnings("unchecked")
	public void load(String url, AjaxParams params, AjaxCallBack ajaxCallBack) {
		FinalHttp finalHttp = new FinalHttp();
		if(0 == CommonUtil.isNetworkAvailable(ct)){
			//			Toast.makeText(ct, "无网络，请检查网络连接！", 0).show();
			//无网络时弹出对话框
			PromptManager.showNoNetWork(ct);
		}else{
			if(params!=null){
				//				params = new AjaxParams();
				finalHttp.post(url, params, ajaxCallBack);
			}else{
				finalHttp.get(url, ajaxCallBack);	
			}
		}
	}
}
