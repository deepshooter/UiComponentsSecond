package com.deepshooter.uicomponentssecond.dialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.deepshooter.uicomponentssecond.R;

public class DialogFragmentTestActivity extends AppCompatActivity {


    TextView dialogFragmentText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment_test);


        dialogFragmentText = (TextView) findViewById(R.id.dialogFragmentText);

        dialogFragmentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mAID= "5" ;
                Bundle args = new Bundle();
                args.putString("ID", mAID + "");

                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.setArguments(args);
                customDialogFragment.show(getFragmentManager(), "");

            }
        });


    }
}
