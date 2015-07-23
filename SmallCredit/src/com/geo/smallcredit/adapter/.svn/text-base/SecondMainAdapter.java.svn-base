package com.geo.smallcredit.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.BeginActivity;
import com.geo.smallcredit.activity.MainShowfenInfoActivity;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.SecondSelector;

public class SecondMainAdapter extends BaseAdapter {
	private Context context;
	private List<SecondSelector> list;
	private Helper h;

	public SecondMainAdapter(Context context, List<SecondSelector> list) {
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
	public View getView(final int position, View v, ViewGroup arg2) {
		if (v == null) {
			v = LayoutInflater.from(context)
					.inflate(R.layout.second_item, null);
			h = new Helper();
			h.mLine = (LinearLayout) v.findViewById(R.id.second_item_line);
			h.img1 = (ImageView) v.findViewById(R.id.second_item_img);
			h.score = (TextView) v.findViewById(R.id.second_item_score);
			h.img2=(ImageView) v.findViewById(R.id.second_item_showcaise);
			h.tigong = (TextView) v.findViewById(R.id.second_item_tigong);
			h.gride = (TextView) v.findViewById(R.id.second_item_gride);
			h.time = (TextView) v.findViewById(R.id.second_item_data);
			h.state = (TextView) v.findViewById(R.id.second_item_state);
			v.setTag(h);
		}
		h = (Helper) v.getTag();
		h.score.setText(list.get(position).getScore());
		h.state.setText(list.get(position).getState());
		h.tigong.setText(list.get(position).getTigong());
		h.gride.setText(list.get(position).getGrade());
		h.time.setText(list.get(position).getTime());
		switch (position) {
		case 0:
			h.mLine.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
//					if (SharedPreferencesUtils.getString(context, "userid",
//							null) == null) {
//						Intent intent = new Intent(context, BeginActivity.class);
//						context.startActivity(intent);
//
//					} else {

						Intent intent = new Intent(context,
								MainShowfenInfoActivity.class);
						intent.putExtra("backText", "查信用");
						context.startActivity(intent);
						// ((Activity) context).overridePendingTransition(
						// R.anim.rotate, R.anim.rotate_out);
						((Activity) context).overridePendingTransition(
								R.anim.hyperspace_in, R.anim.hyperspace_out);

//					}
				}

			});

			break;

		case 1:
			h.mLine.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// if (SharedPreferencesUtils.getString(context, "userid",
					// null) == null) {
					// Intent intent = new Intent(context, BeginActivity.class);
					// context.startActivity(intent);
					// } else {
					//
					// Intent intent = new Intent(context,
					// ShowSelectFractionActivity.class);
					// context.startActivity(intent);
					// }
					ToastUtil.show(context, "敬请期待。。。");
				}
			});
			break;
		case 2:
			h.mLine.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {

					// if (SharedPreferencesUtils.getString(context, "userid",
					// null) == null) {
					// Intent intent = new Intent(context, BeginActivity.class);
					// context.startActivity(intent);
					// } else {
					//
					// Intent intent = new Intent(context,
					// ShowSelectFractionActivity.class);
					// context.startActivity(intent);
					// }
					ToastUtil.show(context, "敬请期待。。。");
				}
			});
		}
		return v;
	}

	class Helper {
		LinearLayout mLine;
		ImageView img1, img2;
		TextView score, tigong, gride, time, state;
	}
}
