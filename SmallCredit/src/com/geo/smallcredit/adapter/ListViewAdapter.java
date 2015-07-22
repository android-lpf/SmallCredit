package com.geo.smallcredit.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.geo.smallcredit.R;

public class ListViewAdapter extends BaseAdapter{
	
	private Context mContext;
	private ArrayList<String> arrayList;
	private LayoutInflater mLayoutInflater;
	public ListViewAdapter(Context context,ArrayList<String> list){
		this.mContext=context;
		this.arrayList=list;
		mLayoutInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView=mLayoutInflater.inflate(R.layout.listview_item, null);
			viewHolder.textView=(TextView) convertView.findViewById(R.id.textview);
			viewHolder.imageView=(ImageView) convertView.findViewById(R.id.imageView);
			convertView.setTag(viewHolder);
			
		}else{
			
			viewHolder=(ViewHolder) convertView.getTag();
		}
		 String content=arrayList.get(position);
		 viewHolder.textView.setText(content);
		return convertView;
	}

	static class ViewHolder{
		TextView textView;
		ImageView imageView;
	}
}
