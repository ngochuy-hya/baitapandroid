package com.example.sliderview.models;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class DepthPageTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position <= -1) {
            page.setAlpha(0);
        } else if (position <= 0) {
            page.setAlpha(1 + position);
            page.setTranslationX(page.getWidth() * -position);
        } else if (position <= 1) {
            page.setAlpha(1 - position);
            page.setTranslationX(page.getWidth() * -position);
        } else {
            page.setAlpha(0);
        }
    }
}
