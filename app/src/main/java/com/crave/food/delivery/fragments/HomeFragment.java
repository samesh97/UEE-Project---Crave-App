package com.crave.food.delivery.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.R;
import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener
{
    private Context context;
    private FragmentManager manager;



    private RecyclerView foodList;
    private RecyclerView popularList;
    private ImageView recommended_food_icon;
    private ImageView navigation_drawer_icon;


    public HomeFragment(Context context,FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view1 = LayoutInflater.from(context).inflate(R.layout.layout_home,null);
        initViews(view1);
        setData();
        return view1;
    }


    private void setData()
    {

       Glide.with(context).load(R.drawable.sri_lankan).into(recommended_food_icon);
        navigation_drawer_icon.setOnClickListener(this);



        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(getTypeObject("Sri Lankan",getResources().getDrawable(R.drawable.sri_lankan)));
        arrayList.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese)));
        arrayList.add(getTypeObject("Indian",getResources().getDrawable(R.drawable.indian)));
        arrayList.add(getTypeObject("Bakery",getResources().getDrawable(R.drawable.bakery)));
        arrayList.add(getTypeObject("Desserts",getResources().getDrawable(R.drawable.desserts)));
        arrayList.add(getTypeObject("Juice Bars",getResources().getDrawable(R.drawable.juice_bars)));

        TypeListAdapter adapter = new TypeListAdapter(context,arrayList);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(adapter);
        foodList.setItemViewCacheSize(arrayList.size());




        ArrayList<Type> arrayList1 = new ArrayList<>();
        arrayList1.add(getTypeObject("McDonalds",getResources().getDrawable(R.drawable.mc_donald)));
        arrayList1.add(getTypeObject("Pizza Hut",getResources().getDrawable(R.drawable.pizza_hut)));
        arrayList1.add(getTypeObject("Biriyani Bowl",getResources().getDrawable(R.drawable.biriyani_bowl)));
        arrayList1.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese)));
        arrayList1.add(getTypeObject("KFC",getResources().getDrawable(R.drawable.kfc)));
        arrayList1.add(getTypeObject("Indian Spices",getResources().getDrawable(R.drawable.indian_spices)));
        arrayList1.add(getTypeObject("Burger King",getResources().getDrawable(R.drawable.burger_king)));


        PopularListAdapter adapter1 = new PopularListAdapter(context,arrayList1);
        LinearLayoutManager manager1 = new LinearLayoutManager(context);
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        popularList.setLayoutManager(manager1);
        popularList.setAdapter(adapter1);
        popularList.setItemViewCacheSize(arrayList.size());
    }
    private void initViews(View view)
    {
        foodList = view.findViewById(R.id.foodList);
        popularList = view.findViewById(R.id.popularList);
        recommended_food_icon = view.findViewById(R.id.recommended_food_icon);
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);


    }
    public Type getTypeObject(String name, Drawable drawable)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        return type;
    }

    @Override
    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
        }
      //  else if(view== foodList){
     //       showRestuarants();
    //    }
    }

    private void showNavigationDialog()
    {
        if(context instanceof MainActivity)
        {
            MainActivity activity = (MainActivity) context;
            activity.showNavigationDialog();
        }
    }

   // public void showRestuarants(){
 //       Fragment fragment = new RestuarantFragment(context,manager);
  //      getActivity().getSupportFragmentManager()
  //              .beginTransaction().replace(R.id.popularList,fragment)
   //             .addToBackStack(null).commit();

  //  }


    public void Login(View view)
    {
        Toast.makeText(context, "Clciked", Toast.LENGTH_SHORT).show();
    }
}
