package com.crave.food.delivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.crave.food.delivery.R;
import com.crave.food.delivery.fragments.LoginFragment;
import com.crave.food.delivery.fragments.RegisterFragment;

public class NotLoggedActivity extends AppCompatActivity {

    private boolean  isWantToLeave = false;

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1)
        {
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
        setContentView(R.layout.activity_not_logged);


        Fragment fragment = new LoginFragment(NotLoggedActivity.this,getSupportFragmentManager());
        replaceFragment(fragment);

    }
    private void replaceFragment (Fragment fragment)
    {
        String backStateName =  fragment.getClass().getName();
        String fragmentTag = backStateName;

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.frame, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }

    }
    public void onRegisterClicked(View view)
    {
        replaceFragment(new RegisterFragment(NotLoggedActivity.this,getSupportFragmentManager()));
    }
    public void GoToMainActivity()
    {
        Intent intent = new Intent(NotLoggedActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}