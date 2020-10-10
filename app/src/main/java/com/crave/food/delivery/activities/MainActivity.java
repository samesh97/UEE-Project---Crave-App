package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crave.food.delivery.R;
import com.crave.food.delivery.config.SharedPrefManager;
import com.crave.food.delivery.fragments.CartFragment;
import com.crave.food.delivery.fragments.FavoriteFragment;
import com.crave.food.delivery.fragments.HomeFragment;
import com.crave.food.delivery.fragments.LoginFragment;
import com.crave.food.delivery.fragments.NotificationFragment;
import com.crave.food.delivery.fragments.OffersFragment;
import com.crave.food.delivery.fragments.OrderFragment;
import com.crave.food.delivery.fragments.ProfileFragment;
import com.crave.food.delivery.fragments.RegisterFragment;
import com.crave.food.delivery.fragments.RestuarantFragment;
import com.crave.food.delivery.fragments.RestuarantViewFragment;
import com.crave.food.delivery.models.Restuarant;
import com.crave.food.delivery.models.Type;
import com.crave.food.delivery.models.User;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

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

            if(isNavigationOpened())
            {
                showNavigationDialog();
            }
            else
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

        TextView user_name = findViewById(R.id.user_name);
        CircleImageView profile_pic = findViewById(R.id.profile_pic);


        User user = SharedPrefManager.getUser(MainActivity.this);
        user_name.setText(user.getUserName());

        String image = user.getImage();
        Uri uri = Uri.parse(image);

        profile_pic.setImageURI(uri);

        homeFragment = new HomeFragment(MainActivity.this,getSupportFragmentManager());
        replaceFragment(homeFragment);


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
        replaceFragment(new LoginFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onProfileClicked(View view)
    {
        replaceFragment(new ProfileFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onHomeClicked(View view)
    {
        if(homeFragment == null)
        {
            homeFragment = new HomeFragment(MainActivity.this,getSupportFragmentManager());
        }
        replaceFragment(homeFragment);
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void Cart(View view)
    {
        replaceFragment(new CartFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void Favorite(View view)
    {
        replaceFragment(new FavoriteFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void Orders(View view)
    {
        replaceFragment(new OrderFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void Offers(View view)
    {
        replaceFragment(new OffersFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void Notification(View view)
    {
        replaceFragment(new NotificationFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onRegisterClicked(View view)
    {
        replaceFragment(new RegisterFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void onRestuarantViewClicked(Type type)
    {
        replaceFragment(new RestuarantViewFragment(MainActivity.this,getSupportFragmentManager(),type));
        if(isNavigationOpened())
            showNavigationDialog();
    }

    public void onRestuarantClicked(Restuarant restuarant)
    {
        replaceFragment(new RestuarantFragment(MainActivity.this,getSupportFragmentManager()));
        if(isNavigationOpened())
            showNavigationDialog();
    }
    public void setFragment(int layout,Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.bottom_to_top,0).replace(layout, fragment).commit();
    }



    public boolean isNavigationOpened()
    {
        if(navigation_drawer.isDrawerOpen(navigationView))
        {
            return true;
        }
        return false;
    }
    private void replaceFragment (Fragment fragment)
    {
        String backStateName =  fragment.getClass().getName();
        String fragmentTag = backStateName;

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.frame_layout, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }

    }

    public void Logout(View view)
    {
        SharedPrefManager.setUserLoggedIn(MainActivity.this,false);
        startActivity(new Intent(MainActivity.this,NotLoggedActivity.class));
        finish();
    }
}