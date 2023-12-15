package com.example.finalsapplication.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.finalsapplication.MainActivity;
import com.example.finalsapplication.R;
import com.example.finalsapplication.UserMenu;
import com.example.finalsapplication.admin.AddUser;
import com.example.finalsapplication.admin.DeleteAccount;
import com.example.finalsapplication.admin.EditAccount;
import com.example.finalsapplication.admin.ViewAccount;

public class AdminMenu extends AppCompatActivity implements View.OnClickListener {

    private CardView add, edit, del, view;
    private ImageButton logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu);

        add = (CardView) findViewById(R.id.toAdd);
        del = (CardView) findViewById(R.id.toDelete);
        view = (CardView) findViewById(R.id.toView);
        edit = (CardView) findViewById(R.id.toEdit);
        logout = findViewById(R.id.btnLogout);

        add.setOnClickListener(this);
        del.setOnClickListener(this);
        edit.setOnClickListener(this);
        view.setOnClickListener(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminMenu.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(AdminMenu.this, "Successfully logged out", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        if (v.getId() == R.id.toAdd) {
            i = new Intent(this, AddUser.class);
            startActivity(i);
        } else if (v.getId() == R.id.toEdit) {
            i = new Intent(this, EditAccount.class);
            startActivity(i);
        } else if (v.getId() == R.id.toView) {
            i = new Intent(this, ViewAccount.class);
            startActivity(i);
        } else if (v.getId() == R.id.toDelete) {
            i = new Intent(this, DeleteAccount.class);
            startActivity(i);
        }
    }
}