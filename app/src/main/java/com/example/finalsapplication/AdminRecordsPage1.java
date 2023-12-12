package com.example.finalsapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminRecordsPage1 extends AppCompatActivity {
    private TextView lesson1Score, lesson2Score, lesson3Score, summativeScore;
    private TextView lesson1Remarks, lesson2Remarks, lesson3Remarks, summativeRemarks;

    private ImageButton backButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_records_page1);

        lesson1Score = (TextView) findViewById(R.id.l1Score);
        lesson2Score = (TextView) findViewById(R.id.l2Score);
        lesson3Score = (TextView) findViewById(R.id.l3Score);
        summativeScore = (TextView) findViewById(R.id.sumScore);

        lesson1Remarks = (TextView) findViewById(R.id.l1Remarks);
        lesson2Remarks = (TextView) findViewById(R.id.l2Remarks);
        lesson3Remarks = (TextView) findViewById(R.id.l3Remarks);
        summativeRemarks = (TextView) findViewById(R.id.sumRemarks);

        backButton = (ImageButton) findViewById(R.id.backButton);

        back();

        int total1 = 0,total2 = 0,total3 = 0,summativeTotal = 0;
        int score1 = 0,score2 = 0,score3 = 0,summativeScore = 0;
        boolean lesson1Passed,lesson2Passed, lesson3Passed, summativePassed;

        lesson1Score.setText(displayScoreAndTotal(score1,total1));
        lesson1Passed = isPassed(score1, total1);
        lesson1Remarks.setText(displayRemarks(lesson1Passed));

        lesson2Score.setText(displayScoreAndTotal(score2,total2));
        lesson2Passed = isPassed(score2, total2);
        lesson2Remarks.setText(displayRemarks(lesson2Passed));

        lesson3Score.setText(displayScoreAndTotal(score3,total3));
        lesson3Passed = isPassed(score3, total3);
        lesson3Remarks.setText(displayRemarks(lesson3Passed));
    }

    public void back(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminRecordsPage1.this, AdminMenu.class);
                startActivity(i);
            }
        });
    }

    public String displayScoreAndTotal(int score, int total){
        return score+"/"+total;
    }

    public boolean isPassed(int score, int total){
        int middle = total/2;
        if (score > middle)
            return true;
        else
            return false;
    }

    public String displayRemarks(boolean passed){
        if(passed)
            return "Passed";
        else
            return "Failed";
    }
}
