package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.popwindow.SelectPicPopupWindow;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class SuccessShenqingActivity extends Activity implements OnClickListener{

	private ImageView imgphone;
	private Button btn,imgback;
	// 自定义的弹出框类
		SelectPicPopupWindow menuWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.successshenqing_activity);
		initview();
		initclick();
	}
	public void initview(){
		imgback=(Button) findViewById(R.id.successshenqing_imgback);
		imgphone=(ImageView) findViewById(R.id.successshenqing_imgPhone);
		btn=(Button) findViewById(R.id.successshenqing_btn);
	}
	public void initclick(){
		imgback.setOnClickListener(this);
		imgphone.setOnClickListener(this);
		btn.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.successshenqing_imgback:
			finish();
			break;

		case R.id.successshenqing_imgPhone:
			// 实例化SelectPicPopupWindow
						menuWindow = new SelectPicPopupWindow(
								SuccessShenqingActivity.this, itemsOnClick);
						// 显示窗口
						menuWindow.showAtLocation(SuccessShenqingActivity.this
								.findViewById(R.id.success_id), Gravity.BOTTOM
								| Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
			break;
		case R.id.successshenqing_btn:
			
		Intent intent= new Intent(SuccessShenqingActivity.this,MainActivity.class);
		startActivity(intent);
			
			
			break;
		}
	}
	// 为弹出窗口实现监听类
		private OnClickListener itemsOnClick = new OnClickListener() {

			public void onClick(View v) {
				menuWindow.dismiss();
			}
		};
}
