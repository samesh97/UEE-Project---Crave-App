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
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.listeners.OnCategoryClicked;
import com.crave.food.delivery.models.Category;
import com.crave.food.delivery.models.Favorite;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class OffersFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private FragmentManager manager;
    private ImageView navigation_drawer_icon;
    RecyclerView foodList;

    public static boolean isPopularList = true;
    public OffersFragment(Context context, FragmentManager manager) {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_offers_main, container, false);
        initViews(view);
        setData();
        return view;
    }

    private void setData() {
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


        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(models);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(favoriteAdapter);
        foodList.setItemViewCacheSize(models.size());


        navigation_drawer_icon.setOnClickListener(this);
    }

    private void initViews(View view) {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        foodList = view.findViewById(R.id.offersRecycleView);

    }

    public void onClick(View view) {
        if (view == navigation_drawer_icon) {
            showNavigationDialog();
        }
    }

    private void showNavigationDialog() {
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            activity.showNavigationDialog();
        }
    }

}