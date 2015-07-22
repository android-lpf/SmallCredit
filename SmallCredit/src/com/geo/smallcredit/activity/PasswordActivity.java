package com.geo.smallcredit.activity;


import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsListView.RecyclerListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.LockPatternUtils;
import com.geo.smallcredit.util.LockPatternView;
import com.geo.smallcredit.util.LockPatternView.Cell;
import com.geo.smallcredit.util.LockPatternView.DisplayMode;
import com.geo.smallcredit.util.LockPatternView.OnPatternListener;
import com.geo.smallcredit.util.ShareUtils;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;

public class PasswordActivity extends Activity{
	// private OnPatternListener onPatternListener;
	private LockPatternView lockPatternView;
	private LockPatternUtils lockPatternUtils;
	private TextView titleTV,title_phone;
	private Button cliearBtn;
	private int inputNum = 4;
	private boolean isFristGestrue = true;  //是否是第一次绘制手势
	static PasswordActivity instanse=null;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.password_activity);
		instanse=this;
		FindViewById();
		lockPatternView.setOnPatternListener(new OnPatternListener() {
			
			String currentPattern = "";
			public void onPatternStart() {}
			@SuppressWarnings("static-access")
			public void onPatternDetected(List<Cell> pattern) {
				//判断有没有设置手势密码
				if (ShareUtils.getIsLock(PasswordActivity.this)) {
					Handler myHandler=new Handler(){// 发送handler信息把页面view清空
						public void handleMessage(android.os.Message msg) {
							switch (msg.what) {
							case PasswordActivity.RESULT_OK:
								lockPatternView.invalidate();
								break;

							default:
								break;
							}
						};
					};

					int result = lockPatternUtils.checkPattern(pattern);
					if (result != 1 && result == 0) {
						if(inputNum == 0){
							
//							Toast.makeText(PasswordActivity.this, "输入次数已过，请重新启动", Toast.LENGTH_LONG).show();
							
							new AlertDialog.Builder(PasswordActivity.this)
							.setTitle("输入次数已过，请重新启动")
							.setPositiveButton("重新启动",new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									Intent i = getBaseContext().getPackageManager()  
									        .getLaunchIntentForPackage(getBaseContext().getPackageName());  
									i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
									startActivity(i);
								}
							}).create().show();
							
							return;
						}
						lockPatternView.setDisplayMode(DisplayMode.Wrong);
						titleTV.setText("密码输入错误，您还可以输入" + inputNum + "次");
						inputNum -= 1;
						titleTV.setTextColor(Color.RED);
						lockPatternView.clearPattern();
					} else if(result == 1){
//						Toast.makeText(PasswordActivity.this, "欢迎加入我们的大家庭", Toast.LENGTH_LONG).show();
						lockPatternView.clearPattern();
						if(SharedPreferencesUtils.getString(PasswordActivity.this,"userid", null)==null){
							startActivity(new Intent(PasswordActivity.this, MainActivity.class));
						}
						finish();
					}
				} else {
					if (!isFristGestrue) {
						if(currentPattern.equals(lockPatternUtils.patternToString(pattern))){
							Toast.makeText(PasswordActivity.this, "设置密码成功", Toast.LENGTH_LONG).show();
							lockPatternUtils.saveLockPattern(pattern);
							ShareUtils.setIsLock(PasswordActivity.this, true);
							lockPatternView.clearPattern();
//							startActivity(new Intent(PasswordActivity.this,MainActivity.class));
							finish();
						}else{
							if(inputNum == 0){
								titleTV.setText("请点击重置按钮重新绘制");
								lockPatternView.clearFocus();
								titleTV.setTextColor(Color.RED);
								cliearBtn.setVisibility(View.VISIBLE);
								return;
							}
							titleTV.setText("两次绘制不一样，您还可以绘制" + inputNum + "次");
							inputNum -= 1;
							titleTV.setTextColor(Color.RED);
							lockPatternView.clearPattern();
						}
					} else {
						currentPattern = lockPatternUtils.patternToString(pattern);
						titleTV.setText("请再一次绘制手势密码");
						titleTV.setTextColor(Color.WHITE);
						lockPatternView.clearPattern();
						isFristGestrue = false;
					}
				}
			}

			public void onPatternCleared() {
				
				
			}

			@Override
			public void onPatternCellAdded(List<Cell> pattern) {
				
			}
			
		});
		
		
	}

	private void FindViewById() {
		lockPatternUtils = new LockPatternUtils(this);
		lockPatternView = (LockPatternView) findViewById(R.id.lpv_lock);
		titleTV = (TextView) findViewById(R.id.password_title_text);
		cliearBtn = (Button) findViewById(R.id.button);
		title_phone=(TextView) findViewById(R.id.password_title_phone);
		cliearBtn.setVisibility(View.INVISIBLE);
		if(ShareUtils.getIsLock(PasswordActivity.this)){
			titleTV.setText("请输入手势密码");
			String mobileno=SharedPreferencesUtils.getString(PasswordActivity.this, "mobileno", null);
			if(mobileno!=null){
				Log.i("mytag","手机号：==== "+mobileno);
				title_phone.setText(mobileno.substring(0, 3)+"********");
			}else {
				ToastUtil.show(PasswordActivity.this,"您还没有登录");
			}
		}else{
			titleTV.setText("请绘制您的手势密码");
		}
		cliearBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isFristGestrue = true;
				titleTV.setText("请绘制您的手势密码");
				titleTV.setTextColor(Color.WHITE);
				lockPatternView.clearPattern();
				inputNum = 4;
			}
		});
	}
}