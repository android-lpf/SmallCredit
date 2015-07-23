package com.geo.smallcredit.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.adapter.PersonInformationAdapter;
import com.geo.smallcredit.vo.PersonInformation;
import com.geo.smallcredit.vo.RoundProgressBar;

public class PersonActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private Button imgBack;
	private ListView lv;
	private List<PersonInformation> list;
	private PersonInformationAdapter adapter;
	private RoundProgressBar mRoundProgressBar;
	private int progress = 0;

	@Override
	public void onStart() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress <= 69) {

					progress += 1;// 这里是加1的 , 从服务器获取的时候因该减掉1

					System.out.println(progress);

					mRoundProgressBar.setProgress(progress);

					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

		super.onStart();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(PersonActivity.this);
		setContentView(R.layout.person_renzheng);
		initView();
		initClick();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress <= 69) {

					progress += 1;// 这里是加1的 , 从服务器获取的时候因该减掉1

					System.out.println(progress);

					mRoundProgressBar.setProgress(progress);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		getData();
		adapter = new PersonInformationAdapter(PersonActivity.this, list);
		lv.setAdapter(adapter);
	}

	private void getData() {
		list = new ArrayList<PersonInformation>();
		list.add(new PersonInformation("身份信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("联系人信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("工作/收入信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("房产信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("银行卡信息", R.drawable.enter_arrow));
		list.add(new PersonInformation("资料上传", R.drawable.enter_arrow));

	}

	private void initClick() {
		imgBack.setOnClickListener(this);
		lv.setOnItemClickListener(this);
	}

	private void initView() {
		imgBack = (Button) findViewById(R.id.person_renzheng_backbtn);
		lv = (ListView) findViewById(R.id.person_renzheng_listview);
		mRoundProgressBar = (RoundProgressBar) findViewById(R.id.person_roundProgressBar);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		switch (position) {
		case 0:
			Intent information = new Intent(PersonActivity.this,
					ShenFenActivity.class);
			startActivity(information);
			break;

		case 1:
			Intent telphone = new Intent(PersonActivity.this,
					LianxiActivity.class);
			startActivity(telphone);
			break;

		case 2:

			Intent work = new Intent(PersonActivity.this, WorkActivity.class);
			startActivity(work);
			break;

		case 3:
			Intent finol = new Intent(PersonActivity.this, House_Activity.class);
			startActivity(finol);
			break;

		case 4:
			Intent bank = new Intent(PersonActivity.this,
					MyTificationBankActivity.class);
			startActivity(bank);
			break;

		case 5:
			Intent upload = new Intent(PersonActivity.this,
					MeansUploadActivity.class);
			startActivity(upload);

			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.person_renzheng_backbtn:
			finish();
			break;
		}
	}
}
