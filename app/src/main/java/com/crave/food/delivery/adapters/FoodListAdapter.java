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

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> {

    private static final String TAG = "FoodListAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public FoodListAdapter( Context context, ArrayList<String> imageNames, ArrayList<String> images) {
        this.mImageNames = imageNames;
        this.mImages = images;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.imgFood);

        holder.txtVwFoodName.setText(mImageNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFood;
        TextView txtVwFoodName;
        RelativeLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFood);
            txtVwFoodName = itemView.findViewById(R.id.txtVwFoodName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
