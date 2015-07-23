package com.geo.smallcredit.fragment;

import com.geo.smallcredit.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ShowYibiaoFragment extends Fragment {

	private View v;
	private ImageView img;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (v == null) {

			v = inflater.inflate(R.layout.yibiaopan, null);
		}

		ViewGroup parent = (ViewGroup) v.getParent();

		if (parent != null) {

			parent.removeView(v);

		}
		initView();
		return v;
	}

	private void initView() {
		
		img = (ImageView) v.findViewById(R.id.yibiaopan_img);
	}
}
