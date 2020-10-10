package com.crave.food.delivery.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.R;
import com.crave.food.delivery.listeners.OnFoodClick;
import com.crave.food.delivery.listeners.OnRestuarantClick;
import com.crave.food.delivery.models.Foods;
import com.crave.food.delivery.models.Restuarant;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> {
//
//    private static final String TAG = "FoodListAdapter";
//
//    private ArrayList<String> mImageNames = new ArrayList<>();
//    private ArrayList<String> mImages = new ArrayList<>();
//    private Context mContext;

    private Context context;
    private ArrayList<Foods> list;
    private OnFoodClick listener;

    public FoodListAdapter(Context context, ArrayList<Foods> list, OnFoodClick listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_listitem,null);
        return new FoodListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.MyViewHolder holder, final int position) {
        if(list != null && list.size() > position)
        {
            final Foods foods = list.get(position);
            holder.txtVwFoodName.setText(foods.getTxtVwFoodName());


            Glide.with(context).load(foods.getImageId()).into(holder.imgFood);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onChange(foods);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFood;
        TextView txtVwFoodName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFood);
            txtVwFoodName = itemView.findViewById(R.id.txtVwFoodName);

        }
    }
}
