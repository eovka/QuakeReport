package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;

    public Earthquake(double magnitude, String location, long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public double getMagnitude() {
        return this.magnitude;
    }
    public String getLocation() {
        return this.location;
    }
    public long getDate() {
        return this.date;
    }
}