package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ViewLesson1Topic3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lesson1_topic3);

        final ImageButton backButton = findViewById(R.id.imageButtonBackVL1);
        final ImageButton nextButton = findViewById(R.id.imageButtonNextVL1);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate back to the UserMenu activity
                Intent intent = new Intent(ViewLesson1Topic3.this, ViewLesson1Topic2.class);

                // Start the UserMenu activity
                startActivity(intent);

                // Finish the current activity (profile_information_user_side)
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate back to the UserMenu activity
                Intent intent = new Intent(ViewLesson1Topic3.this, LessonsPage1.class);

                // Start the UserMenu activity
                startActivity(intent);

                // Finish the current activity (profile_information_user_side)
                finish();
            }
        });
    }
}