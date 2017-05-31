package com.study.tedkim.sms_receiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static com.study.tedkim.sms_receiver.MainActivity.EDIT_MSG;

/**
 * Created by tedkim on 2017. 5. 31..
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder> {

    Context mContext;
    int mLayout;
    ArrayList<MsgItem> mDataSet = new ArrayList<>();
    LayoutInflater mInflater;

    public MsgAdapter(Context context, int layout, ArrayList<MsgItem> dataSet) {

        mContext = context;
        mLayout = layout;
        mDataSet = dataSet;

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class MsgViewHolder extends RecyclerView.ViewHolder {

        CardView cvMsgItem;
        TextView tvSender, tvDate, tvContents;

        public MsgViewHolder(View itemView) {
            super(itemView);

            cvMsgItem = (CardView) itemView.findViewById(R.id.cardView_message);
            tvSender = (TextView) itemView.findViewById(R.id.textView_sender);
            tvDate = (TextView) itemView.findViewById(R.id.textView_date);
            tvContents = (TextView) itemView.findViewById(R.id.textView_contents);

        }
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(mLayout, parent, false);
        MsgViewHolder viewHolder = new MsgViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, final int position) {

        MsgItem item = mDataSet.get(position);

        final String sender = item.writer;
        final String date = item.date;
        final String contents = item.contents;

        holder.tvSender.setText(sender);
        holder.tvDate.setText(date);

        if (contents.length() > 20) {
            String temp = contents.substring(0, 10);
            holder.tvContents.setText(temp+"...");
        }
        else
            holder.tvContents.setText(contents);


        holder.cvMsgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, EditActivity.class);

                intent.putExtra("EDIT_INDEX", position);
                intent.putExtra("EDIT_SENDER", sender);
                intent.putExtra("EDIT_DATE", date);
                intent.putExtra("EDIT_CONTENTS", contents);

                Activity origin = (Activity) mContext;
                origin.startActivityForResult(intent, EDIT_MSG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
