package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String emailInput;
    private static final String AUTH_TOKEN_KEY = "auth_token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonLogIn = findViewById(R.id.buttonLogIn);
        final EditText editTextCompanyPassword = findViewById(R.id.editTextCompanyPassword);
        final EditText editTextCompanyEmail = findViewById(R.id.editTextCompanyEmail);
        DatabaseHelper db = new DatabaseHelper(this);

        // moves to the next field when enter key is pressed
        editTextCompanyEmail.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                editTextCompanyPassword.requestFocus(); // Move focus to the password field
                return true;
            }
            return false;
        });

        // moves to the next activity when enter key is pressed
        editTextCompanyPassword.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                buttonLogIn.performClick();
                return true;
            }
            return false;
        });
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                emailInput = editTextCompanyEmail.getText().toString();
                String passwordInput = editTextCompanyPassword.getText().toString();

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Incomplete Log In Information", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkPassword = db.checkLoginCredentials(emailInput, passwordInput);
                    if (checkPassword) {
                        Toast.makeText(MainActivity.this, "Log In Successful", Toast.LENGTH_SHORT).show();
                        if (emailInput.equals("admin@emicode.com")) {
                            Intent toAdmin = new Intent (MainActivity.this, AdminMenu.class);
                            startActivity(toAdmin);
                        } else {
                            storeAuthToken(emailInput);
                            Intent toUser = new Intent(MainActivity.this, UserMenu.class);
                            startActivity(toUser);
                        }
                    } else
                        Toast.makeText(MainActivity.this, "Log In Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void storeAuthToken(String authToken) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AUTH_TOKEN_KEY, authToken);
        editor.apply();
    }

}