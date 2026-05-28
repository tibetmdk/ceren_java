package com.example.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class OtelActivity extends AppCompatActivity {

    private ViewPager2 hotelImagePager;
    private LinearLayout detailBackButton;
    private TextView reviewsText;
    private TextView seeAllFacilitiesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * Önce bu Activity'nin XML tasarımını ekrana bağlıyoruz.
         * findViewById her zaman setContentView'dan sonra kullanılmalı.
         */
        setContentView(R.layout.activity_otel);

        /*
         * Üstteki otel resim slider'ını bağlıyoruz.
         */
        hotelImagePager = findViewById(R.id.hotelImagePager);

        int[] images = {
                R.drawable.otel2,
                R.drawable.otel2,
                R.drawable.otel2
        };

        HotelImageAdapter adapter = new HotelImageAdapter(images, () -> {
            Intent intent = new Intent(OtelActivity.this, GalleryActivity.class);
            startActivity(intent);
        });

        hotelImagePager.setAdapter(adapter);

        /*
         * Sol üst geri butonu.
         * Bu butona basınca HomeActivity açılır.
         */
        detailBackButton = findViewById(R.id.detailBackButton);

        detailBackButton.setOnClickListener(view -> {
            Intent intent = new Intent(OtelActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        /*
         * Reviews yazısına basınca ReviewsActivity açılır.
         */
        reviewsText = findViewById(R.id.reviewsText);

        reviewsText.setOnClickListener(view -> {
            Intent intent = new Intent(OtelActivity.this, ReviewsActivity.class);
            startActivity(intent);
        });

        /*
         * Popular Facilities yanındaki See all yazısına basınca
         * AmenityActivity açılır.
         */
        seeAllFacilitiesText = findViewById(R.id.seeAllFacilitiesText);

        seeAllFacilitiesText.setOnClickListener(view -> {
            Intent intent = new Intent(OtelActivity.this, AmenityActivity.class);
            startActivity(intent);
        });
    }
}