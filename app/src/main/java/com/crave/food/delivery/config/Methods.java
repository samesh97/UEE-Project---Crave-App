package com.crave.food.delivery.config;

import android.content.Context;
import android.util.DisplayMetrics;

public class Methods
{
    public static float getDeviceWidthInDP(Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        return dpWidth;
    }
    public static float getDeviceHeightInDP(Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        return dpHeight;
    }
    public static float getDeviceHeightInPX(Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
    public static float getDeviceWidthInPX(Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }
}
