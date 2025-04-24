package com.example.circleindicator3_viewpager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.circleindicator3_viewpager2.adapters.ImagesViewPager2Adapter;
import com.example.circleindicator3_viewpager2.models.DepthPageTransformer;
import com.example.circleindicator3_viewpager2.models.Images;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList;
    private Handler handler = new Handler(Looper.getMainLooper());
    private ViewPager2.OnPageChangeCallback pageChangeCallback;

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == imagesList.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
            handler.postDelayed(this, 3000);
        }
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        viewPager2 = findViewById(R.id.viewPager2);
        circleIndicator3 = findViewById(R.id.circleIndicator3);

        // Setup images list
        imagesList = getListImages();

        // Setup ViewPager2 adapter
        ImagesViewPager2Adapter adapter = new ImagesViewPager2Adapter(imagesList);
        viewPager2.setAdapter(adapter);

        // Setup CircleIndicator3
        circleIndicator3.setViewPager(viewPager2);

        // Setup PageTransformer
        viewPager2.setPageTransformer(new DepthPageTransformer()); // or new ZoomOutPageTransformer()

        // Setup auto-scroll with page change callback
        pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        };
        viewPager2.registerOnPageChangeCallback(pageChangeCallback);

        // Start auto-scroll
        handler.postDelayed(runnable, 3000);
    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.quangcao));
        list.add(new Images(R.drawable.coffee));
        list.add(new Images(R.drawable.companypizza));
        list.add(new Images(R.drawable.themoingon));
        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up to prevent memory leaks
        handler.removeCallbacks(runnable);
        viewPager2.unregisterOnPageChangeCallback(pageChangeCallback);
    }
}