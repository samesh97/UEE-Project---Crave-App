package com.crave.food.delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.fragments.OffersFragment;
import com.crave.food.delivery.listeners.OnCategoryClicked;
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {

    OffersFragment c;
    ArrayList<Favorite> models;

    public OrderAdapter(OffersFragment c, ArrayList<Favorite> models) {
        this.c = c;
        this.models = models;
    }
    public OrderAdapter( ArrayList<Favorite> models) {

        this.models = models;
    }

    public OrderAdapter(Context context, ArrayList<Favorite> models, OnCategoryClicked onCategoryClicked) {
    }


    @NonNull
    @Override
    public FavoriteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_row,parent,false);
        return new FavoriteAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.MyViewHolder holder, int position) {

        holder.favTitle.setText(models.get(position).getTitle());
        holder.favDis.setText(models.get(position).getDiscription());
        holder.favIcon.setImageResource(models.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView favTitle,favDis;
        ImageView favIcon;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            favTitle = itemView.findViewById(R.id.titleFav);
            favDis = itemView.findViewById(R.id.disFave);
            favIcon = itemView.findViewById(R.id.foodIcon);
        }
    }

}

