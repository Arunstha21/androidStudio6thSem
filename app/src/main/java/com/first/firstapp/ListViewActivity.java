package com.first.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
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

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        CustomListAdapter customListAdapter = new CustomListAdapter(userDataList);
        listView.setAdapter(customListAdapter);
        gridView.setAdapter(customListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserData dataValues = userDataList.get(position);
                Toast.makeText(getApplicationContext(), "Item Clicked "+dataValues.getEmail(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), RecyclerViewActivity.class));
            }
        });
    }
}