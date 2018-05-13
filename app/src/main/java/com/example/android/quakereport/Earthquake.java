package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;
    private String webAddress;

    public Earthquake(double magnitude, String location, long date, String webAddress) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.webAddress = webAddress;
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
    public String getWebAddress() {
        return this.webAddress;
    }
}
