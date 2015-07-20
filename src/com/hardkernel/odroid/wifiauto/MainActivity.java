package com.hardkernel.odroid.wifiauto;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_layout);
		
		CheckBox cbUse = (CheckBox)findViewById(R.id.cb_use);
		cbUse.setOnCheckedChangeListener(new OnCheckedChangeListener () {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences prefs = getSharedPreferences("PreName", MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putBoolean("Use", isChecked);
				editor.commit();
			}
			
		});
		
		SharedPreferences prefs = getSharedPreferences("PreName", MODE_PRIVATE);
		cbUse.setChecked(prefs.getBoolean("Use", true));
	}

}
