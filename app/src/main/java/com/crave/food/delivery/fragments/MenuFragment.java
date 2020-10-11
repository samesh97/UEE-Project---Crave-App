package com.crave.food.delivery.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.adapters.FoodListAdapter;
import com.crave.food.delivery.listeners.OnFoodClick;
import com.crave.food.delivery.models.Foods;
import com.crave.food.delivery.models.Restuarant;

import java.util.ArrayList;

public class MenuFragment extends Fragment implements View.OnClickListener
{

    private Context context;
    private FragmentManager manager;
    private RecyclerView foodRecyclerView;
    private ImageView navigation_drawer_icon;

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
        foods.setTxtVwFoodName("Bakery");
        foods.setTxtVwDescription("All kinds of Bakery items are available.");
        foods.setImageId(context.getResources().getDrawable(R.drawable.bakery));

        list.add(foods);

        Foods foods2 = new Foods();
        foods2.setTxtVwFoodName("Chicken Burger");
        foods2.setTxtVwDescription("Burger with chillie chicken.");
        foods2.setImageId(context.getResources().getDrawable(R.drawable.burger ));

        list.add(foods2);

        Foods foods3 = new Foods();
        foods3.setTxtVwFoodName("Noodles");
        foods3.setTxtVwDescription("Chinese noodles with chillie chicken.");
        foods3.setImageId(context.getResources().getDrawable(R.drawable.chinese ));

        list.add(foods3);

        Foods foods4 = new Foods();
        foods4.setTxtVwFoodName("Juices");
        foods4.setTxtVwDescription("All kinds of juices");
        foods4.setImageId(context.getResources().getDrawable(R.drawable.juice_bars ));

        list.add(foods4);

        FoodListAdapter adapter = new FoodListAdapter(context, list, new OnFoodClick() {
            @Override
            public void onChange(Foods foods)
            {

            }
        });


        foodRecyclerView.setAdapter(adapter);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        initViews(view);
        setData();
        return view;
    }

    public Foods getFoodObject(String name, String description, Drawable drawable)
    {
        Foods food = new Foods();
        food.setTxtVwFoodName(name);
        food.setTxtVwDescription(description);
        food.setImageId(drawable);
        return food;
    }

    private void setData()
    {
        navigation_drawer_icon.setOnClickListener(this);
    }

    private void initViews(View view)
    {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
    }

    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
        }

        else if(view == foodRecyclerView){
            showNavigationDialog();
        }
    }

    private void showNavigationDialog()
    {
        if(context instanceof MainActivity)
        {
            MainActivity activity = (MainActivity) context;
            activity.showNavigationDialog();
        }
    }
}
