package com.geo.smallcredit.fragment;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.activity.BeginActivity;
import com.geo.smallcredit.activity.ShowSelectFractionActivity;
import com.geo.smallcredit.activity.WebViewActivity;
import com.geo.smallcredit.adapter.SecondMainAdapter;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.utils.net.InternetURL;
import com.geo.smallcredit.vo.SecondSelector;
import com.geo.smallcredit.vo.UserScore;

public class SelectFragment extends Fragment implements OnClickListener,
		OnItemClickListener {
	// private ViewFlow viewFlow;
	// private CircleFlowIndicator indic;
	private SecondMainAdapter adapter;
	private ListView lv;
	private List<SecondSelector> list;
	private View v;
	private ImageButton img1,img2;
	private Button jiafenBtn;
	// private TextView nameTi, noScore, companyName, level, updateDate, score_;
	// private RelativeLayout showScore;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (v == null) {

			v = inflater.inflate(R.layout.second_main, null);
		}

		ViewGroup parent = (ViewGroup) v.getParent();

		if (parent != null) {

			parent.removeView(v);

		}

		initview();
		getData();
		// getDatas();
		initClick();
		// viewWork();
		adapter = new SecondMainAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		if (SharedPreferencesUtils.getString(getActivity(), "userid", null) == null) {
			ToastUtil.show(getActivity(), "����û�е�¼");
			Intent begin = new Intent(getActivity(), BeginActivity.class);
			startActivity(begin);
		}
		return v;
	}

	// private void viewWork() {
	//
	// viewFlow = (ViewFlow) v.findViewById(R.id.viewflow);
	// viewFlow.setAdapter(new Second_ImageAdapter(getActivity()));
	// viewFlow.setmSideBuffer(4); // ʵ��ͼƬ������ �ҵ�ImageAdapterʵ��ͼƬ����Ϊ4
	//
	// CircleFlowIndicator indic = (CircleFlowIndicator) v
	// .findViewById(R.id.viewflowindic);
	// viewFlow.setFlowIndicator(indic);
	// viewFlow.setTimeSpan(4500);
	// viewFlow.setSelection(3 * 1000); // ���ó�ʼλ��
	// viewFlow.startAutoFlowTimer(); // �����Զ�����
	//
	// }
	//
	// @Override
	// public void onResume() {
	// super.onResume();
	//
	// String str_Score=SharedPreferencesUtils.getString(getActivity(), "score",
	// null);
	// if ( str_Score!= null) {
	// showScore.setVisibility(View.VISIBLE);
	// score_.setText(str_Score);
	// } else {
	// showScore.setVisibility(View.GONE);
	// }
	// }

	private void initClick() {

		lv.setOnItemClickListener(this);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		jiafenBtn.setOnClickListener(this);
		
	}

	// ҳ���ʼ��
	public void initview() {
		lv = (ListView) v.findViewById(R.id.second_main_listview);
		img1 = (ImageButton) v.findViewById(R.id.second_main_img1);
		img2 = (ImageButton) v.findViewById(R.id.second_main_img2);
		jiafenBtn = (Button) v.findViewById(R.id.second_main_jiafenbtn);
	}

	private void getData() {

		list = new ArrayList<SecondSelector>();

		list.add(new SecondSelector(R.drawable.second_main_huishutiao,
				"614", R.drawable.second_main_huihengtiao, "�����ǳ��ṩ", "��������",
				"2015.07.10", "�и���"));
		list.add(new SecondSelector(R.color.red,
				"202", R.drawable.second_main_huangse, "�����ǳ��ṩ", "���ýϲ�",
				"2015.07.10", ""));
	}

	public void getDatas() {
		// �����ѯ���� ��ѯ��ǰ����
		AjaxParams params = new AjaxParams();
		params.put("mobileno", SharedPreferencesUtils.getString(getActivity(),
				"mobileno", null));
		params.put("userid",
				SharedPreferencesUtils.getString(getActivity(), "userid", null));
		params.put("imei", AppConfig.getIMEI(getActivity()));
		params.put("androidid", AppConfig.getAndroidId(getActivity()));

		FinalHttp fh = new FinalHttp();
		fh.get(InternetURL.CHECK_SCORE, params, new AjaxCallBack<String>() {

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
			}

			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);

				try {
					// �o�n===����=={"status":1,"desc":"���û�û�в�ѯ�����÷֣�","userScore":null}
					JSONObject json = new JSONObject(t.toString());
					String status = json.getString("status");
					String desc = json.getString("desc");

					JSONArray jsonList = json.getJSONArray("userScore");
					for (int i = 0; i < jsonList.length(); i++) {
						UserScore score = new UserScore();

						JSONObject json2 = jsonList.getJSONObject(i);
						score.setStatus(status);
						score.setDesc(desc);
						score.setScore(json2.getString("score"));
						score.setLevel(json2.getString("level"));
						score.setCompanyName(json2.getString("companyName"));
						// ��****�ṩ
						score.setCompanyName(json2.getString("companyName"));
						score.setUpdateDate(json2.getString("updateDate"));

						Message msg = new Message();
						msg.what = 0x005;
						msg.obj = score;
						handler.sendMessage(msg);
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});

	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0x005:
				UserScore score = (UserScore) msg.obj;

				// if (score != null || !"".equals(score)) {
				// if (Integer.parseInt(score.getStatus()) == 1) {
				// noScore.setVisibility(View.VISIBLE);
				// noScore.setText("����û�в�ѯ�����÷�");
				// } else if (Integer.parseInt(score.getStatus()) == 0) {
				//
				// showScore.setVisibility(View.VISIBLE);
				// companyName.setText(score.getCompanyName() + "���÷���");
				// // ��***��˾�ṩ
				// nameTi.setText("��" + score.getCompanyName() + "�ṩ");
				// level.setText("���õȼ�:" + score.getLevel());
				// updateDate.setText(score.getUpdateDate());
				// score_.setText(score.getScore());
				// }
				// }
				break;
			}
		};
	};

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.second_main_img1:

			break;
			
		case R.id.second_main_img2:
			
			break;
			
		case R.id.second_main_jiafenbtn:
			
			break;
		}
	}
}