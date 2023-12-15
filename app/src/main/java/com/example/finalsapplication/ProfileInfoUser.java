package com.example.finalsapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

public class ProfileInfoUser extends AppCompatActivity {

    private ProgressBar progressBarLesson1;
    private ProgressBar progressBarLesson2;
    private ProgressBar progressBarLesson3;
    private ScrollView scrollViewLessons1;
    private ScrollView scrollViewLessons2;
    private ScrollView scrollViewLessons3;

    private static final String AUTH_TOKEN_KEY = "auth_token";
    private DatabaseHelper db;
    private TextView nameTV, emailTV, idTV, sexTV, birthTV, hiredTV;
    private ImageView pfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_information_user_side);

        // Find the back button in the layout by its ID
        ImageButton backButton = findViewById(R.id.imageButtonBackLP1);
        nameTV = findViewById(R.id.user_name);
        emailTV = findViewById(R.id.user_email);
        idTV = findViewById(R.id.employee_id);
        sexTV = findViewById(R.id.user_sex);
        birthTV = findViewById(R.id.date_of_birth);
        hiredTV = findViewById(R.id.date_hired);
        pfp = findViewById(R.id.profile_pic);
        db = new DatabaseHelper(this);

        String emailCheck = retrieveAuthToken();
        AccountInfo accDetails = db.getUserByEmail(emailCheck);

        if (accDetails.getSex() == "F" ) {
            pfp.setImageResource(R.drawable.female_icon);
        } else {
            pfp.setImageResource(R.drawable.male_icon);
        }

        nameTV.setText("Name: " + accDetails.getName());
        emailTV.setText("User Email: " + accDetails.getEmail());
        idTV.setText("Employee ID: " + String.valueOf(accDetails.getId()));
        sexTV.setText("Sex: " + accDetails.getSex());
        birthTV.setText("Date of Birth: " + accDetails.getDateOfBirth());
        hiredTV.setText("Date Hired: " + accDetails.getDateHired());


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
        scrollViewLessons1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int maxScroll = scrollViewLessons1.getChildAt(0).getHeight() - scrollViewLessons1.getHeight();
                int scrollY = scrollViewLessons1.getScrollY();
                int progress = 0;

                if (maxScroll > 0) {
                    progress = (int) ((float) scrollY / maxScroll * 100);
                }

                // Log progress for debugging
                Log.d("ProgressDebug", "ScrollY: " + scrollY + ", MaxScroll: " + maxScroll + ", Progress: " + progress);

                // Update progress bar
                progressBarLesson1.setProgress(progress);

                // Remove the listener to avoid multiple calls
                scrollViewLessons1.getViewTreeObserver().removeOnPreDrawListener(this);

                return true;
            }
        });

        scrollViewLessons2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int maxScroll = scrollViewLessons2.getChildAt(0).getHeight() - scrollViewLessons2.getHeight();
                int scrollY = scrollViewLessons2.getScrollY();
                int progress = 0;

                if (maxScroll > 0) {
                    progress = (int) ((float) scrollY / maxScroll * 100);
                }

                // Log progress for debugging
                Log.d("ProgressDebug", "ScrollY: " + scrollY + ", MaxScroll: " + maxScroll + ", Progress: " + progress);

                // Update progress bar
                progressBarLesson2.setProgress(progress);

                // Remove the listener to avoid multiple calls
                scrollViewLessons2.getViewTreeObserver().removeOnPreDrawListener(this);

                return true;
            }
        });

        scrollViewLessons3.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int maxScroll = scrollViewLessons3.getChildAt(0).getHeight() - scrollViewLessons3.getHeight();
                int scrollY = scrollViewLessons3.getScrollY();
                int progress = 0;

                if (maxScroll > 0) {
                    progress = (int) ((float) scrollY / maxScroll * 100);
                }

                // Log progress for debugging
                Log.d("ProgressDebug", "ScrollY: " + scrollY + ", MaxScroll: " + maxScroll + ", Progress: " + progress);

                // Update progress bar
                progressBarLesson3.setProgress(progress);

                // Remove the listener to avoid multiple calls
                scrollViewLessons3.getViewTreeObserver().removeOnPreDrawListener(this);

                return true;
            }
        });

    }

    private String retrieveAuthToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString(AUTH_TOKEN_KEY, null);
    }
}
