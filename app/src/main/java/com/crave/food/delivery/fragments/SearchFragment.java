package com.crave.food.delivery.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.SearchListAdapter;
import com.crave.food.delivery.listeners.OnRestuarantClicked;
import com.crave.food.delivery.models.Category;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class SearchFragment extends Fragment
{
    private Context context;
    private RecyclerView search_res_list;

    private Type type;

    public SearchFragment(Context context,Type type)
    {
        this.context = context;
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_search_list,container,false);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        ArrayList<Type> arrayList1 = getArray();

        SearchListAdapter adapter1 = new SearchListAdapter(context, arrayList1, new OnRestuarantClicked() {
            @Override
            public void onChange(Type type) {
                if(context instanceof MainActivity)
                {
                    MainActivity mainActivity = (MainActivity) context;
                    mainActivity.onRestuarantViewClicked(type);
                }
            }
        });
        GridLayoutManager manager1 = new GridLayoutManager(context,3);
        manager1.setOrientation(RecyclerView.VERTICAL);
        search_res_list.setLayoutManager(manager1);
        search_res_list.setAdapter(adapter1);
        search_res_list.setItemViewCacheSize(arrayList1.size());



        for(int i = 0; i < arrayList1.size(); i++)
        {
            Type ty = arrayList1.get(i);
            if(ty.getCategory() == type.getCategory())
            {

            }
            else
            {
                arrayList1.remove(i);
                adapter1.notifyDataSetChanged();
            }
        }




    }
    private void initViews(View view)
    {
        search_res_list = view.findViewById(R.id.search_res_list);
    }
    public Type getTypeObject(String name, Drawable drawable,int category)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        type.setCategory(category);
        return type;
    }
    public ArrayList<Type> getArray()
    {
        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",getResources().getDrawable(R.drawable.mc_donald), Category.SRI_LANKAN));
        arrayList1.add(getTypeObject("Pizza Hut",getResources().getDrawable(R.drawable.pizza_hut),Category.SRI_LANKAN));
        arrayList1.add(getTypeObject("Biriyani Bowl",getResources().getDrawable(R.drawable.biriyani_bowl),Category.SRI_LANKAN));
        arrayList1.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese),Category.SRI_LANKAN));
        arrayList1.add(getTypeObject("KFC",getResources().getDrawable(R.drawable.kfc),Category.SRI_LANKAN));
        arrayList1.add(getTypeObject("Indian Spices",getResources().getDrawable(R.drawable.indian_spices),Category.SRI_LANKAN));
        arrayList1.add(getTypeObject("Burger King",getResources().getDrawable(R.drawable.burger_king),Category.SRI_LANKAN));

//        arrayList1.add(getTypeObject("McDonalds",getResources().getDrawable(R.drawable.mc_donald),Category.CHINESE));
//        arrayList1.add(getTypeObject("Pizza Hut",getResources().getDrawable(R.drawable.pizza_hut),Category.JUICE_BARS));
//        arrayList1.add(getTypeObject("Biriyani Bowl",getResources().getDrawable(R.drawable.biriyani_bowl),Category.JUICE_BARS));
//        arrayList1.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese),Category.DESSERTS));
//        arrayList1.add(getTypeObject("KFC",getResources().getDrawable(R.drawable.kfc),Category.BAKERY));
//        arrayList1.add(getTypeObject("Indian Spices",getResources().getDrawable(R.drawable.indian_spices),Category.BAKERY));
//        arrayList1.add(getTypeObject("Burger King",getResources().getDrawable(R.drawable.burger_king),Category.JUICE_BARS));

        return arrayList1;
    }

}
