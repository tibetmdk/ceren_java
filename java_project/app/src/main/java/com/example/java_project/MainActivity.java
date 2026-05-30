package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton loginButton;
    private AppCompatButton registerButton;
    private TextView registerLinkText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * MainActivity açıldığında activity_main.xml ekrana basılır.
         */
        setContentView(R.layout.activity_main);

        /*
         * XML içindeki butonları Java tarafına bağlıyoruz.
         */
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        registerLinkText = findViewById(R.id.registerLinkText);

        /*
         * Log In butonuna basınca LoginActivity açılır.
         */
        loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        /*
         * Register butonuna basınca RegisterActivity açılır.
         */
        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        /*
         * Alttaki Register yazısına basınca da RegisterActivity açılır.
         */
        registerLinkText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}