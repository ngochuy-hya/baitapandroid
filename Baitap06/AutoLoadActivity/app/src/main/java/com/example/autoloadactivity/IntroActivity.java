package com.example.autoloadactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        new Thread() {
            public void run() {
                int n = 0;
                try {
                    do {
                        if (n >= 2000) {
                            IntroActivity.this.finish();
                            Intent intent = new Intent(IntroActivity.this.getApplicationContext(), LoginActivity.class);
                            IntroActivity.this.startActivity(intent);
                            return;
                        }
                        Thread.sleep(100);
                        n += 100;
                    } while (true);
                } catch (InterruptedException e) {
                    IntroActivity.this.finish();
                    Intent intent = new Intent(IntroActivity.this.getApplicationContext(), LoginActivity.class);
                    IntroActivity.this.startActivity(intent);
                } catch (Throwable throwable) {
                    IntroActivity.this.finish();
                    Intent intent = new Intent(IntroActivity.this.getApplicationContext(), LoginActivity.class);
                    IntroActivity.this.startActivity(intent);
                    throw throwable;
                }
            }
        }.start();
    }
}