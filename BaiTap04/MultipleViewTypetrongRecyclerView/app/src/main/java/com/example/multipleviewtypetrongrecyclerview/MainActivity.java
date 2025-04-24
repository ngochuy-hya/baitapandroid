package com.example.multipleviewtypetrongrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView rvMultipleViewType;
    private List<Object> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rvMultipleViewType = (RecyclerView) findViewById(R.id.rv_multipe_view_type);
        data = new ArrayList<>();
        data.add(new UserModel("Nguyen Van Nghia", "Quan 11"));
        data.add(R.drawable.ic_launcher_foreground);
        data.add("Text 0");
        data.add("Text 1");
        data.add(new UserModel("Nguyen Hoang Minh", "Quan 3"));
        data.add("Text 2");
        data.add(R.drawable.ic_launcher_foreground);
        data.add(R.drawable.ic_launcher_foreground);
        data.add(new UserModel("Pham Nguyen Tam Phu", "Quan 10"));
        data.add("Text 3");
        data.add("Text 4");
        data.add(new UserModel("Tran Van Phuc", "Quan 1"));
        data.add(R.drawable.ic_launcher_foreground);

        CustomAdapter adapter = new CustomAdapter(this, data);
        rvMultipleViewType.setAdapter(adapter);
        rvMultipleViewType.setLayoutManager(new LinearLayoutManager(this));

    }
}