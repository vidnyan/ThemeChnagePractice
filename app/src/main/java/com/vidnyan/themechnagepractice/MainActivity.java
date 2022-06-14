package com.vidnyan.themechnagepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    MaterialButtonToggleGroup mtbg_main,mtbg_lang;
    Button bt_default,bt_dark,bt_light,bt_hindi,bt_english,bt_profile,bt_about_us;

    TextView tv_changing_text,tv_sel_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtbg_main = findViewById(R.id.mtbg_main);
        bt_default = findViewById(R.id.bt_default);
        bt_dark = findViewById(R.id.bt_dark);
        bt_light = findViewById(R.id.bt_light);

        mtbg_lang = findViewById(R.id.mtbg_lang);
        bt_hindi =findViewById(R.id.bt_hindi);
        bt_english = findViewById(R.id.bt_english);

        tv_changing_text = findViewById(R.id.tv_changing_text);
        tv_sel_lang = findViewById(R.id.tv_sel_lang);

        bt_profile = findViewById(R.id.bt_profile);
        bt_about_us = findViewById(R.id.bt_about_us);

        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,profileActivity.class);

                startActivity(i);


            }
        });

        bt_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AboutActivity.class);

                startActivity(i);


            }
        });

        mtbg_lang.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(isChecked){

                    switch(checkedId){
                        case R.id.bt_hindi:
                            String language = "hi";
                            setLocalLang(language);
                        break;

                        case R.id.bt_english:
                            String language1 = "en";
                            setLocalLang(language1);
                            break;
                    }


                }
            }
        });


        mtbg_main.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {

                if(isChecked){
                    switch (checkedId) {

                        case R.id.bt_default:
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                            break;

                        case R.id.bt_dark:
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            break;

                        case R.id.bt_light:
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            break;


                    }
                }



            }
        });

    }

    private void setLocalLang(String language) {

        Resources resources = getResources();

        DisplayMetrics metrics = resources.getDisplayMetrics();

        Configuration configuration = resources.getConfiguration();

        configuration.locale = new Locale(language);

        resources.updateConfiguration(configuration,metrics);

        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        tv_changing_text.setText(R.string.dummy_text);
        bt_hindi.setText(R.string.hindi);
        bt_english.setText(R.string.english);
        tv_sel_lang.setText(R.string.select_language);



    }
}