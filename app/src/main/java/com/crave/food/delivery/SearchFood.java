package com.crave.food.delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;

import com.crave.food.delivery.adapters.FoodListAdapter;

import java.util.ArrayList;

public class SearchFood extends AppCompatActivity {

    private static final String TAG = "SearchFood";

    //Variables
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchfood);
        Log.d(TAG, "onCreate: Started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        mImageUrls.add("bakery.png");
        mNames.add("Bakery");

        mImageUrls.add("biriyani_bowl.jpg");
        mNames.add("Biriyani");

        mImageUrls.add("burger.png");
        mNames.add("Burger");

        mImageUrls.add("chinese.png");
        mNames.add("Chinese");

        initRecyclerView();
    }
    
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initRecyclerView");
        RecyclerView recyclerView = findViewById(R.id.foodRecyclerView);
        FoodListAdapter adapter = new FoodListAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}