package com.crave.food.delivery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.adapters.FoodListAdapter;
import com.crave.food.delivery.listeners.OnFoodClick;
import com.crave.food.delivery.models.Foods;

import java.util.ArrayList;

public class MenuFragment extends Fragment
{

    private Context context;
    private FragmentManager manager;
    private RecyclerView foodRecyclerView;

    public MenuFragment(Context context, FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_searchfood,container,false);
        foodRecyclerView = view.findViewById(R.id.foodRecyclerView);

        ArrayList<Foods> list = new ArrayList<>();

        Foods foods = new Foods();
        foods.setTxtVwFoodName("hello");
        foods.setImageId(context.getResources().getDrawable(R.drawable.pizza_hut));


        list.add(foods);
        FoodListAdapter adapter = new FoodListAdapter(context, list, new OnFoodClick() {
            @Override
            public void onChange(Foods foods)
            {

            }
        });

        foodRecyclerView.setAdapter(adapter);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }
}
