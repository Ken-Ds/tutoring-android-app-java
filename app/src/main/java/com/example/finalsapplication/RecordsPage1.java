package com.example.finalsapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecordsPage1 extends AppCompatActivity {

    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records_page1);

        back = (ImageButton) findViewById(R.id.backButton);
        back();
    }

    public void back(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecordsPage1.this, UserMenu.class);
                startActivity(i);
            }
        });
    }
}
