package com.crave.food.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import com.bumptech.glide.Glide;

public class LoginScreen extends AppCompatActivity {


    private LottieAnimationView login_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        initViews();
        setData();



    }

    private void setData()
    {
        login_animation.setRepeatCount(LottieDrawable.INFINITE);
        login_animation.setAnimation(R.raw.login_vector);
        login_animation.setRenderMode(RenderMode.SOFTWARE);
        login_animation.playAnimation();


    }

    private void initViews()
    {
        login_animation = findViewById(R.id.login_animation);
    }
}