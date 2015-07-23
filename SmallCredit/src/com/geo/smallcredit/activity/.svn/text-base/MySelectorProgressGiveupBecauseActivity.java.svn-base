package com.geo.smallcredit.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.geo.smallcredit.R;

public class MySelectorProgressGiveupBecauseActivity extends Activity implements
		OnClickListener ,OnItemSelectedListener{

	private Button backBtn, submitBtn;
	private EditText shuoming;
	private TextView input;
	private int BigIndex = 100;
	private Spinner sp;
	private LinearLayout mRela;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myselectorprogresssure_giveupbecause);
		initView();
		initClick();
		
		// 点击外部键盘消失
		mRela = (LinearLayout) findViewById(R.id.traceroute_rootview);
		mRela.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
		});
	}

	private void initClick() {
		sp.setOnItemSelectedListener(this);
		backBtn.setOnClickListener(this);
		submitBtn.setOnClickListener(this);
		shuoming.addTextChangedListener(new EditTextWatcher());
	}

	private void initView() {
		sp=(Spinner) findViewById(R.id.myselectorprogressgiveupbecause_spinner);
		backBtn = (Button) findViewById(R.id.myselectorprogressgiveupbecause_backbtn);
		submitBtn = (Button) findViewById(R.id.myselectorprogressgiveupbecause_subimtbtn);
		shuoming = (EditText) findViewById(R.id.myselectorprogressgiveupbecause_shuomingedit);
		input = (TextView) findViewById(R.id.myselectorprogressgiveupbecause_inputtxt);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.myselectorprogressgiveupbecause_backbtn:
			finish();
			break;

		case R.id.myselectorprogressgiveupbecause_subimtbtn:
			finish();
			break;
		}
	}

	public class EditTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {
			String edit = shuoming.getText().toString();

			shuoming.setVisibility(View.VISIBLE);
			if (edit.length() <= BigIndex) {
				input.setText("还能输入" + (BigIndex - edit.length()) + "字");
			} else {
				shuoming.setText(edit.substring(0, BigIndex));
				shuoming.setSelection(edit.substring(0, BigIndex).length());
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

	@Override
	public void onItemSelected(AdapterView<?> arg0, View v, int arg2,
			long arg3) {
		TextView tv=(TextView) v;
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setTextSize(12);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
}
