package com.example.unitconversionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RadioButton;

public class settingsActivity extends AppCompatActivity {

    private RadioButton lightThemeButton;
    private RadioButton darkThemeButton;
    private RadioButton smallTextButton;
    private RadioButton mediumTextButton;
    private RadioButton largeTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Utils.onActivityCreateSetTheme(this);
    }

    public void onRadioButtonClicked(View view){
        //Checks if the button is checked
        boolean checked = ((RadioButton) view).isChecked();

        //Checks which radio button is clicked
        switch (view.getId()){
            case R.id.lightThemeButton:
                Utils.changeToTheme(this, Utils.NORMAL_THEME);

                break;
            case R.id.darkThemeButton:
                Utils.changeToTheme(this, Utils.DARK_THEME);
                break;
        }
    }
}
