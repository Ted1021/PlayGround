package com.study.tedkim.multipleactivity.Customer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.study.tedkim.multipleactivity.R;

import java.util.ArrayList;

import static com.study.tedkim.multipleactivity.Menu.MainActivity.CUSTOMER;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvName;
    EditText etName;
    Button btnAdd, btnExit;

    ArrayList<CustomerItem> mDataSet = new ArrayList<>();

    CustomListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        initView();
        initDataSet();
        setListView();
    }

    public void initView(){

        tvName = (TextView) findViewById(R.id.textView_name);
        etName = (EditText) findViewById(R.id.editText_name);

        btnAdd = (Button) findViewById(R.id.button_add);
        btnAdd.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.button_exit);
        btnExit.setOnClickListener(this);

    }

    // TODO - 여길 SQLite 로!
    public void initDataSet(){

        for(int i=0; i<20; i++){
            CustomerItem item = new CustomerItem();

            item.name = i+97+"";
            item.age = 20+i;
            item.address = "asdasd";
            item.tel = "010"+i+"3"+i+"7"+"1234";

            mDataSet.add(item);
        }
    }

    public void setListView(){

        ListView lvList = (ListView) findViewById(R.id.listView_list);
        mAdapter = new CustomListAdapter(this, R.layout.customer_item, mDataSet);
        lvList.setAdapter(mAdapter);

    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_add:

                CustomerItem item = new CustomerItem();
                String name = etName.getText().toString();
                item.name = name;

                etName.clearComposingText();

                mDataSet.add(item);
                mAdapter.notifyDataSetChanged();

                break;

            case R.id.button_exit:

                setResult(CUSTOMER);
                finish();

                break;

        }
    }
}
