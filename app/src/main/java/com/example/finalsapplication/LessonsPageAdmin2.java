package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LessonsPageAdmin2 extends AppCompatActivity {
    private Button l1t1,l1t2,l1t3;
    private Button l2t1,l2t2,l2t3;
    private Button l3t1,l3t2,l3t3;

    private ImageButton addLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons_page_admin2);

        l1t1 = (Button) findViewById(R.id.L1T1);
        l1t2 = (Button) findViewById(R.id.L1T2);
        l1t3 = (Button) findViewById(R.id.L1T3);

        l2t1 = (Button) findViewById(R.id.L2T1);
        l2t2 = (Button) findViewById(R.id.L2T2);
        l2t3 = (Button) findViewById(R.id.L2T3);

        l3t1 = (Button) findViewById(R.id.L3T1);
        l3t2 = (Button) findViewById(R.id.L3T2);
        l3t3 = (Button) findViewById(R.id.L3T3);

        addLesson = (ImageButton) findViewById(R.id.addLesson);
        l1t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonsPageAdmin2.this, ViewLesson1.class);
                startActivity(i);
            }
        });

        l1t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonsPageAdmin2.this, ViewLesson1Topic2.class);
                startActivity(i);
            }
        });

        l1t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonsPageAdmin2.this, ViewLesson1Topic3.class);
                startActivity(i);
            }
        });

        addLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(LessonsPageAdmin2.this, AdminAddLesson.class);
                startActivity(i);
            }
        });
    }
}