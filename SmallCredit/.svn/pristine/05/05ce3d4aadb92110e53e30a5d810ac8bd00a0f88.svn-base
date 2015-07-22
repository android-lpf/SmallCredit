package com.geo.smallcredit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;

public class DaiActivity extends FragmentActivity implements OnClickListener {

	private Button imgBtn;
	private ImageView btn1,btn2, btn3, btn4;
	private RelativeLayout rl1, rl2, rl3, rl4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(DaiActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_daihuan);
		initView();
		initClick();
	}

	private void initClick() {

		btn1.setOnClickListener(this);

		btn2.setOnClickListener(this);

		btn3.setOnClickListener(this);

		btn4.setOnClickListener(this);

		imgBtn.setOnClickListener(this);

		rl1.setOnClickListener(this);

		rl2.setOnClickListener(this);

		rl3.setOnClickListener(this);

		rl4.setOnClickListener(this);
	}

	private void initView() {

		btn1 = (ImageView) findViewById(R.id.third_daihuan_houseimg);

		btn2 = (ImageView) findViewById(R.id.third_daihuan_carimg);

		btn3 = (ImageView) findViewById(R.id.third_daihuan_xinbaoimg);

		btn4 = (ImageView) findViewById(R.id.third_daihuan_creditimg);

		imgBtn = (Button) findViewById(R.id.third_daihuan_imgback);

		rl1 = (RelativeLayout) findViewById(R.id.third_daihuan_rl1);

		rl2 = (RelativeLayout) findViewById(R.id.third_daihuan_rl2);

		rl3 = (RelativeLayout) findViewById(R.id.third_daihuan_rl3);

		rl4 = (RelativeLayout) findViewById(R.id.third_daihuan_rl4);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.third_daihuan_houseimg:

			Intent intent = new Intent(DaiActivity.this,
					HouseCreditDetailsActivity.class);

			startActivity(intent);

			break;

		case R.id.third_daihuan_carimg:
			Intent car = new Intent(DaiActivity.this,
					CarCreditDetailsActivity.class);

			startActivity(car);

			break;
		case R.id.third_daihuan_xinbaoimg:
			Intent xingbao1 = new Intent(DaiActivity.this,
					XingBaoActivity.class);

			startActivity(xingbao1);
			
			break;

		case R.id.third_daihuan_creditimg:

			break;
		case R.id.third_daihuan_imgback:

			finish();
			break;

		case R.id.third_daihuan_rl1:

			Intent intent1 = new Intent(DaiActivity.this,
					HouseCreditDetailsActivity.class);

			startActivity(intent1);

			break;

		case R.id.third_daihuan_rl2:
			Intent car1 = new Intent(DaiActivity.this,
					CarCreditDetailsActivity.class);

			startActivity(car1);

			break;

		case R.id.third_daihuan_rl3:
			Intent xingbao = new Intent(DaiActivity.this,
					XingBaoActivity.class);

			startActivity(xingbao);
			break;

		case R.id.third_daihuan_rl4:

			break;
		}
	}

}
