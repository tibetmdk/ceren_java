package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsActivity extends AppCompatActivity {

    private LinearLayout detailBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * RegisterActivity açıldığında activity_register.xml ekrana basılır.
         */
        setContentView(R.layout.activity_reviews);

        detailBackButton = findViewById(R.id.reviewsBackButton);

        detailBackButton.setOnClickListener(view -> {
            Intent intent = new Intent(ReviewsActivity.this, OtelActivity.class);
            startActivity(intent);
            finish();
        });
    }
}