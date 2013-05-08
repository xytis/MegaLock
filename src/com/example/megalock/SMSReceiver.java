package com.example.megalock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
	private static final String CRITICAL_MESSAGE = "critical";

	@Override
	public void onReceive(Context context, Intent intent) {

	    Bundle bundle = intent.getExtras();        
	    SmsMessage[] msgs = null;
	    String str = "";            
	    if (bundle != null){
	        Object[] pdus = (Object[]) bundle.get("pdus");
	        msgs = new SmsMessage[pdus.length];            
	        for (int i=0; i<msgs.length; i++){
	            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);  
	            if (msgs[i].getMessageBody().toString().equals(CRITICAL_MESSAGE)){
	                str = "Critical msg from " + msgs[i].getOriginatingAddress() + " !";
	                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
	                abortBroadcast();
	            }    
	        }
	    }
	}
}
