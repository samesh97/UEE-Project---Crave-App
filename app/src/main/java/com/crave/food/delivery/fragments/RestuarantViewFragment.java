package com.crave.food.delivery.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.models.Type;

public class RestuarantViewFragment extends Fragment implements View.OnClickListener {


    private Context context;
    private FragmentManager manager;

    private ImageView navigation_drawer_icon;
    private Button btn_bookATable;
    private Type type;

    private TextView name,hotelAddress;

    public RestuarantViewFragment(Context context, FragmentManager manager, Type type)
    {
        this.context = context;
        this.manager = manager;
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view1 = LayoutInflater.from(context).inflate(R.layout.layout_restuarant_view,null);
        initViews(view1);
        setData();
        return view1;
    }

    private void setData() {
        navigation_drawer_icon.setOnClickListener(this);
        btn_bookATable.setOnClickListener(this);

        name.setText(type.getName());
        hotelAddress.setText(type.getAddress());
    }

    private void initViews(View view)
    {

        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        btn_bookATable = view.findViewById(R.id.btn_bookTable);
        name = view.findViewById(R.id.textView5);
        hotelAddress = view.findViewById(R.id.hotelAddress);

    }
    @Override
    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
        }
        else if(view== btn_bookATable)
        {
            onBookATableClicked();
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



    public void onBookATableClicked() {
        Fragment fragment = new TableFragment(context,manager);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}