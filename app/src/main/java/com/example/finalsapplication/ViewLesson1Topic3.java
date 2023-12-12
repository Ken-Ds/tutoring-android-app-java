package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ViewLesson1Topic3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lesson1_topic3);

        final ImageButton imageButtonBackVL1 = findViewById(R.id.imageButtonBackVL1);
        final ImageButton imageButtonNextVL1 = findViewById(R.id.imageButtonNextVL1);
        imageButtonBackVL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLesson1Topic3.this, ViewLesson1Topic2.class);
                startActivity(intent);
            }
        });

        imageButtonNextVL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLesson1Topic3.this, UserTestPage.class);
                startActivity(intent);
            }
        });
    }

}