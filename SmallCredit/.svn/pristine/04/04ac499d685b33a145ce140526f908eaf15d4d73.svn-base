package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.MyBillPayDetailActivity;
import com.geo.smallcredit.vo.Bill;

public class MyBillAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<Bill> list;

	public MyBillAdapter(Context context, List<Bill> list) {
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
			v = LayoutInflater.from(context)
					.inflate(R.layout.mybill_item, null);
			h = new Helper();
			h.house = (TextView) v.findViewById(R.id.mybill_item_house);
			h.state = (TextView) v.findViewById(R.id.mybill_item_state);
			h.data = (TextView) v.findViewById(R.id.mybill_item_paydata);
			h.price = (TextView) v.findViewById(R.id.mybill_item_payprice);
			h.payMode = (TextView) v.findViewById(R.id.mybill_item_paymode);
			h.payPeriods = (TextView) v
					.findViewById(R.id.mybill_item_payperiods);
			h.overdueDays = (TextView) v
					.findViewById(R.id.mybill_item_Overduedays);
			h.dedit = (TextView) v.findViewById(R.id.mybill_item_dedit);
			h.interest = (TextView) v.findViewById(R.id.mybill_item_interest);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.house.setText(list.get(arg0).getHouse());
		h.state.setText(list.get(arg0).getState());
		h.data.setText(list.get(arg0).getData());
		h.price.setText(list.get(arg0).getPrice());
		h.payMode.setText(list.get(arg0).getPayMode());
		h.payPeriods.setText(list.get(arg0).getPayPeriods());
		h.overdueDays.setText(list.get(arg0).getOverdueDays());
		h.dedit.setText(list.get(arg0).getDedit());
		h.interest.setText(list.get(arg0).getInterest());
		h.house.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(context, MyBillPayDetailActivity.class);
				context.startActivity(it);
			}
		});
		return v;
	}

	class Helper {
		TextView house, state, data, price, payMode, payPeriods, overdueDays,
				dedit, interest;
	}
}
