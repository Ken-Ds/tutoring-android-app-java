package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewTest1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_view1);

        final ImageButton imageButtonBackVT1 = findViewById(R.id.imageButtonBackVT1);
        final Button buttonSubmit = findViewById(R.id.buttonSubmitVT1);

    }
}