package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AmenityActivity extends AppCompatActivity {

    private LinearLayout detailBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * RegisterActivity açıldığında activity_register.xml ekrana basılır.
         */
        setContentView(R.layout.activity_amenities);

        detailBackButton = findViewById(R.id.amenitiesBackButton);

        detailBackButton.setOnClickListener(view -> {
            Intent intent = new Intent(AmenityActivity.this, OtelActivity.class);
            startActivity(intent);
            finish();
        });
    }
}