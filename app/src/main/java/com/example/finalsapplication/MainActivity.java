package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonLogIn = findViewById(R.id.buttonLogIn);
        final EditText editTextCompanyPassword = findViewById(R.id.editTextCompanyPassword);
        final EditText editTextCompanyEmail = findViewById(R.id.editTextCompanyEmail);

    }
}