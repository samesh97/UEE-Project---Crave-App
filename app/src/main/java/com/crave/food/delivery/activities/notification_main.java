package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.crave.food.delivery.R;
import com.crave.food.delivery.adapters.FavoriteAdapter;
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class notification_main extends AppCompatActivity {

    RecyclerView favRecycleView;
    FavoriteAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_main);

        favRecycleView = findViewById(R.id.recycleView);
        favRecycleView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new FavoriteAdapter(this,getMyList());
        favRecycleView.setAdapter(myAdapter);
    }
    private ArrayList<Favorite> getMyList(){
        ArrayList<Favorite> models = new ArrayList<>();

        Favorite m = new Favorite();
        m.setTitle("Order delivered successful");
        m.setDiscription("Your KFC oder has been delivered successfully!");
        m.setImg(R.drawable.mobile_order);
        models.add(m);

        m = new Favorite();
        m.setTitle("Payment successful! ");
        m.setDiscription("Your payment of LKR350.00 has successfully processed!");
        m.setImg(R.drawable.mobile_payment);
        models.add(m);

        return models;
    }
}