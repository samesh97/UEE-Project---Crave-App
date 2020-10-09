package com.crave.food.delivery.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.adapters.FavoriteAdapter;
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class FavoriteMain extends AppCompatActivity {
    RecyclerView favRecycleView;
    FavoriteAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favRecycleView = findViewById(R.id.recycleView);
        favRecycleView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new FavoriteAdapter(this,getMyList());
        favRecycleView.setAdapter(myAdapter);
    }
    private ArrayList<Favorite> getMyList(){
        ArrayList<Favorite> models = new ArrayList<>();

        Favorite m = new Favorite();
        m.setTitle("KFC");
        m.setDiscription("Satisfy your cravings Earn points toward rewards when you order with Crave Eats!");
        m.setImg(R.drawable.kfc);
        models.add(m);

        m = new Favorite();
        m.setTitle("McDonalds");
        m.setDiscription("McDelivery® We've partnered with Crave Eats and Just Eat to deliver your favourites!");
        m.setImg(R.drawable.mc_donald);
        models.add(m);

        return models;
    }
}
