package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserTestPage extends AppCompatActivity {
    private List<QuestionDetails> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int attempts = 0;

    private static final String AUTH_TOKEN_KEY = "auth_token";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_test_page);

        final ImageButton imageButtonBackVT1 = findViewById(R.id.imageButtonBackVT1);
        final Button buttonSubmit = findViewById(R.id.buttonSubmitVT1);

        questions = generateQuestions();

        showQuestions();

        Button submitButton = findViewById(R.id.buttonSubmitVT1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkAnswer();
            }
        });

        imageButtonBackVT1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToLessonPage();
            }
        });

        Log.d("Score",""+score);
    }

    private List<QuestionDetails> generateQuestions() {
        List<QuestionDetails> allQuestions = new ArrayList<>();
        // Add your questions here
        allQuestions.add(new QuestionDetails("1. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum blandit tincidunt.", "A", "B", "C", "A"));

        if (allQuestions.size() >= 5) {
            Collections.shuffle(allQuestions);
            return allQuestions.subList(0, 5);
        } else {
            // Handle the case when there are not enough questions
            return allQuestions;
        }
    }

    private void showQuestions() {
        if (currentQuestionIndex < questions.size()) {
            QuestionDetails currentQuestion = questions.get(currentQuestionIndex);
            TextView questionTextView = findViewById(R.id.textViewQ1);
            questionTextView.setText(currentQuestion.getQuestionText());

            RadioButton choiceARadioButton = findViewById(R.id.radioButtonA1);
            RadioButton choiceBRadioButton = findViewById(R.id.radioButtonB1);
            RadioButton choiceCRadioButton = findViewById(R.id.radioButtonC1);

            choiceARadioButton.setText(currentQuestion.getChoiceA());
            choiceBRadioButton.setText(currentQuestion.getChoiceB());
            choiceCRadioButton.setText(currentQuestion.getChoiceC());
        }
    }
    private void checkAnswer() {
        RadioGroup radioGroup = findViewById(R.id.radio_group1);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            QuestionDetails currentQuestion = questions.get(currentQuestionIndex);

            if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                score++;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.size()) {
                showQuestions();

            } else {
                displayScore();
            }
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayScore() {
        attempts++;

        if (score >= 3) {
            navigateToSuccessPage();
        } else if (attempts < 3) {
            questions = generateQuestions();
            currentQuestionIndex = 0;
            showQuestions();
        } else {
            navigateToFailurePage();
        }
    }

    private void navigateToFailurePage() {
        Intent intent = new Intent(this, SubmissionPageFailed1.class);
        startActivity(intent);
        finish();
    }

    private void navigateToSuccessPage() {
        Intent intent = new Intent(this, SubmissionPageSuccess1.class);
        startActivity(intent);
        finish();
    }

    private void navigateToLessonPage() {
        Intent intent = new Intent(this, ViewLesson1Topic3.class);
        startActivity(intent);
        finish();
    }

    // Inner class representing question details
    static class QuestionDetails {
        private String questionText;
        private String choiceA;
        private String choiceB;
        private String choiceC;
        private String correctAnswer;

        public QuestionDetails(String questionText, String choiceA, String choiceB, String choiceC, String correctAnswer) {
            this.questionText = questionText;
            this.choiceA = choiceA;
            this.choiceB = choiceB;
            this.choiceC = choiceC;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String getChoiceA() {
            return choiceA;
        }

        public String getChoiceB() {
            return choiceB;
        }

        public String getChoiceC() {
            return choiceC;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }

    private String retrieveAuthToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString(AUTH_TOKEN_KEY, null);
    }

    public void saveScore(){
        DatabaseHelper db = new DatabaseHelper(UserTestPage.this);
        String emailCheck = retrieveAuthToken();
        AccountInfo accDetails = db.getUserByEmail(emailCheck);

        String name = accDetails.getName();

        db.updateScore(name,score);
    }
}