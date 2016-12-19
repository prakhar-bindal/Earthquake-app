package com.example.android.quakereport;

/**
 * Created by prakhar on 16/10/16.
 */

public class Earthquake {
    private  Double mag;
    private String place;
    private long date;
    private String url;

    public Earthquake(Double mag,String place,long date,String url)
    {
        this.mag=mag;
        this.place = place;
        this.date = date;
        this.url = url;
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
    public String geturl() {return url;}


}
