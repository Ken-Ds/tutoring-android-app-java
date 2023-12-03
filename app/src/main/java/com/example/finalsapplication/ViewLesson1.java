package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class ViewLesson1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_view1);

        final ImageButton imageButtonBack = findViewById(R.id.imageButtonBack);
        final ImageButton imageButtonNext = findViewById(R.id.imageButtonNext);
    }
}