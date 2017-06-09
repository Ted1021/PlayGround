package com.study.tedkim.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {

    TextView tvSimpleActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        tvSimpleActivity = (TextView) findViewById(R.id.textView_simpleActivity);

        Intent intent = getIntent();
        intent.putExtra("NAME", tvSimpleActivity.getText());
        setResult(RESULT_OK, intent);

    }
}
