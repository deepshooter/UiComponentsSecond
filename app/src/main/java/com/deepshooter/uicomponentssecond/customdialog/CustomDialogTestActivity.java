package com.deepshooter.uicomponentssecond.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deepshooter.uicomponentssecond.R;

public class CustomDialogTestActivity extends AppCompatActivity {

    TextView customDialog ;
    View view ,layoutPopup;
    Dialog dialogMain, dialogSecond;
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_test);


        initializeViews();

    }

     private void initializeViews()
     {
         customDialog = (TextView) findViewById(R.id.customDialog);

         setValues();

     }

    private void setValues()
    {

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutPopup = inflater.inflate(R.layout.addproduct_popup, null);
        view = inflater.inflate(R.layout.addpicturedialouge, null);


        dialogMain = new Dialog(CustomDialogTestActivity.this, android.R.style.Theme_DeviceDefault_Light_DarkActionBar);
        dialogMain.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Window window1 = dialogMain.getWindow();
        WindowManager.LayoutParams layoutParams1 = window1.getAttributes();
        layoutParams1.gravity = Gravity.CENTER;
        layoutParams1.width = getWidth();
        layoutParams1.height = getHeight();
        window1.setAttributes(layoutParams1);



        dialogSecond = new Dialog(CustomDialogTestActivity.this, android.R.style.Theme_DeviceDefault_Light_DarkActionBar);
        dialogSecond.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Window window = dialogSecond.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = getWidth();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);


        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopUp();
            }
        });

    }




    private void showPopUpSecond() {

        dialogSecond.setContentView(view);
        initializeDialogViewsSecond(view);
        dialogSecond.setCancelable(true);
        dialogSecond.show();
        dialogSecond.setCancelable(true);
        dialogSecond.setCanceledOnTouchOutside(true);



    }

    private void showPopUp() {



        dialogMain.setContentView(layoutPopup);
        initializeDialogViews(layoutPopup);
        dialogMain.show();
        overridePendingTransition(R.anim.fadeinfadeout, 0);


    }


    private void initializeDialogViews(View view) {


        final ImageView mCameraImage = (ImageView) view.findViewById(R.id.vI_appu_addpictureImage);
        LinearLayout closeLayout = (LinearLayout) view.findViewById(R.id.vL_appu_closeLayout);

        mCameraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopUpSecond();
            }
        });

        closeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogMain.dismiss();
            }
        });

    }

    private void initializeDialogViewsSecond(View view) {



        final TextView camera = (TextView) view.findViewById(R.id.vT_adddiloge_cameraText);
        final TextView gallery = (TextView) view.findViewById(R.id.vT_adddiloge_GalleryText);
        final TextView remove = (TextView) view.findViewById(R.id.vT_adddiloge_removeText);
        final TextView pickfog = (TextView) view.findViewById(R.id.vT_adddiloge_ourgallerytext);

        final ImageView cameraImage = (ImageView) view.findViewById(R.id.vI_adddiloge_camera);
        final ImageView galleryImage = (ImageView) view.findViewById(R.id.vI_adddiloge_gallery);
        final ImageView removeImage = (ImageView) view.findViewById(R.id.vI_addilogue_deleteimage);
        final ImageView pickfogImage = (ImageView) view.findViewById(R.id.vI_adddiloge_ourgallery);

    }



    private int getHeight() {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        return height;
    }

    private int getWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width;
    }


    @Override
    public void onBackPressed() {
        if (dialogSecond.isShowing()) {

            dialogSecond.dismiss();

        } else if (dialogMain.isShowing()) {

            dialogMain.dismiss();


        } else {

            //Intent intent = new Intent(Intent.ACTION_MAIN);
           // intent.addCategory(Intent.CATEGORY_HOME);
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           // startActivity(intent);
            overridePendingTransition(R.anim.fadeinfadeout, 0);
            super.onBackPressed();

        }

    }
}
