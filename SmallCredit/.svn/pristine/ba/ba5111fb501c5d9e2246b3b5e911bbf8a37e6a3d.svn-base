package com.geo.smallcredit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.geo.smallcredit.R;

public class TravelItemActivity_ImageAdapter extends BaseAdapter{

	private Context mContext;
	private LayoutInflater mInflater;
	private static final int[] ids = {R.drawable.lv_title1, R.drawable.lv_title2, R.drawable.lv_title3};

	public TravelItemActivity_ImageAdapter(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;   //杩斿洖寰堝ぇ鐨勫�浣垮緱getView涓殑position涓嶆柇澧炲ぇ鏉ュ疄鐜板惊鐜�	}
	}
	@Override
	public Object getItem(int position) { 
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.image_item, null);
		}
		((ImageView) convertView.findViewById(R.id.imgView)).setImageResource(ids[position%ids.length]);
//		convertView.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(mContext,CarouselActivity.class);
//				Bundle bundle = new Bundle();
//				bundle.putInt("image_id", ids[position%ids.length]);
//				intent.putExtras(bundle);
//				mContext.startActivity(intent);
//			}
//		});
		return convertView;
	}
}
