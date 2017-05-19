package com.deepshooter.uicomponentssecond.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deepshooter.uicomponentssecond.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        setLanguage("En");

        String mLanguage = getSharedPrefLang();

    }





    private void setLanguage(String locale) {
        SharedPreferences sp = getSharedPreferences("LanguageFlag", 0);
        SharedPreferences.Editor et = sp.edit();
        et.putString("Language", locale);
        et.apply();
    }


    public String getSharedPrefLang() {
        SharedPreferences sp = getSharedPreferences("LanguageFlag", 0);
        String mLang = sp.getString("Language", null);
        return mLang;
    }
}
