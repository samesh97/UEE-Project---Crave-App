package com.crave.food.delivery.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Type implements Serializable
{
    private Drawable imageId;
    private String name;

    public Drawable getImageId() {
        return imageId;
    }

    public void setImageId(Drawable imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
