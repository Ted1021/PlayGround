package com.study.tedkim.textview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvBasic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    public void initView(){

        tvBasic = (TextView) findViewById(R.id.textView_basic);
        tvBasic.setText(R.string.android_inside);

    }
}
