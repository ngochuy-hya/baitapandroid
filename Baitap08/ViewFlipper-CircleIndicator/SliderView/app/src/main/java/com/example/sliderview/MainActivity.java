package com.example.sliderview;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sliderview.adapters.SliderAdapter;
import com.example.sliderview.models.DepthPageTransformer;

import java.util.Arrays;
import java.util.List;
import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private CircleIndicator3 indicator;
    private Handler sliderHandler;
    private Runnable sliderRunnable;
    private final List<Integer> images = Arrays.asList(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager2);
        indicator = findViewById(R.id.indicator);

        // Setup Adapter
        SliderAdapter adapter = new SliderAdapter(images);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        // Auto-scroll
        sliderHandler = new Handler();
        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                int nextItem = (viewPager.getCurrentItem() + 1) % images.size();
                viewPager.setCurrentItem(nextItem);
                sliderHandler.postDelayed(this, 3000);
            }
        };

        // Reset timer on manual scroll
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
        viewPager.setPageTransformer(new DepthPageTransformer());
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}