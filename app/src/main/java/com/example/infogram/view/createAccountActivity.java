package com.example.infogram.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.infogram.R;

public class createAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Mostrar toolbar con título y flecha
        showToolbar(getString(R.string.title_crear_cuenta), true);
    }

    private void showToolbar(String titulo, boolean botonSubir) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titulo);
            getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
        }
    }
}
