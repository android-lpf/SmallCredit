package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;

import com.geo.smallcredit.activity.WebViewActivity;
import com.geo.smallcredit.adapter.GouAdapter;

import com.geo.smallcredit.adapter.ZhuSuAdapter;
import com.geo.smallcredit.vo.Live;
import com.geo.smallcredit.vo.Travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class LiveFragment extends Fragment implements OnItemClickListener {
	private ListView lv;
	private View v;
	private List<Live> list;
	private ZhuSuAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.third_zhusu, null);
		initView();
		initClick();
		getData();
		adapter = new ZhuSuAdapter(getActivity(),list);
		lv.setAdapter(adapter);
		return v;
	}

	private void getData() {
		list = new ArrayList<Live>();
		list.add(new Live("¾´ÇëÆÚ´ý¡£¡£¡£"));
	}

	private void initClick() {
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		lv = (ListView) v.findViewById(R.id.third_zhusu_listview);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
//		switch (position) {
//		case 0:
//			Intent intent = new Intent(getActivity(), WebViewActivity.class);
//			intent.putExtra("url", "https://www.zufangbao.com/");
//			intent.putExtra("title", list.get(position).getName());
//			startActivity(intent);
//			break;
//
//		default:
//			break;
//		}
	}
}
