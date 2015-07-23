package com.geo.smallcredit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.BeginActivity;

import com.geo.smallcredit.activity.MoreActivity;

import com.geo.smallcredit.activity.BangbankThreeActivity;
import com.geo.smallcredit.activity.MyBillActivity;
import com.geo.smallcredit.activity.MyMessageActivity;
import com.geo.smallcredit.activity.MySecurePaymentActivity;
import com.geo.smallcredit.activity.MySecurepaymentInfoActivity;
import com.geo.smallcredit.activity.MySecurepaymentTranscationActivity;
import com.geo.smallcredit.activity.MySelectorProgressInfoActivity;
import com.geo.smallcredit.activity.My_MyInformationActivity;
import com.geo.smallcredit.activity.Mysecurepayment_addbankActivity;
import com.geo.smallcredit.activity.PersonActivity;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;

public class PersonalFragment extends Fragment implements OnClickListener {
	private RelativeLayout loginregisterReal, renzheng, selector, credit,
			bankManger, payment, more, bill;
	private TextView login_state;
	// lastPayment;
	private View v;

	// private Button backBtn;

	private ImageButton my_imgbtn;

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

		// if (SharedPreferencesUtils.getString(getActivity(), "userid", null)
		// == null) {
		// startActivity(new Intent(getActivity(), BeginActivity.class));
		// } else {
		// // 获取 我的 数据
		// login_state.setText("已登录");
		// ToastUtil.show(getActivity(), "已经登录，后台数据不完善，无法获取我的 页面信息");
		// }
		return v;
	}

	@Override
	public void onResume() {

		if (SharedPreferencesUtils.getString(getActivity(), "userid", null) != null) {
			// 获取 我的 数据
			String str = SharedPreferencesUtils.getString(getActivity(),"mobileno", null);
			if(str!=null){
				
				login_state.setText(str.substring(0, 3) + "****"+ str.substring(7, 11));
				ToastUtil.show(getActivity(), "已经登录，后台数据不完善，无法获取我的 页面信息");
			}else {
				ToastUtil.show(getActivity(), "未登录。。。");
			}
		}
		super.onResume();
	}

	private void initView() {

		// backBtn = (Button) v.findViewById(R.id.my_main_backbtn);
		loginregisterReal = (RelativeLayout) v
				.findViewById(R.id.my_main_loginregister_realtive);
		renzheng = (RelativeLayout) v.findViewById(R.id.my_main_tel_realtive);
		selector = (RelativeLayout) v.findViewById(R.id.my_main_progress_selector_relative);
		credit = (RelativeLayout) v.findViewById(R.id.my_main_letter_relative);
		bankManger = (RelativeLayout) v
				.findViewById(R.id.my_main_bankmanger_relative);
		payment = (RelativeLayout) v
				.findViewById(R.id.my_main_feedback_relative);
		bill = (RelativeLayout) v.findViewById(R.id.my_main_mybill_relative);
		// lastPayment = (TextView) v.findViewById(R.id.my_main_lastpayment);
		more = (RelativeLayout) v.findViewById(R.id.my_main_more_relative);
		my_imgbtn = (ImageButton) v.findViewById(R.id.my_messageimgbtn);
		login_state = (TextView) v.findViewById(R.id.my_main_loginregister);
	}

	private void initClick() {

		// backBtn.setOnClickListener(this);
		loginregisterReal.setOnClickListener(this);
		renzheng.setOnClickListener(this);
		selector.setOnClickListener(this);
		credit.setOnClickListener(this);
		bankManger.setOnClickListener(this);
		payment.setOnClickListener(this);
		bill.setOnClickListener(this);
		// lastPayment.setOnClickListener(this);
		more.setOnClickListener(this);
		my_imgbtn.setOnClickListener(this);
		login_state.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// case R.id.my_main_backbtn:
		// getActivity().finish();
		// break;

		case R.id.my_main_loginregister_realtive:

			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent intent1 = new Intent(getActivity(),
						My_MyInformationActivity.class);
				intent1.putExtra("backText","我的");
				startActivity(intent1);
			}
			break;

		case R.id.my_main_tel_realtive:
			// if (SharedPreferencesUtils.getString(getActivity(), "userid",
			// null) == null) {
			// ToastUtil.show(getActivity(), "您还没有登录");
			// Intent begin = new Intent(getActivity(), BeginActivity.class);
			// startActivity(begin);
			// } else {

			ToastUtil.show(getActivity(), "敬请期待。。。");

			// Intent person = new Intent(getActivity(),
			// My_MyInformationActivity.class);
			// startActivity(person);
			// }

			break;
		case R.id.my_main_loginregister:

			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			 } else {
				Intent intent = new Intent(getActivity(),My_MyInformationActivity.class);
				intent.putExtra("backText","我的");
				startActivity(intent);
			}
			break;

		case R.id.my_main_progress_selector_relative:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent progress = new Intent(getActivity(),
						MySelectorProgressInfoActivity.class);
				progress.putExtra("backText","我的");
				startActivity(progress);
			}
			break;

		case R.id.my_main_letter_relative:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent letter = new Intent(getActivity(),
						MySecurepaymentTranscationActivity.class);
				letter.putExtra("backText","我的");
				startActivity(letter);
			}
			break;
		case R.id.my_main_bankmanger_relative:

			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent manger = new Intent(getActivity(), BeginActivity.class);
				startActivity(manger);
			} else {
				Intent payment = new Intent(getActivity(),
						Mysecurepayment_addbankActivity.class);
				payment.putExtra("backText","我的");
				startActivity(payment);
			}
			break;
		case R.id.my_main_feedback_relative:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent payment1 = new Intent(getActivity(),MySecurePaymentActivity.class);
				payment1.putExtra("backText","我的");
				startActivity(payment1);
				// Intent payment1 = new Intent(getActivity(),
				// MySecurepaymentInfoActivity.class);
				// startActivity(payment1);
			}
			break;

		case R.id.my_main_mybill_relative:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent mybill = new Intent(getActivity(), MyBillActivity.class);
				mybill.putExtra("backText","我的");
				startActivity(mybill);
			}
			break;

		case R.id.my_main_more_relative:
			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent intent_more = new Intent(getActivity(),
						MoreActivity.class);
				intent_more.putExtra("backText","我的");
				startActivity(intent_more);
			}
			break;
		case R.id.my_messageimgbtn:

			if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
				ToastUtil.show(getActivity(), "您还没有登录");
				Intent begin = new Intent(getActivity(), BeginActivity.class);
				startActivity(begin);
			} else {
				Intent it = new Intent(getActivity(), MyMessageActivity.class);
				it.putExtra("backText","我的");
				startActivity(it);
			}
			break;
		}
	}
}
