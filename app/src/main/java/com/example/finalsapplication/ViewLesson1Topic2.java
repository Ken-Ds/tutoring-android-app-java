package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ViewLesson1Topic2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lesson1_topic2);
        final ImageButton imageButtonBackVL1 = findViewById(R.id.imageButtonBackVL1);
        final ImageButton imageButtonNextVL1 = findViewById(R.id.imageButtonNextVL1);

        imageButtonBackVL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLesson1Topic2.this, ViewLesson1.class);
                startActivity(intent);
            }
        });

        imageButtonNextVL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLesson1Topic2.this, ViewLesson1Topic3.class);
                startActivity(intent);
            }
        });
    }
}