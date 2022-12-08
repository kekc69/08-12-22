package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Question currentQuestion;
    Game game;
    EditText answer;
    TextView tvName, tvPoints, tvQuestion;
    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        answer = findViewById(R.id.answer);
        tvName = findViewById(R.id.tvName);
        tvPoints = findViewById(R.id.tvPoints);
        tvQuestion = findViewById(R.id.tvQuestion);
        check = findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion.isCorrect(answer.getText().toString())){
                    game.player.points += currentQuestion.givePoints();
                }
                tvPoints.setText("Счёт: " + game.player.points);
                game.next();
                if (game.isEnd()){
                    tvQuestion.setText("Игра окончена! Финальный счёт: " + game.player.points);
                    check.setEnabled(false);
                    return;
                }
                currentQuestion = game.qetCurrentQuestion();
                tvQuestion.setText(currentQuestion.content);
            }
        });

        Intent i = getIntent();
        String name = i.getStringExtra("name");

        game = new Game(name); // game starting

        tvName.setText(name);
        tvPoints.setText("0");

        currentQuestion = game.qetCurrentQuestion();
        tvQuestion.setText(currentQuestion.content);

    }
}