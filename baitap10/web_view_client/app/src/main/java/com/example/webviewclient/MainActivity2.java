package com.example.webviewclient;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.example.webviewclient.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @SuppressLint({"SetJavaScriptEnabled", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Khởi tạo ViewBinding
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ẩn ActionBar nếu cần
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Cấu hình WebView
        WebSettings webSettings = binding.webview2.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        // Thiết lập WebViewClient và WebChromeClient
        binding.webview2.setWebViewClient(new WebViewClient());
        binding.webview2.setWebChromeClient(new WebChromeClient());

        // Tải URL
        binding.webview2.loadUrl("http://iotstar.vn");
    }

    // Xử lý nút back để quay lại trang trước trong WebView
    @Override
    public void onBackPressed() {
        if (binding.webview2.canGoBack()) {
            binding.webview2.goBack();
        } else {
            super.onBackPressed();
        }
    }
}