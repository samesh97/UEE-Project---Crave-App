package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.crave.food.delivery.R;
import com.crave.food.delivery.config.SharedPrefManager;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent;
                if(!SharedPrefManager.isLoggedIn(SplashScreen.this))
                {
                    intent = new Intent(SplashScreen.this,NotLoggedActivity.class);
                }
                else
                {
                    intent = new Intent(SplashScreen.this,MainActivity.class);
                }
                startActivity(intent);
                finish();

            }
        },2000);
    }
}