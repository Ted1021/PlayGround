package com.study.tedkim.multipleactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tedkim on 2017. 5. 30..
 */

public class CustomListAdapter extends BaseAdapter {

    Context mContext;
    int mLayout;
    ArrayList<CustomerItem> mDataSet = new ArrayList<>();
    LayoutInflater mInflater;

    public CustomListAdapter(Context context, int layout, ArrayList<CustomerItem>dataSet){

        mContext = context;
        mLayout = layout;
        mDataSet = dataSet;

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = mInflater.inflate(mLayout, parent, false);
        }

        TextView tvName, tvAge, tvAddress, tvTel;
        String name, age, address, tel;

        name = mDataSet.get(position).name;
        age = mDataSet.get(position).age;
        address = mDataSet.get(position).address;
        tel = mDataSet.get(position).tel;

        tvName = (TextView) convertView.findViewById(R.id.textView_name);
        tvAge = (TextView) convertView.findViewById(R.id.textView_age);
        tvAddress = (TextView) convertView.findViewById(R.id.textView_address);
        tvTel = (TextView) convertView.findViewById(R.id.textView_tel);

        tvName.setText(name);
        tvAge.setText(age);
        tvAddress.setText(address);
        tvTel.setText(tel);

        return convertView;
    }
}
