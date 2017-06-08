package com.study.tedkim.spinner;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener, View.OnClickListener {

    TextView tvResult;
    Spinner spSortingOptions;

    String[] mPlanetDataset;
    String[] mCityDataset;
    String mTestString;

    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    public void initView(){

        tvResult = (TextView) findViewById(R.id.textView_result);

        spSortingOptions = (Spinner) findViewById(R.id.spinner_sortOptions);
        spSortingOptions.setOnItemSelectedListener(this);

        btnChange = (Button) findViewById(R.id.button_change);
        btnChange.setOnClickListener(this);

    }

    public void initData(){

        Resources res = getResources();
        mPlanetDataset = res.getStringArray(R.array.planets_array);
        mCityDataset = res.getStringArray(R.array.city_array);
        mTestString = res.getString(R.string.test_string);
        tvResult.setText(mTestString);

    }

    public void changeSpinnerDataset(){

        // TODO - Why use 'charSequence' ?
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.city_array,
                android.R.layout.simple_spinner_item);

        spSortingOptions.setAdapter(spinnerAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String name = (String) parent.getItemAtPosition(position);
        tvResult.setText(name);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_change:

                changeSpinnerDataset();

                break;

        }
    }
}
