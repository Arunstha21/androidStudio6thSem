package com.first.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("userName");

        recyclerView = findViewById(R.id.recyclerView);
        //this is used in recycler view for general list view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // for grid view display
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false);

        //Show as liner layout showing data in single line
        recyclerView.setLayoutManager(linearLayoutManager);

        //Show data in Grid View
//        recyclerView.setLayoutManager(gridLayoutManager);
        List<UserData> userDataList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            userDataList.add(new UserData("name"+i, "email"+i, i,i));
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(userDataList);
        recyclerView.setAdapter(adapter);
    }
}