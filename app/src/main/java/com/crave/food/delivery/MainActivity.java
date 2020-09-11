package com.crave.food.delivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.config.Methods;
import com.crave.food.delivery.models.Type;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView foodList;
    private RecyclerView popularList;
    private ImageView recommended_food_icon;
    private ImageView navigation_drawer_icon;
    private NavigationView navigationView;
    private DrawerLayout navigation_drawer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setData();



    }

    private void setData()
    {

        Glide.with(getApplicationContext()).load(R.drawable.sri_lankan).into(recommended_food_icon);
        navigation_drawer_icon.setOnClickListener(this);


        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(getTypeObject("Sri Lankan",getResources().getDrawable(R.drawable.sri_lankan)));
        arrayList.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese)));
        arrayList.add(getTypeObject("Indian",getResources().getDrawable(R.drawable.indian)));
        arrayList.add(getTypeObject("Bakery",getResources().getDrawable(R.drawable.bakery)));
        arrayList.add(getTypeObject("Desserts",getResources().getDrawable(R.drawable.desserts)));
        arrayList.add(getTypeObject("Juice Bars",getResources().getDrawable(R.drawable.juice_bars)));

        TypeListAdapter adapter = new TypeListAdapter(getApplicationContext(),arrayList);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(adapter);
        foodList.setItemViewCacheSize(arrayList.size());




        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",getResources().getDrawable(R.drawable.mc_donald)));
        arrayList1.add(getTypeObject("Pizza Hut",getResources().getDrawable(R.drawable.pizza_hut)));
        arrayList1.add(getTypeObject("Biriyani Bowl",getResources().getDrawable(R.drawable.biriyani_bowl)));
        arrayList1.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese)));
        arrayList1.add(getTypeObject("KFC",getResources().getDrawable(R.drawable.kfc)));
        arrayList1.add(getTypeObject("Indian Spices",getResources().getDrawable(R.drawable.indian_spices)));
        arrayList1.add(getTypeObject("Burger King",getResources().getDrawable(R.drawable.burger_king)));


        PopularListAdapter adapter1 = new PopularListAdapter(getApplicationContext(),arrayList1);
        LinearLayoutManager manager1 = new LinearLayoutManager(getApplicationContext());
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        popularList.setLayoutManager(manager1);
        popularList.setAdapter(adapter1);
        popularList.setItemViewCacheSize(arrayList.size());
    }
    private void initViews()
    {
        foodList = findViewById(R.id.foodList);
        popularList = findViewById(R.id.popularList);
        recommended_food_icon = findViewById(R.id.recommended_food_icon);
        navigation_drawer_icon = findViewById(R.id.navigation_drawer_icon);
        navigationView = findViewById(R.id.navigationView);
        navigation_drawer = findViewById(R.id.navigation_drawer);


    }
    public Type getTypeObject(String name, Drawable drawable)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        return type;
    }

    @Override
    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
        }
    }

    private void showNavigationDialog()
    {

        if(navigation_drawer.isDrawerOpen(navigationView))
        {
            navigation_drawer.closeDrawer(navigationView,true);
        }
        else
        {
            navigation_drawer.openDrawer(navigationView,true);
        }
    }
}