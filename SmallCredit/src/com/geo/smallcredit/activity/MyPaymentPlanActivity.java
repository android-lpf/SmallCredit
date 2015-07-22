package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyPaymentPlanAdapter;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.Huankuan;

public class MyPaymentPlanActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private Button backBtn, addBtn;
	private ListView lv;
	private MyPaymentPlanAdapter adapter;
	private List<Huankuan> list;
	private Huankuan huankuan;
	private Bundle b;
	private TextView tx, backtxt;
	private Intent it;
	// 如果改字段的话接口得改

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.msecureypayment_plan);
		initView();
		initClick();
		getDatas();
		it=getIntent();
		backtxt.setText(it.getStringExtra("backText"));
	}

	// private void getData() {
	// list = new ArrayList<Plan>();
	// list.add(new Plan("用于每月房贷还款", "还款日期", "每月16日",
	// "6226 0100 1234 5678 123", "建设银行", "2560.00", "每月18日"));
	// list.add(new Plan("用于每月车贷还款", "还款日期", "每月20日",
	// "6226 0100 1234 5678 123", "建设银行", "2560.00", "每月25日"));
	// list.add(new Plan("用于每月房贷还款", "还款日期", "每月27日",
	// "6226 0100 1234 5678 123", "建设银行", "2560.00", "每月30日"));
	// }

	private void initClick() {
		backBtn.setOnClickListener(this);
		addBtn.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.mypayment_plan_backbtn);
		addBtn = (Button) findViewById(R.id.mypayment_plan_addbtn);
		tx = (TextView) findViewById(R.id.mypayment_plan_zanwu);
		lv = (ListView) findViewById(R.id.mypayment_plan_listview);
		backtxt = (TextView) findViewById(R.id.mypayment_plan_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mypayment_plan_backbtn:
			this.finish();
			break;

		case R.id.mypayment_plan_addbtn:

			Intent add = new Intent(MyPaymentPlanActivity.this,
					MyAddpaymentPlanActivity.class);
			add.putExtra("backText", "还款计划");
			startActivity(add);
			break;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
	}

	public void getDatas() {

		AjaxParams params = new AjaxParams();
		params.put("mobileno",
				SharedPreferencesUtils.getString(this, "mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(this, "userid", null));
		params.put("imei", AppConfig.getIMEI(MyPaymentPlanActivity.this));
		params.put("androidid",
				AppConfig.getAndroidId(MyPaymentPlanActivity.this));

		FinalHttp fh = new FinalHttp();
		fh.get(InternetURL.CHECK_PAYMENTPLAN, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						ToastUtil.show(MyPaymentPlanActivity.this, "还款获取数据失败");
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);
						tx.setVisibility(View.VISIBLE);
						list = new ArrayList<Huankuan>();
						try {
							JSONObject json = new JSONObject(t.toString());
							String status = json.getString("status");
							String desc = json.getString("desc");
							JSONArray json2 = json.getJSONArray("refundList");
							for (int i = 0; i < json2.length(); i++) {
								huankuan = new Huankuan();
								JSONObject json3 = json2.getJSONObject(i);
								huankuan.setStatus(status);
								huankuan.setDesc(desc);
								huankuan.setPlanName(json3
										.getString("planName"));
								huankuan.setPlanBankcard(json3
										.getString("planBankcard"));
								huankuan.setPlanBank(json3
										.getString("planBank"));
								huankuan.setPlanAmount(json3
										.getString("planAmount"));
								huankuan.setPlanRepaymentDate(json3
										.getString("planRepaymentDate"));
								huankuan.setSuggestRepaymentDate(json3
										.getString("suggestRepaymentDate"));
								huankuan.setUpdateDate(json3
										.getString("updateDate"));
								list.add(huankuan);
								Message msg = new Message();
								msg.what = 0x007;
								msg.obj = list;
								handler.sendMessage(msg);
							}
						} catch (Exception e) {

						}

					}
				});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x007:
				List<Huankuan> huan = (List<Huankuan>) msg.obj;

				if (huan != null || "".equals(huan)) {

					adapter = new MyPaymentPlanAdapter(
							MyPaymentPlanActivity.this, huan);
					lv.setAdapter(adapter);

				} else {
					ToastUtil.show(MyPaymentPlanActivity.this, "获取失败");
				}
				break;
			}

		};
	};
}
