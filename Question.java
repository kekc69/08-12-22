package com.example.quiz;

public class Question {
    int difficulty;
    String answer;
    String content;

    public Question(int difficulty, String answer, String content) {
        this.difficulty = difficulty;
        this.answer = answer;
        this.content = content;
    }

    boolean isCorrect(String userAnswer){
        return answer.equals(userAnswer);
    }

    int givePoints(){
        return difficulty * 5;
    }
}
