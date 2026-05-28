package com.example.java_project;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class OtelActivity extends AppCompatActivity {

    private ViewPager2 hotelImagePager;
    private LinearLayout detailBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * Önce bu Activity'nin XML tasarımını ekrana bağlıyoruz.
         * findViewById bundan sonra kullanılmalı.
         */
        setContentView(R.layout.activity_otel);

        /*
         * XML içindeki ViewPager2'yi Java tarafına bağlıyoruz.
         */
        hotelImagePager = findViewById(R.id.hotelImagePager);

        /*
         * ViewPager2 içinde gösterilecek otel resimleri.
         */
        int[] images = {
                R.drawable.otel2,
                R.drawable.otel2,
                R.drawable.otel2
        };

        /*
         * Adapter, resimleri ViewPager2'ye bağlar.
         */
        HotelImageAdapter adapter = new HotelImageAdapter(images);
        hotelImagePager.setAdapter(adapter);

        /*
         * Sol üst geri butonu.
         */
        detailBackButton = findViewById(R.id.detailBackButton);

        detailBackButton.setOnClickListener(view -> {
            finish();
        });
    }
}