package com.nitrkl.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_table_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View rootView = findViewById(R.id.time_table);
        LinearLayout timeBlocks = (LinearLayout) rootView.findViewById(R.id.time_blocks);
        TextView textView = (TextView) timeBlocks.findViewById(R.id.time_slot_1);
        textView.setText("7 a.m.");


        /*NotificationEventReceiver.setUpPeriodAlarm(getApplicationContext(), new Period("OE", "11-10-2016", TimeSlot.DEBUG));
        NotificationEventReceiver.setUpPeriodAlarm(getApplicationContext(), new Period("EC", "11-10-2016", TimeSlot.DEBUG));

        NotificationEventReceiver.setupAlarm(getApplicationContext());
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

}
