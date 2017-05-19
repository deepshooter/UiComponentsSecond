package com.deepshooter.uicomponentssecond.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.deepshooter.uicomponentssecond.R;

public class PopUpWindowTestActivity extends AppCompatActivity {


    TextView popUpWindowText;
    PopupWindow popUpFragment;
    View view;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window_test);

        initializeValues();

    }



    private void initializeValues()
    {
        popUpWindowText = (TextView) findViewById(R.id.popUpWindow);
        setValues();
    }


    private void setValues()
    {

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.addpicturedialouge, null);
        popUpFragment = new PopupWindow(PopUpWindowTestActivity.this);



        popUpWindowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopUp();


            }
        });
    }



    private void showPopUp() {

        initializeDialogViews(view);

        popUpFragment.setContentView(view);

        popUpFragment.setHeight((int) (getHeight() / 3));

        popUpFragment.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popUpFragment.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popUpFragment.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popUpFragment.setFocusable(true);
        popUpFragment.update();

    }

    private void initializeDialogViews(View view) {



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

        if (popUpFragment.isShowing()) {

            popUpFragment.dismiss();

        } else {

            finish();
            overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
            super.onBackPressed();

        }

    }

}
