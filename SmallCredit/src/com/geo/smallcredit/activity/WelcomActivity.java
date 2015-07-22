package com.geo.smallcredit.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class WelcomActivity extends Activity implements OnClickListener{

	public static final String TAG = "WelcomActivity";

	@ViewInject(R.id.image_welcome) private ImageView mImageView;
	private Animation mAnimation = null;
	private Context mContext;
	private String version;
	private Button registerBtn,loginBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MainApplication.getInstance().addActivity(WelcomActivity.this);
		boolean homeStartUp = SharedPreferencesUtils.getBoolean(this,
				"HomeStartUp", false);
			
		if (!homeStartUp) {
//			Log.e(TAG, "第一次安�?");
			startActivity(new Intent(this, HomeStartupActivity.class));
		} else {
			setContentView(R.layout.activity_welcom);
			initView();
			initClick();
			ViewUtils.inject(this);
			mContext = this;
			// 当前应用版本�?
			version = getVersion();
//			Log.e(TAG, version);
			determineNetwork();
		}
		
	}

	private void initClick() {
		registerBtn.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
	}

	private void initView() {
		registerBtn = (Button) findViewById(R.id.regist_welcome);
		loginBtn = (Button) findViewById(R.id.login_welcome);
	}

	/**
	 * 得到当前软件的版本名�?
	 * 
	 * @return
	 */
	public String getVersion() {
		// 包管理器
		PackageManager pm = getPackageManager();
		// 功能清单文件
		try {
			PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
			return packageInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}	
	

	//进入程序，判断当前有没有网络
	private void determineNetwork(){
		
			Log.e(TAG, "有网�?");
			mAnimation = AnimationUtils.loadAnimation(mContext, R.anim.welcom_alpha);
			mImageView.setAnimation(mAnimation); 

			mAnimation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation arg0) {
					// TODO Auto-generated method stub
//					Log.e(TAG, "动画�?�?");
				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation arg0) {
					// TODO Auto-generated method stub
//					Log.e(TAG, "动画结束");
//					Intent intent=new Intent(mContext,MainActivity.class);
//					startActivity(intent);
//					finish();
				}
			});
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.regist_welcome:
			Intent it=new Intent(WelcomActivity.this, RegisterYiActivity.class);
			startActivity(it);
			break;

		case R.id.login_welcome:
//			Intent it1=new Intent(WelcomActivity.this, BeginActivity.class);
//			startActivity(it1);
			Intent it1=new Intent(WelcomActivity.this, MainActivity.class);
     		startActivity(it1);
			break;
		}
	}
	

//	//点击返回按钮�?出程�?
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		// TODO Auto-generated method stub
//		PromptManager.showExitSystem(mContext);
//		return true;
//	}



}
