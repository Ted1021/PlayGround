package com.study.tedkim.multipleactivity.Product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.study.tedkim.multipleactivity.R;

import static com.study.tedkim.multipleactivity.Menu.MainActivity.PRODUCT;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toast.makeText(this, "Successfully Entered!!", Toast.LENGTH_SHORT).show();
        setResult(PRODUCT);
        finish();
    }
}
