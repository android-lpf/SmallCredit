package com.geo.smallcredit.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.interfaces.OnGetResultListener;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;

public class SelectFrationActivity extends Activity implements OnClickListener {

	private Button btn, img_back_btn;
	private TextView username, id_number, phone, system_date, zhongzhi,
			zhongchen, laka;
	private Intent intent;
	private String str_name, str_info;
	private String userName, shenNum, telphone, flg_HomeFragment;
	private CheckBox cb1, cb2, cb3;
	private Bitmap bitmap;
	private Dialog mDialog;
	private SimpleDateFormat formatter;
	private Date curDate;
	private OnGetResultListener mListener;

	public static SelectFrationActivity instance = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(SelectFrationActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.select_fration_activity);
		initview();
		instance = this;
		formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String str = formatter.format(curDate);
		system_date.setText(str);

		intent = getIntent();
		flg_HomeFragment = intent.getStringExtra("HomeFragment");
		str_name = intent.getStringExtra("name");
		str_info = intent.getStringExtra("info");
		bitmap = intent.getParcelableExtra("image");
		userName = intent.getStringExtra("second_name");// 用户姓名
		// username.setText(SharedPreferencesUtils.getString(SelectFrationActivity.this,"username",
		// null));
		username.setText("小张");
		shenNum = intent.getStringExtra("num");// 用户身份证号
		// id_number.setText(SharedPreferencesUtils.getString(SelectFrationActivity.this,"shenfenId",
		// null));
		id_number.setText("1415321259454415");
		telphone = SharedPreferencesUtils.getString(SelectFrationActivity.this,
				"mobileno", null);
		phone.setText(telphone);

		btn_click();

	}

	public void btn_click() {
		btn.setOnClickListener(this);
		img_back_btn.setOnClickListener(this);
		zhongzhi.setOnClickListener(this);
		zhongchen.setOnClickListener(this);
		laka.setOnClickListener(this);

		// cb1.setOnClickListener(this);
		// cb2.setOnClickListener(this);
		// cb3.setOnClickListener(this);

	}

	public void initview() {

		img_back_btn = (Button) findViewById(R.id.select_fration_activity_imgbtn);
		btn = (Button) findViewById(R.id.select_fration_activity_nextbtn);
		username = (TextView) findViewById(R.id.select_fration_activity_uername);
		id_number = (TextView) findViewById(R.id.select_fration_activity_id_number);
		phone = (TextView) findViewById(R.id.select_fration_activity_phone);
		// cb1 = (CheckBox)
		// findViewById(R.id.selecto_fration_activity_checkbox_yi);
		// cb2 = (CheckBox)
		// findViewById(R.id.selecto_fration_activity_checkbox_er);
		// cb3 = (CheckBox)
		// findViewById(R.id.selecto_fration_activity_checkbox_san);
		system_date = (TextView) findViewById(R.id.selecto_data);
		zhongzhi = (TextView) findViewById(R.id.selecto_zhong_xieyi);
		zhongchen = (TextView) findViewById(R.id.selecto_zhongche_xieyi);
		laka = (TextView) findViewById(R.id.selecto_la_xieyi);
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		// 实例化接口
		// mListener = (OnGetResultListener);
	}

	@Override
	public void onClick(View v) {

		String str_username = username.getText().toString().trim();
		String str_id_number = id_number.getText().toString().trim();
		String str_phone = phone.getText().toString().trim();

		switch (v.getId()) {

		case R.id.selecto_zhong_xieyi:

			Intent xieyi1 = new Intent(SelectFrationActivity.this,
					ZhongZhiCheng_xieyiActivity.class);
			xieyi1.putExtra("backText", "统一授权");
			startActivity(xieyi1);

			break;

		case R.id.selecto_zhongche_xieyi:

			Intent xieyi2 = new Intent(SelectFrationActivity.this,
					ZhongChengXin_xieyiActivity.class);
			xieyi2.putExtra("backText", "统一授权");
			startActivity(xieyi2);

			break;

		case R.id.selecto_la_xieyi:

			Intent xieyi3 = new Intent(SelectFrationActivity.this,
					KaoLa_xiyiActivity.class);
			xieyi3.putExtra("backText", "统一授权");
			startActivity(xieyi3);
			break;

		case R.id.select_fration_activity_nextbtn:

			int type = CommonUtil
					.isNetworkAvailable(SelectFrationActivity.this);

			if (type == 1 || type == 2 || type == 3) {

				if ("".equalsIgnoreCase(str_username) || str_username == null) {

					ToastUtil.show(SelectFrationActivity.this, "姓名不能为空");

				} else if ("".equalsIgnoreCase(str_id_number)
						|| str_id_number == null) {

					ToastUtil.show(SelectFrationActivity.this, "身份证不能为空");

				} else if ("".equalsIgnoreCase(str_phone) || str_phone == null) {

					ToastUtil.show(SelectFrationActivity.this, "手机号不能为空");

				} else {
					if ("HomeFragment".equals(flg_HomeFragment)) {

						Intent intent1 = new Intent(SelectFrationActivity.this,
								MainActivity.class);
						intent1.putExtra("select", "select");
						startActivity(intent1);

					} else if ("".equals("")) {

						Intent intent1 = new Intent(SelectFrationActivity.this,
								MainActivity.class);
						intent1.putExtra("select", "select");
						startActivity(intent1);

					} else {

						SelectFrationActivity.this.finish();
					}
				}// mListener.onGetResult("content");
					// showRoundProcessDialog(SelectFrationActivity.this,R.layout.loading_process_dialog_anim);
					//
					// FinalHttp fh = new FinalHttp();
					// AjaxParams params = new AjaxParams();
					// params.put("mobileno", telphone);
					// params.put("business_code", "1");
					// params.put("imei",
					// AppConfig.getIMEI(SelectFrationActivity.this));
					// params.put("androidid",
					// AppConfig.getAndroidId(SelectFrationActivity.this));
					// fh.get(InternetURL.CHECKPHONE, params,
					// new AjaxCallBack<String>() {
					//
					// @Override
					// public void onFailure(Throwable t, int errorNo,
					// String strMsg) {
					// super.onFailure(t, errorNo, strMsg);
					// ToastUtil.show(SelectFrationActivity.this,
					// "验证码发送失败");
					// }
					//
					// @Override
					// public void onSuccess(String t) {
					// super.onSuccess(t);
					// ToastUtil.show(SelectFrationActivity.this,
					// "发送成功");
					// Intent intent = new Intent(
					// SelectFrationActivity.this,
					// BindMobileActivity.class);
					// intent.putExtra("str_name", str_name);
					// intent.putExtra("str_info", str_info);
					// intent.putExtra("userName", userName);
					// intent.putExtra("shenNum", shenNum);
					// intent.putExtra("image", bitmap);
					// startActivity(intent);
					// }
					// });

			} else {
				PromptManager.showNoNetWork(SelectFrationActivity.this);
			}

			break;

		case R.id.select_fration_activity_imgbtn:
			this.finish();
			break;
		}
	}

	public void showRoundProcessDialog(Context mContext, int layout) {
		mDialog = new AlertDialog.Builder(mContext).create();

		mDialog.show();
		// 注意此处要放在show之后 否则会报异常
		mDialog.setContentView(layout);
		// mDialog.setCancelable(false); //false设置点击其他地方不能取消进度条
	}

}
