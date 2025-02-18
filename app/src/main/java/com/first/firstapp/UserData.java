package com.first.firstapp;

public class UserData {
    private String name;
    private String email;
    private float height;
    private int age;

    public UserData(){

    }

    public UserData(String name, String email, float height, int age) {
        this.name = name;
        this.email = email;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }
}
