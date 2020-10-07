package com.crave.food.delivery;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteHolder extends RecyclerView.ViewHolder{
    public ImageView favIcon;
    public TextView favTitle;
    public TextView favDis;

    public FavoriteHolder(@NonNull View itemView) {
        super(itemView);
        this.favIcon = itemView.findViewById(R.id.foodIcon);
        this.favTitle = itemView.findViewById(R.id.titleFav);
        this.favDis = itemView.findViewById(R.id.disFave);
    }
}
