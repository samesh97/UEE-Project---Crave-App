package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.crave.food.delivery.R;
import com.crave.food.delivery.fragments.HomeFragment;
import com.crave.food.delivery.fragments.LoginFragment;
import com.crave.food.delivery.fragments.RegisterFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private NavigationView navigationView;
    private DrawerLayout navigation_drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        setFragment(new HomeFragment(MainActivity.this,getSupportFragmentManager()));


    }

    private void setFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }

    private void initViews()
    {

        navigationView = findViewById(R.id.navigationView);
        navigation_drawer = findViewById(R.id.navigation_drawer);


    }

    public void showNavigationDialog()
    {

        if(navigation_drawer.isDrawerOpen(navigationView))
        {
            navigation_drawer.closeDrawer(navigationView,true);
        }
        else
        {
            navigation_drawer.openDrawer(navigationView,true);
        }
    }

    public void Login(View view)
    {
        setFragment(new LoginFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onHomeClicked(View view)
    {
        setFragment(new HomeFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void onRegisterClicked(View view)
    {
        setFragment(new RegisterFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public boolean isNavigationOpened()
    {
        if(navigation_drawer.isDrawerOpen(navigationView))
        {
            return true;
        }
        return false;
    }

}