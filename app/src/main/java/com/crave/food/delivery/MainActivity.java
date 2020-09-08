package com.crave.food.delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.crave.food.delivery.adapters.TypeListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setData();





    }

    private void setData()
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Fast Food");
        arrayList.add("Bakery");
        arrayList.add("Fruit Items");
        arrayList.add("Fruit Items");
        arrayList.add("Fruit Items");
        arrayList.add("Fruit Items");
        arrayList.add("Fruit Items");
        arrayList.add("Fruit Items");
        arrayList.add("Fruit Items");
        TypeListAdapter adapter = new TypeListAdapter(getApplicationContext(),arrayList);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(adapter);
    }
    private void initViews()
    {
        foodList = findViewById(R.id.foodList);
    }
}