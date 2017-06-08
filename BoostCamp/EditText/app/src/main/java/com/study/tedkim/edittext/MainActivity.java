package com.study.tedkim.edittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etText;
    Button btnSetText;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    public void initView(){

        etText = (EditText) findViewById(R.id.editText_text);
        tvResult = (TextView) findViewById(R.id.textView_result);

        btnSetText = (Button) findViewById(R.id.button_setText);
        btnSetText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button_setText){

            String text = etText.getText().toString();
            tvResult.setText(text);

        }

    }
}
