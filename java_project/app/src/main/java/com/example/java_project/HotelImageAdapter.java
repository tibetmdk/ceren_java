package com.example.java_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotelImageAdapter extends RecyclerView.Adapter<HotelImageAdapter.ImageViewHolder> {

    private int[] images;
    private OnImageClickListener listener;

    public interface OnImageClickListener {
        void onImageClick();
    }

    public HotelImageAdapter(int[] images, OnImageClickListener listener) {
        this.images = images;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel_image, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.hotelImage.setImageResource(images[position]);

        holder.hotelImage.setOnClickListener(view -> {
            if (listener != null) {
                listener.onImageClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView hotelImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelImage = itemView.findViewById(R.id.hotelImage);
        }
    }
}