package com.example.sportsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Resultados extends AppCompatActivity {

    MaterialCardView home;
    TextView correctt, wrongt, resultinfo, resultscore;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        home = findViewById(R.id.returnHome);
        correctt = findViewById(R.id.correctScore);
        wrongt = findViewById(R.id.wrongScore);
        resultinfo = findViewById(R.id.resultInfo);
        resultscore = findViewById(R.id.resultScore);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("Correctas", 0);
        int wrong = getIntent().getIntExtra("Incorrectas", 0);
        int score = correct * 10;

        correctt.setText("" + correct);
        wrongt.setText("" + wrong);
        resultscore.setText("" + score);

        if (correct >= 0 && correct <= 2) {
            resultinfo.setText("You have to take the test again");
            resultImage.setImageResource(R.drawable.basquelbol);
        } else if (correct >= 3 && correct <= 5) {
            resultinfo.setText("You have to try a little more");
            resultImage.setImageResource(R.drawable.americano);
        } else if (correct >= 6 && correct <= 8) {
            resultinfo.setText("You are pretty good");
            resultImage.setImageResource(R.drawable.f1);
        } else {
            resultinfo.setText("You are very good congratulations");
            resultImage.setImageResource(R.drawable.futbol);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Resultados.this, Menu.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Resultados.this, Menu.class));
        finish();
    }

}