package com.geo.smallcredit.util;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author lipengfei
 * @date 06/12/2014
 * @description Toast 提示工具�?
 */
public class ToastUtil {
	/**
	 * 基本Toast提示
	 * 
	 * @param ctx
	 *            当前上下�?
	 * @param msg
	 *            信息内容
	 */
	public static void show(Context ctx, String msg) {
		Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
	}

	/**
	 * 带有时间长短控制的Toast提示
	 * 
	 * @param ctx
	 *            当前上下�?
	 * @param msg
	 *            信息内容
	 * @param time
	 *            显示时间 Either{@link #LENGTH_SHORT} or {@link #LENGTH_LONG}
	 */
	public static void show(Context ctx, String msg, int time) {
		Toast.makeText(ctx, msg, time).show();
	}

	/**
	 * 创建带有自定义View的Toast
	 * 
	 * @param ctx
	 *            当前上下�?
	 * @param msg
	 *            信息内容
	 * @param customView
	 *            自定义View
	 * @param orientation
	 *            View与文字的布局方式 Either{@link #HORIZONTAL} or {@link #VERTICAL}
	 */
	public static void show(Context ctx, String msg, View customView,
			int orientation) {
		Toast toast = Toast.makeText(ctx, msg, Toast.LENGTH_LONG);
		View textView = toast.getView();
		LinearLayout linearLayout = new LinearLayout(ctx);
		linearLayout.setOrientation(orientation);
		linearLayout.addView(customView);
		linearLayout.addView(textView);
		toast.setView(linearLayout);
		toast.show();
	}
}