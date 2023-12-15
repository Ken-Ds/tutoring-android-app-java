package com.example.finalsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserTestPageOld extends AppCompatActivity {
    private List<QuestionDetails> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_test_page_old);

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
    }

    private List<UserTestPageOld.QuestionDetails> generateQuestions() {
        List<UserTestPageOld.QuestionDetails> allQuestions = new ArrayList<>();

        allQuestions.add(new UserTestPageOld.QuestionDetails("Lorem ipsum dolor sit amet?", "A", "B", "C", "A"));

        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(5, allQuestions.size()));
    }

    private void showQuestions() {
        if (currentQuestionIndex < questions.size()) {
            QuestionDetails currentQuestion = questions.get(currentQuestionIndex);
            TextView questionTextView = findViewById(R.id.textViewQ1);
            questionTextView.setText(currentQuestion.getQuestionText());

            RadioButton choiceARadioButton = findViewById(R.id.radioButtonA1);
            choiceARadioButton.setText(currentQuestion.getChoiceA());

            RadioButton choiceBRadioButton = findViewById(R.id.radioButtonB1);
            choiceBRadioButton.setText(currentQuestion.getChoiceB());

            RadioButton choiceCRadioButton = findViewById(R.id.radioButtonC1);
            choiceCRadioButton.setText(currentQuestion.getChoiceC());
        } else {
            Button submitButton = findViewById(R.id.buttonSubmitVT1);
            submitButton.setEnabled(false);
            Toast.makeText(this, "No more questions available. ", Toast.LENGTH_SHORT).show();
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

    private static class QuestionDetails {
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
}
