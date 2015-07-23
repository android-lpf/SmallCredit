package com.geo.smallcredit.activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
import com.geo.smallcredit.vo.LianxiBean;

public class LianxiActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private Button imgBack;
	private Button btnSave, telphoneBtn, telBtn, othertelBtn;
	private String contactId;
	private EditText telphoneName, telphoneNumber, telName, telNumber,
			otherTelName, otherTelNumber;
	private String name = "";
	private String phoneno = "";
	private TelephonyManager tm;// 获取手机 imei
	private Spinner spinner_1level;
	private Spinner spinner_2level;
	private Spinner spinner_3level;
	private LinearLayout mLine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(LianxiActivity.this);
		setContentView(R.layout.person_info);
		tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
		initView();
		initClick();
		getData();
		// 点击外部键盘消失
		mLine = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mLine.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
		});
	}

	private void initClick() {
		imgBack.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		telphoneBtn.setOnClickListener(this);
		telBtn.setOnClickListener(this);
		othertelBtn.setOnClickListener(this);
		spinner_1level.setOnItemSelectedListener(this);
		spinner_2level.setOnItemSelectedListener(this);
		spinner_3level.setOnItemSelectedListener(this);
	}

	private void initView() {

		imgBack = (Button) findViewById(R.id.person_telphone_btn_back_do);
		btnSave = (Button) findViewById(R.id.person_info_savebtn);
		telphoneName = (EditText) findViewById(R.id.person_info_familyship_telnameedit);
		telphoneBtn = (Button) findViewById(R.id.personinfo_familyship_telbookbtn);
		telphoneNumber = (EditText) findViewById(R.id.person_info_familyship_mobileedit);
		telName = (EditText) findViewById(R.id.person_info_work_familyship_nameedit);
		telBtn = (Button) findViewById(R.id.person_info_workship_telbook);
		telNumber = (EditText) findViewById(R.id.person_info_work_familyship_mobileedit);
		otherTelName = (EditText) findViewById(R.id.person_info_otherpersonship_nameedit);
		othertelBtn = (Button) findViewById(R.id.person_info_otherperson_telbookbtn);
		otherTelNumber = (EditText) findViewById(R.id.person_info_otherpersonship_mobileedit);

		spinner_1level = (Spinner) findViewById(R.id.personinfo_familyship_spinner1);

		spinner_2level = (Spinner) findViewById(R.id.person_info_work_familyship_spinner2);

		spinner_3level = (Spinner) findViewById(R.id.person_info_otherpersonship_spinner);
	}

	@Override
	public void onClick(View v) {
		String str_spinner_1level = spinner_1level.getSelectedItem().toString()
				.trim();
		String str_spinner_2level = spinner_2level.getSelectedItem().toString()
				.trim();
		String str_spinner_3level = spinner_3level.getSelectedItem().toString()
				.trim();

		String str_telphoneName = telphoneName.getText().toString().trim();
		String str_telphoneNumber = telphoneNumber.getText().toString().trim();

		String str_telname = telName.getText().toString().trim();
		String str_telnum = telNumber.getText().toString().trim();

		String str_othertelname = otherTelName.getText().toString().trim();
		String str_othertelnum = otherTelNumber.getText().toString().trim();

		switch (v.getId()) {
		case R.id.person_telphone_btn_back_do:
			finish();
			break;

		case R.id.person_info_savebtn:

			int netWorkType = CommonUtil
					.isNetworkAvailable(LianxiActivity.this);

			if (netWorkType == 1 || netWorkType == 2 || netWorkType == 3) {

				if ("".equalsIgnoreCase(str_telphoneName)
						|| str_telphoneName == null) {

					Toast.makeText(LianxiActivity.this, "对不起，姓名也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_telphoneNumber)
						|| str_telphoneNumber == null) {

					Toast.makeText(LianxiActivity.this, "对不起，手机号也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if (str_telphoneNumber.length() < 11
						|| str_telphoneNumber.length() > 11) {

					Toast.makeText(LianxiActivity.this, "对不起，请输入11位手机号",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_telname)
						|| str_telname == null) {

					Toast.makeText(LianxiActivity.this, "对不起，姓名也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_telnum)
						|| str_telnum == null) {

					Toast.makeText(LianxiActivity.this, "对不起，手机号也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if (str_telnum.length() < 11 || str_telnum.length() > 11) {

					Toast.makeText(LianxiActivity.this, "对不起，请输入11位手机号",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_othertelname)
						|| str_othertelname == null) {

					Toast.makeText(LianxiActivity.this, "对不起，姓名也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if ("".equalsIgnoreCase(str_othertelnum)
						|| str_othertelnum == null) {

					Toast.makeText(LianxiActivity.this, "对不起，手机号也不能为空",
							Toast.LENGTH_SHORT).show();

				} else if (str_othertelnum.length() < 11
						|| str_othertelnum.length() > 11) {

					Toast.makeText(LianxiActivity.this, "对不起，请输入11位手机号",
							Toast.LENGTH_SHORT).show();

				} else {

					AjaxParams params = new AjaxParams();
					params.put("contact_flag", "family");
					params.put("contact_name", str_telphoneName);
					params.put("contact_mobile", str_telphoneNumber);
					params.put("contact_relation", str_spinner_1level);
					params.put("userid", SharedPreferencesUtils.getString(
							LianxiActivity.this, "userid", null));
					params.put("imei", AppConfig.getIMEI(LianxiActivity.this));
					params.put("androidid",
							AppConfig.getAndroidId(LianxiActivity.this));

					FinalHttp fh = new FinalHttp();

					fh.post(InternetURL.CHECK_relationship, params,
							new AjaxCallBack<String>() {

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									super.onFailure(t, errorNo, strMsg);
									ToastUtil.show(LianxiActivity.this, "上传失败");
								}

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);

									ToastUtil.show(LianxiActivity.this, "上传成功");
								}

							});
					// 工作联系人
					AjaxParams params2 = new AjaxParams();
					params2.put("contact_flag", "work");
					params2.put("contact_name", str_telname);
					params2.put("contact_mobile", str_telnum);
					params2.put("contact_relation", str_spinner_2level);
					params2.put("userid", SharedPreferencesUtils.getString(
							LianxiActivity.this, "userid", null));
					params2.put("imei", AppConfig.getIMEI(LianxiActivity.this));
					params2.put("androidid",
							AppConfig.getAndroidId(LianxiActivity.this));

					FinalHttp fh2 = new FinalHttp();

					fh2.post(InternetURL.CHECK_relationship, params2,
							new AjaxCallBack<String>() {
							});

					// 其他联系人
					AjaxParams params3 = new AjaxParams();
					params3.put("contact_flag", "other");
					params3.put("contact_name", str_othertelname);
					params3.put("contact_mobile", str_othertelnum);
					params3.put("contact_relation", str_spinner_3level);
					params3.put("userid", SharedPreferencesUtils.getString(
							LianxiActivity.this, "userid", null));
					params3.put("imei", AppConfig.getIMEI(LianxiActivity.this));
					params3.put("androidid",
							AppConfig.getAndroidId(LianxiActivity.this));

					FinalHttp fh3 = new FinalHttp();

					fh3.post(InternetURL.CHECK_relationship, params3,
							new AjaxCallBack<String>() {

								@Override
								public void onSuccess(String t) {
									super.onSuccess(t);
									LianxiActivity.this.finish();
								}

							});

				}

			} else {

				PromptManager.showNoNetWork(LianxiActivity.this);

			}
			break;

		case R.id.personinfo_familyship_telbookbtn:
			name = "";
			phoneno = "";
			Intent i = new Intent(Intent.ACTION_PICK);
			i.setData(Uri.parse("content://com.android.contacts/contacts"));
			startActivityForResult(i, 0);
			break;

		case R.id.person_info_workship_telbook:
			Intent s = new Intent(Intent.ACTION_PICK);
			s.setData(Uri.parse("content://com.android.contacts/contacts"));
			startActivityForResult(s, 1);
			break;
		case R.id.person_info_otherperson_telbookbtn:
			Intent ii = new Intent(Intent.ACTION_PICK);
			ii.setData(Uri.parse("content://com.android.contacts/contacts"));
			startActivityForResult(ii, 2);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Cursor c = null;
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Uri contentUri = data.getData();
			c = this.getContentResolver().query(contentUri, null, null, null,
					null);
			while (c.moveToNext()) {

				name = c.getString(c
						.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

				contactId = c.getString(c
						.getColumnIndex(ContactsContract.Contacts._ID));

				Cursor phones = this.getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null,
						ContactsContract.CommonDataKinds.Phone.CONTACT_ID
								+ " = " + contactId, null, null);

				while (phones.moveToNext()) {
					phoneno = phones.getString(phones.getColumnIndex("data1"));
					System.out.println("phone:" + phoneno);
				}
			}

			switch (requestCode) {
			case 0:
				hander.sendEmptyMessage(0);
				break;

			case 1:
				hander.sendEmptyMessage(1);
				break;
			case 2:
				hander.sendEmptyMessage(2);
				break;
			}

		}

	}

	private Handler hander = new Handler(Looper.getMainLooper()) {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				telphoneName.setText(name);
				telphoneNumber.setText(phoneno);
				break;
			case 1:
				telName.setText(name);
				telNumber.setText(phoneno);
				break;
			case 2:
				otherTelName.setText(name);
				otherTelNumber.setText(phoneno);
				break;
			case 0x003:

				LianxiBean lian = (LianxiBean) msg.obj;
				if (!"".equals(lian) || lian != null) {
					if (Integer.parseInt(lian.getStatus()) == 0) {

						// List<contactList> list=lian.getContactList();
						// Log.i("mytag", "list====="+list);
						// for (int i = 0; i < list.size(); i++) {
						//
						String flag = lian.getContactFlag();

						Log.i("mytag", "flag===" + flag);

						if ("family".equals(flag)) {
							String Relation = lian.getContactRelation();
							if ("父母".equals(Relation)) {
								spinner_1level.setSelection(0, true);
							} else if ("配偶".equals(Relation)) {
								spinner_1level.setSelection(1, true);
							} else if ("子女".equals(Relation)) {
								spinner_1level.setSelection(2, true);
							}
							telphoneName.setText(lian.getContactName());
							telphoneNumber.setText(lian.getContactMobile());

						} else if ("work".equals(flag)) {

							String Relation = lian.getContactRelation();
							if ("同事".equals(Relation)) {
								spinner_2level.setSelection(0, true);
							} else if ("人事(HR)".equals(Relation)) {
								spinner_2level.setSelection(1, true);
							}
							telName.setText(lian.getContactName());
							telNumber.setText(lian.getContactMobile());

						} else if ("other".equals(flag)) {

							String Relation = lian.getContactRelation();
							if ("朋友".equals(Relation)) {
								spinner_3level.setSelection(0, true);
							} else if ("其他".equals(Relation)) {
								spinner_3level.setSelection(1, true);
							}
							otherTelName.setText(lian.getContactName());
							otherTelNumber.setText(lian.getContactMobile());
						}
					}
				}

				break;
			}

		}
	};

	public void getData() {
		AjaxParams params = new AjaxParams();
		params.put("mobileno",
				SharedPreferencesUtils.getString(this, "mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(this, "userid", null));
		params.put("imei", AppConfig.getIMEI(LianxiActivity.this));
		params.put("androidid", AppConfig.getAndroidId(LianxiActivity.this));

		FinalHttp fh = new FinalHttp();

		fh.get(InternetURL.PEOPLE_RENZHENG_READ, params,
				new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);

						Log.i("mytag", "lianxi===返回==" + strMsg);

						ToastUtil.show(LianxiActivity.this, "获取数据失败");
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);

						Log.i("mytag", "身份===返回==" + t.toString());

						// ToastUtil.show(LianxiActivity.this, "获取数据成功");

						// LianxiBean lianxi=GsonUtils.fromJson(t.toString(),
						// LianxiBean.class);
						LianxiBean lianxi = null;
						try {

							JSONObject json = new JSONObject(t.toString());
							String str = json.getString("status");
							JSONArray ja = json.getJSONArray("contactList");
							for (int i = 0; i < ja.length(); i++) {
								lianxi = new LianxiBean();

								lianxi.setStatus(str);
								JSONObject jo = ja.getJSONObject(i);

								lianxi.setContactFlag(jo
										.getString("contactFlag"));

								lianxi.setContactRelation(jo
										.getString("contactRelation"));

								lianxi.setContactName(jo
										.getString("contactName"));

								lianxi.setContactMobile(jo
										.getString("contactMobile"));

								Message msg = new Message();
								msg.what = 0x003;
								msg.obj = lianxi;
								hander.sendMessage(msg);
							}

						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				});
	}

	// 此方法只是关闭软键盘
	public void hintKbTwo() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive() && getCurrentFocus() != null) {
			if (getCurrentFocus().getWindowToken() != null) {
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {

		TextView tv = (TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
		hintKbTwo();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

}
