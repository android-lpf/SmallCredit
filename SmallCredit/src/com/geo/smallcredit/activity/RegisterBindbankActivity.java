package com.geo.smallcredit.activity;

import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.CommonUtil;
import com.geo.smallcredit.util.GsonUtils;
import com.geo.smallcredit.util.PromptManager;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.RegisterBindbankVo;
import com.geo.smallcredit.vo.RegisterBindbankVo.data;
import com.geo.smallcredit.vo.TimeButton;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterBindbankActivity extends Activity implements
		OnClickListener {

	private Button finishBtn;
	private EditText cardNumEdit, mobileEdit, verifyEdit;
	private TextView type;
	private TimeButton verifyBtn;
	private Bundle savedInstanceState;
	private LinearLayout mLine;
	private Intent intent;
	private String username,id_number,card_no,ticket;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register_bind_bank);
		initView();
		intent=getIntent();
		username=intent.getStringExtra("username");
		id_number=intent.getStringExtra("shenfennum");
		initClick();
		cardNumEdit.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			  }
			
			@Override
			public void afterTextChanged(Editable s) {
				
				AjaxParams params=new AjaxParams();
				params.put("card_bin", cardNumEdit.getText().toString().trim());
				params.put("token", SharedPreferencesUtils.getString(RegisterBindbankActivity.this,"token",null));
				FinalHttp fh=new FinalHttp();
				fh.post(InternetURL.USER_YANBANK, params,new AjaxCallBack<String>() {

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						ToastUtil.show(RegisterBindbankActivity.this,"��ȡ����ʧ��");
					}

					@Override
					public void onSuccess(String t) {
						super.onSuccess(t);
						Log.i("mytag","======mmm----"+cardNumEdit.getText().toString().trim());
						if(!"".equals(t.toString())||t.toString()!=null){
							if(cardNumEdit.getText().toString().trim().length()>=16){
								RegisterBindbankVo mRegisterBindbankVo=GsonUtils.fromJson(t.toString(), RegisterBindbankVo.class);
								if(mRegisterBindbankVo.getCode()==200){
									data mdata=mRegisterBindbankVo.getData();
									type.setText(mdata.getBank_name());
									card_no=mdata.getBank_no();
									
								}else {
									ToastUtil.show(RegisterBindbankActivity.this,"û�и�������Ϣ");
								}
							}
						}
					}
					
				});
			}
		});
	}

	private void initClick() {
		finishBtn.setOnClickListener(this);
		verifyBtn.setOnClickListener(this);
		mLine.setOnClickListener(this);
		
	}

	private void initView() {

		finishBtn = (Button) findViewById(R.id.register_bind_bank_finishbtn);
		cardNumEdit = (EditText) findViewById(R.id.register_bind_bank_banknum_edit);
		mobileEdit = (EditText) findViewById(R.id.register_bind_bank_phone_edit);
		verifyEdit = (EditText) findViewById(R.id.register_bind_bank_verify_edit);
		type = (TextView) findViewById(R.id.register_bind_bank_banktype);
		verifyBtn = (TimeButton) findViewById(R.id.register_bind_bank_sendverifybtn);
		mLine=(LinearLayout) findViewById(R.id.traceroute_rootview);
		
	}

	@Override
	public void onClick(View v) {

		String num = cardNumEdit.getText().toString().trim();
		String phone = mobileEdit.getText().toString().trim();
		String verify = verifyEdit.getText().toString().trim();

		switch (v.getId()) {

		case R.id.register_bind_bank_sendverifybtn:
			int netWork = CommonUtil
					.isNetworkAvailable(RegisterBindbankActivity.this);

			if (netWork == 1 || netWork == 2 || netWork == 3) {

				if ("".equalsIgnoreCase(phone) || phone == null) {

					ToastUtil.show(this, "�ֻ��Ų���Ϊ��");

				} else if (phone.length() != 11) {

					ToastUtil.show(RegisterBindbankActivity.this, "������11λ���ֻ���");

				} else {
					// �������ǻ�ȡ��֤��
					verifyBtn.onCreate(savedInstanceState);
					verifyBtn.setTextAfter("������»�ȡ").setTextBefore("��ȡ��֤��")
							.setLenght(60 * 1000);
					AjaxParams params = new AjaxParams();
					params.put("userid", SharedPreferencesUtils.getString(RegisterBindbankActivity.this,"userid", null));
					params.put("phone",SharedPreferencesUtils.getString(RegisterBindbankActivity.this,"phone", null));
					params.put("realname", username);//�û���ʵ����
					params.put("id_number", id_number);//���֤����
					params.put("bank_card_number", num);//���п���
					params.put("card_no", card_no);//���м�Ʊ��
					params.put("phone_no", phone);//����Ԥ���ֻ���
					params.put("token",SharedPreferencesUtils.getString(RegisterBindbankActivity.this,"token",null));
					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.BANK_NUMBER, params,
							new AjaxCallBack<String>() {
								@Override
								public void onSuccess(String t) {
									String json=t.toString();
									if(!"".equals(json)||json!=null){
										try {
											JSONObject json1=new JSONObject(json);
											int code=json1.getInt("code");
											if(code==200){
											  ticket=json1.getString("ticket");
											}else if(code==501){
												ToastUtil.show(RegisterBindbankActivity.this,"���п���Ϣ����");
											}else if(code==502){
												ToastUtil.show(RegisterBindbankActivity.this,"�����п��Ѱ�");
											}
										} catch (JSONException e) {
											e.printStackTrace();
										}
									}
									ToastUtil.show(RegisterBindbankActivity.this, "��֤�뷢�ͳɹ�");
								}

								@Override
								public void onFailure(Throwable t, int errorNo,
										String strMsg) {
									Toast.makeText(RegisterBindbankActivity.this,"��֤�뷢��ʧ��", Toast.LENGTH_SHORT).show();
								}
							});

				}
			} else {
				PromptManager.showNoNetWork(RegisterBindbankActivity.this);
			}
			break;
		case R.id.traceroute_rootview:
			// ����ⲿ������ʧ
			AppConfig.CloseKey(RegisterBindbankActivity.this, v);
			break;

		case R.id.register_bind_bank_finishbtn:
			int netWork2 = CommonUtil.isNetworkAvailable(RegisterBindbankActivity.this);

				if (netWork2 == 1 || netWork2 == 2 || netWork2 == 3) {
					AjaxParams params = new AjaxParams();
					params.put("valid_code", verify);
					params.put("token",SharedPreferencesUtils.getString(RegisterBindbankActivity.this,"token",null));
					params.put("ticket", ticket);
					params.put("bank_card_number", num);
					FinalHttp fh = new FinalHttp();
					fh.post(InternetURL.BIND_BANK,params,new AjaxCallBack<String>() {

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							super.onFailure(t, errorNo, strMsg);
							ToastUtil.show(RegisterBindbankActivity.this,"���ݻ�ȡʧ��");
						}

						@Override
						public void onSuccess(String t) {
							super.onSuccess(t);
							String json=t.toString();
							if(!"".equals(json)||json!=null){
								try {
									JSONObject json1=new JSONObject(json);
									int code=json1.getInt("code");
									if(code==200){
										Intent to_main=new Intent(RegisterBindbankActivity.this,MainActivity.class);
										startActivity(to_main);
										ToastUtil.show(RegisterBindbankActivity.this,"�󿨳ɹ�");
										RegisterBindbankActivity.this.finish();
									}
								} catch (JSONException e) {
									e.printStackTrace();
								}
							}
						}
						
					});
				}else{
					PromptManager.showNoNetWork(RegisterBindbankActivity.this);
				}
			break;

		}
	}

}
