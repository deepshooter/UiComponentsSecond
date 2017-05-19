package com.deepshooter.uicomponentssecond.multipleselectlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.deepshooter.uicomponentssecond.R;
import com.deepshooter.uicomponentssecond.bean.Data;
import com.deepshooter.uicomponentssecond.customs.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MultipleSelectListViewActivity extends AppCompatActivity implements MultipleSelectListViewAdapter.OnRowClick {

    RecyclerView mListRecyclerView;
    ArrayList<Data> dataArrayList;
    MultipleSelectListViewAdapter multipleSelectListViewAdapter ;

    List<String> stringList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_select_listview);

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

        multipleSelectListViewAdapter = new MultipleSelectListViewAdapter(MultipleSelectListViewActivity.this,dataArrayList ,this);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(MultipleSelectListViewActivity.this));
        mListRecyclerView.setItemAnimator(new DefaultItemAnimator());
       // mListRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(MultipleSelectListViewActivity.this));
        mListRecyclerView.setHasFixedSize(false);

        mListRecyclerView.setAdapter(multipleSelectListViewAdapter);
        multipleSelectListViewAdapter.notifyDataSetChanged();

    }


    private void prepareData()
    {
        dataArrayList = new ArrayList<>();

        Data data1 = new Data();
        data1.setmNumber("1");
        data1.setmText("One");
        dataArrayList.add(data1);

        Data data2 = new Data();
        data2.setmNumber("2");
        data2.setmText("Two");
        dataArrayList.add(data2);


        Data data3 = new Data();
        data3.setmNumber("3");
        data3.setmText("Three");
        dataArrayList.add(data3);

        Data data4 = new Data();
        data4.setmNumber("4");
        data4.setmText("Four");
        dataArrayList.add(data4);

        Data data5 = new Data();
        data5.setmNumber("5");
        data5.setmText("Five");
        dataArrayList.add(data5);


        Data data6 = new Data();
        data6.setmNumber("6");
        data6.setmText("Six");
        dataArrayList.add(data6);

        Data data7 = new Data();
        data7.setmNumber("7");
        data7.setmText("Seven");
        dataArrayList.add(data7);

        Data data8 = new Data();
        data8.setmNumber("8");
        data8.setmText("Eight");
        dataArrayList.add(data8);

        Data data9 = new Data();
        data9.setmNumber("9");
        data9.setmText("Nine");
        dataArrayList.add(data9);

        Data data10 = new Data();
        data10.setmNumber("10");
        data10.setmText("Ten");
        dataArrayList.add(data10);

        Data data11 = new Data();
        data11.setmNumber("11");
        data11.setmText("Eleven");
        dataArrayList.add(data11);

        Data data12 = new Data();
        data12.setmNumber("12");
        data12.setmText("Twelve");
        dataArrayList.add(data12);

    }


    @Override
    public void onRowClick(List<String> row) {

        stringList = row;

        Log.e("Size =  ",stringList.size()+"");
    }
}
