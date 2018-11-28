package com.example.bhavikvashi.earthquake;

import java.util.ArrayList;

class EQdata
{
    private String city;
    long date;
    Double mag;

    public EQdata(Double x,String y,long z)
    {
        mag=x;
        city=y;
        date=z;
    }

    public String getCity() {
        return city;
    }

    public long getDate() {
        return date;
    }

    public Double getMag() {
        return mag;
    }
}
