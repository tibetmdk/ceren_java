package com.example.java_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * RegisterActivity açıldığında activity_register.xml ekrana basılır.
         */
        setContentView(R.layout.activity_reviews);
    }
}