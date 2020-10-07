package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.crave.food.delivery.R;
import com.crave.food.delivery.fragments.HomeFragment;
import com.crave.food.delivery.fragments.LoginFragment;
import com.crave.food.delivery.fragments.ProfileFragment;
import com.crave.food.delivery.fragments.RegisterFragment;
import com.crave.food.delivery.fragments.RestuarantFragment;
import com.crave.food.delivery.fragments.RestuarantViewFragment;
import com.crave.food.delivery.models.Restuarant;
import com.crave.food.delivery.models.Type;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private NavigationView navigationView;
    private DrawerLayout navigation_drawer;

    private boolean isWantToLeave = false;
    private HomeFragment homeFragment = null;

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
        homeFragment = new HomeFragment(MainActivity.this,getSupportFragmentManager());
        setFragment(homeFragment);


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

    public void Profile(View view)
    {
        setFragment(new ProfileFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onHomeClicked(View view)
    {
        if(homeFragment == null)
        {
            homeFragment = new HomeFragment(MainActivity.this,getSupportFragmentManager());
        }
        setFragment(homeFragment);
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
        setFragment(new RestuarantViewFragment(MainActivity.this,getSupportFragmentManager(),type));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onRestuarantClicked(Restuarant restuarant)
    {
        setFragment(new RestuarantFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void setFragment(int layout,Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(layout, fragment).addToBackStack(null).commit();
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