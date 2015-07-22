package com.geo.smallcredit.adapter;

import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.HomeBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HomeFragmentAdapter extends BaseAdapter {

	private Context context;
	
	private List<HomeBean> list;
	
	public HomeFragmentAdapter(Context context, List<HomeBean> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		if(list!=null){
			
			return list.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
 ViewHolder v;
	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		
		if(view ==null){
			v=new ViewHolder();
			view =LayoutInflater.from(context).inflate(R.layout.homefragment_item, null);
			v.tv1=(TextView) view.findViewById(R.id.home_fragment_item_tv1);
			
			v.tv2=(TextView) view.findViewById(R.id.home_fragment_item_tv2);
			view.setTag(v);
		}
		v=(ViewHolder) view.getTag();
		
		v.tv1.setText(list.get(arg0).getTitle());
		v.tv2.setText(list.get(arg0).getDesc());
		
		return view;
	}
class ViewHolder{
	TextView tv1,tv2;
	
}
}
