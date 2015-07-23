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
import com.geo.smallcredit.vo.Bank;

public class MyBankTypeAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<Bank> list;

	public MyBankTypeAdapter(Context context, List<Bank> list) {
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
			v = LayoutInflater.from(context).inflate(R.layout.my_mybanktype_item,
					null);
			h = new Helper();
			h.img = (ImageView) v.findViewById(R.id.mybanktype_img);
			h.name = (TextView) v.findViewById(R.id.mybanktype_name);
			h.type = (TextView) v.findViewById(R.id.mybanktype_type);
			h.num1 = (TextView) v.findViewById(R.id.mybanktype_numberone);
			h.num2 = (TextView) v.findViewById(R.id.mybanktype_numbertwo);
			h.num3 = (TextView) v.findViewById(R.id.mybanktype_numberthree);
			h.num4 = (TextView) v.findViewById(R.id.mybanktype_numberfour);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.img.setImageResource(R.drawable.zhaoshangbank);
		h.name.setText(list.get(arg0).getName());
		h.type.setText(list.get(arg0).getType());
		h.num1.setText(list.get(arg0).getNum1());
		h.num2.setText(list.get(arg0).getNum2());
		h.num3.setText(list.get(arg0).getNum3());
		h.num4.setText(list.get(arg0).getNum4());

		return v;
	}

	class Helper {
		ImageView img;
		TextView name, type, num1, num2, num3, num4;
	}
}
