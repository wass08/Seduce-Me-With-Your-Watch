package com.wass08.futureseduction.sender;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.wass08.futureseduction.R;

/**
 * Created by wassimsamad on 07/12/14.
 */
public class NotificationSender {
    private static int notificationId = 1;

    private static void sendNotification(Context context, String title, String content) {
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),
                R.drawable.default_background);
        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintHideIcon(true)
                        .setBackground(bitmap)
                        .setContentIcon(R.drawable.heart_picto);


        long pattern[] = {500, 500};

        // Create a NotificationCompat.Builder to build a standard notification
        // then extend it with the WearableExtender
        Notification notif = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.heart_picto)
                .extend(wearableExtender)
                .setVibrate(pattern)
                .build();
        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Issue the notification with notification manager.
        notificationManager.notify(notificationId++, notif);
    }

    public static void sendDefaultManNotification(Context context) {
        String title = context.getResources().getString(R.string.sample_man_title);
        String content = context.getResources().getString(R.string.sample_man_content);
        sendNotification(context, title, content);
    }

    public static void sendDefaultWomanNotification(Context context) {
        String title = context.getResources().getString(R.string.sample_woman_title);
        String content = context.getResources().getString(R.string.sample_woman_content);
        sendNotification(context, title, content);
    }

    public static void sendDefaultLoveNotification(Context context) {
        String title = context.getResources().getString(R.string.sample_love_title);
        String content = context.getResources().getString(R.string.sample_love_content);
        sendNotification(context, title, content);
    }

    public static void sendCustomNotification(Context context, String title, String content) {
        sendNotification(context, title, content);
    }
}
