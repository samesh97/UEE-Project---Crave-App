package com.crave.food.delivery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.R;

public class LoginFragment extends Fragment implements View.OnClickListener
{
    private Context context;
    private FragmentManager manager;
    private LottieAnimationView login_animation;
    private ImageView navigation_drawer_icon;

    public LoginFragment(Context context, FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_login,null,false);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        login_animation.setRepeatCount(LottieDrawable.INFINITE);
//        login_animation.setAnimation(R.raw.login_vector);
//        login_animation.setRenderMode(RenderMode.SOFTWARE);
//        login_animation.playAnimation();

        navigation_drawer_icon.setOnClickListener(this);


    }

    private void initViews(View view)
    {
        login_animation = view.findViewById(R.id.login_animation);
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
    }
    @Override
    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
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
}
