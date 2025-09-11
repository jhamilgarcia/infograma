package com.example.infogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infogram.view.containeActivity;
import com.example.infogram.view.createAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void goCreateAcoont(View view){
        startActivity(new Intent(this, createAccountActivity.class));
    }

    public void login(View view) {
        startActivity(new Intent(this, containeActivity.class));
    }
}