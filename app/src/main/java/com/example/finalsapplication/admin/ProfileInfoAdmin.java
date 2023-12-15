package com.example.finalsapplication.admin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.AdminRecordsPage1;
import com.example.finalsapplication.R;
import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

public class ProfileInfoAdmin extends AppCompatActivity {

    private ProgressBar progressBarLesson1;
    private ProgressBar progressBarLesson2;
    private ProgressBar progressBarLesson3;
    private ScrollView scrollViewLessons1;
    private ScrollView scrollViewLessons2;
    private ScrollView scrollViewLessons3;

    private TextView nameTV, emailTV, idTV, sexTV, birthTV, hiredTV;
    private ImageView pfp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_information_admin_side);

        // Find the back button in the layout by its ID
        ImageButton backButton = findViewById(R.id.imageButtonBackLP1);

        nameTV = findViewById(R.id.user_name);
        emailTV = findViewById(R.id.user_email);
        idTV = findViewById(R.id.employee_id);
        sexTV = findViewById(R.id.user_sex);
        birthTV = findViewById(R.id.date_of_birth);
        hiredTV = findViewById(R.id.date_hired);
        pfp = findViewById(R.id.profile_pic);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String id = intent.getStringExtra("id");
        String sex = intent.getStringExtra("sex");
        String dateOfBirth = intent.getStringExtra("dateOfBirth");
        String dateHired = intent.getStringExtra("dateHired");

        if (sex == "F"){
            pfp.setImageResource(R.drawable.female_icon);
        } else {
            pfp.setImageResource(R.drawable.male_icon);
        }

        nameTV.setText("Name: " + name);
        emailTV.setText("User Email: " + email);
        idTV.setText("Employee ID: " + id);
        sexTV.setText("Sex: " + sex);
        birthTV.setText("Date of Birth: " + dateOfBirth);
        hiredTV.setText("Date Hired: " + dateHired);

        // Set an OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate back to the UserManagement activity
                Intent intent = new Intent(ProfileInfoAdmin.this, UserManagement.class);

                // Start the UserManagement activity
                startActivity(intent);

                // Finish the current activity (profile_information_admin_side)
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
                Intent intent = new Intent(ProfileInfoAdmin.this, AdminRecordsPage1.class);

                // Start the View Records activity
                startActivity(intent);
            }
        });

        // Find the progress bars in the layout by their IDs
        progressBarLesson1 = findViewById(R.id.progressBar_lesson1);
        progressBarLesson2 = findViewById(R.id.progressBar_lesson2);
        progressBarLesson3 = findViewById(R.id.progressBar_lesson3);

        View layout1 = getLayoutInflater().inflate(R.layout.view_lesson1_topic1, null);
        scrollViewLessons1 = layout1.findViewById(R.id.scrollViewT1);

        View layout2 = getLayoutInflater().inflate(R.layout.view_lesson1_topic2, null);
        scrollViewLessons2 = layout2.findViewById(R.id.LessonView2ScrollView);

        View layout3 = getLayoutInflater().inflate(R.layout.view_lesson1_topic3, null);
        scrollViewLessons3 = layout3.findViewById(R.id.LessonView3ScrollView);

        // Set OnScrollChangeListeners for the ScrollViews
        scrollViewLessons1.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                // Update progress based on scroll position for ProgressBar1
                updateProgress(progressBarLesson1, scrollViewLessons1);
            }
        });

        scrollViewLessons2.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                // Update progress based on scroll position for ProgressBar2
                updateProgress(progressBarLesson2, scrollViewLessons2);
            }
        });

        scrollViewLessons3.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                // Update progress based on scroll position for ProgressBar3
                updateProgress(progressBarLesson3, scrollViewLessons3);
            }
        });
    }

    // Method to update progress based on scroll position
    private void updateProgress(ProgressBar progressBar, ScrollView scrollView) {
        // Calculate progress based on your scroll position and the ScrollView's content height
        int maxScroll = scrollView.getChildAt(0).getHeight() - scrollView.getHeight();
        int scrollY = scrollView.getScrollY();
        int progress = (int) ((float) scrollY / maxScroll * 100);

        // Update progress bars
        progressBar.setProgress(progress);
    }

}
