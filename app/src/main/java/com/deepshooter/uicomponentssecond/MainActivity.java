package com.deepshooter.uicomponentssecond;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deepshooter.uicomponentssecond.customdialog.CustomDialogTestActivity;
import com.deepshooter.uicomponentssecond.dialogfragment.CustomDialogFragment;
import com.deepshooter.uicomponentssecond.dialogfragment.DialogFragmentTestActivity;
import com.deepshooter.uicomponentssecond.multipleselectlistview.MultipleSelectListViewActivity;
import com.deepshooter.uicomponentssecond.popupmenu.PopUpMenuTestActivity;
import com.deepshooter.uicomponentssecond.popupwindow.PopUpWindowTestActivity;
import com.deepshooter.uicomponentssecond.simpledailog.SimpleDialogTestActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mListRecyclerView;
    ArrayList<String> dataArrayList;
    RecyclerViewListAdapter recyclerViewListAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

    }


    private void initializeView()
    {
        mListRecyclerView = (RecyclerView) findViewById(R.id.vR_recyclerViewList);

        setValues();
    }


    private void setValues()
    {
        prepareData();

        recyclerViewListAdapter = new RecyclerViewListAdapter(MainActivity.this,dataArrayList);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mListRecyclerView.setHasFixedSize(false);

        mListRecyclerView.setAdapter(recyclerViewListAdapter);
        recyclerViewListAdapter.notifyDataSetChanged();

    }


    private void prepareData() {

        dataArrayList = new ArrayList<>();
        dataArrayList.add("DialogFragment");
        dataArrayList.add("PopUpMenu");
        dataArrayList.add("SimpleDialog");
        dataArrayList.add("MultipleSelectListView");
        dataArrayList.add("PopUpWindow");
        dataArrayList.add("CustomDialog");


    }



    public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.MyViewHolder> {

        Context context;
        List<String> dataList;

        public RecyclerViewListAdapter(Context context, List<String> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_list, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {


            holder.mText.setText(dataList.get(position));

            holder.vL_item_Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(dataArrayList.get(position).equalsIgnoreCase("DialogFragment"))
                    {
                        startActivity(new Intent(MainActivity.this, DialogFragmentTestActivity.class));

                    }else  if(dataArrayList.get(position).equalsIgnoreCase("PopUpMenu"))
                    {
                            Intent intent = new Intent(MainActivity.this,PopUpMenuTestActivity.class);
                            startActivity(intent);
                    }
                    else  if(dataArrayList.get(position).equalsIgnoreCase("SimpleDialog"))
                    {
                        Intent intent = new Intent(MainActivity.this,SimpleDialogTestActivity.class);
                        startActivity(intent);
                    }
                    else  if(dataArrayList.get(position).equalsIgnoreCase("MultipleSelectListView"))
                    {
                        Intent intent = new Intent(MainActivity.this,MultipleSelectListViewActivity.class);
                        startActivity(intent);
                    }
                    else  if(dataArrayList.get(position).equalsIgnoreCase("PopUpWindow"))
                    {
                        Intent intent = new Intent(MainActivity.this,PopUpWindowTestActivity.class);
                        startActivity(intent);
                    }
                    else  if(dataArrayList.get(position).equalsIgnoreCase("CustomDialog"))
                    {
                        Intent intent = new Intent(MainActivity.this,CustomDialogTestActivity.class);
                        startActivity(intent);
                    }
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

            TextView mText;
            LinearLayout vL_item_Layout;

            public MyViewHolder(View itemView) {
                super(itemView);

                mText = (TextView) itemView.findViewById(R.id.vT_Text);
                vL_item_Layout = (LinearLayout) itemView.findViewById(R.id.vL_item_Layout);

            }
        }


    }
}
