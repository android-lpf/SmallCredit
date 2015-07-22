package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.popwindow.SelectPicPopupWindow;
import com.geo.smallcredit.util.ToastUtil;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyMouthPaymentPlanActivity extends Activity implements
		OnClickListener {

	private Button backBtn, telBtn, deleteBtn;
	private TextView planName, payNum, bankName, payPrice, payData,
			jianyiPayData;

	// �Զ���ĵ�������
	SelectPicPopupWindow menuWindow;
	private LinearLayout mReal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mymouthpayment_plan);
		initView();
		initClick();

		// ����ⲿ������ʧ
		mReal = (LinearLayout) findViewById(R.id.mymouthpayment_planrela);
		mReal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

			}
		});
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		telBtn.setOnClickListener(this);
		deleteBtn.setOnClickListener(this);
	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.mymouthpayment_plan_backbtn);
		telBtn = (Button) findViewById(R.id.mymouthpayment_plan_telbtn);
		deleteBtn = (Button) findViewById(R.id.mymouthpayment_plan_deletebtn);
		planName = (TextView) findViewById(R.id.mymouthpayment_plan_nameedit);
		payNum = (TextView) findViewById(R.id.mymouthpayment_plan_cardnumedit);
		bankName = (TextView) findViewById(R.id.mymouthpayment_plan_banknameedit);
		payPrice = (TextView) findViewById(R.id.mymouthpayment_plan_paypriceedit);
		payData = (TextView) findViewById(R.id.mymouthpayment_plan_shijipaydataedit);
		jianyiPayData = (TextView) findViewById(R.id.mymouthpayment_plan_jianyipaydataedit);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mymouthpayment_plan_backbtn:
			finish();
			break;

		case R.id.mymouthpayment_plan_telbtn:
			// ʵ����SelectPicPopupWindow
			menuWindow = new SelectPicPopupWindow(
					MyMouthPaymentPlanActivity.this, itemsOnClick);
			// ��ʾ����
			menuWindow.showAtLocation(MyMouthPaymentPlanActivity.this
					.findViewById(R.id.mymouthpayment_planrela), Gravity.BOTTOM
					| Gravity.CENTER_HORIZONTAL, 0, 0); // ����layout��PopupWindow����ʾ��λ��
			break;

		case R.id.mymouthpayment_plan_deletebtn:
			ToastUtil.show(MyMouthPaymentPlanActivity.this, "ɾ���ɹ�");
			finish();
			break;
		}
	}

	// Ϊ��������ʵ�ּ�����
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
		}
	};
}
