package com.geo.smallcredit.activity;

import com.geo.smallcredit.R;
import com.geo.smallcredit.popwindow.SelectPicPopupWindow;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MySelectorProgressSureActivity extends Activity implements
		OnClickListener {

	private Button backBtn, telBtn, sureBtn, giveupBtn;
	private TextView price, qiXian, shenQing, jie, feWu, pay;
	private CheckBox thirdCb, personCb;
	// �Զ���ĵ�������
	SelectPicPopupWindow menuWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myselectorprogresssure);
		initView();
		initClick();
	}

	private void initClick() {
		backBtn.setOnClickListener(this);
		telBtn.setOnClickListener(this);
		sureBtn.setOnClickListener(this);
		giveupBtn.setOnClickListener(this);
		thirdCb.setOnClickListener(this);
		personCb.setOnClickListener(this);

	}

	private void initView() {
		backBtn = (Button) findViewById(R.id.myselectorprogresssure_backbtn);
		telBtn = (Button) findViewById(R.id.myselectorprogresssure_telbtn);
		sureBtn = (Button) findViewById(R.id.myselectorprogresssure_surebtn);
		giveupBtn = (Button) findViewById(R.id.myselectorprogresssure_giveupbtn);
		price = (TextView) findViewById(R.id.myselectorprogresssure_price);
		qiXian = (TextView) findViewById(R.id.myselectorprogresssure_qixian);
		shenQing = (TextView) findViewById(R.id.myselectorprogresssure_shenqing);
		jie = (TextView) findViewById(R.id.myselectorprogresssure_jie);
		feWu = (TextView) findViewById(R.id.myselectorprogresssure_fuwufei);
		pay = (TextView) findViewById(R.id.myselectorprogresssure_pay);
		thirdCb = (CheckBox) findViewById(R.id.myselectorprogresssure_checkthird);
		personCb = (CheckBox) findViewById(R.id.myselectorprogresssure_checkperson);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.myselectorprogresssure_backbtn:
			finish();
			break;

		case R.id.myselectorprogresssure_telbtn:
			// ʵ����SelectPicPopupWindow
			menuWindow = new SelectPicPopupWindow(
					MySelectorProgressSureActivity.this, itemsOnClick);
			// ��ʾ����
			menuWindow.showAtLocation(MySelectorProgressSureActivity.this
					.findViewById(R.id.myselectorprogresssure), Gravity.BOTTOM
					| Gravity.CENTER_HORIZONTAL, 0, 0); // ����layout��PopupWindow����ʾ��λ��
			break;

		case R.id.myselectorprogresssure_surebtn:
			finish();
			break;

		case R.id.myselectorprogresssure_giveupbtn:
			Intent giveup = new Intent(MySelectorProgressSureActivity.this,
					MySelectorProgressGiveupBecauseActivity.class);
			startActivity(giveup);
			break;

		case R.id.myselectorprogresssure_checkthird:
			View view = LayoutInflater.from(this).inflate(
					R.layout.xiao_xing_yong_xie_yi, null);
			WebView wv = (WebView) view.findViewById(R.id.webview);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.loadUrl("file:///android_asset/xiaoxinyong.html");

			new AlertDialog.Builder(this)
					.setTitle("���ø���(С����)����Э��")

					.setView(view)
					.setCancelable(false)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {

									thirdCb.setChecked(true);
								}
							})
					.setNegativeButton("ȡ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									thirdCb.setChecked(false);
								}
							}).create().show();

			break;

		case R.id.myselectorprogresssure_checkperson:
			View vi = LayoutInflater.from(this).inflate(
					R.layout.xiao_xing_yong_xie_yi, null);
			WebView w = (WebView) vi.findViewById(R.id.webview);
			w.getSettings().setJavaScriptEnabled(true);
			w.loadUrl("file:///android_asset/xiaoxinyong.html");

			new AlertDialog.Builder(this)
					.setTitle("���ø���(С����)����Э��")

					.setView(vi)
					.setCancelable(false)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {

									personCb.setChecked(true);
								}
							})
					.setNegativeButton("ȡ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									personCb.setChecked(false);
								}
							}).create().show();

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
