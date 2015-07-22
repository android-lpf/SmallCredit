package com.geo.smallcredit.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.ToastUtil;

public class PersonalFragment extends Fragment implements OnClickListener {
	private RelativeLayout rl1,rl2,rl3,rl4;
	private View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (v == null) {
			v = inflater.inflate(R.layout.my_main, null);
		}
		ViewGroup parent = (ViewGroup) v.getParent();
		if (parent != null) {
			parent.removeView(v);
		}
		initView();
		initClick();

		return v;
	}

//	@Override
//	public void onResume() {
//
//		if (SharedPreferencesUtils.getString(getActivity(), "userid", null) != null) {
//			// 获取 我的 数据
//			String str = SharedPreferencesUtils.getString(getActivity(),"mobileno", null);
//			if(str!=null){
//				
//				login_state.setText(str.substring(0, 3) + "****"+ str.substring(7, 11));
//				ToastUtil.show(getActivity(), "已经登录，后台数据不完善，无法获取我的 页面信息");
//			}else {
//				ToastUtil.show(getActivity(), "未登录。。。");
//			}
//		}
//		super.onResume();
//	}

	private void initView() {
		rl1=(RelativeLayout) v.findViewById(R.id.my_main_rl1);
		rl2=(RelativeLayout) v.findViewById(R.id.my_main_rl2);
		rl3=(RelativeLayout) v.findViewById(R.id.my_main_rl3);
		rl4=(RelativeLayout) v.findViewById(R.id.my_main_rl4);
	}

	private void initClick() {
		rl1.setOnClickListener(this);
		rl2.setOnClickListener(this);
		rl3.setOnClickListener(this);
		rl4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_main_rl1:
			ToastUtil.show(getActivity(),"我的信用");
			break;

		case R.id.my_main_rl2:
			ToastUtil.show(getActivity(),"我的专属");
			break;
		case R.id.my_main_rl3:
			ToastUtil.show(getActivity(),"邀请好友");
			break;
		case R.id.my_main_rl4:
			ToastUtil.show(getActivity(),"设置");
			break;
		}
	}
}
