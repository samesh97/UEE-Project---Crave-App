package com.crave.food.delivery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

import java.util.ArrayList;

public class FoodClickedFragment extends Fragment implements View.OnClickListener {
    private Context context;
    private FragmentManager manager;
    private RecyclerView foodRecyclerView;
    private ImageView navigation_drawer_icon;

    private Foods foods;

    private ImageView imageView9;
    private TextView textView12;


    public FoodClickedFragment(Context context, FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    public FoodClickedFragment(Context context, FragmentManager manager,Foods foods)
    {
        this.context = context;
        this.manager = manager;
        this.foods = foods;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_food_button_clicked,container,false);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        navigation_drawer_icon.setOnClickListener(this);

        if(foods != null)
        {
            imageView9.setImageDrawable(foods.getImageId());
            textView12.setText(foods.getTxtVwFoodName());
        }
    }

    private void initViews(View view)
    {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        imageView9 = view.findViewById(R.id.imageView9);
        textView12 = view.findViewById(R.id.textView12);
    }

    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
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
