package com.geo.smallcredit.fragment;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.BeginActivity;
import com.geo.smallcredit.activity.MyBillActivity;
import com.geo.smallcredit.activity.PersonActivity;
import com.geo.smallcredit.activity.XiaofeiActivity;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.vo.Receiver;
import com.geo.smallcredit.vo.RoundProgressBar;

public class HomeFragment extends Fragment implements OnClickListener {

	private RelativeLayout mRelativeLayout1, mRelativeLayout2,
			mRelativeLayout3, mRelativeLayout4, mRelativeLayout5;
	private View v;
	private RoundProgressBar mRoundProgressBar1;
	private int progress = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (v == null) {
			v = inflater.inflate(R.layout.home_, null);
		}
		ViewGroup parent = (ViewGroup) v.getParent();
		if (parent != null) {
			parent.removeView(v);
		}
		initview();

		btn_click();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress <= 69) {

					progress += 1;// 这里是加1的 , 从服务器获取的时候因该减掉1

					System.out.println(progress);

					mRoundProgressBar1.setProgress(progress);

					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

		return v;
	}

	public void initview() {
		mRelativeLayout1 = (RelativeLayout) v.findViewById(R.id.home_rela1);
		mRelativeLayout2 = (RelativeLayout) v.findViewById(R.id.home_real2);
		mRelativeLayout3 = (RelativeLayout) v.findViewById(R.id.home_rl3);
		mRelativeLayout4 = (RelativeLayout) v.findViewById(R.id.home_rela4);
		mRelativeLayout5 = (RelativeLayout) v.findViewById(R.id.home_rel5);
		mRoundProgressBar1 = (RoundProgressBar) v
				.findViewById(R.id.roundProgressBar1);
	}

	public void btn_click() {
		mRelativeLayout1.setOnClickListener(this);
		mRelativeLayout2.setOnClickListener(this);
		mRelativeLayout3.setOnClickListener(this);
		mRelativeLayout4.setOnClickListener(this);
		mRelativeLayout5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.home_rela1:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				Intent intent = new Intent(getActivity(), BeginActivity.class);
				startActivity(intent);
			} else {
				Intent intent = new Intent(getActivity(), PersonActivity.class);

				startActivity(intent);
			}
			break;

		case R.id.home_real2:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				Intent intent = new Intent(getActivity(), BeginActivity.class);
				startActivity(intent);
			} else {
				Intent it = new Intent(getActivity(), MyBillActivity.class);
				startActivity(it);
			}
			break;

		case R.id.home_rl3:
			Toast.makeText(getActivity(), "该功能还未实现,期待", Toast.LENGTH_SHORT)
					.show();
			break;

		case R.id.home_rela4:

			// FinancialFragment financial = new FinancialFragment();
			// getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl,
			// financial).commit();
			setAlarm(true);
			Toast.makeText(getActivity(), "该功能还未实现,尽情期待", Toast.LENGTH_SHORT)
					.show();
			break;

		case R.id.home_rel5:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				Intent intent = new Intent(getActivity(), BeginActivity.class);
				startActivity(intent);
			} else {
				Intent it1 = new Intent(getActivity(), XiaofeiActivity.class);
				startActivity(it1);
			}
			break;
		}

	}

	private void setAlarm(boolean bool) {
		/*
		 * AlarmManager 全局定时器 其用法跟Timer有点类似,作用有如下两点: 第一:在指定时长后执行某项操作;
		 * 第二:周期性的执行某项操作.
		 * AlarmManager与Intent的配合使用,可以启动Activity,发送Broadcast,开启Service.
		 */

		AlarmManager am = (AlarmManager) getActivity().getSystemService(
				Context.ALARM_SERVICE);

		PendingIntent pi = PendingIntent.getBroadcast(getActivity(), 0,
				new Intent(getActivity(), Receiver.class), 0);

		if (bool) {
			Calendar c = Calendar.getInstance();
			am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
		} else {
			am.cancel(pi);
		}
	}

}
