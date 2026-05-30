package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout firstHotelCard;
    private TextView homeUserNameText;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * HomeActivity açıldığında activity_home.xml ekrana basılır.
         */
        setContentView(R.layout.activity_home);

        databaseHelper = new DatabaseHelper(this);

        /*
         * Home ekranındaki kullanıcı adı TextView'ini Java tarafına bağlıyoruz.
         */
        homeUserNameText = findViewById(R.id.homeUserNameText);

        /*
         * LoginActivity'den gönderilen email'i alıyoruz.
         */
        String userEmail = getIntent().getStringExtra("user_email");

        /*
         * Eğer email geldiyse database'den kullanıcının adını çekiyoruz.
         */
        if (userEmail != null) {
            String fullName = databaseHelper.getFullNameByEmail(userEmail);
            homeUserNameText.setText(fullName);
        }

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