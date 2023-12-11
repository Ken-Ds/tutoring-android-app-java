package com.example.finalsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileInfoUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_information_user_side);

        // Find the back button in your layout by its ID
        ImageButton backButton = findViewById(R.id.imageButtonBackLP1);

        // Set an OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate back to the UserMenu activity
                Intent intent = new Intent(ProfileInfoUser.this, UserMenu.class);

                // Start the UserMenu activity
                startActivity(intent);

                // Finish the current activity (profile_information_user_side)
                finish();
            }
        });

        // Find the "View Records" button in your layout by its ID
        Button viewRecordsButton = findViewById(R.id.viewRecords);

        // Set an OnClickListener for the "View Records" button
        viewRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate to the View Records page
                Intent intent = new Intent(ProfileInfoUser.this, RecordsPage1.class);

                // Start the View Records activity
                startActivity(intent);
            }
        });

        // Find the progress bars in your layout by their IDs
        ProgressBar progressBarLesson1 = findViewById(R.id.progressBar_lesson1);
        ProgressBar progressBarLesson2 = findViewById(R.id.progressBar_lesson2);
        ProgressBar progressBarLesson3 = findViewById(R.id.progressBar_lesson3);

        // Set an OnClickListener for each progress bar
        progressBarLesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate to the Lessons page
                Intent intent = new Intent(ProfileInfoUser.this, TestPage1.class);

                // Start the Lessons activity
                startActivity(intent);
            }
        });

        progressBarLesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate to the Lessons page
                Intent intent = new Intent(ProfileInfoUser.this, TestPage1.class);

                // Start the Lessons activity
                startActivity(intent);
            }
        });

        progressBarLesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate to the Lessons page
                Intent intent = new Intent(ProfileInfoUser.this, TestPage1.class);

                // Start the Lessons activity
                startActivity(intent);
            }
        });
    }
}
