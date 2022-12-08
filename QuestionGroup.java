package com.example.quiz;

public class QuestionGroup {
    Question[] questions;
    int count;
    String cattegory;
    int current = 0;

    public QuestionGroup(Question[] questions, int count, String cattegory) {
        this.questions = questions;
        this.count = count;
        this.cattegory = cattegory;
    }

    Question getCurrent(){
        return questions[current];
    }
}
