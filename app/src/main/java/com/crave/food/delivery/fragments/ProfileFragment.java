package com.crave.food.delivery.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.config.SharedPrefManager;
import com.crave.food.delivery.models.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements View.OnClickListener
{
    private Context context;
    private FragmentManager manager;

    private ImageView navigation_drawer_icon;

    private EditText username_et,email_et,password_et,c_password_et;
    private Button register_btn;

    private Uri imageUri = null;
    public static final int IMAGE_PICK_REQUEST_CODE = 200;
    private CircleImageView profile_pic;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_PICK_REQUEST_CODE && data != null)
        {
            imageUri = data.getData();
            profile_pic.setImageURI(imageUri);
        }

    }

    public ProfileFragment(Context context,FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_profile,container,false);
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        navigation_drawer_icon.setOnClickListener(this);

        username_et = view.findViewById(R.id.username_et);
        email_et = view.findViewById(R.id.email_et);
        password_et = view.findViewById(R.id.password_et);
        c_password_et = view.findViewById(R.id.c_password_et);
        register_btn = view.findViewById(R.id.register_btn);
        profile_pic = view.findViewById(R.id.profile_pic);

        profile_pic.setOnClickListener(this);
        register_btn.setOnClickListener(this);


        User user = SharedPrefManager.getUser(context);

        username_et.setText(user.getUserName());
        email_et.setText(user.getEmail());
        password_et.setText(user.getPassword());
        c_password_et.setText(user.getPassword());
        profile_pic.setImageURI(Uri.parse(user.getImage()));

        return view;
    }

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
            else
            {
                User user = new User();
                user.setUserName(userName);
                user.setEmail(email);
                user.setPassword(password);
                if(imageUri != null)
                {
                    user.setImage(imageUri.toString());
                }
                else
                {
                    User user1 = SharedPrefManager.getUser(context);
                    user.setImage(user1.getImage());
                }

                SharedPrefManager.setUserLoggedIn(context,true);
                SharedPrefManager.setUser(context,user);

                Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
                if(context instanceof MainActivity)
                {
                    ((MainActivity) context).onBackPressed();
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
