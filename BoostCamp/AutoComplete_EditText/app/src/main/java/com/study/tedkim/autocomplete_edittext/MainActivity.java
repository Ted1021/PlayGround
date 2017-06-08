package com.study.tedkim.autocomplete_edittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView atText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = { "SM3", "SM5", "SM7", "SONATA", "AVANTE", "SOUL", "K5", "K7" };

        atText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        atText.setAdapter(adapter);

    }
}
