package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    private LinearLayout detailBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * RegisterActivity açıldığında activity_register.xml ekrana basılır.
         */
        setContentView(R.layout.activity_galery);

        detailBackButton = findViewById(R.id.galleryBackButton);

        detailBackButton.setOnClickListener(view -> {
            Intent intent = new Intent(GalleryActivity.this, OtelActivity.class);
            startActivity(intent);
            finish();
        });

    }
}