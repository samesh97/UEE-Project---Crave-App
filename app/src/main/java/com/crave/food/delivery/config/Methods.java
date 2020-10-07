package com.crave.food.delivery.config;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import com.crave.food.delivery.R;
import com.crave.food.delivery.models.Category;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;
import java.util.Random;

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
    public static ArrayList<Type> getPopularList(Context context)
    {
        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",context.getResources().getDrawable(R.drawable.mc_donald), Category.SRI_LANKAN,"Kottawa"));
        arrayList1.add(getTypeObject("Pizza Hut",context.getResources().getDrawable(R.drawable.pizza_hut),Category.SRI_LANKAN,"Maharagama"));
        arrayList1.add(getTypeObject("Biriyani Bowl",context.getResources().getDrawable(R.drawable.biriyani_bowl),Category.SRI_LANKAN,"Galle"));
        arrayList1.add(getTypeObject("Chinese",context.getResources().getDrawable(R.drawable.chinese),Category.SRI_LANKAN,"Borella"));
        arrayList1.add(getTypeObject("KFC",context.getResources().getDrawable(R.drawable.kfc),Category.SRI_LANKAN,"Kalutara"));
        arrayList1.add(getTypeObject("Indian Spices",context.getResources().getDrawable(R.drawable.indian_spices),Category.SRI_LANKAN,"Aluthgama"));
        arrayList1.add(getTypeObject("Burger King",context.getResources().getDrawable(R.drawable.burger_king),Category.SRI_LANKAN,"Panadura"));

        Random random = new Random();


        ArrayList<Type> returnList = new ArrayList<>();
        for(int i = 0; i < arrayList1.size(); i++)
        {
            boolean res = random.nextBoolean();
            if(res)
            {
                returnList.add(arrayList1.get(i));
            }
        }

        return returnList;
    }
    public static ArrayList<Type> getArray(Context context,Type type)
    {
        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",context.getResources().getDrawable(R.drawable.mc_donald), Category.SRI_LANKAN,"Kottawa"));
        arrayList1.add(getTypeObject("Pizza Hut",context.getResources().getDrawable(R.drawable.pizza_hut),Category.SRI_LANKAN,"Maharagama"));
        arrayList1.add(getTypeObject("Biriyani Bowl",context.getResources().getDrawable(R.drawable.biriyani_bowl),Category.SRI_LANKAN,"Galle"));
        arrayList1.add(getTypeObject("Chinese",context.getResources().getDrawable(R.drawable.chinese),Category.BAKERY,"Borella"));
        arrayList1.add(getTypeObject("KFC",context.getResources().getDrawable(R.drawable.kfc),Category.JUICE_BARS,"Kalutara"));
        arrayList1.add(getTypeObject("Indian Spices",context.getResources().getDrawable(R.drawable.indian_spices),Category.SRI_LANKAN,"Aluthgama"));
        arrayList1.add(getTypeObject("Burger King",context.getResources().getDrawable(R.drawable.burger_king),Category.INDIAN,"Panadura"));


        ArrayList<Type> returnArray = new ArrayList();

        for(int i = 0; i < arrayList1.size(); i++)
        {
            if(type.getCategory() == arrayList1.get(i).getCategory())
            {
                returnArray.add(arrayList1.get(i));
            }
        }


        return returnArray;
    }
    public static Type getTypeObject(String name, Drawable drawable, int category, String address)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        type.setCategory(category);
        type.setAddress(address);
        return type;
    }
}
