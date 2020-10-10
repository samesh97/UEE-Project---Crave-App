package com.crave.food.delivery.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Foods implements Serializable {
    private Drawable imgFood;
    private String txtVwFoodName;

    public Drawable getImageId() {
        return imgFood;
    }

    public void setImageId(Drawable imageView3) {
        this.imgFood = imgFood;
    }

    public String getTxtVwFoodName() {
        return txtVwFoodName;
    }

    public void setTxtVwFoodName(String resturant) {
        this.txtVwFoodName = resturant;
    }

}
