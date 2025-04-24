package com.example.viewpager_circleindicator_retrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpager_circleindicator_retrofit.adapters.ImagesViewPagerAdapter;
import com.example.viewpager_circleindicator_retrofit.models.ImagesSlider;
import com.example.viewpager_circleindicator_retrofit.models.MessageModel;
import com.example.viewpager_circleindicator_retrofit.network.ApiService;
import com.google.gson.Gson;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImagesViewPagerAdapter adapter;
    private CircleIndicator circleIndicator;

    private static final String BASE_URL = "http://app.iotstar.vn:8081/appfoods/";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.cricle_indicator); // Đảm bảo ID đúng

        loadImagesFromApi();
    }

    private void loadImagesFromApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<MessageModel> call = apiService.LoadImageSlider(1);

        call.enqueue(new Callback<MessageModel>() {
            @Override
            public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    List<ImagesSlider> imagesList = response.body().getResult();
                    adapter = new ImagesViewPagerAdapter(MainActivity.this, imagesList);
                    viewPager.setAdapter(adapter);
                    circleIndicator.setViewPager(viewPager);
                    Log.d("API_RESPONSE", "Dữ liệu trả về: " + new Gson().toJson(response.body()));
                } else {
                    Log.e("API_ERROR", "Lỗi phản hồi API: " + response.errorBody());
                    Toast.makeText(MainActivity.this, "Lỗi tải dữ liệu", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MessageModel> call, Throwable t) {
                Log.e("API_FAILURE", "Lỗi gọi API: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
