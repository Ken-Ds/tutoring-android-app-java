package com.example.finalsapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalsapplication.R;
import com.example.finalsapplication.dataType.DatabaseHelper;

public class Delete extends AppCompatActivity {

    private ScrollView scrollViewLessons1;
    private ScrollView scrollViewLessons2;
    private ScrollView scrollViewLessons3;

    private ImageButton deleteButton;

    private TextView nameTV, emailTV, idTV, sexTV, birthTV, hiredTV;
    private ImageView pfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

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

        if ("F".equals(sex)){
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
                Intent intent = new Intent(Delete.this, UserManagement.class);

                // Start the UserManagement activity
                startActivity(intent);

                // Finish the current activity (profile_information_admin_side)
                finish();
            }
        });

        View layout1 = getLayoutInflater().inflate(R.layout.view_lesson1_topic1, null);
        scrollViewLessons1 = layout1.findViewById(R.id.scrollViewT1);

        View layout2 = getLayoutInflater().inflate(R.layout.view_lesson1_topic2, null);
        scrollViewLessons2 = layout2.findViewById(R.id.LessonView2ScrollView);

        View layout3 = getLayoutInflater().inflate(R.layout.view_lesson1_topic3, null);
        scrollViewLessons3 = layout3.findViewById(R.id.LessonView3ScrollView);

        deleteButton = (ImageButton) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(Delete.this);
                Intent intent = getIntent();
                Integer id = Integer.parseInt(intent.getStringExtra("id"));
                db.deleteAccount(id);
                Toast.makeText(Delete.this, "Account Deleted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Delete.this, UserManagement.class);
                startActivity(i);
            }
        });
    }


}