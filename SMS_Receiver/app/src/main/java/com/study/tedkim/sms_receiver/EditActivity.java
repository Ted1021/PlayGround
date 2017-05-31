package com.study.tedkim.sms_receiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etSender, etDate, etContents;
    Button btnSave, btnCancel;

    static final int SUCCESS = 1;
    static final int FAIL = -1;

    int itemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initView();
        setData();
    }

    public void initView() {

        etSender = (EditText) findViewById(R.id.editText_sender);
        etDate = (EditText) findViewById(R.id.editText_date);
        etContents = (EditText) findViewById(R.id.editText_contents);

        btnSave = (Button) findViewById(R.id.button_save);
        btnSave.setOnClickListener(this);

        btnCancel = (Button) findViewById(R.id.button_cancel);
        btnCancel.setOnClickListener(this);

    }

    public void setData(){

        Intent intent = getIntent();
        String sender = intent.getStringExtra("EDIT_SENDER");
        String date = intent.getStringExtra("EDIT_DATE");
        String contents = intent.getStringExtra("EDIT_CONTENTS");
        itemIndex = intent.getIntExtra("EDIT_INDEX", -1);

        etSender.setText(sender);
        etDate.setText(date);
        etContents.setText(contents);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_save:

                Intent intent = new Intent(this, MainActivity.class);

                String sender = etSender.getText().toString();
                String date = etDate.getText().toString();
                String contents = etContents.getText().toString();


                intent.putExtra("EDIT_SENDER", sender);
                intent.putExtra("EDIT_DATE", date);
                intent.putExtra("EDIT_CONTENTS", contents);
                intent.putExtra("EDIT_INDEX", itemIndex);

                setResult(SUCCESS, intent);

                finish();

                break;

            case R.id.button_cancel:

                finish();

                break;

        }
    }
}
