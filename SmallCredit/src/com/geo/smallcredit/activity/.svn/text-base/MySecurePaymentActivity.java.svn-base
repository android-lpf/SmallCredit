package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.util.myDialog;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.HouseBean;
import com.geo.smallcredit.vo.WuYouShouYI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MySecurePaymentActivity extends Activity implements
		OnClickListener {
	private Button backBtn, wen;
	private TextView accountYue, accountShouyi, haveShouyi;
	private RelativeLayout plan, dela, recharge, deposit;
	private String yue;
	private ScrollView sv;
	private TextView backtext;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepayment);
		initView();
		intent = getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		getData();
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		// wen.setOnClickListener(this);
		plan.setOnClickListener(this);
		dela.setOnClickListener(this);
		recharge.setOnClickListener(this);
		deposit.setOnClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.mysecurepayment_backbtn);
		// wen = (Button) findViewById(R.id.mysecurepayment_wen);
		accountYue = (TextView) findViewById(R.id.mysecurepayment_accountyu_eprice);
		accountShouyi = (TextView) findViewById(R.id.mysecurepayment_shouyi_price);
		haveShouyi = (TextView) findViewById(R.id.mysecurepayment_haveshouyiprice);
		plan = (RelativeLayout) findViewById(R.id.mysecurepayment_payplan_relative);
		dela = (RelativeLayout) findViewById(R.id.mysecurepayment_dealjilu_relative);
		recharge = (RelativeLayout) findViewById(R.id.mysecurepayment_recharge_relative);
		deposit = (RelativeLayout) findViewById(R.id.mysecurepayment_deposit_relative);
		sv = (ScrollView) findViewById(R.id.mysecurepayment_id);
		backtext = (TextView) findViewById(R.id.mysecurepayment_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.mysecurepayment_backbtn:
			MySecurePaymentActivity.this.finish();
			break;
		// case R.id.mysecurepayment_wen:
		//
		// showAllSubject();
		// break;
		case R.id.mysecurepayment_payplan_relative:
			Intent plan = new Intent(MySecurePaymentActivity.this,
					MyPaymentPlanActivity.class);
			plan.putExtra("backText", "无忧还款");
			startActivity(plan);
			break;

		case R.id.mysecurepayment_dealjilu_relative:
			Intent deal = new Intent(MySecurePaymentActivity.this,
					MySecurepaymentTranscationActivity.class);
			deal.putExtra("backText", "无忧还款");
			startActivity(deal);
			break;

		case R.id.mysecurepayment_recharge_relative:
			// Intent recharge = new Intent(MySecurePaymentActivity.this,
			// MySecurepaymentRechargeActivity.class);
			// startActivity(recharge);
			Intent bank = new Intent(MySecurePaymentActivity.this,
					Mysecurepayment_addbankActivity.class);
			bank.putExtra("backText", "无忧还款");
			startActivity(bank);

			break;

		case R.id.mysecurepayment_deposit_relative:
			Intent deposit = new Intent(MySecurePaymentActivity.this,
					MySecurepaymentDepositActivity.class);
			deposit.putExtra("backText", "无忧还款");
			deposit.putExtra("yue", yue);
			
			startActivity(deposit);
			break;
		}
	}

	public void getData() {
		AjaxParams params = new AjaxParams();
		params.put("mobileno",
				SharedPreferencesUtils.getString(this, "mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(this, "userid", null));
		params.put("imei", AppConfig.getIMEI(MySecurePaymentActivity.this));
		params.put("androidid",
				AppConfig.getAndroidId(MySecurePaymentActivity.this));
		FinalHttp fh = new FinalHttp();
		fh.get(InternetURL.UWYOUHUANKUANG_QUERY, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						Log.i("mytag", strMsg);
						ToastUtil.show(MySecurePaymentActivity.this, "获取数据失败");
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);
						Log.i("mytag", t.toString());
//						WuYouShouYI shou = GsonUtils.fromJson(t.toString(),
//								WuYouShouYI.class);
//
//						Message msg = new Message();
//						msg.what = 0x006;
//						msg.obj = shou;
//						handler.sendMessage(msg);

					}
				});

	}

//	Handler handler = new Handler() {
//		public void handleMessage(Message msg) {
//			switch (msg.what) {
//			case 0x006:
//				WuYouShouYI shouyi = (WuYouShouYI) msg.obj;
//				if (shouyi != null || !"".equals(shouyi)) {
//					if (shouyi.getStatus() == 0) {
//						yue = shouyi.getBalance();
//						accountYue.setText(shouyi.getBalance());
//						accountShouyi.setText(shouyi.getYield());
//						haveShouyi.setText(shouyi.getBonus());
//					} else {
//
//						accountYue.setText("0.00");
//						accountShouyi.setText("00.000");
//						haveShouyi.setText("0.00");
//						ToastUtil.show(MySecurePaymentActivity.this, "您还没有收益");
//					}
//				}
//				break;
//			}
//		};
//	};

	public void showAllSubject() {
		// View
		// vie=LayoutInflater.from(MySecurePaymentActivity.this).inflate(R.layout.wuyou_shuoming,
		// null);
		// new AlertDialog.Builder(MySecurePaymentActivity.this)
		// .setCancelable(false)
		// .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface arg0, int arg1) {
		//
		// }
		// })
		// .setView(vie).create().show();

		new myDialog(MySecurePaymentActivity.this).showDialog(
				R.layout.wuyou_shuoming, 0, 0);
	}
}
