package com.crave.food.delivery.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Restuarant implements Serializable {
    private Drawable imageView3;
    private String resturant;
    private String location;

    public Drawable getImageId() {
        return imageView3;
    }

    public void setImageId(Drawable imageView3) {
        this.imageView3 = imageView3;
    }

    public String getRestuarnt() {
        return resturant;
    }

    public void setResturant(String resturant) {
        this.resturant = resturant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
