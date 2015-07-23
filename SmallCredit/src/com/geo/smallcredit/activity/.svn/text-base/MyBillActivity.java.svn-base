package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.adapter.MyBillAdapter;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.BaseBean;
import com.geo.smallcredit.vo.Bill;

public class MyBillActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	private Button backBtn, wenBtn;
	private ListView lv;
	private MyBillAdapter adapter;
	private List<Bill> list;
	private TextView nobill;
	private TextView backtext;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(MyBillActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mybill);
		initView();
		intent = getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		getData();
		getInfo();
		adapter = new MyBillAdapter(MyBillActivity.this, list);
		lv.setAdapter(adapter);
		initClick();
	}

	private void getData() {

		list = new ArrayList<Bill>();
		list.add(new Bill("房贷代还", "待还款", "2015-07-01", "1200.00元", "等额本息",
				"1/1", "0   天", "0.00   元", "0.00   元"));
		list.add(new Bill("旅游分期", "待还款", "2015-07-01", "1200.00元", "等额本息",
				"3/12", "0   天", "0.00   元", "0.00   元"));

	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.mybill_backbtn);
		wenBtn = (Button) findViewById(R.id.mybill_wenbtn);
		lv = (ListView) findViewById(R.id.mybill_listview);
		nobill = (TextView) findViewById(R.id.mybill_nobill);
		backtext = (TextView) findViewById(R.id.mybill_backtext);
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		wenBtn.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		switch (position) {
		case 0:
			ToastUtil.show(MyBillActivity.this, "暂无功能，尽请期待。。。");
			break;

		case 1:
			Intent travel = new Intent(MyBillActivity.this,
					MyBillPayDetailActivity.class);
			travel.putExtra("backText", "我的账单");
			startActivity(travel);
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mybill_backbtn:
			MyBillActivity.this.finish();
			break;

		case R.id.mybill_wenbtn:
			ToastUtil.show(MyBillActivity.this, "暂无功能，尽请期待。。。");
			break;
		}
	}

	public void getInfo() {
		int netWorkType = CommonUtil.isNetworkAvailable(MyBillActivity.this);

		if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

			AjaxParams params = new AjaxParams();

			params.put("mobileno", SharedPreferencesUtils.getString(
					MyBillActivity.this, "mobileno", null));
			params.put("userid", SharedPreferencesUtils.getString(
					MyBillActivity.this, "userid", null));
			params.put("imei", AppConfig.getIMEI(MyBillActivity.this));
			params.put("androidid", AppConfig.getAndroidId(MyBillActivity.this));

			Log.i("mytag", "====" + AppConfig.getAndroidId(MyBillActivity.this)
					+ AppConfig.getIMEI(MyBillActivity.this));

			FinalHttp fh = new FinalHttp();

			fh.get(InternetURL.CHECK_MYBILL, params,
					new AjaxCallBack<String>() {

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							super.onFailure(t, errorNo, strMsg);
							Log.i("mytag", "我的账单 错误====" + strMsg);
						}

						@Override
						public void onSuccess(String t) {
							super.onSuccess(t);
							try {
								JSONObject json = new JSONObject(t.toString());
								// {"status":0,"desc":"交易记录获取成功","tradeList":[]}
								String status = json.getString("status");
								String desc = json.getString("desc");
								if (Integer.parseInt(status) == 0) {
									nobill.setVisibility(View.VISIBLE);
								}

							} catch (JSONException e) {
								e.printStackTrace();
							}
						}

					});
		} else {

			PromptManager.showNoNetWork(MyBillActivity.this);
			this.finish();

		}
	}
}
