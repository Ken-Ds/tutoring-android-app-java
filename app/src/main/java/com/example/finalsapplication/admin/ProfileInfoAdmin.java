package com.example.finalsapplication.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.R;

public class ProfileInfoAdmin extends AppCompatActivity {

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
        int score = Integer.parseInt(intent.getStringExtra("score"));

        if ("F".equals(sex)) {
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
                intent.putExtra("score",score);

                // Start the View Records activity
                startActivity(intent);
            }
        });
    }

}
