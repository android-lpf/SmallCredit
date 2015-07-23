package com.geo.smallcredit.util;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.provider.Settings;
import android.widget.Toast;

public class PromptManager {

	private static ProgressDialog dialog;

	public static void closeProgressDialog() {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	/**
	 * 当判断当前手机没有网络时使用
	 * 
	 * @param context
	 */
	public static void showNoNetWork(final Context context) {
		AlertDialog.Builder builder = new Builder(context);
		builder.setIcon(R.drawable.ic_launcher)
				//
				.setTitle(R.string.app_name)
				//
				.setMessage("当前无网络")
				.setPositiveButton("设置", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// 跳转到系统的网络设置界面
						Intent intent = new Intent(Settings.ACTION_SETTINGS);
						context.startActivity(intent);
						System.exit(0);
					}
				}).setNegativeButton("退出程序", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						((Activity) context).finish();
					}
				}).show();
	}

	/**
	 * 退出系统
	 * 
	 * @param context
	 */
	public static void showExitSystem(Context context) {
		AlertDialog.Builder builder = new Builder(context);
		builder.setIcon(R.drawable.logo)
				//
				.setTitle(R.string.app_name).setCancelable(false)
				//
				.setMessage("是否退出应用")
				.setPositiveButton(R.string.is_positive, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						MainApplication.getInstance().removeActivity();
						System.exit(0);
					}
				}).setNegativeButton("取消", null).show();

	}

	/**
	 * 显示错误提示框
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showErrorDialog(Context context, String msg) {
		new AlertDialog.Builder(context)//
				.setIcon(R.drawable.logo)//
				.setTitle(R.string.app_name)//
				.setMessage(msg)//
				.setNegativeButton(context.getString(R.string.is_positive),
						null)//
				.show();
	}

	/***
	 * 
	 * @param Toast
	 * @param msg
	 */
	public static void showToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	public static void showToast(Context context, int msgResId) {
		Toast.makeText(context, msgResId, Toast.LENGTH_LONG).show();
	}

}
