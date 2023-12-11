package com.example.finalsapplication;

public class Question {
    private String questionText;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String correctAnswer;

    public Question(String questionText, String choiceA, String choiceB, String choiceC , String correctAnswer){
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
