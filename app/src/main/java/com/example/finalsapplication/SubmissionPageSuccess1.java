package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SubmissionPageSuccess1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission_page_success1);

        ImageButton backButton = findViewById(R.id.imageButtonBackTP1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubmissionPageSuccess1.this, UserMenu.class));
                finish();
            }
        });

        Button recordsButton = findViewById(R.id.buttonRecords);
        recordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubmissionPageSuccess1.this, RecordsPage1.class));
            }
        });
    }
}