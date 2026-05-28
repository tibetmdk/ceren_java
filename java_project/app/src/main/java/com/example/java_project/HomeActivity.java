package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout firstHotelCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * HomeActivity açıldığında activity_home.xml ekrana basılır.
         */
        setContentView(R.layout.activity_home);

        /*
         * XML içindeki ilk otel kartını Java tarafına bağlıyoruz.
         */
        firstHotelCard = findViewById(R.id.firstHotelCard);

        /*
         * İlk otel kartına basıldığında OtelActivity sayfası açılır.
         */
        firstHotelCard.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, OtelActivity.class);
            startActivity(intent);
        });
    }
}