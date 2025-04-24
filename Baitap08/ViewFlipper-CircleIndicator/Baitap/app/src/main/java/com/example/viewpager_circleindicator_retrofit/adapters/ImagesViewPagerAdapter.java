package com.example.viewpager_circleindicator_retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.viewpager_circleindicator_retrofit.R;
import com.example.viewpager_circleindicator_retrofit.models.*;

import java.util.List;


public class ImagesViewPagerAdapter extends PagerAdapter{
    private Context context;
    private List<ImagesSlider> imagesList;

    public ImagesViewPagerAdapter(Context context, List<ImagesSlider> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_images, container, false);
        ImageView imageView = view.findViewById(R.id.imgView);

        ImagesSlider images = imagesList.get(position);
        Glide.with(context).load(images.getAvatar()).into(imageView);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject (@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem (@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
