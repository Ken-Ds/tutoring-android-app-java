package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TestPage1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);

        Button takeTestLesson1 = findViewById(R.id.takeTestLesson1);
        Button takeTestLesson2 = findViewById(R.id.takeTestLesson2);
        Button takeTestLesson3 = findViewById(R.id.takeTestLesson3);
        Button summativeButton = findViewById(R.id.summativeButton);

        takeTestLesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the common test view (ViewTest1) for Lesson 1
                Intent intent = new Intent(TestPage1.this, ViewTest1.class);
                startActivity(intent);
            }
        });

        takeTestLesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(TestPage1.this, ViewTest1.class);
                startActivity(intent);
            }
        });

        takeTestLesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPage1.this, ViewTest1.class);
                startActivity(intent);
            }
        });

        summativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPage1.this, ViewTest1.class);
                startActivity(intent);
            }
        });
    }
}
