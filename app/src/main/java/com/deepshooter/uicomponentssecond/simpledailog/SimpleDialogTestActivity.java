package com.deepshooter.uicomponentssecond.simpledailog;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.deepshooter.uicomponentssecond.MainActivity;
import com.deepshooter.uicomponentssecond.R;

public class SimpleDialogTestActivity extends AppCompatActivity {



    TextView dialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_dialog_test);

        dialog = (TextView) findViewById(R.id.dialog);

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callLogOutDialog();
            }
        });
    }



    public void callLogOutDialog(){

        DialogInterface.OnClickListener mClick1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        };

        DialogInterface.OnClickListener mClick2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                Intent intent = new Intent(SimpleDialogTestActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        };

        android.app.AlertDialog.Builder mAlert = new android.app.AlertDialog.Builder(SimpleDialogTestActivity.this);
        mAlert.setTitle("Log Out");
        mAlert.setMessage("Are you sure, you want to LogOut?");
        mAlert.setNegativeButton("No", mClick1);
        mAlert.setPositiveButton("Yes", mClick2);
        mAlert.show();
    }

}
