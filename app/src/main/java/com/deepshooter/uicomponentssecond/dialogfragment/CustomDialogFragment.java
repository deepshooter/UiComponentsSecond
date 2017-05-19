package com.deepshooter.uicomponentssecond.dialogfragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deepshooter.uicomponentssecond.MainActivity;
import com.deepshooter.uicomponentssecond.R;

/**
 * Created by Avinashmishra on 18-05-2017.
 */

public class CustomDialogFragment extends DialogFragment {


    TextView vT_applyID;
    LinearLayout vL_closeLayout;

    Dialog dialog;
    String mID;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.setContentView(R.layout.dialog_fragment_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        initializeValue();

        return dialog;
    }


    private  void initializeValue()
    {
        vT_applyID = (TextView) dialog.findViewById(R.id.vT_applyID);
        vL_closeLayout = (LinearLayout) dialog.findViewById(R.id.vL_closeLayout);
        setValues();

    }

    private void setValues() {

        mID = getArguments().getString("ID");

        vT_applyID.setText(getString(R.string.your_id)+mID);

        vL_closeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);*/

                dialog.dismiss();
            }
        });

    }


  /*  @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        getActivity().finish();
    }*/
}
