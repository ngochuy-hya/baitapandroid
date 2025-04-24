package com.example.sinhsongaunhien;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);
        final EditText editText2 = findViewById(R.id.editText2);
        final TextView textViewResult = findViewById(R.id.textViewResult);
        Button buttonRnd = findViewById(R.id.buttonRnd);

        buttonRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int min = Integer.parseInt(editText1.getText().toString());
                    int max = Integer.parseInt(editText2.getText().toString());

                    if (min >= max) {
                        Toast.makeText(MainActivity.this,
                                "Số thứ nhất phải nhỏ hơn số thứ hai",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Random random = new Random();
                    int randomNumber = random.nextInt((max - min) + 1) + min;

                    textViewResult.setText(String.valueOf(randomNumber));

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,
                            "Vui lòng nhập đầy đủ 2 số",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}