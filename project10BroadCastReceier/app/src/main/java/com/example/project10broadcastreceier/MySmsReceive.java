package com.example.project10broadcastreceier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceive extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        proccessReceive(context, intent);
    }

    public void proccessReceive(Context context , Intent intent){
        Bundle bundle = intent.getExtras();
        String massage = "";
        String body = "";
        String address = "";
        if (bundle != null) {
            Object[] smsExtra = (Object[]) bundle.get("pdus");
            for (int i = 0 ; i < smsExtra.length ; i++){
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) smsExtra[i]);
                body = smsMessage.getMessageBody();
                address = smsMessage.getOriginatingAddress();
                massage += "Có 1 tin nhắn từ " + address + "\n" + body + "vừa gọi đến";
            }
            Toast.makeText(context , massage , Toast.LENGTH_LONG).show();
        }
    }
}