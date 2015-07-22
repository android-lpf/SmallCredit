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
			h.mLine = (LinearLayout) v
					.findViewById(R.id.third_main_two_item_Line);
			h.real1 = (RelativeLayout) v
					.findViewById(R.id.third_main_two_item_real);
			h.real2 = (RelativeLayout) v
					.findViewById(R.id.third_main_two_item_real2);
			h.img = (ImageView) v.findViewById(R.id.third_mian_two_imageView);
			h.name = (TextView) v.findViewById(R.id.third_main_two_item_name);
			h.info = (TextView) v.findViewById(R.id.third_mian_two_item_info);
			h.front = (ImageView) v
					.findViewById(R.id.third_mian_two_item_front);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.name.setText(list.get(position).getName());
		h.info.setText(list.get(position).getInfo());
		h.front.setBackgroundResource(R.drawable.enter_arrow);
		switch (position) {
		case 0:
			h.img.setBackgroundResource(R.drawable.third_le);
			h.real1.setBackgroundResource(R.drawable.lan_down_item_color_selector);
			h.real2.setBackgroundResource(R.drawable.lan_up_item_color_selector);
			h.mLine.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (SharedPreferencesUtils.getString(context, "userid",
							null) == null) {
						Intent intent = new Intent(context, BeginActivity.class);
						context.startActivity(intent);
					} else {
						Intent intent = new Intent(context,
								XiaofeiActivity.class);
						intent.putExtra("backText", "发现");
						context.startActivity(intent);

					}
				}
			});
			break;

		case 1:
			h.img.setBackgroundResource(R.drawable.third_xin);
			h.real1.setBackgroundResource(R.drawable.lan_down_item_color_selector);
			h.real2.setBackgroundResource(R.drawable.lan_up_item_color_selector);
			h.mLine.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					
					if (SharedPreferencesUtils.getString(context, "userid",
							null) == null) {
						Intent intent = new Intent(context, BeginActivity.class);
						context.startActivity(intent);
					} else {
						Intent intent = new Intent(context, JieActivity.class);
						intent.putExtra("backText", "发现");
						context.startActivity(intent);
					}
				}
			});
			break;

		case 2:
			h.img.setBackgroundResource(R.drawable.third_bang);
			h.real1.setBackgroundResource(R.drawable.lan_down_item_color_selector);
			h.real2.setBackgroundResource(R.drawable.lan_up_item_color_selector);
			h.mLine.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					// Intent intent = new Intent(context, DaiActivity.class);
					// context.startActivity(intent);
					ToastUtil.show(context, "敬请期待。。。");

				}
			});
			break;

		case 3:
			h.img.setBackgroundResource(R.drawable.third_wen);
			h.real1.setBackgroundResource(R.drawable.cheng_up_item_selector);
			h.real2.setBackgroundResource(R.drawable.cheng_down_item_selector);
			h.mLine.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ToastUtil.show(context, "敬请期待。。。");
				}
			});
			break;
		}
		return v;
	}

	class Helper {
		LinearLayout mLine;
		RelativeLayout real1, real2;
		ImageView img, front;
		TextView name, info;
	}
}
