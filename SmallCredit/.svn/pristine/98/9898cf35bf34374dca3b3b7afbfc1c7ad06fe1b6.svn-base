package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.PersonInformation;

public class PersonInformationAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<PersonInformation> list;

	public PersonInformationAdapter(Context context,
			List<PersonInformation> list) {
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
	public View getView(int arg0, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context).inflate(
					R.layout.person_renzheng_item, null);
			h = new Helper();
			h.img = (ImageView) v.findViewById(R.id.person_renzheng_frontbtn);
			h.name = (TextView) v.findViewById(R.id.person_renzheng_name);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.img.setImageResource(R.drawable.enter_arrow);
		h.name.setText(list.get(arg0).getName());

		return v;
	}

	class Helper {
		ImageView img;
		TextView name;
	}
}
