package com.geo.smallcredit.adapter;

import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.MyBillAdapter.Helper;
import com.geo.smallcredit.vo.Card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyDebitBankAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<Card> list;

	public MyDebitBankAdapter(Context context, List<Card> list) {
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
					R.layout.my_renzheng_bankinfo_jiejibank_item, null);
			h = new Helper();
			h.title = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jieji);
			h.name = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jiejibank_item_banknametxt);
			h.type = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jiejibank_item_banktype);
			h.num = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jiejibank_item_banknumtxt);
			h.number = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jiejibank_item_banknum);
			h.use = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jiejibank_item_usetxt);
			h.cardUse = (TextView) v
					.findViewById(R.id.my_renzheng_bankinfo_jiejibank_item_use);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.title.setText(list.get(arg0).getTitleType());
		h.name.setText(list.get(arg0).getBankName());
		h.type.setText(list.get(arg0).getBankType());
		h.num.setText(list.get(arg0).getBankNum());
		h.number.setText(list.get(arg0).getBankNumber());
		h.use.setText(list.get(arg0).getBankUse());
		h.cardUse.setText(list.get(arg0).getBankcardUse());
		return v;
	}

	class Helper {
		TextView title, name, type, num, number, use, cardUse;
	}
}
