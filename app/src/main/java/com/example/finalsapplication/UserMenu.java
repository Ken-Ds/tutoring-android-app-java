package com.example.finalsapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;


public class UserMenu extends AppCompatActivity implements View.OnClickListener {

    private CardView lessons, profile, records, about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_menu);

        lessons = (CardView) findViewById(R.id.toLessons);
        records = (CardView) findViewById(R.id.toRecords);
        profile = (CardView) findViewById(R.id.toProfile);
        about = (CardView) findViewById(R.id.toAbout);

        lessons.setOnClickListener(this);
        records.setOnClickListener(this);
        profile.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        if (v.getId() == R.id.toLessons){
            i = new Intent(this, ViewLesson1.class);
            startActivity(i);
        } else if (v.getId() == R.id.toProfile) {
            i = new Intent(this, ProfileInfoUser.class);
            startActivity(i);
        } else if (v.getId() == R.id.toRecords){
            i = new Intent(this, RecordsPage1.class);
            startActivity(i);
        } else if (v.getId() == R.id.toAbout) {
            i = new Intent(this, AboutUs.class);
            startActivity(i);
        }
    }
}