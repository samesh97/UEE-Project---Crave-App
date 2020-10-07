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

import com.bumptech.glide.Glide;
import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.listeners.OnRestuarantClicked;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class PopularRecommendedFragment extends Fragment
{
    private Context context;


    private RecyclerView popularList;
    private ImageView recommended_food_icon;

    PopularRecommendedFragment(Context context)
    {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_popular_and_recomended,container,false);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        Glide.with(context).load(R.drawable.sri_lankan).into(recommended_food_icon);





        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",getResources().getDrawable(R.drawable.mc_donald)));
        arrayList1.add(getTypeObject("Pizza Hut",getResources().getDrawable(R.drawable.pizza_hut)));
        arrayList1.add(getTypeObject("Biriyani Bowl",getResources().getDrawable(R.drawable.biriyani_bowl)));
        arrayList1.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese)));
        arrayList1.add(getTypeObject("KFC",getResources().getDrawable(R.drawable.kfc)));
        arrayList1.add(getTypeObject("Indian Spices",getResources().getDrawable(R.drawable.indian_spices)));
        arrayList1.add(getTypeObject("Burger King",getResources().getDrawable(R.drawable.burger_king)));


        PopularListAdapter adapter1 = new PopularListAdapter(context, arrayList1, new OnRestuarantClicked() {
            @Override
            public void onChange(Type type) {
                if(context instanceof MainActivity)
                {
                    MainActivity mainActivity = (MainActivity) context;
                    mainActivity.onRestuarantViewClicked(type);
                }
            }
        });
        LinearLayoutManager manager1 = new LinearLayoutManager(context);
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        popularList.setLayoutManager(manager1);
        popularList.setAdapter(adapter1);
        popularList.setItemViewCacheSize(arrayList1.size());
    }

    private void initViews(View view)
    {

        popularList = view.findViewById(R.id.popularList);
        recommended_food_icon = view.findViewById(R.id.recommended_food_icon);
    }
    public Type getTypeObject(String name, Drawable drawable)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        return type;
    }
}
