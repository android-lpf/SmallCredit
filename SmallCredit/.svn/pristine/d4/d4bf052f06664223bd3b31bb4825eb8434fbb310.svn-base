package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.TravelItemActivity;
import com.geo.smallcredit.activity.WebViewActivity;
import com.geo.smallcredit.adapter.SecondMainAdapter;
import com.geo.smallcredit.adapter.TravelAdapter;
import com.geo.smallcredit.vo.SecondSelector;
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

public class LvXingFragment extends Fragment implements OnItemClickListener {
	private TravelAdapter adapter;
	private ListView lv;
	private List<Travel> list;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.lvxing, null);
		getData();
		initView();
		initclick();
		adapter = new TravelAdapter(getActivity(), list);
		lv.setAdapter(adapter);

		return view;
	}

	private void initView() {
		lv = (ListView) view.findViewById(R.id.lvxing_lv);
	}

	public void initclick() {
		lv.setOnItemClickListener(this);

	}

	private void getData() {

		list = new ArrayList<Travel>();

		list.add(new Travel("\t小信用为您推荐", R.drawable.lvxing, "呼哧旅行", "您的环球旅行支票",
				R.drawable.enter_arrow, R.drawable.tuijian));

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		// case 1:
		//
		// Intent intent1 = new Intent(getActivity(), WebViewActivity.class);
		// intent1.putExtra("url", "http://huchill.com/");
		// intent1.putExtra("title", list.get(arg2).getName());
		// startActivity(intent1);
		//
		// break;
		// case 2:
		// Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
		// intent2.putExtra("url",
		// "http://www.uubpay.com/index.php?m=content&c=index&a=lists&catid=11");
		// intent2.putExtra("title", list.get(arg2).getName());
		// startActivity(intent2);
		// break;
	}
}