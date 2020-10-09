package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.crave.food.delivery.R;
import com.crave.food.delivery.adapters.FavoriteAdapter;
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class offers_main extends AppCompatActivity {

    RecyclerView offerRecycleView;
    FavoriteAdapter offersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_main);

        offerRecycleView = findViewById(R.id.offersRecycleView);
        offerRecycleView.setLayoutManager(new LinearLayoutManager(this));
        offersAdapter = new FavoriteAdapter(this,getMylist());
        offerRecycleView.setAdapter(offersAdapter);

    }
    private ArrayList<Favorite> getMylist(){
        ArrayList<Favorite> models = new ArrayList<>();

        Favorite m = new Favorite();
        m.setTitle("25% Off From Collage Students!");
        m.setDiscription("Satisfy your cravings Earn points toward rewards when you order with Crave Eats!");
        m.setImg(R.drawable.desserts);
        models.add(m);

        m = new Favorite();
        m.setTitle("10% Off For Commercial Credit Cards!");
        m.setDiscription("McDelivery® We've partnered with Crave Eats and Just Eat to deliver your favourites!");
        m.setImg(R.drawable.chinese);
        models.add(m);

        m = new Favorite();
        m.setTitle("20% Off With Family Meals");
        m.setDiscription("Satisfy your cravings Earn points toward rewards when you order with Crave Eats!");
        m.setImg(R.drawable.juice_bars);
        models.add(m);

        m = new Favorite();
        m.setTitle("18% Off With A Large Chicken Burger!");
        m.setDiscription("McDelivery® We've partnered with Crave Eats and Just Eat to deliver your favourites!");
        m.setImg(R.drawable.indian);
        models.add(m);

        return models;
    }
}