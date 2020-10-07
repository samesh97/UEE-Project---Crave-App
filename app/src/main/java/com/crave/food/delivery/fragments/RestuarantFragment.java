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
import com.crave.food.delivery.adapters.TypeListAdapter;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class RestuarantFragment extends Fragment implements View.OnClickListener {


        private Context context;
        private FragmentManager manager;

        private RecyclerView foodList;
        private ImageView navigation_drawer_icon;
     //   private RecyclerView restuarantList;

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


    }

    private void initViews(View view)
    {
        foodList = view.findViewById(R.id.foodList);
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
      //  restuarantList=view.findViewById(R.id.restuarantList);

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