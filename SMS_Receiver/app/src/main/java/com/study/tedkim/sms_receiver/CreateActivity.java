package com.study.tedkim.sms_receiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etSender, etDate, etContents;
    Button btnSave, btnCancel;

    static final int SUCCESS = 1;
    static final int FAIL = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        initView();

    }

    public void initView(){

        etSender = (EditText) findViewById(R.id.editText_sender);
        etDate = (EditText) findViewById(R.id.editText_date);
        etContents = (EditText) findViewById(R.id.editText_contents);

        btnSave = (Button) findViewById(R.id.button_save);
        btnSave.setOnClickListener(this);

        btnCancel = (Button) findViewById(R.id.button_cancel);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_save:

                Intent intent = new Intent(this, MainActivity.class);

                String sender = etSender.getText().toString();
                String date = etDate.getText().toString();
                String contents = etContents.getText().toString();

                intent.putExtra("NEW_SENDER", sender);
                intent.putExtra("NEW_DATE", date);
                intent.putExtra("NEW_CONTENTS", contents);

                setResult(SUCCESS, intent);

                finish();

                break;

            case R.id.button_cancel:

                finish();

                break;

        }
    }
}
