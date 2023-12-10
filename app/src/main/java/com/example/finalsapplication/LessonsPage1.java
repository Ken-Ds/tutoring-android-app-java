package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                updateButtonState();
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

        // Disable buttons by default
        L1T1.setEnabled(false);
        L1T2.setEnabled(false);
        L1T3.setEnabled(false);
        L2T1.setEnabled(false);
        L2T2.setEnabled(false);
        L2T3.setEnabled(false);
        L3T1.setEnabled(false);
        L3T2.setEnabled(false);
        L3T3.setEnabled(false);

        // Set click listener for Topic 1 of Lesson 1
        if (currentLesson == 1 && currentTopic == 1) {
            L1T1.setEnabled(true);
            L1T1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to the ViewLesson activity for Lesson 1, Topic 1
                    Intent intent = new Intent(LessonsPage1.this, ViewLesson1.class);
                    intent.putExtra("lesson", 1);
                    intent.putExtra("topic", 1);
                    startActivity(intent);
                }
            });
        } else {
            // Set click listeners based on the current lesson and topic
            setButtonClickListener(L1T2, 1, 2);
            setButtonClickListener(L1T3, 1, 3);
            setButtonClickListener(L2T1, 2, 1);
            setButtonClickListener(L2T2, 2, 2);
            setButtonClickListener(L2T3, 2, 3);
            setButtonClickListener(L3T1, 3, 1);
            setButtonClickListener(L3T2, 3, 2);
            setButtonClickListener(L3T3, 3, 3);
        }
    }

    private void setButtonClickListener(Button button, final int lesson, final int topic) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLesson = lesson;
                currentTopic = topic;
                // Navigate to the ViewLesson activity based on the lesson and topic
                Intent intent = new Intent(LessonsPage1.this, ViewLesson1.class);
                intent.putExtra("lesson", currentLesson);
                intent.putExtra("topic", currentTopic);
                startActivity(intent);
            }
        });
    }
}