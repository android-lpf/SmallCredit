package com.geo.smallcredit.adapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.MyMouthPaymentPlanActivity;
import com.geo.smallcredit.vo.Huankuan;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyPaymentPlanAdapter extends BaseAdapter {
	private Context context;
	private Helper h;
	private List<Huankuan> list;

	public MyPaymentPlanAdapter(Context context, List<Huankuan> list) {
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
	public View getView(final int arg0, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context).inflate(
					R.layout.mysecurepayment_plan_item, null);
			h = new Helper();

			h.use = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepay);
			h.payData = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepaydatatxt);
			h.data = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepaydata);
			h.cardNum = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepay_cardnum);
			h.bankName = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepay_bankname);
			h.price = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepay_price);
			h.actulPayData = (TextView) v
					.findViewById(R.id.mypayment_plan_item_housepay_data);

			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.use.setText(list.get(arg0).getPlanName());
		h.data.setText(list.get(arg0).getSuggestRepaymentDate());
		h.cardNum.setText(list.get(arg0).getPlanBankcard());
		h.bankName.setText(list.get(arg0).getPlanBank());
		h.price.setText(list.get(arg0).getPlanAmount());
		h.actulPayData.setText(list.get(arg0).getPlanRepaymentDate());
		h.use.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent plan = new Intent(context,
						MyMouthPaymentPlanActivity.class);
				context.startActivity(plan);
			}
		});
		return v;
	}
	class Helper {
		TextView use, payData, data, cardNum, bankName, price, actulPayData;
	}
}
