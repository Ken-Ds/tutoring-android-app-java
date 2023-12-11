package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.util.TimeFormatException;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private String allowedEmail = "emilysotelo@emicode.com";
    private static final String ALLOWED_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonLogIn = findViewById(R.id.buttonLogIn);
        final EditText editTextCompanyPassword = findViewById(R.id.editTextCompanyPassword);
        final EditText editTextCompanyEmail = findViewById(R.id.editTextCompanyEmail);

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
                if (validateFields(editTextCompanyEmail, editTextCompanyPassword)) {
                    if (validateEmail(editTextCompanyEmail) && validatePassword(editTextCompanyPassword)) {
                        allowedEmail(editTextCompanyEmail); // Check if the entered email is allowed
                        logIn();
                    }
                }
            }
        });
    }


    //This method validates the email inputted by the user
    //
    private boolean validateEmail(EditText editTextCompanyEmail) {
        String emailInput = editTextCompanyEmail.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean validatePassword(EditText editTextCompanyPassword) {
        String passwordInput = editTextCompanyPassword.getText().toString();
        if (passwordInput.equals(ALLOWED_PASSWORD)) {
            return true;
        } else {
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    //This method validates if the password and email field is empty
    //
    private boolean validateFields(EditText editTextCompanyEmail, EditText editTextCompanyPassword) {
        String emailInput = editTextCompanyEmail.getText().toString();
        String passwordInput = editTextCompanyPassword.getText().toString();
        if (!emailInput.isEmpty() && !passwordInput.isEmpty()) {
            return true;
        } else {
            Toast.makeText(this, "Incomplete Log In Information", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void allowedEmail(EditText editTextCompanyEmail) {

        String enteredEmail = editTextCompanyEmail.getText().toString();

        // Check if the entered email matches the allowed email
        if (enteredEmail.equals(allowedEmail)) {
            Toast.makeText(this, "Log In Succesfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
        }
    }

    //pwede ko pa ito ipolish kaso waitings ako sa code pag sa logic na ng log in like san
    //pupunta soooooo plus ayawq na gawin tas pede ko din pagsamahin na mga methods na redundant

    private void logIn() {
        Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show();
        //  add login logic here

        //Palitan na lang hehe for testing purposes only
        Intent logInButton = new Intent(this, UserMenu.class);
        startActivity(logInButton);

    }
}