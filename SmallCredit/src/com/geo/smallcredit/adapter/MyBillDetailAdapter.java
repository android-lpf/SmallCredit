package com.geo.smallcredit.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.vo.Bill;

public class MyBillDetailAdapter extends BaseAdapter{

		private Context context;
		private Helper h;
		private List<Bill> list;

		public MyBillDetailAdapter(Context context, List<Bill> list) {
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
						.inflate(R.layout.mybill_item_paydetail_item, null);
				h = new Helper();
				h.travel = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_travel);
				h.state = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_travelstate);
				h.data = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_traveldata);
				h.price = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_travelprice);
				h.payMode = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_travemode);
				h.payPeriods = (TextView) v
						.findViewById(R.id.mybill_item_paydetail_item_traveperiods);
				h.overdueDays = (TextView) v
						.findViewById(R.id.mybill_item_paydetail_item_traveOverduedays);
				h.dedit = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_travededit);
				h.interest = (TextView) v.findViewById(R.id.mybill_item_paydetail_item_traveinterest);
				v.setTag(h);
			}
			h = (Helper) v.getTag();
			h.travel.setText(list.get(arg0).getHouse());
			h.state.setText(list.get(arg0).getState());
			h.data.setText(list.get(arg0).getData());
			h.price.setText(list.get(arg0).getPrice());
			h.payMode.setText(list.get(arg0).getPayMode());
			h.payPeriods.setText(list.get(arg0).getPayPeriods());
			h.overdueDays.setText(list.get(arg0).getOverdueDays());
			h.dedit.setText(list.get(arg0).getDedit());
			h.interest.setText(list.get(arg0).getInterest());
			return v;
		}

		class Helper {
			TextView travel, state, data, price, payMode, payPeriods, overdueDays,
					dedit, interest;
		}

}
