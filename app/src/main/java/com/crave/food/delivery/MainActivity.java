package com.crave.food.delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView foodList;
    private RecyclerView popularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setData();





    }

    private void setData()
    {
        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(getTypeObject("Fast food",getResources().getDrawable(R.drawable.burger)));
        arrayList.add(getTypeObject("Fruits",getResources().getDrawable(R.drawable.strawberry)));
        arrayList.add(getTypeObject("Fast Food",getResources().getDrawable(R.drawable.burger)));
        arrayList.add(getTypeObject("Fruits",getResources().getDrawable(R.drawable.strawberry)));
        arrayList.add(getTypeObject("Fast food",getResources().getDrawable(R.drawable.burger)));
        arrayList.add(getTypeObject("Fruits",getResources().getDrawable(R.drawable.strawberry)));
        TypeListAdapter adapter = new TypeListAdapter(getApplicationContext(),arrayList);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(adapter);
        foodList.setItemViewCacheSize(arrayList.size());



        PopularListAdapter adapter1 = new PopularListAdapter(getApplicationContext(),arrayList);
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
    }
    public Type getTypeObject(String name, Drawable drawable)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        return type;
    }
}