package com.example.videoshort_api;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videoshort_api.adapters.VideosAdapter;
import com.example.videoshort_api.models.MessageVideoModel;
import com.example.videoshort_api.models.VideoModel;
import com.example.videoshort_api.services.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private VideosAdapter videosAdapter;
    private List<VideoModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tắt tiêu đề và bật full màn hình
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Ánh xạ ViewPager2
        viewPager2 = findViewById(R.id.vpager);
        list = new ArrayList<>();

        // Gọi API để lấy danh sách video
        getVideos();
    }

    private void getVideos() {
        APIService.serviceapi.getVideos().enqueue(new Callback<MessageVideoModel>() {
            @Override
            public void onResponse(Call<MessageVideoModel> call, Response<MessageVideoModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    list = response.body().getResult();
                    videosAdapter = new VideosAdapter(MainActivity.this, list);
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                    viewPager2.setAdapter(videosAdapter);
                } else {
                    Log.e("MainActivity", "Response unsuccessful or empty body");
                }
            }

            @Override
            public void onFailure(Call<MessageVideoModel> call, Throwable t) {
                Log.e("MainActivity", "API call failed: " + t.getMessage(), t);
            }
        });
    }
}
