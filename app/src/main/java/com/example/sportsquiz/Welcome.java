package com.example.sportsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Welcome extends AppCompatActivity {

    Button comenzar;
    Button instruccciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        comenzar = findViewById(R.id.comenzar);
        comenzar.setOnClickListener(view -> {
            Intent intent = new Intent(Welcome.this, Menu.class);
            startActivity(intent);
        });

        instruccciones = findViewById(R.id.Instrucciones);
        instruccciones.setOnClickListener(view -> {
            Intent intent = new Intent(Welcome.this, Instrucciones.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(Welcome.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("¿Estás seguro de que deseas cerrar la aplicación?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, (dialogInterface, i) -> dialogInterface.dismiss());
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, (dialogInterface, i) -> finish());
        materialAlertDialogBuilder.show();
    }
}