package com.first.firstapp;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class activity_grid_view extends AppCompatActivity {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("userName");
        String password = getIntent().getStringExtra("password");
        int phone = getIntent().getIntExtra("phone", 0);

        List<UserData> userDataList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            userDataList.add(new UserData("name"+i, "email"+i, i,i));
        }

        gridView = findViewById(R.id.gridViewA);
        CustomListAdapter customListAdapter = new CustomListAdapter(userDataList);
        gridView.setAdapter(customListAdapter);
    }
}