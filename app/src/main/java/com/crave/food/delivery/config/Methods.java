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
        arrayList1.add(getTypeObject("KFC",context.getResources().getDrawable(R.drawable.kfc),Category.SRI_LANKAN,"Kalutara"));
        arrayList1.add(getTypeObject("Burger King",context.getResources().getDrawable(R.drawable.burger_king),Category.SRI_LANKAN,"Colombo 7"));
        arrayList1.add(getTypeObject("Dominos",context.getResources().getDrawable(R.drawable.dominos),Category.SRI_LANKAN,"Panadura"));

        arrayList1.add(getTypeObject("Ceylon Spice Heaven",context.getResources().getDrawable(R.drawable.logo_ceylon_spice_heaven),Category.SRI_LANKAN,"Nugegoda"));
        arrayList1.add(getTypeObject("Mamas",context.getResources().getDrawable(R.drawable.logo_mamas_family_restuarant),Category.SRI_LANKAN,"Panadura"));
        arrayList1.add(getTypeObject("Goodness",context.getResources().getDrawable(R.drawable.logo_goodness_at_the_edge),Category.SRI_LANKAN,"Nawinna"));
        arrayList1.add(getTypeObject("Raja bojun",context.getResources().getDrawable(R.drawable.logo_raja_bojun),Category.SRI_LANKAN,"Nugegoda"));
        arrayList1.add(getTypeObject("Colombo Rice&Curry",context.getResources().getDrawable(R.drawable.logo_colombo_rice_and_curry),Category.SRI_LANKAN,"Kalutara"));
        arrayList1.add(getTypeObject("The Hut",context.getResources().getDrawable(R.drawable.logo_the_hut),Category.SRI_LANKAN,"Panadura"));
        arrayList1.add(getTypeObject("Summer Hut",context.getResources().getDrawable(R.drawable.logo_summer_hut_family_restuarant),Category.SRI_LANKAN,"Colombo 5"));
        arrayList1.add(getTypeObject("Thuna Paha",context.getResources().getDrawable(R.drawable.logo_thuna_paha_),Category.SRI_LANKAN,"Kotte"));


        arrayList1.add(getTypeObject("Corn Hill",context.getResources().getDrawable(R.drawable.logo_corn_hill),Category.BAKERY,"Panadura"));
        arrayList1.add(getTypeObject("Revis Bakery",context.getResources().getDrawable(R.drawable.logo_revis_bakery),Category.BAKERY,"Nugegoda"));
        arrayList1.add(getTypeObject("Bake & Take",context.getResources().getDrawable(R.drawable.bake_and_take),Category.BAKERY,"Kotte"));
        arrayList1.add(getTypeObject("Baker's Kitchen",context.getResources().getDrawable(R.drawable.bakers_kitchen),Category.BAKERY,"Colombo"));
        arrayList1.add(getTypeObject("Short Sweet",context.getResources().getDrawable(R.drawable.logo_short_sweets),Category.BAKERY,"Wattala"));
        arrayList1.add(getTypeObject("P & S",context.getResources().getDrawable(R.drawable.logo_ps),Category.BAKERY,"Panadura"));
        arrayList1.add(getTypeObject("Sweet Talk ",context.getResources().getDrawable(R.drawable.logo_sweet_talk_bakery),Category.BAKERY,"Kandy"));


        arrayList1.add(getTypeObject("Biriyani Bowl",context.getResources().getDrawable(R.drawable.biriyani_bowl),Category.INDIAN,"Galle"));
        arrayList1.add(getTypeObject("India & Foods",context.getResources().getDrawable(R.drawable.logo_india_and_food),Category.INDIAN,"Aluthgama"));
        arrayList1.add(getTypeObject("Indian Spices",context.getResources().getDrawable(R.drawable.indian_spices),Category.INDIAN,"Nugegoda"));
        arrayList1.add(getTypeObject("Little India",context.getResources().getDrawable(R.drawable.logo_little_india),Category.INDIAN,"Matara"));
        arrayList1.add(getTypeObject("Dawat",context.getResources().getDrawable(R.drawable.logo_dawat),Category.INDIAN,"Colombo"));
        arrayList1.add(getTypeObject("Giris",context.getResources().getDrawable(R.drawable.logo_giris),Category.INDIAN,"Kandy"));
        arrayList1.add(getTypeObject("India Food",context.getResources().getDrawable(R.drawable.logo_india_food),Category.INDIAN,"Kotte"));
        arrayList1.add(getTypeObject("Indian Chef",context.getResources().getDrawable(R.drawable.logo_indian_chef),Category.INDIAN,"Aluthgama"));
        arrayList1.add(getTypeObject("Indian Lounge",context.getResources().getDrawable(R.drawable.logo_indian_lounge),Category.INDIAN,"Wattala"));
        arrayList1.add(getTypeObject("Saathina",context.getResources().getDrawable(R.drawable.logo_saathina),Category.INDIAN,"Colombo"));
        arrayList1.add(getTypeObject("Hot Dosa",context.getResources().getDrawable(R.drawable.logo2_indian_foods),Category.INDIAN,"Colombo"));


        arrayList1.add(getTypeObject("Dim Sum King",context.getResources().getDrawable(R.drawable.logo_dimsum), Category.CHINESE,"Kottawa"));
        arrayList1.add(getTypeObject("Dragon House",context.getResources().getDrawable(R.drawable.logo_dragonhouse), Category.CHINESE,"Kotte"));
        arrayList1.add(getTypeObject("China City Gargen",context.getResources().getDrawable(R.drawable.logo_china_city_garden_restuarant), Category.CHINESE,"Colombo"));
        arrayList1.add(getTypeObject("Oriental",context.getResources().getDrawable(R.drawable.logo_oriental_restuarant), Category.CHINESE,"Colombo"));
        arrayList1.add(getTypeObject("Sushi",context.getResources().getDrawable(R.drawable.logo_sushi_restuarant), Category.CHINESE,"Nugegoda"));
        arrayList1.add(getTypeObject("Dollar Express",context.getResources().getDrawable(R.drawable.logo_dollar_express), Category.CHINESE,"Kottawa"));
        arrayList1.add(getTypeObject("Chinese Cuisine",context.getResources().getDrawable(R.drawable.logo_chinese_cusine), Category.CHINESE,"Matara"));
        arrayList1.add(getTypeObject("Red Bowl",context.getResources().getDrawable(R.drawable.logo_red_bowl_express), Category.CHINESE,"Colombo"));

        arrayList1.add(getTypeObject("Scoope Colombo",context.getResources().getDrawable(R.drawable.logo_scoopecolombo), Category.DESSERTS,"Kandy"));
        arrayList1.add(getTypeObject("Mooseum",context.getResources().getDrawable(R.drawable.logo_mooseum_ice_cream), Category.DESSERTS,"Nugegoda"));
        arrayList1.add(getTypeObject("Cup Cake Kingdom",context.getResources().getDrawable(R.drawable.logo_cupcake_kingdom), Category.DESSERTS,"Kottawa"));
        arrayList1.add(getTypeObject("Isle Of Gelato",context.getResources().getDrawable(R.drawable.logo_isle_of_gelato), Category.DESSERTS,"Colombo"));
        arrayList1.add(getTypeObject("Delauched Desserts",context.getResources().getDrawable(R.drawable.logo_delauched_desserts), Category.DESSERTS,"Colombo 8"));
        arrayList1.add(getTypeObject("Dream Scape",context.getResources().getDrawable(R.drawable.logo_dream_scape), Category.DESSERTS,"Kottawa"));
        arrayList1.add(getTypeObject("Delice Perle",context.getResources().getDrawable(R.drawable.logo_delice_perle), Category.DESSERTS,"Wattala"));

        arrayList1.add(getTypeObject("Coffee Cafe",context.getResources().getDrawable(R.drawable.logo_cofee_cafe), Category.JUICE_BARS,"Kottawa"));
        arrayList1.add(getTypeObject("Lovetts",context.getResources().getDrawable(R.drawable.logo_lovetts), Category.JUICE_BARS,"Kotte"));
        arrayList1.add(getTypeObject("Costa",context.getResources().getDrawable(R.drawable.logo_costa_cofee), Category.JUICE_BARS,"Nugegoda"));
        arrayList1.add(getTypeObject("Cool Park",context.getResources().getDrawable(R.drawable.cool_park), Category.JUICE_BARS,"Kandy"));
        arrayList1.add(getTypeObject("Fresco",context.getResources().getDrawable(R.drawable.logo_fresco), Category.JUICE_BARS,"Colombo 8"));
        arrayList1.add(getTypeObject("Rasa Juice Shop",context.getResources().getDrawable(R.drawable.logo_rasa_juice_shop), Category.JUICE_BARS,"Matara"));
        arrayList1.add(getTypeObject("Marine Smoothies",context.getResources().getDrawable(R.drawable.logo_marine_smoothies), Category.JUICE_BARS,"Colombo"));


        Random random = new Random();


        ArrayList<Type> returnList = new ArrayList<>();
        for(int i = 0; i < arrayList1.size(); i++)
        {
            boolean res = random.nextBoolean();
            if(res)
            {
                returnList.add(arrayList1.get(i));

                if(returnList.size() > 8)
                {
                    return returnList;
                }
            }
        }

        return returnList;
    }
    public static ArrayList<Type> getArray(Context context,Type type)
    {
        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",context.getResources().getDrawable(R.drawable.mc_donald), Category.SRI_LANKAN,"Kottawa"));
        arrayList1.add(getTypeObject("Pizza Hut",context.getResources().getDrawable(R.drawable.pizza_hut),Category.SRI_LANKAN,"Maharagama"));
        arrayList1.add(getTypeObject("KFC",context.getResources().getDrawable(R.drawable.kfc),Category.SRI_LANKAN,"Kalutara"));
        arrayList1.add(getTypeObject("Burger King",context.getResources().getDrawable(R.drawable.burger_king),Category.SRI_LANKAN,"Colombo 7"));
        arrayList1.add(getTypeObject("Dominos",context.getResources().getDrawable(R.drawable.dominos),Category.SRI_LANKAN,"Panadura"));

        arrayList1.add(getTypeObject("Ceylon Spice Heaven",context.getResources().getDrawable(R.drawable.logo_ceylon_spice_heaven),Category.SRI_LANKAN,"Nugegoda"));
        arrayList1.add(getTypeObject("Mamas",context.getResources().getDrawable(R.drawable.logo_mamas_family_restuarant),Category.SRI_LANKAN,"Panadura"));
        arrayList1.add(getTypeObject("Goodness",context.getResources().getDrawable(R.drawable.logo_goodness_at_the_edge),Category.SRI_LANKAN,"Nawinna"));
        arrayList1.add(getTypeObject("Raja bojun",context.getResources().getDrawable(R.drawable.logo_raja_bojun),Category.SRI_LANKAN,"Nugegoda"));
        arrayList1.add(getTypeObject("Colombo Rice&Curry",context.getResources().getDrawable(R.drawable.logo_colombo_rice_and_curry),Category.SRI_LANKAN,"Kalutara"));
        arrayList1.add(getTypeObject("The Hut",context.getResources().getDrawable(R.drawable.logo_the_hut),Category.SRI_LANKAN,"Panadura"));
        arrayList1.add(getTypeObject("Summer Hut",context.getResources().getDrawable(R.drawable.logo_summer_hut_family_restuarant),Category.SRI_LANKAN,"Colombo 5"));
        arrayList1.add(getTypeObject("Thuna Paha",context.getResources().getDrawable(R.drawable.logo_thuna_paha_),Category.SRI_LANKAN,"Kotte"));


        arrayList1.add(getTypeObject("Corn Hill",context.getResources().getDrawable(R.drawable.logo_corn_hill),Category.BAKERY,"Panadura"));
        arrayList1.add(getTypeObject("Revis Bakery",context.getResources().getDrawable(R.drawable.logo_revis_bakery),Category.BAKERY,"Nugegoda"));
        arrayList1.add(getTypeObject("Bake & Take",context.getResources().getDrawable(R.drawable.bake_and_take),Category.BAKERY,"Kotte"));
        arrayList1.add(getTypeObject("Baker's Kitchen",context.getResources().getDrawable(R.drawable.bakers_kitchen),Category.BAKERY,"Colombo"));
        arrayList1.add(getTypeObject("Short Sweet",context.getResources().getDrawable(R.drawable.logo_short_sweets),Category.BAKERY,"Wattala"));
        arrayList1.add(getTypeObject("P & S",context.getResources().getDrawable(R.drawable.logo_ps),Category.BAKERY,"Panadura"));
        arrayList1.add(getTypeObject("Sweet Talk ",context.getResources().getDrawable(R.drawable.logo_sweet_talk_bakery),Category.BAKERY,"Kandy"));


        arrayList1.add(getTypeObject("Biriyani Bowl",context.getResources().getDrawable(R.drawable.biriyani_bowl),Category.INDIAN,"Galle"));
        arrayList1.add(getTypeObject("India & Foods",context.getResources().getDrawable(R.drawable.logo_india_and_food),Category.INDIAN,"Aluthgama"));
        arrayList1.add(getTypeObject("Indian Spices",context.getResources().getDrawable(R.drawable.indian_spices),Category.INDIAN,"Nugegoda"));
        arrayList1.add(getTypeObject("Little India",context.getResources().getDrawable(R.drawable.logo_little_india),Category.INDIAN,"Matara"));
        arrayList1.add(getTypeObject("Dawat",context.getResources().getDrawable(R.drawable.logo_dawat),Category.INDIAN,"Colombo"));
        arrayList1.add(getTypeObject("Giris",context.getResources().getDrawable(R.drawable.logo_giris),Category.INDIAN,"Kandy"));
        arrayList1.add(getTypeObject("India Food",context.getResources().getDrawable(R.drawable.logo_india_food),Category.INDIAN,"Kotte"));
        arrayList1.add(getTypeObject("Indian Chef",context.getResources().getDrawable(R.drawable.logo_indian_chef),Category.INDIAN,"Aluthgama"));
        arrayList1.add(getTypeObject("Indian Lounge",context.getResources().getDrawable(R.drawable.logo_indian_lounge),Category.INDIAN,"Wattala"));
        arrayList1.add(getTypeObject("Saathina",context.getResources().getDrawable(R.drawable.logo_saathina),Category.INDIAN,"Colombo"));
        arrayList1.add(getTypeObject("Hot Dosa",context.getResources().getDrawable(R.drawable.logo2_indian_foods),Category.INDIAN,"Colombo"));


        arrayList1.add(getTypeObject("Dim Sum King",context.getResources().getDrawable(R.drawable.logo_dimsum), Category.CHINESE,"Kottawa"));
        arrayList1.add(getTypeObject("Dragon House",context.getResources().getDrawable(R.drawable.logo_dragonhouse), Category.CHINESE,"Kotte"));
        arrayList1.add(getTypeObject("China City Gargen",context.getResources().getDrawable(R.drawable.logo_china_city_garden_restuarant), Category.CHINESE,"Colombo"));
        arrayList1.add(getTypeObject("Oriental",context.getResources().getDrawable(R.drawable.logo_oriental_restuarant), Category.CHINESE,"Colombo"));
        arrayList1.add(getTypeObject("Sushi",context.getResources().getDrawable(R.drawable.logo_sushi_restuarant), Category.CHINESE,"Nugegoda"));
        arrayList1.add(getTypeObject("Dollar Express",context.getResources().getDrawable(R.drawable.logo_dollar_express), Category.CHINESE,"Kottawa"));
        arrayList1.add(getTypeObject("Chinese Cuisine",context.getResources().getDrawable(R.drawable.logo_chinese_cusine), Category.CHINESE,"Matara"));
        arrayList1.add(getTypeObject("Red Bowl",context.getResources().getDrawable(R.drawable.logo_red_bowl_express), Category.CHINESE,"Colombo"));

        arrayList1.add(getTypeObject("Scoope Colombo",context.getResources().getDrawable(R.drawable.logo_scoopecolombo), Category.DESSERTS,"Kandy"));
        arrayList1.add(getTypeObject("Mooseum",context.getResources().getDrawable(R.drawable.logo_mooseum_ice_cream), Category.DESSERTS,"Nugegoda"));
        arrayList1.add(getTypeObject("Cup Cake Kingdom",context.getResources().getDrawable(R.drawable.logo_cupcake_kingdom), Category.DESSERTS,"Kottawa"));
        arrayList1.add(getTypeObject("Isle Of Gelato",context.getResources().getDrawable(R.drawable.logo_isle_of_gelato), Category.DESSERTS,"Colombo"));
        arrayList1.add(getTypeObject("Delauched Desserts",context.getResources().getDrawable(R.drawable.logo_delauched_desserts), Category.DESSERTS,"Colombo 8"));
        arrayList1.add(getTypeObject("Dream Scape",context.getResources().getDrawable(R.drawable.logo_dream_scape), Category.DESSERTS,"Kottawa"));
        arrayList1.add(getTypeObject("Delice Perle",context.getResources().getDrawable(R.drawable.logo_delice_perle), Category.DESSERTS,"Wattala"));

        arrayList1.add(getTypeObject("Coffee Cafe",context.getResources().getDrawable(R.drawable.logo_cofee_cafe), Category.JUICE_BARS,"Kottawa"));
        arrayList1.add(getTypeObject("Lovetts",context.getResources().getDrawable(R.drawable.logo_lovetts), Category.JUICE_BARS,"Kotte"));
        arrayList1.add(getTypeObject("Costa",context.getResources().getDrawable(R.drawable.logo_costa_cofee), Category.JUICE_BARS,"Nugegoda"));
        arrayList1.add(getTypeObject("Cool Park",context.getResources().getDrawable(R.drawable.cool_park), Category.JUICE_BARS,"Kandy"));
        arrayList1.add(getTypeObject("Fresco",context.getResources().getDrawable(R.drawable.logo_fresco), Category.JUICE_BARS,"Colombo 8"));
        arrayList1.add(getTypeObject("Rasa Juice Shop",context.getResources().getDrawable(R.drawable.logo_rasa_juice_shop), Category.JUICE_BARS,"Matara"));
        arrayList1.add(getTypeObject("Marine Smoothies",context.getResources().getDrawable(R.drawable.logo_marine_smoothies), Category.JUICE_BARS,"Colombo"));



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
