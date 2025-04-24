package com.example.circleindicator3_viewpager2.models;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

public class DepthPageTransformer implements ViewPager2.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        if (position <= -1) { // [-Infinity,-1)
            // Page is off-screen to the left
            view.setAlpha(0f);
        } else if (position <= 0) { // [-1,0]
            // Default slide transition when moving left
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setTranslationZ(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);
        } else if (position <= 1) { // (0,1]
            // Fade out and scale down
            view.setAlpha(1 - position);
            view.setTranslationX(pageWidth * -position);
            view.setTranslationZ(-1f);
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else { // (1,+Infinity)
            // Page is off-screen to the right
            view.setAlpha(0f);
        }
    }
}
