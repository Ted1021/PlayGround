package com.study.tedkim.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSimpleIntent, btnImplicitIntent;

    static final int SIMPLE_ACTIVITY = 101;
    static final int IMPLICIT_ACTIVITY = 102;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    public void initView() {

        btnSimpleIntent = (Button) findViewById(R.id.button_simple_intent);
        btnSimpleIntent.setOnClickListener(this);

        btnImplicitIntent = (Button) findViewById(R.id.button_implicit_intent);
        btnImplicitIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent ;

        switch (v.getId()) {

            case R.id.button_simple_intent:

                intent = new Intent(MainActivity.this, SimpleActivity.class);
                startActivityForResult(intent, SIMPLE_ACTIVITY);

                break;

            case R.id.button_implicit_intent:

                intent = new Intent(MainActivity.this, ImplicitActivity.class);
                startActivityForResult(intent, IMPLICIT_ACTIVITY);

                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            String recentActivity="";

            switch(requestCode){

                case SIMPLE_ACTIVITY:

                    recentActivity = data.getStringExtra("NAME");
                    Toast.makeText(MainActivity.this, "Visit "+recentActivity, Toast.LENGTH_LONG).show();

                    break;

                case IMPLICIT_ACTIVITY:

                    recentActivity = data.getStringExtra("NAME");
                    Toast.makeText(MainActivity.this, "Visit "+recentActivity, Toast.LENGTH_LONG).show();

                    break;
            }



        }
    }
}
