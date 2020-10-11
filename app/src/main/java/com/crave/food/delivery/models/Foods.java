package com.crave.food.delivery.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Foods implements Serializable {
    private Drawable imgFood;
    private String txtVwFoodName;
    private String txtVwDescription;
    private String txtVwPriceCart;

    public Drawable getImageId() {
        return imgFood;
    }

    public void setImageId(Drawable imageView3) {
        this.imgFood = imageView3;
    }

    public String getTxtVwFoodName() {
        return txtVwFoodName;
    }

    public void setTxtVwFoodName(String txtVwFoodName) {
        this.txtVwFoodName = txtVwFoodName;
    }

    public String getTxtVwDescription() {
        return txtVwDescription;
    }

    public void setTxtVwDescription(String txtVwDescription) {
        this.txtVwDescription = txtVwDescription;
    }

    public String getTxtVwPriceCart() {
        return txtVwPriceCart;
    }

    public void setTxtVwPriceCart(String txtVwPriceCart) {
        this.txtVwPriceCart = txtVwPriceCart;
    }
}
