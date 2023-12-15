package com.example.finalsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        // Find the back button in your layout by its ID
        ImageButton backButton = findViewById(R.id.imageButtonBackLP1);

        // Set an OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the intent to navigate back to the UserMenu activity
                Intent intent = new Intent(AboutUs.this, UserMenu.class);

                // Start the UserMenu activity
                startActivity(intent);

                // Finish the current activity
                finish();
            }
        });
    }
}
