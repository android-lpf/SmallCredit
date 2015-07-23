package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.Wu;

public class JieProgressInfoAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	// private List<JieProgressInfo> list;
	private List<Wu> list;

	public JieProgressInfoAdapter(Context context, List<Wu> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context).inflate(
					R.layout.myselectorprogressinfo_item, null);
			h = new Helper();
			// h.house = (TextView) v
			// .findViewById(R.id.myselectorprogressitem_housedai);
			// h.shenhe = (TextView) v
			// .findViewById(R.id.myselectorprogressitem_firstshenhe);
			// h.data = (TextView) v
			// .findViewById(R.id.myselectorprogressitem_firstshenhedata);
			// h.price = (TextView) v
			// .findViewById(R.id.myselectorprogressitem_jieprice);
			// h.mouth = (TextView) v
			// .findViewById(R.id.myselectorprogressitem_jiebrowermouth);
			// h.miaoshu = (TextView) v
			// .findViewById(R.id.myselectorprogressitem_jiemiaoshu);
			h.info = (TextView) v
					.findViewById(R.id.myselectorprogressitem_info);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		// h.house.setText(list.get(arg0).getHouseDai());
		// String str=list.get(arg0).getType();
		// h.shenhe.setText(list.get(arg0).getFirstShen());
		// if("1".equals(str)){
		//
		// h.shenhe.setTextColor(context.getResources().getColor(R.color.actionsheet_blue));
		// }else{
		// h.shenhe.setTextColor(Color.WHITE);
		// }
		// h.data.setText(list.get(arg0).getFirstData());
		// h.price.setText(list.get(arg0).getPrice());
		// h.mouth.setText(list.get(arg0).getMouth());
		// h.miaoshu.setText(list.get(arg0).getMiaoshu());
		//
		h.info.setText(list.get(arg0).getInfo());
		return v;
	}

	class Helper {
		// TextView house, shenhe, data, price, mouth, miaoshu;
		TextView info;

	}
}
