package com.crave.food.delivery.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.R;
import com.crave.food.delivery.adapters.PopularListAdapter;
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.listeners.OnCategoryClicked;
import com.crave.food.delivery.listeners.OnRestuarantClicked;
import com.crave.food.delivery.models.Category;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener
{
    private Context context;
    private FragmentManager manager;
    private RecyclerView foodList;
    private FrameLayout home_sub_frame_layout;


    private SearchFragment searchFragment = null;


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
        navigation_drawer_icon.setOnClickListener(this);
        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(getTypeObject("Sri Lankan",getResources().getDrawable(R.drawable.sri_lankan), Category.SRI_LANKAN));
        arrayList.add(getTypeObject("Chinese",getResources().getDrawable(R.drawable.chinese),Category.CHINESE));
        arrayList.add(getTypeObject("Indian",getResources().getDrawable(R.drawable.indian),Category.INDIAN));
        arrayList.add(getTypeObject("Bakery",getResources().getDrawable(R.drawable.bakery),Category.BAKERY));
        arrayList.add(getTypeObject("Desserts",getResources().getDrawable(R.drawable.desserts),Category.DESSERTS));
        arrayList.add(getTypeObject("Juice Bars",getResources().getDrawable(R.drawable.juice_bars),Category.JUICE_BARS));

        TypeListAdapter adapter = new TypeListAdapter(context, arrayList, new OnCategoryClicked() {
            @Override
            public void onChange(Type type) {
                if(context instanceof MainActivity)
                {
                    MainActivity activity = (MainActivity) context;
                    if(searchFragment == null)
                    {
                        searchFragment = new SearchFragment(context,type);
                        activity.setFragment(R.id.home_sub_frame_layout,searchFragment);
                    }
                    else
                    {
                        searchFragment.updateView(type);
                    }

                }
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        foodList.setLayoutManager(manager);
        foodList.setAdapter(adapter);
        foodList.setItemViewCacheSize(arrayList.size());

        //set fragment
        if(context instanceof MainActivity)
        {
            MainActivity activity = (MainActivity) context;
            activity.setFragment(R.id.home_sub_frame_layout,new PopularRecommendedFragment(context));
        }

    }
    private void initViews(View view)
    {

        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        foodList = view.findViewById(R.id.foodList);
        home_sub_frame_layout = view.findViewById(R.id.home_sub_frame_layout);

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
    public Type getTypeObject(String name, Drawable drawable,int category)
    {
        Type type = new Type();
        type.setName(name);
        type.setImageId(drawable);
        type.setCategory(category);
        return type;
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
