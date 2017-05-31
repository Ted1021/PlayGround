package com.study.tedkim.multipleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvUserName, tvRecentFunction;
    Button btnCustomer, btnProduct, btnRevenue;

    public static final int CUSTOMER = 100;
    public static final int PRODUCT = 101;
    public static final int REVENUE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView(){

        tvUserName = (TextView) findViewById(R.id.textView_userName);
        Intent intent_SignIn = getIntent();
        String userName = intent_SignIn.getStringExtra("name");
        tvUserName.setText(userName);


        tvRecentFunction = (TextView) findViewById(R.id.textView_recentFunction);

        btnCustomer = (Button) findViewById(R.id.button_customer);
        btnCustomer.setOnClickListener(this);

        btnProduct = (Button) findViewById(R.id.button_product);
        btnProduct.setOnClickListener(this);

        btnRevenue = (Button) findViewById(R.id.button_revenue);
        btnRevenue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch(v.getId()){

            case R.id.button_customer:

                intent = new Intent(this, CustomerActivity.class);
                startActivityForResult(intent, CUSTOMER);

                break;

            case R.id.button_product:

                intent = new Intent(this, ProductActivity.class);
                startActivityForResult(intent, PRODUCT);

                break;

            case R.id.button_revenue:

                intent = new Intent(this, RevenueActivity.class);
                startActivityForResult(intent, REVENUE);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){

            case CUSTOMER:

                tvRecentFunction.setText("Customer");

                break;

            case PRODUCT:

                tvRecentFunction.setText("Product");

                break;

            case REVENUE:

                tvRecentFunction.setText("Revenue");

                break;
        }
    }
}
