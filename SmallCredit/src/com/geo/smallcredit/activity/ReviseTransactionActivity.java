package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.MD5Util;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class ReviseTransactionActivity extends Activity implements
		OnClickListener, OnCheckedChangeListener {

	private EditText paw, newpaw, repaw;
	private CheckBox check;
	private Button imgback;
	private Button btn;
	private LinearLayout mReal;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.revisetransaction_activity);
		initview();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initclick();
		
		// 点击外部键盘消失
		mReal = (LinearLayout) findViewById(R.id.revise_transaction_LinearLayout);
		mReal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				
			}
		});
	}

	public void initview() {
		paw = (EditText) findViewById(R.id.revise_transaction_paw);
		newpaw = (EditText) findViewById(R.id.revise_transaction_newpaw);
		repaw = (EditText) findViewById(R.id.revise_transaction_repaw);
		btn=(Button) findViewById(R.id.revise_transaction_btn);
		imgback=(Button) findViewById(R.id.revise_transaction_imgback);
		check=(CheckBox) findViewById(R.id.revise_transaction_checkbox);
		backtext=(TextView) findViewById(R.id.revise_transaction_backtext);
	}

	public void initclick() {
		
		imgback.setOnClickListener(this);
		btn.setOnClickListener(this);
		check.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		String str_paw=paw.getText().toString().trim();
		String str_newpaw=newpaw.getText().toString().trim();
		String str_repaw=repaw.getText().toString().trim();
		
		
		switch (v.getId()) {
		case R.id.revise_transaction_imgback:
			this.finish();
			break;

		case R.id.revise_transaction_btn:
			int type=CommonUtil.isNetworkAvailable(ReviseTransactionActivity.this);
			
			if(type==1||type==2||type==3){
				if("".equals(str_paw)||str_paw==null){
					ToastUtil.show(ReviseTransactionActivity.this, "请输入原密码");
				}else if("".equals(str_newpaw)||str_newpaw==null){
					ToastUtil.show(ReviseTransactionActivity.this, "请输入新密码");
				}else if("".equals(str_repaw)||str_repaw==null){
					ToastUtil.show(ReviseTransactionActivity.this, "请输入确认密码");
				}else if(!str_repaw.equals(str_newpaw)){
					ToastUtil.show(ReviseTransactionActivity.this, "确认密码和新密码两次不符合");
				}else{
					AjaxParams params=new AjaxParams();
					
					params.put("old_password", MD5Util.string2MD5(str_paw));
					params.put("password", MD5Util.string2MD5(str_newpaw));
					params.put("password_type", "trade");
					params.put("userid",SharedPreferencesUtils.getString(ReviseTransactionActivity.this, "userid", null));
					FinalHttp fh=new FinalHttp();
					fh.post(InternetURL.UPDATA_PASSWORD,params, new AjaxCallBack<String>() {

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							super.onFailure(t, errorNo, strMsg);
							Log.i("mytag", "修改交易密码失败"+strMsg.toString());
							//修改密码成功{"status":1,"userId":"6445de68-1248-11e5-8e40-643e8cc25414","mobileno":null,"desc":"原密码校验错误"}
						}

						@Override
						public void onSuccess(String t) {
							super.onSuccess(t);
							ToastUtil.show(ReviseTransactionActivity.this,"您的交易密码修改成功");
							Intent intent = new Intent(ReviseTransactionActivity.this,MainActivity.class);
							SharedPreferencesUtils.saveString(ReviseTransactionActivity.this,"userid",null);
							startActivity(intent);
						}
					});
				}
			}else{
				PromptManager.showNoNetWork(ReviseTransactionActivity.this);
			}
			
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean ischecked) {
		if(ischecked){
			//如果选中，显示密码   
			paw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			newpaw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			repaw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			
		}else{
			//否则隐藏密码
            paw.setTransformationMethod(PasswordTransformationMethod.getInstance());
			newpaw.setTransformationMethod(PasswordTransformationMethod.getInstance());
			repaw.setTransformationMethod(PasswordTransformationMethod.getInstance());
		}
		
	}
}
