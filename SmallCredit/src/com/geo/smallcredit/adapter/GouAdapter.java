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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.Huchi_shuoming_Activity;
import com.geo.smallcredit.activity.Laifenqi_ShuomingActivity;
import com.geo.smallcredit.activity.WebViewActivity;
import com.geo.smallcredit.vo.Travel;

public class GouAdapter extends BaseAdapter {
	private Context context;
	private List<Travel> list;
	private Helper h;

	public GouAdapter(Context context, List<Travel> list) {
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
			v = LayoutInflater.from(context).inflate(R.layout.gouwu_item, null);
			h = new Helper();
			h.title = (TextView) v.findViewById(R.id.gou_item_title);
			h.img = (ImageView) v.findViewById(R.id.gou_item_imageview);
			h.name = (TextView) v.findViewById(R.id.gou_item_name);
			h.info = (TextView) v.findViewById(R.id.gou_item_info);
			h.front = (ImageView) v.findViewById(R.id.gou_item_front);
			h.show = (ImageView) v.findViewById(R.id.gou_item_showimg);
			h.real1 = (RelativeLayout) v.findViewById(R.id.gou_item_rela1);
			h.real2 = (RelativeLayout) v.findViewById(R.id.gou_item_rela2);
			h.real3 = (RelativeLayout) v.findViewById(R.id.gou_item_rela3);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.title.setText(list.get(position).getTitle());
		h.name.setText(list.get(position).getName());
		h.info.setText(list.get(position).getInfo());
		h.front.setBackgroundResource(R.drawable.enter_arrow);
		switch (position) {
		case 0:
			h.img.setBackgroundResource(R.drawable.gouwu);
			h.show.setBackgroundResource(R.drawable.tuijian);
			h.real2.setBackgroundResource(R.drawable.lan_up_item_color_selector);
			h.real3.setBackgroundResource(R.drawable.lan_down_item_color_selector);
			h.real1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it1 = new Intent(context,
							Laifenqi_ShuomingActivity.class);
					it1.putExtra("url",
							"http:/laifenqi.com/m");
					it1.putExtra("title", "来分期");
					it1.putExtra("backText", "消费分期");
					context.startActivity(it1);
				}
			});
			break;
		}
		return v;
	}

	class Helper {
		private RelativeLayout real1, real2, real3;
		ImageView img, front, show;
		TextView title, name, info;
	}
}
