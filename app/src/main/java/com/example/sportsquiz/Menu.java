package com.example.sportsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton futbol;
    ImageButton box;
    ImageButton americano;
    ImageButton beisbol;
    ImageButton f1;
    ImageButton basquetbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        futbol=(ImageButton) findViewById(R.id.ibfutbol);
        box=(ImageButton) findViewById(R.id.ibbox);
        americano=(ImageButton) findViewById(R.id.ibamericano);
        beisbol=(ImageButton) findViewById(R.id.ibbeisbol);
        f1=(ImageButton) findViewById(R.id.ibf1);
        basquetbol=(ImageButton) findViewById(R.id.ibbasquebol);

        futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, futbol.class);
                startActivity(intent);
            }
        });

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, box.class);
                startActivity(intent);
            }
        });

        americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, americano.class);
                startActivity(intent);
            }
        });

        beisbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, beisbol.class);
                startActivity(intent);
            }
        });

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, f1.class);
                startActivity(intent);
            }
        });

        basquetbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, basquetbol.class);
                startActivity(intent);
            }
        });
    }
}
