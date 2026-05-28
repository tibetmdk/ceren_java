package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;

    private Button registerButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /*

         * Bu Activity'nin kullanacağı XML tasarım dosyası.

         */

        setContentView(R.layout.activity_main);

        /*

         * XML'deki butonları Java değişkenlerine bağlıyoruz.

         */

        loginButton = findViewById(R.id.loginButton);

        registerButton = findViewById(R.id.registerButton);

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

        TextView registerLinkText = findViewById(R.id.registerLinkText);

        registerLinkText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }

}