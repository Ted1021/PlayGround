package com.study.tedkim.multipleactivity.LogIn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.study.tedkim.multipleactivity.Menu.MainActivity;
import com.study.tedkim.multipleactivity.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPassword;
    Button btnSignIn;

    String mUserId, mUserPassword;

    static final String FILENAME = "com.study.tedkim.multipleactivity.userInfo";

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

    public void checkPreference(){

        SharedPreferences pref = getSharedPreferences(FILENAME, MODE_PRIVATE);
        SharedPreferences.Editor pEditor;

        if(!pref.contains("INIT")){

            pEditor = pref.edit();

            pEditor.putBoolean("INIT", true);

            pEditor.putString("USER_ID", mUserId);
            pEditor.putString("USER_PW", mUserPassword);

            pEditor.commit();

            setActivity();
        }

        else{

            String checkUserId = pref.getString("USER_ID", null);
            String checkUserPw = pref.getString("USER_PW", null);

            Log.e("CHECK_Pref", ">>>>>>>>"+checkUserId+" / "+checkUserPw);


            if( (checkUserId.equals(mUserId)) && (checkUserPw.equals(mUserPassword)) )
                setActivity();

            else
                Toast.makeText(SignInActivity.this, "아이디 또는 패스워드가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_signIn:

                mUserId = etName.getText().toString();
                mUserPassword = etPassword.getText().toString();

                checkPreference();

                break;
        }
    }

    public void setActivity(){

        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        intent.putExtra("USER_ID", mUserId);
        intent.putExtra("USER_PW", mUserPassword);

        startActivity(intent);
        this.finish();

    }
}
