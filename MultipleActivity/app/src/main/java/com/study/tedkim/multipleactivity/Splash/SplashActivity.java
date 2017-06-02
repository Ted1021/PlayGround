package com.study.tedkim.multipleactivity.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.study.tedkim.multipleactivity.LogIn.HomeActivity;
import com.study.tedkim.multipleactivity.R;

public class SplashActivity extends AppCompatActivity {

    ImageView ivSplashIcon;
    private static final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // splash activity 정의
        ivSplashIcon = (ImageView) findViewById(R.id.imageView_splash_icon);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                // splash 아이콘 이미지 로딩
                Glide.with(SplashActivity.this).load(R.drawable.splash_icon).into(ivSplashIcon);

                // 로그인 메인 화면으로 이동
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();

            }

        }, SPLASH_DISPLAY_LENGTH);

    }
}
