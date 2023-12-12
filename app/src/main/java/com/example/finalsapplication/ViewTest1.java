package com.example.finalsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewTest1 extends AppCompatActivity {

    //private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int attempts = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_test_page);

        /*
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
    }
    private List<Question> generateQuestions () {
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.add(new Question("Lorem ipsum dolor sit amet?", "A", "B", "C", "A"));

        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, 5);
    }

    private void showQuestions() {
        Question currentQuestion= questions.get(currentQuestionIndex);

        TextView questionTextView = findViewById(R.id.textViewQ1);
        questionTextView.setText(currentQuestion.getQuestionText());

        RadioButton choiceARadioButton = findViewById(R.id.radioButtonA1);
        choiceARadioButton.setText(currentQuestion.getChoiceA());

        RadioButton choiceBRadioButton = findViewById(R.id.radioButtonB1);
        choiceBRadioButton.setText(currentQuestion.getChoiceB());

        RadioButton choiceCRadioButton = findViewById(R.id.radioButtonC1);
        choiceCRadioButton.setText(currentQuestion.getChoiceC());
    }

    private void checkAnswer() {
        RadioGroup radioGroup = findViewById(R.id.radio_group1);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        if (selectedRadioButton != null) {
            String selectedAnswer = selectedRadioButton.getText().toString();
            Question currentQuestion = questions.get(currentQuestionIndex);

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
        Intent intent = new Intent(this, SubmissionPageFailed1.class);
        startActivity(intent);
        finish();
    }

 */
    }

}

