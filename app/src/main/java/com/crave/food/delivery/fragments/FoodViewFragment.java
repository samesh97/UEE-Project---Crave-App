package com.crave.food.delivery.fragments;

import android.content.Context;
import  android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.crave.food.delivery.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodViewFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context context;
    private FragmentManager manager;
    private RecyclerView foodRecyclerView;
    private FrameLayout home_sub_frame_layout;
    private ImageView navigation_drawer_icon;
    private EditText editText;

    public FoodViewFragment(Context context,FragmentManager manager) {
        this.context = context;
        this.manager = manager;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodViewFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static FoodViewFragment newInstance(String param1, String param2) {
//        FoodViewFragment fragment = new FoodViewFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_view, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}