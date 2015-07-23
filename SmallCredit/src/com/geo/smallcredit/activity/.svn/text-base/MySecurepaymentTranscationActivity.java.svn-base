package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyTranscationAdapter;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.Transcation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MySecurepaymentTranscationActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	private Button backBtn;
	private ListView lv;
	private List<Transcation> list;
	private MyTranscationAdapter adapter;
	private TextView deal;
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mysecurepayment_transcation);
		initView();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();
		getDatas();

	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.mysecurepayment_transcation_backbtn);
		lv = (ListView) findViewById(R.id.mysecurepayment_transcation_listview);
		deal = (TextView) findViewById(R.id.mydeal_nobill);
		backtext=(TextView) findViewById(R.id.mysecurepay_backtext);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mysecurepayment_transcation_backbtn:
			MySecurepaymentTranscationActivity.this.finish();
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

	}

	public void getDatas() {
		AjaxParams params = new AjaxParams();
		params.put("mobileno",
				SharedPreferencesUtils.getString(this, "mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(this, "userid", null));
		params.put("imei",
				AppConfig.getIMEI(MySecurepaymentTranscationActivity.this));
		params.put("androidid",
				AppConfig.getAndroidId(MySecurepaymentTranscationActivity.this));
		FinalHttp fh = new FinalHttp();
		fh.get(InternetURL.JIAO_YI_QUERY, params, new AjaxCallBack<String>() {

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				ToastUtil.show(MySecurepaymentTranscationActivity.this,
						"交易获取数据失败");
			}

			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);
				deal.setVisibility(View.VISIBLE);
				list = new ArrayList<Transcation>();
				try {
					JSONObject json = new JSONObject(t.toString());
					String status = json.getString("status");
					String desc = json.getString("desc");
					JSONArray tradeList = json.getJSONArray("tradeList");
					for (int i = 0; i < tradeList.length(); i++) {
						Transcation mTranscation = new Transcation();
						JSONObject json2 = tradeList.getJSONObject(i);
						String tradeStatus = json2.getString("tradeStatus");
						String tradeType = json2.getString("tradeType");
						mTranscation.setTradeType(tradeType);
						mTranscation.setTradeStatus(tradeStatus);
						mTranscation.setStatus(status);
						mTranscation.setDesc(desc);
						mTranscation.setTradeNumber(json2
								.getString("tradeNumber"));
						mTranscation.setTradeTime(json2.getString("tradeTime"));

						mTranscation.setPayAccount(json2
								.getString("payAccount"));
						mTranscation.setBeneficiaryAccount(json2
								.getString("beneficiaryAccount"));
						list.add(mTranscation);

					}

					Message msg = new Message();
					msg.what = 0x008;
					msg.obj = list;
					handler.sendMessage(msg);

				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x008:
				List<Transcation> lists = (List<Transcation>) msg.obj;
				if (lists != null || !"".equals(lists)) {

					adapter = new MyTranscationAdapter(
							MySecurepaymentTranscationActivity.this, lists);
					lv.setAdapter(adapter);
				}

				break;

			}

		};

	};

}
