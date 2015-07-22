package com.geo.smallcredit.adapter;

import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.CreditRecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCreditRecordAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<CreditRecord> list;

	public MyCreditRecordAdapter(Context context, List<CreditRecord> list) {
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
			v = LayoutInflater.from(context).inflate(
					R.layout.my_creditrecord_item, null);
			h = new Helper();

			h.name = (TextView) v.findViewById(R.id.my_creditrecord_item_name);
			h.lastSelector = (TextView) v
					.findViewById(R.id.my_creditrecord_item_lastselector);
			h.lastTime = (TextView) v
					.findViewById(R.id.my_creditrecord_item_selectortime);
			h.fen = (TextView) v
					.findViewById(R.id.my_creditrecord_item_selectorfen);
			h.tigong = (TextView) v
					.findViewById(R.id.my_creditrecord_item_tigong);

			v.setTag(h);
		}
		h = (Helper) v.getTag();
		
		h.name.setText(list.get(arg0).getName());
		h.lastSelector.setText(list.get(arg0).getLastSelector());
		h.lastTime.setText(list.get(arg0).getLastTime());
		h.fen.setText(list.get(arg0).getFen());
		h.tigong.setText(list.get(arg0).getTiGong());
		
		return v;
	}

	class Helper {
		TextView name, lastSelector, lastTime, fen, tigong;
	}
}
