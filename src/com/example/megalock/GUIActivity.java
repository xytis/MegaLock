package com.example.megalock;

import com.example.megalock.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class GUIActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_gui);

		final View entryButton = findViewById(R.id.btnEntry);
		final View enterPhone = findViewById(R.id.configPhone);
		final TextView phoneNumber = (TextView) findViewById(R.id.textPhone);
		final View confirmButton = findViewById(R.id.btnConfirm);
	
		entryButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				entryButton.setVisibility(View.GONE);
				enterPhone.setVisibility(View.VISIBLE);
			}
		});
		
		confirmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (phoneNumberValid(phoneNumber.getText())) {
					//Intent service = new Intent(context, MyService.class);
					//context.startService(service); 
				} else {
					phoneNumber.setBackgroundColor(Color.RED);
				}
			}
		});
		
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}
	
	private boolean phoneNumberValid(CharSequence number) {
		return number == "+37069902044";
	}
}
