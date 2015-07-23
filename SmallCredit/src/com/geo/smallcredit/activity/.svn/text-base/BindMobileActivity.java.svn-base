package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.Bill;
import com.geo.smallcredit.vo.TimeButton;

public class BindMobileActivity extends Activity implements OnClickListener {

	private Button back_btn,btn_submit;
	private EditText phoneNum;
//	private TimeButton phoneTextView;
	private Bundle savedInstanceState;
	private Intent intent;
	private String str_username,str_shenNum;
	private String str_info,str_name,mobile;
	private TextView bind_phone;
	private Bitmap bitmap;
	private ProgressBar pb;
	private int pro;
	private LinearLayout mLinearLayout;
	Handler mHandler=new Handler(){
		public void handleMessage(Message msg) {
			//处理消息  
            switch (msg.what) {  
                case 0x111:  
                    //设置滚动条和text的值  
                    pb.setProgress(pro);  
                    break;  
                default:  
                    break;  
            }  
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(BindMobileActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bind_mobile);
		initview();
		btn_onclick();
		intent=getIntent();
		mobile=SharedPreferencesUtils.getString(BindMobileActivity.this,"mobileno",null);
		bind_phone.setText(mobile.substring(0,3)+"********");
		
		str_name=intent.getStringExtra("str_name");
		str_info=intent.getStringExtra("str_info");
		str_username=intent.getStringExtra("userName");
		str_shenNum=intent.getStringExtra("shenNum");
		bitmap=intent.getParcelableExtra("image");
	}

	public void initview() {
		back_btn=(Button) findViewById(R.id.btn_sure_back_do);
//		btn_phonenum=(Button) findViewById(R.id.btn_sure_phonenum);
		btn_submit=(Button) findViewById(R.id.btn_sure_submit);
		phoneNum=(EditText) findViewById(R.id.btn_sure_et);
//		phoneTextView=(TimeButton) findViewById(R.id.btn_sure_phonenum);
		bind_phone=(TextView) findViewById(R.id.bind_phone);
//		pb=(ProgressBar) findViewById(R.id.bind_mobile_progressBar);
		mLinearLayout=(LinearLayout) findViewById(R.id.bind_mobile_id);
	}

	public void btn_onclick() {
		back_btn.setOnClickListener(this);
//		btn_phonenum.setOnClickListener(this);
		btn_submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_sure_back_do:
			finish();
			break;
		case R.id.bind_mobile_id:
			AppConfig.CloseKey(BindMobileActivity.this, v);
			break;
		case R.id.btn_sure_submit:
			
			String phoneNum_str=phoneNum.getText().toString().trim();
			
			if("".equalsIgnoreCase(phoneNum_str)||phoneNum_str==null){
				
				ToastUtil.show(this, "验证码不能为空");
				
			}else {
//				setProgressBarIndeterminateVisibility(true);
//				pb.setVisibility(View.VISIBLE);
//				start();
				Intent intent = new Intent(BindMobileActivity.this,ShowSelectFractionActivity.class);
				intent.putExtra("str_info", str_info);
				intent.putExtra("str_name", str_name);
				intent.putExtra("str_username", str_username);
				intent.putExtra("str_shenNum", str_shenNum);
				intent.putExtra("image", bitmap);
				startActivity(intent);
			}
			
			break;
		}
	}
	
	private void start()  
    {  
        new Thread(new Runnable() {  
        	
            @Override  
            public void run() {  
            	
                int max = pb.getMax();  
                
                try {  
                    //子线程循环间隔消息  
                    while (pro < max) {  
                        pro += 10;  
                        Message msg = new Message();  
                        msg.what = 0x111;  
                        mHandler.sendMessage(msg);  
                        Thread.sleep(1000);  
                    }  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
    }  
}
