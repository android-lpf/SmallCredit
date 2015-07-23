package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.ThridAdapter;
import com.geo.smallcredit.vo.ThirdMain;

public class FinancialFragment extends Fragment implements OnClickListener,
		OnItemClickListener {
	// private ViewFlow viewFlow;
	// private CircleFlowIndicator indic;

	private View v;
	private ListView lv;
	private List<ThirdMain> list;
	private ThridAdapter adapter;
	private FrameLayout img;
	private Button menuBtn;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (v == null) {
			v = inflater.inflate(R.layout.third_main_two, null);
		}
		ViewGroup parent = (ViewGroup) v.getParent();
		if (parent != null) {
			parent.removeView(v);
		}
		// viewWork();
		initview();
		initClick();
		getData();
		adapter = new ThridAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		return v;
	}

	private void getData() {

		list = new ArrayList<ThirdMain>();
		
		list.add(new ThirdMain(R.drawable.faxian_pingan, "平安直通", "大品牌,门槛低",
				"一次申请多个贷款方案", R.drawable.next));
		list.add(new ThirdMain(R.drawable.faxian_huchilvxing, "呼哧旅行", "您的环球旅行支票",
				"极速操作、无需攒钱、只做精品", R.drawable.next));
	}

	public void initview() {

		lv = (ListView) v.findViewById(R.id.third_main_two_listview);
		img = (FrameLayout) v.findViewById(R.id.third_main_two_framelayout);
		menuBtn = (Button) v.findViewById(R.id.third_main_two_menubtn);
		
	}

	public void initClick() {

		lv.setOnItemClickListener(this);
		img.setOnClickListener(this);
		menuBtn.setOnClickListener(this);
		
	}

	// private void viewWork() {
	// viewFlow = (ViewFlow) v.findViewById(R.id.third_mian_two_viewflow);
	// viewFlow.setAdapter(new ImageAdapter(getActivity()));
	// viewFlow.setmSideBuffer(4); // 实际图片张数， 我的ImageAdapter实际图片张数为4
	// indic = (CircleFlowIndicator)
	// v.findViewById(R.id.third_mian_two_viewflowindic);
	// viewFlow.setFlowIndicator(indic);
	// viewFlow.setTimeSpan(4500);
	// viewFlow.setSelection(3 * 1000); // 设置初始位置
	// viewFlow.startAutoFlowTimer(); // 启动自动播放
	//
	// }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			
		case R.id.third_main_two_framelayout:
//			Intent it = new Intent(getActivity(), WebViewActivity.class);
//			it.putExtra("url", "http://m.weicaifu.com");
//			it.putExtra("title", "微财富");
//			startActivity(it);
			break;
		case R.id.third_main_two_menubtn:
			
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		
	}
}
