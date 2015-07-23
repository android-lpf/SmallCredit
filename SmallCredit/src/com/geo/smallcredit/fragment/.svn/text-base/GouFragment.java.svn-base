package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.WebViewActivity;
import com.geo.smallcredit.adapter.GouAdapter;
import com.geo.smallcredit.vo.Travel;

public class GouFragment extends Fragment implements OnItemClickListener {

	private ListView lv;
	private View v;
	private List<Travel> list;
	private GouAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.third_gouwu, null);
		initView();
		initclick();
		getData();
		adapter = new GouAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		return v;
	}

	private void initclick() {
		lv.setOnItemClickListener(this);
	}

	private void getData() {
		list = new ArrayList<Travel>();

		list.add(new Travel("\t小信用为您推荐", R.drawable.gouwu, "来分期", "互联网白领分期平台",
				R.drawable.enter_arrow, R.drawable.tuijian));	}

	private void initView() {
		lv = (ListView) v.findViewById(R.id.goufagment_listview);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		
	}
}
