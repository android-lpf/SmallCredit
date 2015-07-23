package com.geo.smallcredit.adapter;

import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.Wu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyMessageAdapter extends BaseAdapter {

	private Context context;
	private Helper h;
//	private List<Message> list;
	private List<Wu> list;
	public MyMessageAdapter(Context context, List<Wu> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int arg0, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context).inflate(R.layout.my_message_item,
					null);
			h = new Helper();

//			h.result = (TextView) v
//					.findViewById(R.id.my_message_resultnotifition);
//			h.time = (TextView) v.findViewById(R.id.my_message_notifitiontime);
//			h.info = (TextView) v
//					.findViewById(R.id.my_message_resultnotification_info);
			h.info = (TextView) v.findViewById(R.id.my_message_info);
			v.setTag(h);
		}

		h = (Helper) v.getTag();
//		h.result.setText(list.get(arg0).getName());
//		h.time.setText(list.get(arg0).getTime());
		h.info.setText(list.get(arg0).getInfo());
		return v;

	}

	class Helper {
	//	TextView result, time, info;
		TextView info;
	}
}
