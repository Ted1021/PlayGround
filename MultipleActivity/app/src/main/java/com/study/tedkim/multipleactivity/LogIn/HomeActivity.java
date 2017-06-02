package com.study.tedkim.multipleactivity.LogIn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.study.tedkim.multipleactivity.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivBackground;
    Button btnSignUp, btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();

    }

    public void initView(){

        ivBackground = (ImageView) findViewById(R.id.imageView_home_background);
        Glide.with(this).load(R.drawable.home_image_1).into(ivBackground);
        ivBackground.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);   // shader

        btnSignUp = (Button) findViewById(R.id.button_signUp);
        btnSignUp.setOnClickListener(this);

        btnSignIn = (Button) findViewById(R.id.button_signIn);
        btnSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch(v.getId()){

            case R.id.button_signUp:

                break;

            case R.id.button_signIn:

                intent = new Intent(HomeActivity.this, SignInActivity.class);
                startActivity(intent);

                break;

        }

    }
}
