package com.example.finalsapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

public class RecordsPage1 extends AppCompatActivity {
    private TextView summativeScore;
    private TextView summativeRemarks;

    private static final String AUTH_TOKEN_KEY = "auth_token";

    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.records_page1);


        DatabaseHelper db = new DatabaseHelper(RecordsPage1.this);

        String emailCheck = retrieveAuthToken();
        AccountInfo accDetails = db.getUserByEmail(emailCheck);

        int score = accDetails.getScore();

        summativeScore = (TextView) findViewById(R.id.summativeScore);

        summativeRemarks = (TextView) findViewById(R.id.summativeRemarks);

        back = (ImageButton) findViewById(R.id.backButton);
        back();

        int sumTotal = 5;
        int sumScore = score;
        boolean summativePassed;


        summativeScore.setText(displayScoreAndTotal(sumScore,sumTotal));
        summativePassed = isPassed(sumScore,sumTotal);
        summativeRemarks.setText(displayRemarks(summativePassed));
    }

    public void back(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecordsPage1.this, UserMenu.class);
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

    private String retrieveAuthToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString(AUTH_TOKEN_KEY, null);
    }
}
