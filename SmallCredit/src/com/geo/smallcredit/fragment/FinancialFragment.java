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
		
		list.add(new ThirdMain(R.drawable.faxian_pingan, "ƽ��ֱͨ", "��Ʒ��,�ż���",
				"һ�������������", R.drawable.next));
		list.add(new ThirdMain(R.drawable.faxian_huchilvxing, "��������", "���Ļ�������֧Ʊ",
				"���ٲ�����������Ǯ��ֻ����Ʒ", R.drawable.next));
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
	// viewFlow.setmSideBuffer(4); // ʵ��ͼƬ������ �ҵ�ImageAdapterʵ��ͼƬ����Ϊ4
	// indic = (CircleFlowIndicator)
	// v.findViewById(R.id.third_mian_two_viewflowindic);
	// viewFlow.setFlowIndicator(indic);
	// viewFlow.setTimeSpan(4500);
	// viewFlow.setSelection(3 * 1000); // ���ó�ʼλ��
	// viewFlow.startAutoFlowTimer(); // �����Զ�����
	//
	// }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			
		case R.id.third_main_two_framelayout:
//			Intent it = new Intent(getActivity(), WebViewActivity.class);
//			it.putExtra("url", "http://m.weicaifu.com");
//			it.putExtra("title", "΢�Ƹ�");
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
