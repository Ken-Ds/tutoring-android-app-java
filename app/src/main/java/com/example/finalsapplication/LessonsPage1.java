package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LessonsPage1 extends AppCompatActivity {

    private int currentLesson = 1;
    private int currentTopic = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons_page);

        updateButtonState();

        findViewById(R.id.L1T1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLesson = 1;
                currentTopic = 1;
                updateButtonState();
            }
        });

        findViewById(R.id.L1T2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 1;
                currentTopic = 2;
                updateButtonState();
            }
        });

        findViewById(R.id.L1T3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 1;
                currentTopic = 3;
                updateButtonState() ;
            }
        });

        findViewById(R.id.L2T1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 2;
                currentTopic = 1;
                updateButtonState();
            }
        });

        findViewById(R.id.L2T2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 2;
                currentTopic = 2;
                updateButtonState();
            }
        });

        findViewById(R.id.L2T3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 2;
                currentTopic = 3;
                updateButtonState();
            }
        });

        findViewById(R.id.L3T1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 3;
                currentTopic = 1;
                updateButtonState();
            }
        });

        findViewById(R.id.L3T2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = 3;
                currentTopic = 2;
                updateButtonState();
            }
        });

        findViewById(R.id.L3T3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLesson = 3;
                currentTopic = 3;
                updateButtonState();
            }
        });

        findViewById(R.id.imageButtonBackLP1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentTopic > 1) {
                    currentTopic--;
                } else if (currentLesson > 1) {
                    currentLesson--;
                    currentTopic = 3;
                }
                updateButtonState();
            }
        });

    }

    private void updateButtonState() {
        Button L1T1 = findViewById(R.id.L1T1);
        Button L1T2 = findViewById(R.id.L1T2);
        Button L1T3 = findViewById(R.id.L1T3);
        Button L2T1 = findViewById(R.id.L2T1);
        Button L2T2 = findViewById(R.id.L2T2);
        Button L2T3 = findViewById(R.id.L2T3);
        Button L3T1 = findViewById(R.id.L3T1);
        Button L3T2 = findViewById(R.id.L3T2);
        Button L3T3 = findViewById(R.id.L3T3);

        if (currentLesson == 1) {
            // Lesson 1
            L1T1.setEnabled(currentTopic >= 1);
            L1T2.setEnabled(currentTopic >= 2);
            L1T3.setEnabled(currentTopic >= 3);
            // Disable other Lesson 1 buttons based on completion status
            L2T1.setEnabled(false);
            L2T2.setEnabled(false);
            L2T3.setEnabled(false);
            L3T1.setEnabled(false);
            L3T2.setEnabled(false);
            L3T3.setEnabled(false);
        } else if (currentLesson == 2) {
            // Lesson 2
            // Enable or disable buttons for Lesson 2 based on completion status
            L2T1.setEnabled(currentTopic >= 1);
            L2T2.setEnabled(currentTopic >= 2);
            L2T3.setEnabled(currentTopic >= 3);
            // Disable other Lesson 2 buttons based on completion status
            L3T1.setEnabled(false);
            L3T2.setEnabled(false);
            L3T3.setEnabled(false);
        } else if (currentLesson == 3) {
            // Lesson 3
            // Enable or disable buttons for Lesson 3 based on completion status
            L3T1.setEnabled(currentTopic >= 1);
            L3T2.setEnabled(currentTopic >= 2);
            L3T3.setEnabled(currentTopic >= 3);
        }
    }
}