package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.BeginActivity;
import com.geo.smallcredit.activity.MainActivity;
import com.geo.smallcredit.activity.MySecurePaymentActivity;
import com.geo.smallcredit.activity.MySecurepaymentInfoActivity;
import com.geo.smallcredit.activity.PersonActivity;
import com.geo.smallcredit.activity.SelectFrationActivity;
import com.geo.smallcredit.activity.XiaofeiActivity;
import com.geo.smallcredit.adapter.ImageAdapter;
import com.geo.smallcredit.circle.CircleFlowIndicator;
import com.geo.smallcredit.circle.ViewFlow;
import com.geo.smallcredit.interfaces.OnGetResultListener;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.HomeBean;
import com.geo.smallcredit.vo.RoundProgressBar;
import com.lidroid.xutils.db.sqlite.CursorUtils.FindCacheSequence;

public class HomeFragmentTwo extends Fragment implements OnClickListener {

	private RoundProgressBar mRoundProgressBar1;
	private int progress = 0;
	private View view, vv;
	private RelativeLayout rl1, friend, rl3, rl4, rl5;
	// private LinearLayout rl3;
	private RadioButton rb;
	private CircleFlowIndicator indic;
	private ViewFlow viewFlow;
	private ListView listview;
	private List<HomeBean> list;
	// 定义接口
	private OnGetResultListener mListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.home_fragment, null);
		vv = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main,
				null);
		initview();
		startRoundbar();
		initClick();

		// viewWork();
		// addData();
		// listview=(ListView) view.findViewById(R.id.hometwo_listview);
		//
		// HomeFragmentAdapter adapter = new
		// HomeFragmentAdapter(getActivity(),list);
		// listview.setAdapter(adapter);

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		
//		if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
//			view.findViewById(R.id.home_fragment_wuyou).setVisibility(
//					View.VISIBLE);
//		} else {
//			view.findViewById(R.id.home_fragment_wuyou2).setVisibility(
//					View.VISIBLE);
//			view.findViewById(R.id.home_fragment_wuyou).setVisibility(
//					View.GONE);
//		}
		
	}

	private void viewWork() {
		viewFlow = (ViewFlow) view.findViewById(R.id.hometwo_viewflow);
		viewFlow.setAdapter(new ImageAdapter(getActivity()));
		viewFlow.setmSideBuffer(4); // 实际图片张数， 我的ImageAdapter实际图片张数为4
		indic = (CircleFlowIndicator) view
				.findViewById(R.id.hometwo_viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(4500);
		viewFlow.setSelection(3 * 1000); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// 实例化接口
		mListener = (OnGetResultListener) activity;
	}

	public void initClick() {
		rl1.setOnClickListener(this);
		friend.setOnClickListener(this);
		rl3.setOnClickListener(this);
		rl4.setOnClickListener(this);
		rl5.setOnClickListener(this);// 无忧还款
	}

	public void initview() {

		mRoundProgressBar1 = (RoundProgressBar) view
				.findViewById(R.id.homefragment_roundProgressBar);
		rl1 = (RelativeLayout) view.findViewById(R.id.homefragment_rl1);
		friend = (RelativeLayout) view.findViewById(R.id.home_fragment_friend);
		rl3 = (RelativeLayout) view.findViewById(R.id.homefragment_rl3);
		rb = (RadioButton) vv.findViewById(R.id.main_select);
		rl4 = (RelativeLayout) view.findViewById(R.id.home_fragment_wuyou);
		rl5 = (RelativeLayout) view.findViewById(R.id.home_fragment_wuyou2);
	}

	public void startRoundbar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress <= 79) {

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
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.homefragment_rl1:

//			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
//
//				ToastUtil.show(getActivity(), "您还没有登录");
//
//				Intent intent = new Intent(getActivity(), BeginActivity.class);
//
//				startActivity(intent);
//
//			} else {
//
//				Intent intent = new Intent(getActivity(), PersonActivity.class);
//
//				startActivity(intent);
//			}
			ToastUtil.show(getActivity(), "敬请期待");
			break;

		case R.id.home_fragment_friend:

			ToastUtil.show(getActivity(), "敬请期待");

			break;
		case R.id.homefragment_rl3:

			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {

				ToastUtil.show(getActivity(), "您还没有登录");

				Intent intent = new Intent(getActivity(), BeginActivity.class);

				startActivity(intent);

			}else {

				mListener.onGetResult("cont");
			}

			break;
		case R.id.home_fragment_wuyou:

			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {

				ToastUtil.show(getActivity(), "您还没有登录");

				Intent intent = new Intent(getActivity(), BeginActivity.class);

				startActivity(intent);

			} else {

				Intent wuyou = new Intent(getActivity(),
						MySecurepaymentInfoActivity.class);
				wuyou.putExtra("backText", "推荐");
				startActivity(wuyou);
			}

			break;
		case R.id.home_fragment_wuyou2:
			
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent intent = new Intent(getActivity(), BeginActivity.class);
				startActivity(intent);
			}else if(SharedPreferencesUtils.getString(getActivity(), "score",null)==null){
				
				ToastUtil.show(getActivity(), "系统检查到你是首次查询,需授权");
				Intent intent = new Intent(getActivity(), SelectFrationActivity.class);
				intent.putExtra("HomeFragment","HomeFragment");
				startActivity(intent);
				
			} else {
				mListener.onGetResult("content");
			}
			break;
		}
	}

	public void addData() {
		list = new ArrayList<HomeBean>();
		list.add(new HomeBean("个人征信", "查询我的信用分数"));
		list.add(new HomeBean("无忧还款", "自动还款  余额生息"));
		list.add(new HomeBean("金融生活", "分期消费  信用代还  信用借款"));
		list.add(new HomeBean("最大期权", "最高期权24期"));
	}
	
}
