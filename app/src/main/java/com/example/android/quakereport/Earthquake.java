package com.example.android.quakereport;

/**
 * Created by prakhar on 16/10/16.
 */

public class Earthquake {
    private  Double mag;
    private String place;
    private long date;

    public Earthquake(Double mag,String place,long date)
    {
        this.mag=mag;
        this.place = place;
        this.date = date;
    }


    public Double getmag()
    {
        return mag;
    }
    public String getplace()
    {
        return place;
    }
    public long getdate()
    {
        return date;
    }


}
