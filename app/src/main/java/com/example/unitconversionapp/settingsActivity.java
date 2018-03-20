package com.example.unitconversionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button lightButton;
    private Button darkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_settings);

        darkButton = findViewById(R.id.darkButton);
        darkButton.setOnClickListener(this);

        lightButton = findViewById(R.id.lightButton);
        lightButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.lightButton:
                Utils.changeToTheme(MainActivity.getActivity(), Utils.NORMAL_THEME);
                Utils.changeToTheme(this, Utils.NORMAL_THEME);
                break;
            case R.id.darkButton:
                Utils.changeToTheme(MainActivity.getActivity(), Utils.DARK_THEME);
                Utils.changeToTheme(this, Utils.DARK_THEME);

                break;
        }
    }
}
