package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMenu extends AppCompatActivity implements View.OnClickListener {

    private CardView add, edit, del, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu);

        add = (CardView) findViewById(R.id.toAdd);
        del = (CardView) findViewById(R.id.toDelete);
        view = (CardView) findViewById(R.id.toView);
        edit = (CardView) findViewById(R.id.toEdit);

        add.setOnClickListener(this);
        del.setOnClickListener(this);
        edit.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        if (v.getId() == R.id.toAdd) {
            i = new Intent(this, AddUser.class);
            startActivity(i);
        } else if (v.getId() == R.id.toEdit) {
            i = new Intent(this, EditProfile.class);
            startActivity(i);
        } else if (v.getId() == R.id.toView) {
            i = new Intent(this, UserManagement.class);
            startActivity(i);
        } else if (v.getId() == R.id.toDelete) {
            i = new Intent(this, UserManagement.class);
            startActivity(i);
        }
    }
}