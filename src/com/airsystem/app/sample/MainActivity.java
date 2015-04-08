package com.airsystem.app.sample;

import com.airsystem.app.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
public class MainActivity extends Activity implements OnClickListener {
	private ImageButton mImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageButton = (ImageButton) findViewById(R.id.btnNext);
		mImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnNext: {
			Intent endActivityIntent = new Intent(this, EndActivity.class);
			startActivity(endActivityIntent);
			break;
		}
		}
	}
}