package com.example.cnts;

public class Donnation {
    private String center = "";
    private String date = "";
    private String time = "";
    private String userUID = "";

    public Donnation() {
    }

    public Donnation(String center, String date, String time, String userUID) {
        this.center = center;
        this.date = date;
        this.time = time;
        this.userUID = userUID;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCenter() {
        return center;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }
}
