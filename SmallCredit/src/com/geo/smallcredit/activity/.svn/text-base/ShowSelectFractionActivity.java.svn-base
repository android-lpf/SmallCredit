package com.geo.smallcredit.activity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geo.smallcredit.R;
import com.geo.smallcredit.MainApplication.MainApplication;
import com.geo.smallcredit.util.AppConfig;
import com.geo.smallcredit.util.SharedPreferencesUtils;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.util.myDialog;
import com.geo.smallcredit.utils.net.InternetURL;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

public class ShowSelectFractionActivity extends Activity implements
		OnClickListener {
	final UMSocialService mController = UMServiceFactory
			.getUMSocialService("com.umeng.share");
	private TextView companyname, second_tigong, second_payfen,
			second_payfen_state, second_payfen_dengji, second_payfen_time,
			second_payfen_updataTime;
	private Intent intent;
	private String str_username, str_id_number, str_phone, str_info, str_name;
	private Button back;
	private RelativeLayout rl, rl2;
	private ProgressBar myBar;
	private Handler myHandler;
	protected static final int GUI_STOP = 0x1110;
	protected static final int GUI_THREADING = 0x122;
	private int counter = 0;
	private ImageView img, sharebtn;
	private Dialog mDialog;
	private TextView backtxt;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			if (msg.what == 0x111) {

				String str = (String) msg.obj;// 分数

				second_payfen.setText(str);

				SharedPreferencesUtils.saveString(
						ShowSelectFractionActivity.this, "score", str);

			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainApplication.getInstance().addActivity(
				ShowSelectFractionActivity.this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_payfen);
		initview();
		intent = getIntent();
		str_username = intent.getStringExtra("str_username");

		str_id_number = intent.getStringExtra("str_id_number");

		str_phone = intent.getStringExtra("str_phone");
		
		backtxt.setText(intent.getStringExtra("backText"));

		// str_info=intent.getStringExtra("str_info");
		// second_tigong.setText(str_info);
		// str_name=intent.getStringExtra("str_name");
		// second_payfen.setText(str_name);
		// SelectFration(str_username, str_id_number);
		SelectFration("", "");

		onclick();
		myBar.setMax(100);
		myBar.setProgress(0);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					try {
						counter = (i + 1) * 20;
						Thread.sleep(1000);
						if (i == 4) {
							Message msg = new Message();
							msg.what = GUI_STOP;
							ShowSelectFractionActivity.this.myHandler
									.sendMessage(msg);
							break;
						} else {
							Message msg = new Message();
							msg.what = GUI_THREADING;
							ShowSelectFractionActivity.this.myHandler
									.sendMessage(msg);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void initview() {
		addWeiXin();
		setShareContent();
		back = (Button) findViewById(R.id.second_payfen_back);
		companyname = (TextView) findViewById(R.id.second_shenfen_name);
		second_payfen = (TextView) findViewById(R.id.second_payfen_showfen);
		second_tigong = (TextView) findViewById(R.id.second_tigong);
		second_payfen = (TextView) findViewById(R.id.second_payfen_showfen);
		second_payfen_state = (TextView) findViewById(R.id.second_payfen_state);
		second_payfen_dengji = (TextView) findViewById(R.id.second_payfen_dengji);
		second_payfen_time = (TextView) findViewById(R.id.second_payfen_time);
		second_payfen_updataTime = (TextView) findViewById(R.id.second_payfen_updataTime);
		rl = (RelativeLayout) findViewById(R.id.second_payfen_rl1);
		rl2 = (RelativeLayout) findViewById(R.id.second_payfen_rl2);
		myBar = (ProgressBar) findViewById(R.id.second_payfen_progress);
		img = (ImageView) findViewById(R.id.second_shenfen_img2);
		sharebtn = (ImageView) findViewById(R.id.second_payfen_share);
		backtxt = (TextView) findViewById(R.id.second_payfen_backtext);
	}

	public void onclick() {

		rl.setOnClickListener(this);
		rl2.setOnClickListener(this);
		back.setOnClickListener(this);
		sharebtn.setOnClickListener(this);
		img.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.second_payfen_back:
			this.finish();
			break;
		case R.id.second_shenfen_img2:
			showAllSubject();
			break;
		case R.id.second_payfen_rl1:
			// 跳转到fragment
			if (SharedPreferencesUtils.getString(
					ShowSelectFractionActivity.this, "userid", null) == null) {
				Intent intent = new Intent(ShowSelectFractionActivity.this,
						BeginActivity.class);
				startActivity(intent);
			} else {
				Intent it = new Intent(ShowSelectFractionActivity.this,
						MainActivity.class);
				it.putExtra("tab3", 0);
				startActivity(it);
			}
			break;

		case R.id.second_payfen_rl2:

			ToastUtil.show(ShowSelectFractionActivity.this, "敬请期待...");

			break;
		case R.id.second_payfen_share:
			mController.getConfig().setPlatforms(SHARE_MEDIA.WEIXIN,
					SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
					SHARE_MEDIA.EMAIL, SHARE_MEDIA.SINA, SHARE_MEDIA.QZONE,
					SHARE_MEDIA.FACEBOOK, SHARE_MEDIA.SMS, SHARE_MEDIA.RENREN,
					SHARE_MEDIA.FACEBOOK);
			mController.openShare(ShowSelectFractionActivity.this, false);
			break;
		}
	}

	/***
	 * 通过网络查询后台分数
	 * 
	 * @author
	 * 
	 */
	public void SelectFration(String username, String id_number) {

		AjaxParams params = new AjaxParams();

		params.put("username", "");
		params.put("id_number", "");
		params.put("mobile", SharedPreferencesUtils.getString(
				ShowSelectFractionActivity.this, "mobile", null));
		params.put("imei", AppConfig.getIMEI(ShowSelectFractionActivity.this));

		FinalHttp fh = new FinalHttp();

		fh.post(InternetURL.SELECT_FRATION, params,

		new AjaxCallBack<String>() {
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				Toast.makeText(ShowSelectFractionActivity.this, "查询失败",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);
				try {

					JSONArray ja = new JSONArray(t.toString());

					for (int i = 0; i < ja.length(); i++) {

						JSONObject jo = ja.getJSONObject(i);

						String str = jo.getString("score");

						Message msg = new Message();

						msg.what = 0x111;
						msg.obj = str;
						Log.i("mytag", "分数====" + str);
						handler.sendMessage(msg);
						ToastUtil.show(ShowSelectFractionActivity.this, "查询成功");
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addWeiXin() {
		String appID = "wxa2f5a98559f73d10";
		String appSecret = "78dfe7abf0c8b0478e7851c5d7a0776f";
		// 添加微信平台
		UMWXHandler wxHandler = new UMWXHandler(
				ShowSelectFractionActivity.this, appID, appSecret);
		wxHandler.addToSocialSDK();
		// 添加微信朋友圈
		UMWXHandler wxCircleHandler = new UMWXHandler(
				ShowSelectFractionActivity.this, appID, appSecret);
		wxCircleHandler.setToCircle(true);
		wxCircleHandler.addToSocialSDK();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		/** 使用SSO授权必须添加如下代码 */
		UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(
				requestCode);
		if (ssoHandler != null) {
			ssoHandler.authorizeCallBack(requestCode, resultCode, data);
		}
	}

	/**
	 * 根据不同的平台设置不同的分享内容</br>
	 */
	private void setShareContent() {

		// 配置SSO
		mController.getConfig().setSsoHandler(new SinaSsoHandler());
		QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(
				ShowSelectFractionActivity.this, "1104254566",
				"HfOJxqLsT0mvzqTS");
		qZoneSsoHandler.addToSocialSDK();

		UMImage urlImage = new UMImage(
				ShowSelectFractionActivity.this,
				"http://c.hiphotos.baidu.com/image/pic/item/9213b07eca8065383e4aa43c96dda144ad348278.jpg");
		UMusic uMusic = new UMusic(
				"http://data1.5sing.kgimg.com/T1iEVbBXWT1R47IVrK.mp3");
		uMusic.setAuthor("小信用");
		uMusic.setTitle("小苹果");
		uMusic.setThumb("http://c.hiphotos.baidu.com/image/pic/item/9213b07eca8065383e4aa43c96dda144ad348278.jpg");

		// 微信好友分享测试
		WeiXinShareContent weixinContent = new WeiXinShareContent();
		weixinContent.setShareContent("Android微信好友分享测试");
		weixinContent.setTitle("小信用-微信");
		weixinContent.setTargetUrl("http://www.baidu.com");
		weixinContent.setShareMedia(urlImage);
		mController.setShareMedia(weixinContent);

		// 设置朋友圈分享的内容
		CircleShareContent circleMedia = new CircleShareContent();
		circleMedia.setShareContent("测试 测试 测试 测试");
		circleMedia.setTitle("Android微信朋友圈分享测试");
		circleMedia.setShareMedia(urlImage);
		circleMedia.setTargetUrl("http://www.baidu.com");
		mController.setShareMedia(circleMedia);

		// 设置QQ空间分享内容
		QZoneShareContent qzone = new QZoneShareContent();
		qzone.setTitle("Android  QQ空间分享测试");
		qzone.setShareContent("Android  QQ空间分享测试、测试、测试、测试、测试、、、");
		qzone.setShareImage(urlImage);
		qzone.setShareMedia(uMusic);
		mController.setShareMedia(qzone);

		// 设置QQ好友分享内容
		QQShareContent qqShareContent = new QQShareContent();
		qqShareContent.setTitle("Android QQ好友分享测试");
		qqShareContent.setShareImage(urlImage);
		qqShareContent.setShareMedia(uMusic);
		qqShareContent.setShareContent("Android QQ好友分享测试  小呀小苹果。。。  ");
		mController.setShareMedia(qqShareContent);

		// 设置新浪微博分享
		SinaShareContent sinaContent = new SinaShareContent();
		sinaContent.setShareContent("Android 新浪微博分享  测试、测试、测试、测试、测试、测试、");
		sinaContent.setTitle("Android 新浪微博分享测试");
		sinaContent.setShareImage(urlImage);
		mController.setShareMedia(sinaContent);

	}

	public void showAllSubject() {
		// View
		// vie=LayoutInflater.from(MySecurePaymentActivity.this).inflate(R.layout.wuyou_shuoming,
		// null);
		// new AlertDialog.Builder(MySecurePaymentActivity.this)
		// .setCancelable(false)
		// .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface arg0, int arg1) {
		//
		// }
		// })
		// .setView(vie).create().show();

		new myDialog(ShowSelectFractionActivity.this).showDialog(
				R.layout.showfen_shuoming, 0, 0);
	}
}
