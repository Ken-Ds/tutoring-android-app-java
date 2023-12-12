package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

import java.util.ArrayList;

public class EditProfile extends AppCompatActivity {
    public AccountInfo acc;

    private EditText getTextName, getTextEmail ,getTextEmployeeID;
    private Button save;
    private ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        DatabaseHelper db = new DatabaseHelper(this);

        getTextName = (EditText) findViewById(R.id.editTextEditName);
        getTextEmail = (EditText) findViewById(R.id.editTextEditEmail);
        getTextEmployeeID = (EditText) findViewById(R.id.editTextEditEmployeeId);
        save = (Button) findViewById(R.id.buttonSubmitVT1);
        backButton = (ImageButton) findViewById(R.id.imageButtonBackVT1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String id = intent.getStringExtra("id");
        Log.d("name",name);

        getTextName.setText(name);
        getTextEmail.setText(email);
        getTextEmployeeID.setText(id);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = String.valueOf(getTextName.getText());
                String newEmail = String.valueOf(getTextEmail.getText());
                String newId = String.valueOf(getTextEmployeeID.getText());

                db.updateAccount(name,newName,newEmail,Integer.parseInt(newId));
                Toast.makeText(EditProfile.this,"Update Successful",Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditProfile.this,UserManagement.class);
                startActivity(i);
            }
        });

    }
}