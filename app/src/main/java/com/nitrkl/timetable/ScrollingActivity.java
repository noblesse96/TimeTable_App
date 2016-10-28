package com.nitrkl.timetable;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_table_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View rootView = findViewById(R.id.time_table);
        LinearLayout timeBlocks = (LinearLayout) rootView.findViewById(R.id.time_blocks);

        final TextView header_1 = (TextView) timeBlocks.findViewById(R.id.header_1);
        header_1.setText("Time");

        TextView slot1 = (TextView) timeBlocks.findViewById(R.id.time_slot_1);
        slot1.setText("7 A.M.");

        TextView slot2 = (TextView) timeBlocks.findViewById(R.id.time_slot_2);
        slot2.setText("8 A.M.");

        TextView slot3 = (TextView) timeBlocks.findViewById(R.id.time_slot_3);
        slot3.setText("9 A.M.");

        TextView slot4 = (TextView) timeBlocks.findViewById(R.id.time_slot_4);
        slot4.setText("10 A.M.");

        TextView slot5 = (TextView) timeBlocks.findViewById(R.id.time_slot_5);
        slot5.setText("11 A.M.");

        TextView slot6 = (TextView) timeBlocks.findViewById(R.id.time_slot_6);
        slot6.setText("12 P.M.");

        TextView slot7 = (TextView) timeBlocks.findViewById(R.id.time_slot_7);
        slot7.setText("1 P.M.");

        TextView slot8 = (TextView) timeBlocks.findViewById(R.id.time_slot_8);
        slot8.setText("2 P.M.");

        TextView slot9 = (TextView) timeBlocks.findViewById(R.id.time_slot_9);
        slot9.setText("3 P.M.");

        TextView slot10 = (TextView) timeBlocks.findViewById(R.id.time_slot_10);
        slot10.setText("4 P.M.");

        TextView slot11 = (TextView) timeBlocks.findViewById(R.id.time_slot_11);
        slot11.setText("5 P.M.");

        TextView slot12 = (TextView) timeBlocks.findViewById(R.id.time_slot_12);
        slot12.setText("6 P.M.");

        TextView slot13 = (TextView) timeBlocks.findViewById(R.id.time_slot_13);
        slot13.setText("7 P.M.");

//        Dynamic Layout Calling

        /*Monday*/

        final LinearLayout classBlocks = (LinearLayout) rootView.findViewById(R.id.monday_blocks);

        TextView monday_class = (TextView) classBlocks.findViewById(R.id.monday_class);
        monday_class.setText("Mon");

        TextView monday_free = (TextView) classBlocks.findViewById(R.id.no_class_monday);
        monday_free.setText("");

        TextView OE = (TextView) classBlocks.findViewById(R.id.OE_Monday);
        OE.setText("NanoMaterials");

        TextView Lunch = (TextView) classBlocks.findViewById(R.id.Lunch);
        Lunch.setText("Lunch");

        TextView Free_Period = (TextView) classBlocks.findViewById(R.id.Free_class_Monday);
        Free_Period.setText("");

        TextView Thermal_Monday = (TextView) classBlocks.findViewById(R.id.Thermal_Monday);
        Thermal_Monday.setText("Thermal Engineering");

        TextView Electronics_Monday = (TextView) classBlocks.findViewById(R.id.Electronics_Monday);
        Electronics_Monday.setText("Electronics");

        TextView GSM_Monday = (TextView) classBlocks.findViewById(R.id.GSM_Monday);
        GSM_Monday.setText("GSM");


        /*Tuesday*/
        LinearLayout tuesdayBlocks = (LinearLayout) rootView.findViewById(R.id.tuesday_blocks);

        TextView tuesday_class = (TextView) tuesdayBlocks.findViewById(R.id.tuesday_class);
        tuesday_class.setText("Tue");

        TextView tuesday_free = (TextView) tuesdayBlocks.findViewById(R.id.no_class_tuesday);
        tuesday_free.setText("");

        TextView OE_tuesday = (TextView) tuesdayBlocks.findViewById(R.id.OE_Tuesday);
        OE_tuesday.setText("NanoMaterials");

        TextView Lunch1 = (TextView) tuesdayBlocks.findViewById(R.id.Lunch);
        Lunch1.setText("Lunch");

        TextView Free_tuesday = (TextView) tuesdayBlocks.findViewById(R.id.Free_class_Tuesday);
        Free_tuesday.setText("");

        TextView Ergo_tuesday= (TextView) tuesdayBlocks.findViewById(R.id.Ergo_Tuesday);
        Ergo_tuesday.setText("Ergonomics");

        TextView Electronics_Tuesday = (TextView) tuesdayBlocks.findViewById(R.id.Electronics_Tuesday);
        Electronics_Tuesday.setText("Electronics");

        TextView GSM_tuesday = (TextView) tuesdayBlocks.findViewById(R.id.GSM_Tuesday);
        GSM_tuesday.setText("GSM");

        /*Wednesday*/
        LinearLayout wedBlocks = (LinearLayout) rootView.findViewById(R.id.wednesday_blocks);

        TextView wednesdayclass = (TextView) wedBlocks.findViewById(R.id.wednesday_class);
        wednesdayclass.setText("Wed");

        TextView free_class = (TextView) wedBlocks.findViewById(R.id.no_class_wednesday);
        free_class.setText("");

        TextView thermal_wednesday = (TextView) wedBlocks.findViewById(R.id.Thermal_Wednesday);
        thermal_wednesday.setText("Thermal");

        TextView Ec_wed = (TextView) wedBlocks.findViewById(R.id.Ec_Wednesday);
        Ec_wed.setText("Electronics");

        TextView Lunch_wed = (TextView) wedBlocks.findViewById(R.id.Lunch);
        Lunch_wed.setText("Lunch");

        TextView free_class_1 = (TextView) wedBlocks.findViewById(R.id.Free_class_Wednesday);
        free_class_1.setText("");

        TextView lab_wed = (TextView) wedBlocks.findViewById(R.id.Ansys_Wednesday);
        lab_wed.setText("Ansys Lab");


        /*Thursday*/

        LinearLayout thuBlocks = (LinearLayout) rootView.findViewById(R.id.Thursday_blocks);

        TextView thursday_class = (TextView) thuBlocks.findViewById(R.id.dynamic_class);
        thursday_class.setText("Thu");

        TextView free_block_thu = (TextView) thuBlocks.findViewById(R.id.Free_block);
        free_block_thu.setText("");

        TextView lab_thu = (TextView) thuBlocks.findViewById(R.id.Ergo_lab);
        lab_thu.setText("Ergonomics Lab");

        TextView free_thu = (TextView) thuBlocks.findViewById(R.id.Free_class_Thursday);
        free_thu.setText("");

        TextView Lunch3 = (TextView) thuBlocks.findViewById(R.id.Lunch);
        Lunch3.setText("Lunch");

        TextView Ec_thu = (TextView) thuBlocks.findViewById(R.id.Ec_Thursday);
        Ec_thu.setText("Electronics");

        TextView Ergo_thu = (TextView) thuBlocks.findViewById(R.id.Ergo_Thursday);
        Ergo_thu.setText("Ergo");

        TextView free_thu_1 = (TextView) thuBlocks.findViewById(R.id.Free_class_Thursday_2);
        free_thu_1.setText("");

        TextView GSM_thu = (TextView) thuBlocks.findViewById(R.id.GSM_Thursday);
        GSM_thu.setText("GSM");

        /*Friday*/

        LinearLayout friBlocks = (LinearLayout) rootView.findViewById(R.id.Friday_blocks);

        TextView fri_class = (TextView) friBlocks.findViewById(R.id.dynamic_class);
        fri_class.setText("Fri");

        TextView free_block_fri = (TextView) friBlocks.findViewById(R.id.Free_block);
        free_block_fri.setText("");

        TextView lab_fri = (TextView) friBlocks.findViewById(R.id.Pd_lab_Friday);
        lab_fri.setText("PD Lab");

        TextView oe_fri = (TextView) friBlocks.findViewById(R.id.OE_Friday);
        oe_fri.setText("NanoMaterials");

        TextView Lunch4 = (TextView) friBlocks.findViewById(R.id.Lunch);
        Lunch4.setText("Lunch");

        TextView Ergo_fri = (TextView) friBlocks.findViewById(R.id.Ergo_Friday);
        Ergo_fri.setText("Ergonomics");

        TextView thermal_fri = (TextView) friBlocks.findViewById(R.id.Thermal_Friday);
        thermal_fri.setText("Thermal");

        TextView free_fri = (TextView) friBlocks.findViewById(R.id.Free_class_Friday);
        free_fri.setText("");

        TextView GSM_fri = (TextView) friBlocks.findViewById(R.id.GSM_Friday);
        GSM_fri.setText("GSM");

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
