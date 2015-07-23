package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.Live;

public class ZhuSuAdapter extends BaseAdapter {
	
	private Context context;
	private List<Live> list;
	private Helper h;

	public ZhuSuAdapter(Context context, List<Live> list) {
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
		return 0;
	}

	@Override
	public View getView(int position, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context).inflate(R.layout.zhusu_item, null);
			h = new Helper();
			h.name = (TextView) v.findViewById(R.id.zhusu_item_qidai);
			h.real1 = (LinearLayout) v.findViewById(R.id.zhusu_item_real1);
			h.real2 = (RelativeLayout) v.findViewById(R.id.zhusu_item_real2);
			h.real3 = (RelativeLayout) v.findViewById(R.id.zhusu_item_real3);
			v.setTag(h);
			// h.title = (TextView) v.findViewById(R.id.tracel_item_title);
			// h.img = (ImageView) v.findViewById(R.id.travel_item_imageview);
			// h.name = (TextView) v.findViewById(R.id.travel_item_name);
			// h.info = (TextView) v.findViewById(R.id.travel_item_info);
			// h.front = (ImageView) v.findViewById(R.id.travel_item_front);
			// h.show = (ImageView) v.findViewById(R.id.travel_item_showimg);
			// h.real1 = (RelativeLayout)
			// v.findViewById(R.id.tracel_item_rela1);
			// h.real2 = (RelativeLayout)
			// v.findViewById(R.id.tracel_item_rela2);
			// h.real3 = (RelativeLayout)
			// v.findViewById(R.id.tracel_item_rela3);
			// v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.name.setText(list.get(position).getName());
		switch (position) {
		case 0:
			h.real2.setBackgroundResource(R.drawable.lan_up_item_color_selector);
			h.real3.setBackgroundResource(R.drawable.lan_down_item_color_selector);
			h.real1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					
					ToastUtil.show(context, "¾´ÇëÆÚ´ý¡£¡£¡£");
					
				}
			});
			break;
		}
		// h.title.setText(list.get(position).getTitle());
		// h.name.setText(list.get(position).getName());
		// h.info.setText(list.get(position).getInfo());
		// h.front.setBackgroundResource(R.drawable.enter_arrow);
		// switch (position) {
		// case 0:
		// h.img.setBackgroundResource(R.drawable.zhusu);
		// h.show.setBackgroundResource(R.drawable.tuijian);
		// h.real2.setBackgroundResource(R.color.blue_up);
		// h.real3.setBackgroundResource(R.color.blue_down);
		// h.real1.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Intent it1 = new Intent(context,
		// WebViewActivity.class);
		// it1.putExtra("url",
		// "http://www.uubpay.com/index.php?m=content&c=index&a=lists&catid=9");
		// it1.putExtra("title", "¾´ÇëÆÚ´ý¡£¡£¡£");
		// context.startActivity(it1);
		// }
		// });
		// break;
		//
		// case 1:
		//
		// break;
		//
		// }
		return v;
	}

	class Helper {
		// private RelativeLayout real1, real2, real3;
		// ImageView img, front, show;
		// TextView title, name, info;
		private RelativeLayout real2, real3;
		private LinearLayout real1;
		private TextView name;
	}

}
