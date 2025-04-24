package com.example.circleindicator3_viewpager2.adapters;

import android.view.View;
import android.widget.ImageView;

import com.example.circleindicator3_viewpager2.models.Images;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circleindicator3_viewpager2.R;

public class ImagesViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    public ImagesViewHolder (@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgView);
    }

    public void bindImage(int imageResId) {
        imageView.setImageResource(imageResId);
    }
}

