package com.example.finalsapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

public class AddUser extends AppCompatActivity {

    private EditText nameET, idET, emailET, passwordET, date_hiredET, date_birthET;
    private RadioGroup sexRG;
    private RadioButton chosenRB;
    private DatabaseHelper DB;
    private ImageView pfp;
    private static final int PICK_IMAGE_REQUEST = 99;
    private Uri imagePath;
    private Bitmap imageToStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);

        nameET = findViewById(R.id.editTextNameAU);
        idET = findViewById(R.id.editTextEmployeeIDAU);
        emailET = findViewById(R.id.editTextEmailAU);
        passwordET = findViewById(R.id.editTextPasswordAU);
        sexRG = findViewById(R.id.radioButtonSex);
        date_hiredET = findViewById(R.id.editTextDateHiredAU);
        date_birthET = findViewById(R.id.editTextBirthDateAU);
        pfp = findViewById(R.id.imageView);
        Button upload = findViewById(R.id.buttonUploadPictureAU);
        Button submit = findViewById(R.id.buttonSubmitVT1);
        ImageButton back = findViewById(R.id.imageButtonBackVT1);
        DB = new DatabaseHelper(this);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex = "F";
                try {
                    int radioID = sexRG.getCheckedRadioButtonId();
                    chosenRB = findViewById(radioID);
                    sex = chosenRB.getText().toString();
                } catch (NullPointerException ex){
                    Toast.makeText(AddUser.this, "Sex field is empty", Toast.LENGTH_SHORT).show();
                }


                String name = nameET.getText().toString();
                String id = idET.getText().toString();
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                String date_hired = date_hiredET.getText().toString();
                String date_birth = date_birthET.getText().toString();

               if (name.isEmpty()) {
                   Toast.makeText(AddUser.this, "Name field is empty", Toast.LENGTH_SHORT).show();
               } else if (id.isEmpty()) {
                   Toast.makeText(AddUser.this, "ID field is empty", Toast.LENGTH_SHORT).show();
               } else if (email.isEmpty()) {
                   Toast.makeText(AddUser.this, "Email field is empty", Toast.LENGTH_SHORT).show();
               } else if (password.isEmpty()) {
                   Toast.makeText(AddUser.this, "Password field is empty", Toast.LENGTH_SHORT).show();
               } else if (date_hired.isEmpty()) {
                   Toast.makeText(AddUser.this, "Date hired field is empty", Toast.LENGTH_SHORT).show();
               } else if (date_birth.isEmpty()) {
                   Toast.makeText(AddUser.this, "Date of birth field is empty", Toast.LENGTH_SHORT).show();
               } else if (pfp.getDrawable() == null || imageToStore == null) {
                   Toast.makeText(AddUser.this, "Profile Picture is empty", Toast.LENGTH_SHORT).show();
               } else {
                    AccountInfo newUser = new AccountInfo(Integer.parseInt(id), email, password, name, sex, date_birth, date_hired, imageToStore);
                    boolean checkID = DB.checkUserID(id);
                    boolean checkEmail = DB.checkUserEmail(email);
                    if  (checkID) {
                        Toast.makeText(AddUser.this, "Make sure User ID is unique", Toast.LENGTH_SHORT).show();
                    } else if (checkEmail) {
                        Toast.makeText(AddUser.this, "Make sure User Email is unique", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean insert = DB.addOne(newUser);
                        if (insert) {
                            Toast.makeText(AddUser.this, "Created User Account Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddUser.this, UserManagement.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
                imagePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                pfp.setImageBitmap(imageToStore);
            }

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }


}