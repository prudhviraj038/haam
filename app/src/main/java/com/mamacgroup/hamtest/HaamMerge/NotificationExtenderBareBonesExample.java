package com.mamacgroup.hamtest.HaamMerge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationPayload;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

import java.math.BigInteger;

public class NotificationExtenderBareBonesExample extends NotificationExtenderService {
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
//            OverrideSettings overrideSettings = new OverrideSettings();
//            overrideSettings.extender = new NotificationCompat.Extender() {
//                @Override
//                public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
//                    // Sets the background notification color to Green on Android 5.0+ devices.
//                    return builder.setColor(new BigInteger("FF00FF00", 16).intValue());
////                    return builder.setSound();
//                }
//            };
//
//            OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
//            Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);
        return false;
    }
}