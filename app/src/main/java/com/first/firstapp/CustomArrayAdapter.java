package com.first.firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<UserData> {
    private final MainActivity mainActivity;
    private final List<UserData> userDataList;

    public  CustomArrayAdapter(MainActivity mainActivity, List<UserData> userDataList){
        super(mainActivity, 0, userDataList);
        this.mainActivity = mainActivity;
        this.userDataList = userDataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_item, parent,false);
            TextView name = convertView.findViewById(R.id.name);
            TextView email = convertView.findViewById(R.id.email);
            TextView height = convertView.findViewById(R.id.height);
            TextView age = convertView.findViewById(R.id.age);

            UserData userData = userDataList.get(position);
            name.setText(userData.getName());
            email.setText(userData.getEmail());
            height.setText(String.valueOf(userData.getHeight()));
            age.setText(String.valueOf(userData.getAge()));

            return convertView;
        }
        return convertView;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

}
