package com.geo.smallcredit.activity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geo.smallcredit.R;
import com.geo.smallcredit.util.BitmapUtil;
import com.geo.smallcredit.util.ToastUtil;
import com.geo.smallcredit.vo.Popuw;

public class SuggestionActivity extends Activity implements OnClickListener {
	private Button btn, imgback;
	private EditText edit_text;
	private TextView text_view;
	private int BigIndex = 100;
	private ImageView img, imageview;
	private View popupView;
	private PopupWindow popupWindow;
	LayoutInflater inflater;
	private LinearLayout mLine;

	// 自定义的弹出框类
	Popuw menuWindow;
	private String temppath;
	private Uri tempuri;
	private File finalfile;
	private File tempFile;
	/* 用来标识请求照相功能 */
	private static final int CAMERA_WITH_DATA = 50;
	/* 用来标识请求gallery */
	private static final int PHOTO_PICKED_WITH_DATA = 60;
	/* 用来标识裁剪的返回 */
	private static final int CUT_PHOTO = 70;
	private int createnum = 0;
	ImageView tv;
	private static final File PHOTO_DIR = new File(
			Environment.getExternalStorageDirectory() + "/dotOrderImage");
	private TextView backtext;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.suggestion_activity);
		initview();
		intent=getIntent();
		backtext.setText(intent.getStringExtra("backText"));
		initClick();

		// 点击外部键盘消失
		mLine = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mLine.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

			}
		});

	}

	public void initview() {
		imgback = (Button) findViewById(R.id.suggestion_imgback);
		btn = (Button) findViewById(R.id.suggestion_btn);
		edit_text = (EditText) findViewById(R.id.suggestion_ed1);
		text_view = (TextView) findViewById(R.id.suggestion_tv1);
		img = (ImageView) findViewById(R.id.suggestion_img);
		imageview = (ImageView) findViewById(R.id.suggestion_imageview);
		backtext=(TextView) findViewById(R.id.suggestion_backtext);
	}

	public void initClick() {
		imgback.setOnClickListener(this);
		btn.setOnClickListener(this);
		edit_text.addTextChangedListener(new EditTextWatcher());
		img.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.suggestion_imgback:

			this.finish();

			break;

		case R.id.suggestion_btn:

			ToastUtil.show(SuggestionActivity.this, "需要后台接口");
			break;
		case R.id.suggestion_img:
			hintKbTwo();
			// 实例化SelectPicPopupWindow
			menuWindow = new Popuw(SuggestionActivity.this, itemsOnClick);
			// 显示窗口
			menuWindow.showAtLocation(
					SuggestionActivity.this.findViewById(R.id.suggestion_id),
					Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置

			break;
		}
	}

	public class EditTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {
			String edit = edit_text.getText().toString();

			edit_text.setVisibility(View.VISIBLE);
			if (edit.length() <= BigIndex) {
				text_view.setText("还能输入" + (BigIndex - edit.length()) + "字");
			} else {
				edit_text.setText(edit.substring(0, BigIndex));
				edit_text.setSelection(edit.substring(0, BigIndex).length());
			}
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {

		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {

		}

	}

	// 使用系统当前日期加以调整作为照片的名称
	private String getPhotoFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"'IMG'_yyyyMMdd_HHmmss");
		return dateFormat.format(date) + ".jpg";
	}

	@Override
	protected void onResume() {
		System.out.println("onResume");
		// // 切换屏幕方向会导致activity的摧毁和重建
		// if (getRequestedOrientation() ==
		// ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// System.out.println("屏幕切换");
		// }
		super.onResume();
	}

	/**
	 * 保存裁剪之后的图片数据 &nbsp;
	 * 
	 * @param picdata
	 */
	private void setPicToView(Intent picdata) {
		Bundle extras = picdata.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			finalfile = new File(PHOTO_DIR, getPhotoFileName());
			BitmapUtil.saveImg(photo, finalfile);
			// Log.i("finalfile", finalfile.getAbsolutePath());
			Drawable drawable = new BitmapDrawable(photo);

			/**
			 * 下面注释的方法是将裁剪之后的图片以Base64Coder的字符方式上 传到服务器，QQ头像上传采用的方法跟这个类似
			 */

			/*
			 * ByteArrayOutputStream stream = new ByteArrayOutputStream();
			 * photo.compress(Bitmap.CompressFormat.JPEG, 60, stream); byte[] b
			 * = stream.toByteArray(); // 将图片流以字符串形式存储下来&nbsp; tp = new
			 * String(Base64Coder.encodeLines(b));
			 * 这个地方大家可以写下给服务器上传图片的实现，直接把tp直接上传就可以了， 服务器处理的方法是服务器那边的事了，吼吼&nbsp;
			 * 如果下载到的服务器的数据还是以Base64Coder的形式的话，可以用以下方式转换 为我们可以用的图片类型就OK啦...吼吼
			 * Bitmap dBitmap = BitmapFactory.decodeFile(tp); Drawable drawable
			 * = new BitmapDrawable(dBitmap);
			 */

			imageview.setImageDrawable(drawable);
		}
	}

	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
			switch (v.getId()) {
			case R.id.btn_take_photo: {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				// 下面这句指定调用相机拍照后的照片存储的路径
				if (!PHOTO_DIR.exists()) {
					boolean iscreat = PHOTO_DIR.mkdirs();// 创建照片的存储目录
				}

				tempFile = new File(PHOTO_DIR, getPhotoFileName());
				// if (!tempFile.exists()) {
				// try {
				// tempFile.createNewFile();
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				// }
				temppath = tempFile.getAbsolutePath();
				tempuri = Uri.fromFile(tempFile);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, tempuri);

				startActivityForResult(intent, CAMERA_WITH_DATA);
			}
				break;
			case R.id.btn_pick_photo: {

				Intent intent = new Intent(Intent.ACTION_PICK, null);

				/**
				 * 下面这句话，与其它方式写是一样的效果，如果： intent.setData(MediaStore.Images
				 * .Media.EXTERNAL_CONTENT_URI);
				 * intent.setType(""image/*");设置数据类型 如果朋友们要限制上传到服务器的图片类型时可以直接写如
				 * ："image/jpeg 、 image/png等的类型"
				 */

				intent.setDataAndType(
						MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

				startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
			}
				break;
			default:
				break;
			}

		}

	};

	/**
	 * 裁剪图片方法实现 &nbsp;
	 * 
	 * @param uri
	 */

	public void startPhotoZoom(Uri uri) {
		/*
		 * 至于下面这个Intent的ACTION是怎么知道的，大家可以看下自己路径下的如下网页
		 * yourself_sdk_path/docs/reference/android/content/Intent.html
		 * 直接在里面Ctrl+F搜：CROP ，之前没仔细看过，其实安卓系统早已经有自带图片裁剪功能, 是直接调本地库的
		 */
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 200);
		intent.putExtra("outputY", 200);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, CUT_PHOTO);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println("onActivityResult");
		switch (requestCode) {
		// 如果是直接从相册获取
		case PHOTO_PICKED_WITH_DATA:
			if (data != null && data.getData() != null) {
				startPhotoZoom(data.getData());
				// System.out.println("data.getData()"+data.getData());
			}

			break;
		// 如果是调用相机拍照时
		case CAMERA_WITH_DATA:
			Log.i("resultCode", resultCode + "");
			if (resultCode == 0) {
				return;
			}
			Log.i("createnum", createnum + "");
			startPhotoZoom(tempuri);
			break;
		// 取得裁剪后的图片
		case CUT_PHOTO:
			/**
			 * 非空判断大家一定要验证，如果不验证的话， 在剪裁之后如果发现不满意，要重新裁剪，丢弃
			 * 当前功能时，会报NullException，只 在这个地方加下，大家可以根据不同情况在合适的 地方做判断处理类似情况 &nbsp;
			 */
			Log.i("CUT_PHOTO", resultCode + "");
			// if(resultCode==0){
			// return;
			// }
			if (data != null) {
				setPicToView(data);
			}
			break;
		default:
			break;

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		System.out.println("onSaveInstanceState");
		outState.putString("temppath", temppath);
		outState.putSerializable("finalfile", finalfile);
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("onRestoreInstanceState");
		temppath = savedInstanceState.getString("temppath");
		finalfile = (File) savedInstanceState.getSerializable("finalfile");
		super.onRestoreInstanceState(savedInstanceState);
	}

	// 此方法只是关闭软键盘
	public void hintKbTwo() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive() && getCurrentFocus() != null) {
			if (getCurrentFocus().getWindowToken() != null) {
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

}
