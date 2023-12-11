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
    private boolean lesson1Topic1Completed = false;
    private boolean lesson1Topic2Completed = false;

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

        L1T1.setEnabled(true);
        L1T2.setEnabled(false);
        L1T3.setEnabled(false);
        L2T1.setEnabled(false);
        L2T2.setEnabled(false);
        L2T3.setEnabled(false);
        L3T1.setEnabled(false);
        L3T2.setEnabled(false);
        L3T3.setEnabled(false);

        if (currentLesson == 1 && currentTopic == 1) {
            L1T1.setEnabled(true);
            L1T1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to the ViewLesson activity for Lesson 1, Topic 1
                    Intent intent = new Intent(LessonsPage1.this, ViewLesson1.class);
                    startActivity(intent);
                }
            });
        } else {
            setButtonClickListener(L1T2, 1, 2, lesson1Topic1Completed);
            setButtonClickListener(L1T3, 1, 3, lesson1Topic2Completed);
        }
    }

    private void setButtonClickListener(Button button, final int lesson, final int topic, final boolean completed) {
        button.setEnabled(completed);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = lesson;
                currentTopic = topic;

                Class<?> targetClass = determineTargetClass(currentLesson, currentTopic);
                Intent intent = new Intent(LessonsPage1.this, targetClass);
                startActivity(intent);
            }
        });
    }

    private Class<?> determineTargetClass(int lesson, int topic) {
        if (lesson == 1 && topic == 1) {
            return ViewLesson1.class;
        } else if (lesson == 1 && topic == 2) {
            return ViewLesson1Topic2.class;
        } else if (lesson == 1 && topic == 3) {
            return ViewLesson1Topic3.class;
        }
        return ViewTest1.class;
    }
}

