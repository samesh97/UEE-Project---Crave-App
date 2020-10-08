package com.crave.food.delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crave.food.delivery.R;
import com.crave.food.delivery.config.Methods;
import com.crave.food.delivery.listeners.OnRestuarantClicked;
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.MyViewHolder>
{
    private Context context;
    private ArrayList<Type> list;
    private OnRestuarantClicked listener;

    public SearchListAdapter(Context context, ArrayList<Type> list, OnRestuarantClicked listener)
    {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.search_list_row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapter.MyViewHolder holder, final int position)
    {
        if(list != null && list.size() > position)
        {
            final Type type = list.get(position);
            holder.title.setText(type.getName());

            Glide.with(context).load(type.getImageId()).into(holder.icon);

            holder.hotelAddress.setText(type.getAddress());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onChange(type);
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
        ImageView image_background;
        TextView title;
        ImageView icon;
        TextView hotelAddress;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);


            int onesize = (int) (Methods.getDeviceWidthInPX(context) / 3.2);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(onesize, (int) (onesize * 1.1));
            itemView.setLayoutParams(params);
            image_background = itemView.findViewById(R.id.image_background);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
            hotelAddress = itemView.findViewById(R.id.hotelAddress);
        }
    }
}
