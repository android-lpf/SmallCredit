package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.BeginActivity;
import com.geo.smallcredit.activity.JieActivity;
import com.geo.smallcredit.activity.XiaofeiActivity;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.ThirdMain;

public class ThridAdapter extends BaseAdapter {

	private Context context;
	private Helper h;
	private List<ThirdMain> list;

	public ThridAdapter(Context context, List<ThirdMain> list) {
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
	public View getView(int position, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context).inflate(
					R.layout.third_main_two_item, null);
			h = new Helper();
			h.img = (ImageView) v.findViewById(R.id.third_mian_two_imageView);
			h.name = (TextView) v.findViewById(R.id.third_main_two_item_name);
			h.info = (TextView) v.findViewById(R.id.third_mian_two_item_info);
			h.info2 = (TextView) v.findViewById(R.id.third_mian_two_item_info2);
			h.front = (ImageView) v
					.findViewById(R.id.third_mian_two_item_front);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.img.setBackgroundResource(R.drawable.faxian_pingan);
		h.name.setText(list.get(position).getName());
		h.info.setText(list.get(position).getInfo());
		h.info2.setText(list.get(position).getInformation());
		h.front.setBackgroundResource(R.drawable.next);
		return v;
	}

	class Helper {
		ImageView img, front;
		TextView name, info,info2;
	}
}
