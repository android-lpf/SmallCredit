package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyDebitBankAdapter;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.Card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MyTificationBankActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	private Button backBtn;
	private TextView add;
	private ListView lv1, lv2;
	private MyDebitBankAdapter adapter;
	private List<Card> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_renzheng_bankinfo);
		initView();
		initClick();
		getData();
		getDatas();
		adapter = new MyDebitBankAdapter(MyTificationBankActivity.this, list);
		lv1.setAdapter(adapter);
		lv2.setAdapter(adapter);
	}

	private void getData() {
		list = new ArrayList<Card>();
		list.add(new Card("   借记卡","银行", "建设银行", "卡号", "6226 0101 7451 820", "用途", "还房贷"));
	}
	
	private void initClick() {
		backBtn.setOnClickListener(this);
		add.setOnClickListener(this);
		lv1.setOnItemClickListener(this);
		lv2.setOnItemClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.my_renzheng_bankinfo_backbtn);
		add = (TextView) findViewById(R.id.my_renzheng_bankinfo_add);
		lv1 = (ListView) findViewById(R.id.my_renzheng_bankinfo_jiejibanklistview);
		lv2 = (ListView) findViewById(R.id.my_renzheng_bankinfo_creditbanklistview);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.my_renzheng_bankinfo_backbtn:
			finish();
			break;
			
		case R.id.my_renzheng_bankinfo_add:
			Intent it = new Intent(MyTificationBankActivity.this,
					MyAddBankActivity.class);
			startActivity(it);
			break;

		}
	}
	
	public void getDatas(){
		
		AjaxParams params=new AjaxParams();
		
		params.put("userid", SharedPreferencesUtils.getString(MyTificationBankActivity.this,"userid", null));
		params.put("imei", AppConfig.getIMEI(MyTificationBankActivity.this));
		params.put("androidid", AppConfig.getAndroidId(MyTificationBankActivity.this));
		params.put("mobileno", SharedPreferencesUtils.getString(MyTificationBankActivity.this, "mobileno", null));
		
		FinalHttp fh=new FinalHttp();
		
		fh.get(InternetURL.USER_BANK_RENZHENG_READ,params, new AjaxCallBack<String>(){

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				ToastUtil.show(MyTificationBankActivity.this,"读取银行卡信息失败");
				Log.i("mytag", "strMsg=="+strMsg);
			}

			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);
				ToastUtil.show(MyTificationBankActivity.this,"读取银行卡信息成功，占无数据");
			}
			
		});
	}
}
