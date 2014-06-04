package com.example.notificationtest.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // here we create an object of our Notification which include the properties of it like ..
        // ... the Image, Title and the Text
        final NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                       .setSmallIcon(R.drawable.ic_launcher)  /* the image source from the the res file*/
                       .setContentTitle("My notification")    /*the Title for my Notification*/
                       .setContentText("Hello World!");       /* the Text we want it to be showed in the Notifaction*/
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(MainActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        final NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Button pushNotifiButton= (Button) findViewById(R.id.pushNotification);
        pushNotifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mId allows you to update the notification later on.
                mNotificationManager.notify(mId, mBuilder.build());
            }
        });


    }
    int mId;
}
