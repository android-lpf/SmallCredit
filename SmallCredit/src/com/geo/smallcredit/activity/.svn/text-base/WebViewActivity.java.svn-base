package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.sso.UMSsoHandler;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WebViewActivity extends Activity implements OnClickListener {
   
	private WebView mWebView;
	private Button imgback;
	private Intent intent;
	private String webUrl,title,tag;
	private TextView showTitle,backtext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.webview_activity);
		initview();
		
		intent=getIntent();
		webUrl=intent.getStringExtra("url");
		title=intent.getStringExtra("title");
		tag=intent.getStringExtra("tag");
		showTitle.setText(title);
		backtext.setText(intent.getStringExtra("backText"));
		mWebView = (WebView) findViewById(R.id.webview_activity);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setUseWideViewPort(true);// 设置此属性，可任意比例缩放
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBuiltInZoomControls(true);
		webSettings.setSupportZoom(true);
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 关闭webview中缓存
		mWebView.loadUrl(webUrl);
		mWebView.setWebViewClient(new WebViewClient(){

		      @Override
		      public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        view.loadUrl(url);
		        return true;
		      }
		    });
		initclick();
	}


	public void initview() {

		imgback = (Button) findViewById(R.id.webview_activity_imgback);
		showTitle=(TextView) findViewById(R.id.webview_title);
		backtext=(TextView) findViewById(R.id.webview_backtext);
	}

	public void initclick() {
		imgback.setOnClickListener(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		if(keyCode == KeyEvent.KEYCODE_BACK){ 
			
          if("huchi".equals(tag)){
				
				finish();
				Huchi_shuoming_Activity.instance.finish();
				
			}else if("paipai".equals(tag)){
				
				finish();
				Paipaidai_ShuomingActivity.instance.finish();
				
			}else if("jiafengqi".equals(tag)){
				finish();
				Jiafenqi_ShuomingActivity.instance.finish();
			}else if("laifenqi".equals(tag)){
				finish();
				Laifenqi_ShuomingActivity.instance.finish();
			}else if("pingan".equals(tag)){
				finish();
				Pinganyidai_ShuomingActivity.instance.finish();
			}
			else{
				
				finish();
				
			}
			
		}
		
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.webview_activity_imgback:

			if("huchi".equals(tag)){
				
				finish();
				Huchi_shuoming_Activity.instance.finish();
				
			}else if("paipai".equals(tag)){
				
				finish();
				Paipaidai_ShuomingActivity.instance.finish();
				
			}else if("jiafengqi".equals(tag)){
				finish();
				Jiafenqi_ShuomingActivity.instance.finish();
			}else if("laifenqi".equals(tag)){
				finish();
				Laifenqi_ShuomingActivity.instance.finish();
			}else if("pingan".equals(tag)){
				finish();
				Pinganyidai_ShuomingActivity.instance.finish();
			}
			else{
				
				finish();
				
			}
	//		Huchi_shuoming_Activity.instance.finish();
			break;

		}
	}
	
}
