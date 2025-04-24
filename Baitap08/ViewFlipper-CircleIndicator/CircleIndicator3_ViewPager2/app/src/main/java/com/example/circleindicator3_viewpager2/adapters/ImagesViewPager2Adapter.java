package com.example.circleindicator3_viewpager2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circleindicator3_viewpager2.R;
import com.example.circleindicator3_viewpager2.models.Images;

import java.util.List;

public class ImagesViewPager2Adapter extends RecyclerView.Adapter<ImagesViewPager2Adapter.ImagesViewHolder> {
    private final List<Images> imagesList;

    public ImagesViewPager2Adapter(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
        return new ImagesViewHolder(view);  // Sửa lỗi thiếu dấu `;`
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) { // Sửa tên hàm
        Images image = imagesList.get(position);
        if (image != null) {
            holder.imageView.setImageResource(image.getImagesId());
        }
    }

    @Override
    public int getItemCount() {
        return (imagesList != null) ? imagesList.size() : 0;
    }

    // ViewHolder class
    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
        }
    }
}
