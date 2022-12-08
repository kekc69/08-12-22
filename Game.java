package com.example.quiz;

public class Game {
    Player player;
    QuestionGroup questionGroup;

    Game(String name){
        player = new Player(name);
        Question[] questions = new Question[] {
                new Question(0,"2", "4 - 2 = ?"),
                new Question(2,"0", "Сколько корней имеет уравнение 2x^2 + 2x + 20 = 0")
        };

        questionGroup = new QuestionGroup(questions, 3, "Математика");
    }

    Question qetCurrentQuestion(){
        return questionGroup.getCurrent();
    }

    void next(){
        questionGroup.current++;
    }

    boolean isEnd(){
        return questionGroup.current == questionGroup.count;
    }

}

