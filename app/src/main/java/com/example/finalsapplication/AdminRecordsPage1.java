package com.example.finalsapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AdminRecordsPage1 extends AppCompatActivity {
    private ImageButton backButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_records_page1);

        backButton = (ImageButton) findViewById(R.id.backButton);

        back();
    }

    public void back(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminRecordsPage1.this, AdminMenu.class);
                startActivity(i);
            }
        });
    }
}
