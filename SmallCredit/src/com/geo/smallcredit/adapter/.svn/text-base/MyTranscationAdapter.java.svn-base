package com.geo.smallcredit.adapter;

import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.Transcation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyTranscationAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<Transcation> list;

	public MyTranscationAdapter(Context context, List<Transcation> list) {
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
					R.layout.mysecurepayment_transcation_item, null);
			h = new Helper();
			h.dealType = (TextView) v
					.findViewById(R.id.mysecurepayment_transcation_item_dealtype);
			h.flow = (TextView) v
					.findViewById(R.id.mysecurepayment_transcation_item_dealflow);
			h.price = (TextView) v
					.findViewById(R.id.mysecurepayment_transcation_item_dealprice);
			h.time = (TextView) v
					.findViewById(R.id.mysecurepayment_transcation_item_dealtime);
			h.payAccount = (TextView) v
					.findViewById(R.id.mysecurepayment_transcation_item_payaccount);
			h.collectionAccount = (TextView) v
					.findViewById(R.id.mysecurepayment_transcation_item_collectionaccount);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.dealType.setText(list.get(arg0).getTradeStatus());
		h.flow.setText(list.get(arg0).getTradeType());
		h.price.setText(list.get(arg0).getTradeNumber());
		h.time.setText(list.get(arg0).getTradeTime());
		h.payAccount.setText(list.get(arg0).getPayAccount());
		h.collectionAccount.setText(list.get(arg0).getBeneficiaryAccount());

		return v;
	}

	class Helper {
		TextView dealType, flow, price, time, payAccount, collectionAccount;
	}
}
