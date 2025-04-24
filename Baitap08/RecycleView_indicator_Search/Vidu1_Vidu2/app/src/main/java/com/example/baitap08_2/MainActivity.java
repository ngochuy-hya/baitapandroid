package com.example.baitap08_2;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView; // Đã sửa import này
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IconAdapter adapter;
    private List<IconModel> iconList;
    private SearchView searchView; // Giờ đã khớp với import

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupRecyclerView();
        setupSearchView();
    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.rclcon);
        searchView = findViewById(R.id.searchView);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        ));
        recyclerView.addItemDecoration(new LinePagerIndicatorDecoration(this));

        iconList = new ArrayList<>();
        // Thêm try-catch để bắt lỗi nếu drawable không tồn tại
        try {
            iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Person"));
            iconList.add(new IconModel(R.drawable.ic_baseline_home_24, "Home"));
            iconList.add(new IconModel(R.drawable.ic_baseline_settings_24, "Settings"));
        } catch (Exception e) {
            // Fallback sử dụng drawable mặc định của hệ thống nếu lỗi
            iconList.add(new IconModel(android.R.drawable.ic_menu_gallery, "Gallery"));
            iconList.add(new IconModel(android.R.drawable.ic_menu_info_details, "Info"));
            iconList.add(new IconModel(android.R.drawable.ic_menu_help, "Help"));
        }

        adapter = new IconAdapter(this, iconList);
        recyclerView.setAdapter(adapter);
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<IconModel> filteredList = new ArrayList<>();
        if (text.isEmpty()) {
            filteredList.addAll(iconList);
        } else {
            for (IconModel item : iconList) {
                if (item.getDesc().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        adapter.setFilteredList(filteredList);
    }
}