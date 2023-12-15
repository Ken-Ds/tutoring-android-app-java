package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LessonPage extends AppCompatActivity {

    private int currentLesson = 1;
    private int currentTopic = 1;
    private boolean lesson1Topic1Completed = true;
    private boolean lesson1Topic2Completed = true;
    private boolean lesson1Topic3Completed = true;
    private boolean lesson2Topic1Completed = false;
    private boolean lesson2Topic2Completed = false;
    private boolean lesson2Topic3Completed = false;
    private boolean lesson3Topic1Completed = false;
    private boolean lesson3Topic2Completed = false;
    private boolean lesson3Topic3Completed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons_page);

        updateButtonState();

        ImageButton backButton = findViewById(R.id.imageButtonBackTP1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
        Button summativeButton = findViewById(R.id.summativeButton);

        L1T1.setEnabled(true);
        L1T2.setEnabled(true);
        L1T3.setEnabled(true);
        L2T1.setEnabled(false);
        L2T2.setEnabled(false);
        L2T3.setEnabled(false);
        L3T1.setEnabled(false);
        L3T2.setEnabled(false);
        L3T3.setEnabled(false);
        summativeButton.setEnabled(true);

        if (currentLesson == 1 && currentTopic == 1) {
            L1T1.setEnabled(true);
            L1T1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LessonPage.this, ViewLesson1.class);
                    startActivity(intent);
                }
            });

            setButtonClickListener(L1T2, 1, 2, lesson1Topic1Completed);
            setButtonClickListener(L1T3, 1, 3, lesson1Topic2Completed);
        }

        setButtonClickListener(L2T1, 2, 1, lesson2Topic1Completed);
        setButtonClickListener(L2T2, 2, 2, lesson2Topic2Completed);
        setButtonClickListener(L2T3, 2, 3, lesson2Topic3Completed);

        setButtonClickListener(L3T1, 3, 1, lesson3Topic1Completed);
        setButtonClickListener(L3T2, 3, 2, lesson3Topic2Completed);
        setButtonClickListener(L3T3, 3, 3, lesson3Topic3Completed);
        summativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lesson1Topic3Completed && lesson2Topic3Completed && lesson3Topic3Completed) {
                    Intent intent = new Intent(LessonPage.this, UserTestPage.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LessonPage.this, "Complete all lessons before taking summative test", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setButtonClickListener(Button button, final int lesson, final int topic, final boolean completed) {
        button.setEnabled(completed);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentLesson = lesson;
                currentTopic = topic;

                Class<?> targetClass = determineTargetClass(currentLesson, currentTopic);
                Intent intent = new Intent(LessonPage.this, targetClass);
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
        return LessonPage.class;
    }
}