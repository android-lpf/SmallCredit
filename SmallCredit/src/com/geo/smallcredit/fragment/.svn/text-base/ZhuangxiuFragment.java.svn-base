package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.WebViewActivity;
import com.geo.smallcredit.adapter.GouAdapter;
import com.geo.smallcredit.adapter.ZhuangXiuAdapter;
import com.geo.smallcredit.vo.Travel;
import com.geo.smallcredit.vo.ZhuangXiu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ZhuangxiuFragment extends Fragment implements OnItemClickListener {
	private ListView lv;
	private View v;
	private List<Travel> list;
	private ZhuangXiuAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.third_zhuangxiu, null);
		initView();
		initClick();
		getData();
		adapter =new ZhuangXiuAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		return v;
	}

	private void getData() {
		list = new ArrayList<Travel>();

		list.add(new Travel("\t小信用为您推荐", R.drawable.zhuangxiu, "家分期", "装修也能用分期",
				R.drawable.enter_arrow, R.drawable.tuijian));	}

	private void initClick() {
		lv.setOnItemClickListener(this);		
	}

	private void initView() {
		lv = (ListView) v.findViewById(R.id.third_zhuangxiu_listview);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
//		switch (position) {
//		case 0:
//			Intent intent = new Intent(getActivity(),WebViewActivity.class);
//			intent.putExtra("url", "http://www.uubpay.com/index.php?m=content&c=index&a=lists&catid=10");
//			intent.putExtra("title",list.get(position).getName());
//			startActivity(intent);
//			break;
//
//		default:
//			break;
//		}
	}
}
