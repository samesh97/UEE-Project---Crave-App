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
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class NotificationFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private FragmentManager manager;
    private Button btnCheckOut;
    private ImageView navigation_drawer_icon;
   private RecyclerView foodList;

    public NotificationFragment(Context context, FragmentManager manager) {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_notification_main, container, false);
        initViews(view);
        setData();
        return view;
    }

    private void setData() {

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

        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(models);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(favoriteAdapter);
        foodList.setItemViewCacheSize(models.size());

        navigation_drawer_icon.setOnClickListener(this);
    }

    private void initViews(View view) {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        foodList = view.findViewById(R.id.recycleView);
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