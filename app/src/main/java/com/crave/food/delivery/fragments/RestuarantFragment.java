package com.crave.food.delivery.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.RestuarantListAdapter;
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.listeners.OnRestuarantClick;
import com.crave.food.delivery.listeners.OnRestuarantClicked;
import com.crave.food.delivery.models.Restuarant;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class RestuarantFragment extends Fragment implements View.OnClickListener {


        private Context context;
        private FragmentManager manager;

        private RecyclerView foodList;
        private RecyclerView restuarantList;
        private ImageView navigation_drawer_icon;


    public RestuarantFragment(Context context,FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view1 = LayoutInflater.from(context).inflate(R.layout.layout_restuarant,null);
        initViews(view1);
        setData();
        return view1;
    }

    private void setData() {
        navigation_drawer_icon.setOnClickListener(this);


        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(getTypeObject("Sri Lankan", getResources().getDrawable(R.drawable.sri_lankan)));
        arrayList.add(getTypeObject("Chinese", getResources().getDrawable(R.drawable.chinese)));
        arrayList.add(getTypeObject("Indian", getResources().getDrawable(R.drawable.indian)));
        arrayList.add(getTypeObject("Bakery", getResources().getDrawable(R.drawable.bakery)));
        arrayList.add(getTypeObject("Desserts", getResources().getDrawable(R.drawable.desserts)));
        arrayList.add(getTypeObject("Juice Bars", getResources().getDrawable(R.drawable.juice_bars)));

        TypeListAdapter adapter = new TypeListAdapter(context, arrayList);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(adapter);
        foodList.setItemViewCacheSize(arrayList.size());


        ArrayList<Restuarant> arrayList1 = new ArrayList<>();
        arrayList1.add(getRestuarantObject("McDonalds","Galle Road,Colombo",getResources().getDrawable(R.drawable.mc_donald)));
        arrayList1.add(getRestuarantObject("Pizza Hut","galle",getResources().getDrawable(R.drawable.pizza_hut)));
        arrayList1.add(getRestuarantObject("Biriyani Bowl","galle",getResources().getDrawable(R.drawable.biriyani_bowl)));
        arrayList1.add(getRestuarantObject("Chinese","matara",getResources().getDrawable(R.drawable.chinese)));
        arrayList1.add(getRestuarantObject("KFC","colombo",getResources().getDrawable(R.drawable.kfc)));
        arrayList1.add(getRestuarantObject("Indian Spices","Kandy",getResources().getDrawable(R.drawable.indian_spices)));
        arrayList1.add(getRestuarantObject("Burger King","Matara",getResources().getDrawable(R.drawable.burger_king)));


   /*     RestuarantListAdapter adapter1 = new RestuarantListAdapter(context, arrayList1, new OnRestuarantClick() {
            @Override
            public void onChange(Type type) {
                if(context instanceof MainActivity)
                {
                    MainActivity mainActivity = (MainActivity) context;
                    mainActivity.onRestuarantViewClick(restuarant);
                }
            }
        });


        LinearLayoutManager manager1 = new LinearLayoutManager(context);
        manager1.setOrientation(RecyclerView.VERTICAL);
        restuarantList.setLayoutManager(manager1);
        restuarantList.setAdapter(adapter1);
        restuarantList.setItemViewCacheSize(arrayList1.size());
*/
    }



    private void initViews(View view)
    {
        foodList = view.findViewById(R.id.foodList);
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        restuarantList=view.findViewById(R.id.restuarantList);

    }

    public Type getTypeObject(String name, Drawable drawable)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        return type;
    }

    public Restuarant getRestuarantObject(String name, String location,Drawable drawable)
    {
        Restuarant res = new Restuarant();
        res.setResturant(name);
        res.setLocation(location);
        res.setImageId(drawable);
        return res;
    }
    @Override
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