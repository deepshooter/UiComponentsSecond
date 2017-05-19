package com.deepshooter.uicomponentssecond.multipleselectlistview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.deepshooter.uicomponentssecond.R;
import com.deepshooter.uicomponentssecond.bean.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avinashmishra on 02-05-2017.
 */

public class MultipleSelectListViewAdapter extends RecyclerView.Adapter<MultipleSelectListViewAdapter.MyViewHolder> {

    Context context;
    List<Data> dataList;

    List<String> row_index;
    private OnRowClick onRowClick;

    public MultipleSelectListViewAdapter(Context context, List<Data> dataList, OnRowClick onRowClick) {
        this.context = context;
        this.dataList = dataList;
        this.onRowClick=onRowClick;
        row_index = new ArrayList<>();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_multiselect_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

         holder.mNumberText.setText(dataList.get(position).getmNumber());
         holder.mText.setText(dataList.get(position).getmText());


        if(!row_index.isEmpty()){
            if(row_index.contains(position+"")){
                holder.mNumberText.setTextColor(ContextCompat.getColor(context, R.color.grey));
                holder.mText.setTextColor(ContextCompat.getColor(context, R.color.grey));
                holder.itemLayout.setBackgroundResource(R.drawable.list_background);

            }
            else{
                holder.mNumberText.setTextColor(ContextCompat.getColor(context, R.color.white));
                holder.mText.setTextColor(ContextCompat.getColor(context, R.color.white));
                holder.itemLayout.setBackgroundResource(R.drawable.list_background_gray);

            }

        }

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (row_index.contains(position + "")) {
                    row_index.remove(position + "");


                    onRowClick.onRowClick(row_index);
                }else {

                    row_index.add(position + "");
                    onRowClick.onRowClick(row_index);
                }

                notifyDataSetChanged();
            }

        });


    }

    @Override
    public int getItemCount() {

        if (dataList == null || dataList.size() == 0)
            return 0;
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mNumberText,mText;
        LinearLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNumberText = (TextView) itemView.findViewById(R.id.vT_number);
            mText = (TextView) itemView.findViewById(R.id.vT_Text);
            itemLayout = (LinearLayout) itemView.findViewById(R.id.vL_item_Layout);

        }
    }

    public interface OnRowClick {
        void onRowClick (List<String> row);
    }

}
