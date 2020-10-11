package com.crave.food.delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.R;
import com.crave.food.delivery.listeners.OnFoodClick;
import com.crave.food.delivery.models.Foods;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Foods> list;
    private OnFoodClick listener;

    public CartAdapter(Context context, ArrayList<Foods> list, OnFoodClick listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cartitem,parent,false);
        return new CartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        if(list != null && list.size() > position)
        {
            final Foods foods = list.get(position);
            holder.txtVwFoodNameCart.setText(foods.getTxtVwFoodName());
            holder.txtVwPriceCart.setText(foods.getTxtVwPriceCart());

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
        TextView txtVwFoodNameCart;
        TextView txtVwPriceCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFoodCart);
            txtVwFoodNameCart = itemView.findViewById(R.id.txtVwFoodNameCart);
            txtVwPriceCart = itemView.findViewById(R.id.txtVwPriceCart);
        }
    }
}
