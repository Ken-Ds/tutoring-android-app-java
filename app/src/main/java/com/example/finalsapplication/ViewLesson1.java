package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewLesson1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_view1);

        final ImageButton imageButtonBackVL1 = findViewById(R.id.imageButtonBackVL1);
        final ImageButton imageButtonNextVL1 = findViewById(R.id.imageButtonNextVL1);

    }
}
