package com.crave.food.delivery.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.activities.NotLoggedActivity;
import com.crave.food.delivery.config.SharedPrefManager;
import com.crave.food.delivery.models.User;
import com.google.android.material.snackbar.Snackbar;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    public static final int IMAGE_PICK_REQUEST_CODE = 200;

    private Context context;
    private FragmentManager manager;

    private ImageView navigation_drawer_icon;
    private Button register_btn;

    private EditText username_et,email_et,password_et,c_password_et;
    private ImageView profile_pic;

    private Uri imageUri = null;

    public RegisterFragment(Context context,FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_PICK_REQUEST_CODE && data != null)
        {
            imageUri = data.getData();
            profile_pic.setImageURI(imageUri);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.register_layout,null);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        navigation_drawer_icon.setOnClickListener(this);
        register_btn.setOnClickListener(this);
        profile_pic.setOnClickListener(this);
    }

    private void initViews(View view)
    {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        register_btn = view.findViewById(R.id.register_btn);
        username_et = view.findViewById(R.id.username_et);
        email_et = view.findViewById(R.id.email_et);
        password_et = view.findViewById(R.id.password_et);
        c_password_et = view.findViewById(R.id.c_password_et);
        profile_pic = view.findViewById(R.id.profile_pic);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
        }
        else if(view == profile_pic)
        {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, IMAGE_PICK_REQUEST_CODE);
        }
        else if(view == register_btn)
        {
            String userName = username_et.getText().toString().trim();
            String email = email_et.getText().toString().trim();
            String password = password_et.getText().toString().trim();
            String cPassword = c_password_et.getText().toString().trim();




            if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 120);
                return;
            }

            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 130);
                return;
            }


            if (userName.isEmpty())
            {
                Toast.makeText(context, "Please enter Username", Toast.LENGTH_SHORT).show();
            }
            else if (email.isEmpty())
            {
                Toast.makeText(context, "Please enter Email", Toast.LENGTH_SHORT).show();
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                Toast.makeText(context, "Please enter valid Email", Toast.LENGTH_SHORT).show();
            }
            else if (password.isEmpty())
            {
                Toast.makeText(context, "Please enter Password", Toast.LENGTH_SHORT).show();
            }
            else if (cPassword.isEmpty())
            {
                Toast.makeText(context, "Please confirm Password", Toast.LENGTH_SHORT).show();
            }
            else if (!password.equals(cPassword))
            {
                Toast.makeText(context, "Please mismatched", Toast.LENGTH_SHORT).show();
            }
            else if(imageUri == null)
            {
                Toast.makeText(context, "Please pick an image", Toast.LENGTH_SHORT).show();
            }
            else
            {
                User user = new User();
                user.setEmail(email);
                user.setUserName(userName);
                user.setPassword(password);
                user.setImage(imageUri.toString());
                SharedPrefManager.setUser(context,user);

                Toast.makeText(context, "Registration Success", Toast.LENGTH_SHORT).show();
                if(context instanceof NotLoggedActivity)
                {
                    ((NotLoggedActivity) context).onBackPressed();
                }




            }
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
