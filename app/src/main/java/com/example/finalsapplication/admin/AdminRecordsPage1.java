package com.example.finalsapplication.admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.R;

import java.util.Objects;

public class AdminRecordsPage1 extends AppCompatActivity {
    private TextView summativeScore;
    private TextView summativeRemarks;

    private ImageButton backButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_records_page1);

        summativeScore = (TextView) findViewById(R.id.summativeScore);

        summativeRemarks = (TextView) findViewById(R.id.summativeRemarks);

        backButton = (ImageButton) findViewById(R.id.backButton);

        back();

        Intent intent = getIntent();
        int score = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra("score")));
        int sumTotal = 5;
        int sumScore = score;
        boolean summativePassed;

        summativeScore.setText(displayScoreAndTotal(sumScore,sumTotal));
        summativePassed = isPassed(sumScore,sumTotal);
        summativeRemarks.setText(displayRemarks(summativePassed));
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
