package com.study.tedkim.button_widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ImageButton imageButton;
    CheckBox checkBox;
    ToggleButton toggleButton;
    Switch aSwitch;
    RadioButton radioButton;

    TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    public void initView() {

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(this);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(this);

        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnClickListener(this);

        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.textView_result);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:

                tvResult.setText("Button is clicked !");

                break;

            case R.id.imageButton:

                tvResult.setText("ImageButton is clicked !");

                break;

            case R.id.checkBox:

                if (checkBox.isChecked())
                    tvResult.setText("check button is checked !");
                else
                    tvResult.setText("check button is un-checked !");

                break;

            case R.id.toggleButton:

//                if(!mToggleButtonFlag) {
//                    tvResult.setText("toggleButton is Activated !");
//                    mToggleButtonFlag = true;
//                    toggleButton.setActivated(mToggleButtonFlag);
//                }

                if (!toggleButton.isActivated()) {
                    tvResult.setText("toggleButton is Activated !");
                    toggleButton.setActivated(true);
                } else {
                    tvResult.setText("toggleButton is diactivated !");
                    toggleButton.setActivated(false);
                }

                break;

            case R.id.switch1:

                if (!aSwitch.isActivated()) {
                    tvResult.setText("switch is activated !");
                    aSwitch.setActivated(true);
                } else {
                    tvResult.setText("switch is diactivated !");
                    aSwitch.setActivated(false);
                }

                break;

            case R.id.radioButton:

                if(!radioButton.isActivated()){
                    tvResult.setText("radio button is activated");
                    radioButton.setActivated(true);
                }
                else{
                    tvResult.setText("radio button is diactivated !");
                    radioButton.setActivated(false);
                }

                break;

        }
    }
}
