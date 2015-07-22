package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.adapter.JieProgressInfoAdapter.Helper;
import com.geo.smallcredit.vo.BankManger;
import com.geo.smallcredit.vo.Wu;

public class Mysecurepayment_AddbankAdapter extends BaseAdapter {

	private Context context;
	private Helper h;
//	private List<BankManger> list;
	private List<Wu> list;

	public Mysecurepayment_AddbankAdapter(Context context, List<Wu> list) {
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
					R.layout.mysecurepayment_addbank_item, null);
			h = new Helper();
//			h.bankMangerType = (TextView) v
//					.findViewById(R.id.mysecurepaayment_addbankitem_wuyou);
//			h.bankName = (TextView) v
//					.findViewById(R.id.mysecurepaayment_addbankitem_bankname);
//			h.bankType = (TextView) v
//					.findViewById(R.id.mysecurepaayment_addbankitem_banktype);
//			h.bankNum = (TextView) v
//					.findViewById(R.id.mysecurepaayment_addbankitem_banknum);
			h.info = (TextView) v
					.findViewById(R.id.mysecurepaayment_addbankitem_wu2);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
//		h.bankMangerType.setText(list.get(arg0).getBankmangertype());
//		h.bankName.setText(list.get(arg0).getBankName());
//		h.bankType.setText(list.get(arg0).getBankType());
//		h.bankNum.setText("**** **** **** **"+list.get(arg0).getBankNum().substring(12, 16));
		h.info.setText(list.get(arg0).getInfo());
		return v;
	}

	class Helper {

//		TextView bankMangerType, bankName, bankType, bankNum;
		TextView info;

	}
}
