package com.crave.food.delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.R;
import com.crave.food.delivery.listeners.OnRestuarantClick;
import com.crave.food.delivery.listeners.OnRestuarantClicked;
import com.crave.food.delivery.models.Restuarant;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class RestuarantListAdapter extends RecyclerView.Adapter<RestuarantListAdapter.MyViewHolder>{


    private Context context;
    private ArrayList<Restuarant> list;
    private OnRestuarantClick listener;

    public RestuarantListAdapter(Context context, ArrayList<Restuarant> list, OnRestuarantClick listener)
    {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RestuarantListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.restuarantlist_row,null);
        return new RestuarantListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestuarantListAdapter.MyViewHolder holder, final int position)
    {
        if(list != null && list.size() > position)
        {
            final Restuarant restuarant = list.get(position);
            holder.restuarantName.setText(restuarant.getRestuarnt());
            holder.restuarantLocation.setText(restuarant.getLocation());

            Glide.with(context).load(restuarant.getImageId()).into(holder.imageView3);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onChange(restuarant);
                }
            });

        }

    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView3;
        TextView restuarantName;
        TextView restuarantLocation;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView3 = itemView.findViewById(R.id.imageView3);
            restuarantName = itemView.findViewById(R.id.restuarantName);
            restuarantLocation = itemView.findViewById(R.id.restuarantLocation);
        }
    }


}