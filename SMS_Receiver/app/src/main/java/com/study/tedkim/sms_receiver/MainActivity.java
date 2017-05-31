package com.study.tedkim.sms_receiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNewMsg;
    TextView tvCount;
    RecyclerView rvMsgList;

    ArrayList<MsgItem> mDataSet = new ArrayList<>();

    MsgAdapter mAdapter;

    public static final int NEW_MSG = 100;
    public static final int EDIT_MSG = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        setRecyclerView();
    }

    public void initView() {

        tvCount = (TextView) findViewById(R.id.textView_count);
        tvCount.setText(mDataSet.size() + "");

        btnNewMsg = (Button) findViewById(R.id.button_newMessage);
        btnNewMsg.setOnClickListener(this);
    }

    public void setRecyclerView() {

        mAdapter = new MsgAdapter(this, R.layout.message_item, mDataSet);

        rvMsgList = (RecyclerView) findViewById(R.id.recyclerView_msgList);
        rvMsgList.setAdapter(mAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvMsgList.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_newMessage:

                Intent intent = new Intent(this, CreateActivity.class);
                startActivityForResult(intent, NEW_MSG);

                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        MsgItem item;

        if (resultCode == 1) {
            switch (requestCode) {

                case NEW_MSG:

                    item = new MsgItem();

                    item.writer = data.getStringExtra("NEW_SENDER");
                    item.date = data.getStringExtra("NEW_DATE");
                    item.contents = data.getStringExtra("NEW_CONTENTS");

                    mDataSet.add(item);

                    break;

                case EDIT_MSG:

                    int index = data.getIntExtra("EDIT_INDEX", -1);
                    if(index == -1)
                        return;

                    item = mDataSet.get(index);

                    item.writer = data.getStringExtra("EDIT_SENDER");
                    item.date = data.getStringExtra("EDIT_DATE");
                    item.contents = data.getStringExtra("EDIT_CONTENTS");

                    break;
            }

            tvCount.setText(mDataSet.size()+"");
            mAdapter.notifyDataSetChanged();
        }
    }

    public void initData() {

        MsgArchive data = new MsgArchive();

        for (int i = 0; i < 20; i++) {

            MsgItem item = new MsgItem();

            item.writer = data.senders.get(i);
            item.date = data.dates.get(i);
            item.contents = data.contents.get(i);

            mDataSet.add(item);
        }
    }
}
