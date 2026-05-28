package com.example.java_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * LoginActivity açıldığında activity_login.xml ekrana basılır.
         */
        setContentView(R.layout.activity_login);
    }
}