package com.example.sportsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Instrucciones extends AppCompatActivity {

    Button atr;
    Button sig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.americano));
        atr=(Button) findViewById(R.id.atr1);
        sig=(Button) findViewById(R.id.sig1);

        atr.setOnClickListener(view -> {
            Intent intent = new Intent(Instrucciones.this, Welcome.class);
            startActivity(intent);
        });

        sig.setOnClickListener(view -> {
            Intent intent = new Intent(Instrucciones.this, Ins1.class);
            startActivity(intent);
        });
    }
}