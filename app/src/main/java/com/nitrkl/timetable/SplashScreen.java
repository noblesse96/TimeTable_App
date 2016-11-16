package com.nitrkl.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nitrkl.timetable.ui.StudentActivity;
import com.nitrkl.timetable.ui.TeacherActivity;

public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        Button Functioning
        Button SplashButton_Teacher = (Button)findViewById(R.id.SplashButton_Teacher);
        SplashButton_Teacher.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent intent = new Intent(SplashScreen.this, TeacherActivity.class);
                startActivity(intent);
            }
        });

        Button SplashButton_Student = (Button)findViewById(R.id.SplashButton_Student);
        SplashButton_Student.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent intent = new Intent(SplashScreen.this, StudentActivity.class);
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