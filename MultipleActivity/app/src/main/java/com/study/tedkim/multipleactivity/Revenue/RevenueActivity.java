package com.study.tedkim.multipleactivity.Revenue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.study.tedkim.multipleactivity.R;

import static com.study.tedkim.multipleactivity.Menu.MainActivity.REVENUE;

public class RevenueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        Toast.makeText(this, "Successfully Entered!!", Toast.LENGTH_SHORT).show();
        setResult(REVENUE);
        finish();
    }
}
