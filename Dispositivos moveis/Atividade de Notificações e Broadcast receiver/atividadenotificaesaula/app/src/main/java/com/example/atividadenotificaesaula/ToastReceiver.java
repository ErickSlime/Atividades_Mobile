package com.example.atividadenotificaesaula;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class ToastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            Toast.makeText(context, "Dispositivo conectado a energia", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                sendNotification(context, "Dispositivo conectado à energia.");
            }
        }
        else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())){
            Toast.makeText(context, "Dispositivo desconectado da energia", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                sendNotification(context, "Dispositivo desconectado da energia.");
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void sendNotification(Context context, String message) {
        Notification.Builder builder = new Notification.Builder(context, NotificationUtils.getChanelId(context));
        builder.setContentTitle("Status de Energia");
        builder.setContentText(message);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(1, builder.build());
        }
    }
}