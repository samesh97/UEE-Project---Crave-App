package com.crave.food.delivery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.adapters.FavoriteAdapter;
import com.crave.food.delivery.adapters.OrderAdapter;
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class OrderFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private FragmentManager manager;
    private Button btnCheckOut;
    private ImageView navigation_drawer_icon;

    RecyclerView foodList;

    public OrderFragment(Context context, FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.oder_main_activity,container,false);
        initViews(view);
        setData();
        return view;
    }
    private void setData()
    {
        ArrayList<Favorite> models = new ArrayList<>();

        Favorite m = new Favorite();
        m.setTitle("Orange Juice");
        m.setDiscription("KFC Malabe \nLKR 350.00");
        m.setImg(R.drawable.juice_bars);
        models.add(m);

        m = new Favorite();
        m.setTitle("Rice And Curry");
        m.setDiscription("Mathara Bath Kade Colombo\nLKR 200.00");
        m.setImg(R.drawable.sri_lankan);
        models.add(m);

        OrderAdapter favoriteAdapter = new OrderAdapter(models);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(favoriteAdapter);
        foodList.setItemViewCacheSize(models.size());


        navigation_drawer_icon.setOnClickListener(this);
    }

    private void initViews(View view)
    {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        foodList = view.findViewById(R.id.recycleView);
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
