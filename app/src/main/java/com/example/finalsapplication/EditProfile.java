package com.example.finalsapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
    private ImageButton backButton, profileEdit;
    private static final int PICK_IMAGE_REQUEST = 99;
    private Uri imagePath;
    private Bitmap imageToStore;
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
        profileEdit = (ImageButton) findViewById(R.id.imageButtonProfileEdit);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String id = intent.getStringExtra("id");

        getTextName.setText(name);
        getTextEmail.setText(email);
        getTextEmployeeID.setText(id);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = String.valueOf(getTextName.getText());
                String newEmail = String.valueOf(getTextEmail.getText());
                String newId = String.valueOf(getTextEmployeeID.getText());

                if(newName.isEmpty()){
                    Toast.makeText(EditProfile.this,"The Name Field Is Empty",Toast.LENGTH_SHORT).show();
                } else if(newEmail.isEmpty()){
                    Toast.makeText(EditProfile.this,"The Email Field Is Empty",Toast.LENGTH_SHORT).show();
                } else if(newId.isEmpty()){
                    Toast.makeText(EditProfile.this,"The Id Field Is Empty",Toast.LENGTH_SHORT).show();
                } else {
                    db.updateAccount(name, newName, newEmail, Integer.parseInt(newId));
                    Toast.makeText(EditProfile.this, "Update Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditProfile.this,UserManagement.class);
                startActivity(i);
            }
        });

        profileEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
                imagePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                profileEdit.setImageBitmap(imageToStore);
            }

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}