package com.example.finalsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileInfoAdmin extends AppCompatActivity {

    private ProgressBar progressBarLesson1;
    private ProgressBar progressBarLesson2;
    private ProgressBar progressBarLesson3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_information_admin_side);

        // Find the back button in your layout by its ID
        ImageButton backButton = findViewById(R.id.imageButtonBackLP1);

        // Set an OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate back to the UserMenu activity
                Intent intent = new Intent(ProfileInfoAdmin.this, UserMenu.class);

                // Start the UserMenu activity
                startActivity(intent);

                // Finish the current activity (profile_information_admin_side)
                finish();
            }
        });

        // Find the edit button in your layout by its ID
        ImageButton editButton = findViewById(R.id.edit_button);

        // Set an OnClickListener for the edit button
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate to the Edit page
                Intent intent = new Intent(ProfileInfoAdmin.this, TestPage1.class);

                // Start the Edit activity
                startActivity(intent);
            }
        });

        // Find the "View Records" button in your layout by its ID
        Button viewRecordsButton = findViewById(R.id.viewRecords);

        // Set an OnClickListener for the "View Records" button
        viewRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate to the View Records page
                Intent intent = new Intent(ProfileInfoAdmin.this, AdminRecordsPage1.class);

                // Start the View Records activity
                startActivity(intent);
            }
        });

        // Find the progress bars in your layout by their IDs
        ProgressBar progressBarLesson1 = findViewById(R.id.progressBar_lesson1);
        ProgressBar progressBarLesson2 = findViewById(R.id.progressBar_lesson2);
        ProgressBar progressBarLesson3 = findViewById(R.id.progressBar_lesson3);

        // Find the ScrollView in your layout by its ID
        ScrollView scrollView = findViewById(R.id.scrollView);

        // Set an OnScrollChangeListener for the ScrollView
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                // Update progress based on scroll position
                updateProgress(scrollView.getScrollY());
            }
        });

        // Method to update progress based on scroll position
        private void updateProgress(int scrollY) {
            // Calculate progress based on your scroll position and the ScrollView's content height
            int maxScroll = scrollView.getChildAt(0).getHeight() - scrollView.getHeight();
            int progress = (int) ((float) scrollY / maxScroll * 100);

            // Update your progress bars here
            progressBarLesson1.setProgress(progress);
            progressBarLesson2.setProgress(progress);
            progressBarLesson3.setProgress(progress);
        }
    }
}
