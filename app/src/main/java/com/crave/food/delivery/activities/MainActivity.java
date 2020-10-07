package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.crave.food.delivery.R;
import com.crave.food.delivery.fragments.HomeFragment;
import com.crave.food.delivery.fragments.LoginFragment;
import com.crave.food.delivery.fragments.RegisterFragment;
import com.crave.food.delivery.fragments.RestuarantFragment;
import com.crave.food.delivery.fragments.RestuarantViewFragment;
import com.crave.food.delivery.models.Type;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private NavigationView navigationView;
    private DrawerLayout navigation_drawer;

    private boolean isWantToLeave = false;

    @Override
    public void onBackPressed()
    {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1)
        {

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    isWantToLeave = false;
                }
            }, 2000);

            if (isWantToLeave)
            {
                finish();
            }
            else
            {
                Toast.makeText(this, "Press again to leave", Toast.LENGTH_SHORT).show();
            }
            isWantToLeave = true;
        }
        else
        {
            super.onBackPressed();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        setFragment(new RestuarantFragment(MainActivity.this,getSupportFragmentManager()));


    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
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
    public void onRestuarantViewClicked(Type type)
    {
        setFragment(new RestuarantViewFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onRestuarantClicked(Type type)
    {
        setFragment(new RestuarantViewFragment(MainActivity.this,getSupportFragmentManager()));
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