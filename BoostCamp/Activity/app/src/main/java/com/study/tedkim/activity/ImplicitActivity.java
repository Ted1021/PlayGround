package com.study.tedkim.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ImplicitActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDial, btnContact, btnGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        initView();

        Intent intent = getIntent();
        intent.putExtra("NAME", "Implicit Activity");
        setResult(RESULT_OK, intent);

    }

    public void initView(){

        btnDial = (Button) findViewById(R.id.button_dial);
        btnDial.setOnClickListener(this);

        btnContact = (Button) findViewById(R.id.button_contact);
        btnContact.setOnClickListener(this);

        btnGallery = (Button) findViewById(R.id.button_gallery);
        btnGallery.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        Intent intent;

        switch(v.getId()){

            case R.id.button_dial:

                intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);

                break;

            case R.id.button_contact:

                intent = new Intent(Intent.ACTION_PICK);
                intent.setData(Uri.parse("content://contacts/phones"));
                startActivity(intent);

                break;

            case R.id.button_gallery:

                intent = new Intent();


                break;

        }

    }
}
