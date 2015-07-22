package com.geo.smallcredit.fragment;

import com.geo.smallcredit.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPersonFragment extends Fragment{
	
	private View v;
	private TextView img;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {

		if (v == null) {

			v = inflater.inflate(R.layout.personinfoimg, null);
		}

		ViewGroup parent = (ViewGroup) v.getParent();

		if (parent != null) {

			parent.removeView(v);

		}
		initView();
		return v;
	}

	private void initView() {
		img=(TextView) v.findViewById(R.id.personinfoimg_shenfen);
	}
}
