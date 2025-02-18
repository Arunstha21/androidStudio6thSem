package com.first.firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private final List<UserData> userDataList;
    public CustomListAdapter(List<UserData> userDataList){
        this.userDataList = userDataList;
    }

    @Override
    public int getCount() {
        return userDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
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
}
