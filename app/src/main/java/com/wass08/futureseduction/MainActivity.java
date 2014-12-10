package com.wass08.futureseduction;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;


public class MainActivity extends ActionBarActivity {

    private ViewPager                       viewPager;
    private FragmentStatePagerAdapter       adapter;
    private CirclePageIndicator             indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new MainPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        indicator =  (CirclePageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int idNotif = 1;
    public void testNotification(View view) {
        Log.v("Test", "test");
        Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.default_background);
        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintHideIcon(true)
                        .setBackground(bitmap)
                        .setContentIcon(R.drawable.heart_picto);


// Create a NotificationCompat.Builder to build a standard notification
// then extend it with the WearableExtender
        Notification notif = new NotificationCompat.Builder(this)
                .setContentTitle("ALERTE MEUF")
                .setContentText("La femme de ta vie est juste à côté de toi")
                .setSmallIcon(R.drawable.heart_picto)
                .extend(wearableExtender)
                .build();
        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

// Issue the notification with notification manager.
        notificationManager.notify(idNotif++, notif);
    }
}
