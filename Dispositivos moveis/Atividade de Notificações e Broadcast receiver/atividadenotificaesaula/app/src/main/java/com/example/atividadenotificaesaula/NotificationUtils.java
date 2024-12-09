package com.example.atividadenotificaesaula;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class NotificationUtils {
    private static final String CHANNEL_ID = "com.example.atividadenotificaesaula.android.channel";
    private static final String CHANEL_NAME = "My Channel";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getChanelId(Context context){
        NotificationManager mn = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = mn.getNotificationChannel(CHANNEL_ID);
        }

        if(channel == null){
            channel = new NotificationChannel(CHANNEL_ID, CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            mn.createNotificationChannel(channel);
        }
        return CHANNEL_ID;
    }
}
