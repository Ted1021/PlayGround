package com.study.tedkim.multipleactivity.LogIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.study.tedkim.multipleactivity.Menu.MainActivity;
import com.study.tedkim.multipleactivity.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initView();

    }

    public void initView(){

        etName = (EditText) findViewById(R.id.editText_id);
        etPassword = (EditText) findViewById(R.id.editText_pw);

        btnSignIn = (Button) findViewById(R.id.button_signIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_signIn:

                String userName = etName.getText().toString();
                String password = etPassword.getText().toString();

                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                intent.putExtra("name", userName);
                intent.putExtra("password", password);

                startActivity(intent);

                break;
        }
    }
}
