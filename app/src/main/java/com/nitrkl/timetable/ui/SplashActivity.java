/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nitrkl.timetable.R;

/**
 * The Splash Page activity which is the first activity shown.
 *
 * @author eswar
 * @version 1.00
 * @since 16/11/2016
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        Button Functioning
        Button SplashButton_Teacher = (Button)findViewById(R.id.SplashButton_Teacher);
        SplashButton_Teacher.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent intent = new Intent(SplashActivity.this, TeacherActivity.class);
                startActivity(intent);
            }
        });

        Button SplashButton_Student = (Button)findViewById(R.id.SplashButton_Student);
        SplashButton_Student.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent intent = new Intent(SplashActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
