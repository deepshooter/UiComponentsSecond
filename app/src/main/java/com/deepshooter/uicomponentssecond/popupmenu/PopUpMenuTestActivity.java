package com.deepshooter.uicomponentssecond.popupmenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.deepshooter.uicomponentssecond.MainActivity;
import com.deepshooter.uicomponentssecond.R;
import com.deepshooter.uicomponentssecond.customs.IconizedMenu;

public class PopUpMenuTestActivity extends AppCompatActivity {


    TextView simplePopup , customPopup , popUpWithIcon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu_test);

        initializeValue();
    }

    private void initializeValue()
    {
        simplePopup = (TextView) findViewById(R.id.simplePopup);
        customPopup = (TextView) findViewById(R.id.customPopup);
        popUpWithIcon = (TextView) findViewById(R.id.popUpWithIcon);


        setValues();
    }


    private void setValues()
    {

        simplePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simplePopupMenu();
            }
        });



        customPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customPopupMenu();

            }
        });




        popUpWithIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenuWithIcon();

            }
        });


    }




    private  void simplePopupMenu(){


        final PopupMenu popupMenu = new PopupMenu(PopUpMenuTestActivity.this, simplePopup);
        popupMenu.inflate(R.menu.simple_popup_menu);
        popupMenu.show();


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.edit:

                        popupMenu.dismiss();

                        //finish();

                        Toast.makeText(PopUpMenuTestActivity.this, "Edit", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.clear:

                        popupMenu.dismiss();


                        //finish();

                        Toast.makeText(PopUpMenuTestActivity.this, "Clear", Toast.LENGTH_SHORT).show();

                        break;


                }

                return true;
            }
        });
    }




    public void customPopupMenu() {

        final PopupMenu popup = new PopupMenu(PopUpMenuTestActivity.this, customPopup);
        //popup.getMenuInflater().inflate(R.menu.custom_popup_menu, popup.getMenu());

        popup.getMenu().add(1, R.id.username, 1, "Avinash");
        popup.getMenu().add(1,R.id.email,2,"Avi@gmail.com");
        popup.getMenu().add(1,R.id.logout,3,"Logout");

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.username:

                        popup.dismiss();
                        break;

                    case R.id.email:

                        popup.dismiss();
                        break;

                    case R.id.logout:
                        popup.dismiss();
                        break;
                }
                return true;
            }
        });


        popup.show();

    }


    public void PopupMenuWithIcon() {


        final IconizedMenu PopupMenu = new IconizedMenu(getWindow().getContext(), popUpWithIcon);
        MenuInflater inflater = PopupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_with_icon, PopupMenu.getMenu());

        PopupMenu.show();


        PopupMenu.setOnMenuItemClickListener(new IconizedMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.feedback:

                        Toast.makeText(PopUpMenuTestActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
                        PopupMenu.dismiss();

                        break;

                    case R.id.chat_with_us:

                        Toast.makeText(PopUpMenuTestActivity.this, "Chat", Toast.LENGTH_SHORT).show();
                        PopupMenu.dismiss();
                        break;

                    case R.id.accswitch:

                        Toast.makeText(PopUpMenuTestActivity.this, "Switch", Toast.LENGTH_SHORT).show();
                        PopupMenu.dismiss();
                        break;



                }


                return true;
            }
        });

    }
}
