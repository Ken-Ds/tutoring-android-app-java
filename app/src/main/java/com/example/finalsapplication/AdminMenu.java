package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMenu extends AppCompatActivity implements View.OnClickListener {

    private CardView lessons, user, test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu);

        lessons = (CardView) findViewById(R.id.ad_toLessons);
        user = (CardView) findViewById(R.id.toUserMan) ;
        test = (CardView) findViewById(R.id.toTest);

        lessons.setOnClickListener(this);
        user.setOnClickListener(this);
        test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        if (v.getId() == R.id.ad_toLessons) {
            i = new Intent(this, LessonsPageAdmin2.class);
            startActivity(i);
        } else if (v.getId() == R.id.toUserMan) {
            i = new Intent(this, AddUser.class);
            startActivity(i);
        } else if (v.getId() == R.id.toTest) {
            i = new Intent(this, TestPageAdmin2.class);
            startActivity(i);
        }
    }
}