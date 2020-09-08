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
import com.crave.food.delivery.models.Type;

import java.util.ArrayList;

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.MyViewHolder>
{
    private Context context;
    private ArrayList<Type> list;
    private int currentSelectedItem  = 0;

    public TypeListAdapter(Context context, ArrayList<Type> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TypeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.type_list_row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeListAdapter.MyViewHolder holder, final int position)
    {
        if(list != null && list.size() > position)
        {
            Type type = list.get(position);
            holder.title.setText(type.getName());
            if(currentSelectedItem == position)
            {
                if(position % 2== 0)
                {
                    holder.image_background.setImageResource(R.drawable.tomato_background_left_oriented);
                }
                else
                {
                    holder.image_background.setImageResource(R.drawable.tomato_background_right_oriented);
                }
                holder.title.setTextColor(context.getResources().getColor(R.color.white));

            }
            else
            {
                if(position % 2== 0)
                {
                    holder.image_background.setImageResource(R.drawable.white_background_left_oriented);
                }
                else
                {
                    holder.image_background.setImageResource(R.drawable.white_background_right_oriented);
                }
                holder.title.setTextColor(context.getResources().getColor(R.color.orange));
            }


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    currentSelectedItem = position;
                    notifyDataSetChanged();
                }
            });

            holder.icon.setImageDrawable(type.getImageId());

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
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            image_background = itemView.findViewById(R.id.image_background);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
        }
    }
}