package com.hardkernel.odroid.wifiauto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;

public class ACConnectReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		SharedPreferences prefs = context.getSharedPreferences("PreName", Context.MODE_PRIVATE);
		if(prefs.getBoolean("Use", true)) {
			WifiManager manager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
				manager.setWifiEnabled(true);
			} else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
				manager.setWifiEnabled(false);
			} 
		}
	}

}
