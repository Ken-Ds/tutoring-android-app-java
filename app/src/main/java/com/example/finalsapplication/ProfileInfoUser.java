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

        if ("F".equals(accDetails.getSex())) {
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

    }

    private String retrieveAuthToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString(AUTH_TOKEN_KEY, null);
    }
}
