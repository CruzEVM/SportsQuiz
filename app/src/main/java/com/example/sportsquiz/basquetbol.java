package com.example.sportsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class basquetbol extends AppCompatActivity {

    TextView quiztext, aans, bans, cans, dans;
    List<QuesitionsItem> quesitionsItems;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basquetbol);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.basquetbol));
        quiztext = findViewById(R.id.quizText);
        aans = findViewById(R.id.aanswer);
        bans = findViewById(R.id.banswer);
        cans = findViewById(R.id.canswer);
        dans = findViewById(R.id.danswer);

        loadAllQuestions();
        Collections.shuffle(quesitionsItems);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(view -> {
            if (quesitionsItems.get(currentQuestions).getAnswer1().equals(quesitionsItems.get(currentQuestions).getCorrect())) {
                correct++;
                aans.setBackgroundResource(R.color.green);
                aans.setTextColor(getResources().getColor(R.color.white));
            } else {
                wrong++;
                aans.setBackgroundResource(R.color.red);
                aans.setTextColor(getResources().getColor(R.color.white));
            }

            if (currentQuestions < quesitionsItems.size()-1) {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionScreen(currentQuestions);
                    aans.setBackgroundResource(R.color.white);
                    aans.setTextColor(getResources().getColor(R.color.black));
                }, 1000);
            } else {
                Intent intent = new Intent(basquetbol.this, Resultados.class);
                intent.putExtra("Correctas", correct);
                intent.putExtra("Incorrectas", wrong);
                startActivity(intent);
                finish();
            }
        });

        bans.setOnClickListener(view -> {
            if (quesitionsItems.get(currentQuestions).getAnswer2().equals(quesitionsItems.get(currentQuestions).getCorrect())) {
                correct++;
                bans.setBackgroundResource(R.color.green);
                bans.setTextColor(getResources().getColor(R.color.white));
            } else {
                wrong++;
                bans.setBackgroundResource(R.color.red);
                bans.setTextColor(getResources().getColor(R.color.white));
            }

            if (currentQuestions < quesitionsItems.size()-1) {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionScreen(currentQuestions);
                    bans.setBackgroundResource(R.color.white);
                    bans.setTextColor(getResources().getColor(R.color.black));
                }, 1000);
            } else {
                Intent intent = new Intent(basquetbol.this, Resultados.class);
                intent.putExtra("Correctas", correct);
                intent.putExtra("Incorrectas", wrong);
                startActivity(intent);
                finish();
            }
        });

        cans.setOnClickListener(view -> {
            if (quesitionsItems.get(currentQuestions).getAnswer3().equals(quesitionsItems.get(currentQuestions).getCorrect())) {
                correct++;
                cans.setBackgroundResource(R.color.green);
                cans.setTextColor(getResources().getColor(R.color.white));
            } else {
                wrong++;
                cans.setBackgroundResource(R.color.red);
                cans.setTextColor(getResources().getColor(R.color.white));
            }

            if (currentQuestions < quesitionsItems.size()-1) {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionScreen(currentQuestions);
                    cans.setBackgroundResource(R.color.white);
                    cans.setTextColor(getResources().getColor(R.color.black));
                }, 1000);
            } else {
                Intent intent = new Intent(basquetbol.this, Resultados.class);
                intent.putExtra("Correctas", correct);
                intent.putExtra("Incorrectas", wrong);
                startActivity(intent);
                finish();
            }
        });

        dans.setOnClickListener(view -> {
            if (quesitionsItems.get(currentQuestions).getAnswer4().equals(quesitionsItems.get(currentQuestions).getCorrect())) {
                correct++;
                dans.setBackgroundResource(R.color.green);
                dans.setTextColor(getResources().getColor(R.color.white));
            } else {
                wrong++;
                dans.setBackgroundResource(R.color.red);
                dans.setTextColor(getResources().getColor(R.color.white));
            }

            if (currentQuestions < quesitionsItems.size()-1) {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionScreen(currentQuestions);
                    dans.setBackgroundResource(R.color.white);
                    dans.setTextColor(getResources().getColor(R.color.black));
                }, 1000);
            } else {
                Intent intent = new Intent(basquetbol.this, Resultados.class);
                intent.putExtra("Correctas", correct);
                intent.putExtra("Incorrectas", wrong);
                startActivity(intent);
                finish();
            }
        });
    }
    private void setQuestionScreen(int currentQuestions) {
        quiztext.setText(quesitionsItems.get(currentQuestions).getQuestions());
        aans.setText(quesitionsItems.get(currentQuestions).getAnswer1());
        bans.setText(quesitionsItems.get(currentQuestions).getAnswer2());
        cans.setText(quesitionsItems.get(currentQuestions).getAnswer3());
        dans.setText(quesitionsItems.get(currentQuestions).getAnswer4());
    }

    private void loadAllQuestions() {
        quesitionsItems = new ArrayList<>();
        String jsonquiz = loadJsonFromAsset();
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("Basquetbol");
            for (int i = 0; i < questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String answer4String = question.getString("answer4");
                String correctString = question.getString("correct");

                quesitionsItems.add(new QuesitionsItem(questionsString, answer1String, answer2String, answer3String, answer4String, correctString));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset() {
        String json = "";
        try {
            InputStream inputStream = getAssets().open("Basquetbol.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(basquetbol.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("¿Seguro que quieres salir de la cuestionario?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, (dialogInterface, i) -> dialogInterface.dismiss());
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, (dialogInterface, i) -> finish());
        materialAlertDialogBuilder.show();
    }
}