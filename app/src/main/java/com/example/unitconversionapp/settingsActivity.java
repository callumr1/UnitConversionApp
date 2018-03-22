package com.example.unitconversionapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class settingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button lightButton;
    private Button darkButton;
    private Button smallTextButton;
    private Button mediumTextButton;
    private Button largeTextButton;
    private static int textSize;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_settings);

        darkButton = findViewById(R.id.darkButton);
        darkButton.setOnClickListener(this);

        lightButton = findViewById(R.id.lightButton);
        lightButton.setOnClickListener(this);

        smallTextButton = findViewById(R.id.smallTextButton);
        smallTextButton.setOnClickListener(this);

        mediumTextButton = findViewById(R.id.mediumTextButton);
        mediumTextButton.setOnClickListener(this);

        largeTextButton = findViewById(R.id.largeTextButton);
        largeTextButton.setOnClickListener(this);

        Intent intent = getIntent();
        textSize = intent.getIntExtra("Text Size", 2);

        if(textSize == 0){
            smallTextButton.setTextAppearance(android.R.style.TextAppearance_Small);
            mediumTextButton.setTextAppearance(android.R.style.TextAppearance_Small);
            largeTextButton.setTextAppearance(android.R.style.TextAppearance_Small);
            lightButton.setTextAppearance(android.R.style.TextAppearance_Small);
            darkButton.setTextAppearance(android.R.style.TextAppearance_Small);
        }
        else if(textSize == 1){
            smallTextButton.setTextAppearance(android.R.style.TextAppearance_Medium);
            mediumTextButton.setTextAppearance(android.R.style.TextAppearance_Medium);
            largeTextButton.setTextAppearance(android.R.style.TextAppearance_Medium);
            lightButton.setTextAppearance(android.R.style.TextAppearance_Medium);
            darkButton.setTextAppearance(android.R.style.TextAppearance_Medium);
        }
        else if (textSize == 2){
            smallTextButton.setTextAppearance(android.R.style.TextAppearance_Large);
            mediumTextButton.setTextAppearance(android.R.style.TextAppearance_Large);
            largeTextButton.setTextAppearance(android.R.style.TextAppearance_Large);
            lightButton.setTextAppearance(android.R.style.TextAppearance_Large);
            darkButton.setTextAppearance(android.R.style.TextAppearance_Large);
        }

        constraintLayout = findViewById(R.id.mainLayout);
        constraintLayout.setOnTouchListener(new OnSwipeTouchListener(settingsActivity.this){
            @Override
            public void onSwipeRight() {
                Intent intent = new Intent(settingsActivity.this, MainActivity.class);
                intent.putExtra("Text Size", textSize);
                startActivity(intent);
            }
        });
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
            case R.id.smallTextButton:
                textSize = 0;
                smallTextButton.setTextAppearance(android.R.style.TextAppearance_Small);
                mediumTextButton.setTextAppearance(android.R.style.TextAppearance_Small);
                largeTextButton.setTextAppearance(android.R.style.TextAppearance_Small);
                lightButton.setTextAppearance(android.R.style.TextAppearance_Small);
                darkButton.setTextAppearance(android.R.style.TextAppearance_Small);
                break;
            case R.id.mediumTextButton:
                textSize = 1;
                smallTextButton.setTextAppearance(android.R.style.TextAppearance_Medium);
                mediumTextButton.setTextAppearance(android.R.style.TextAppearance_Medium);
                largeTextButton.setTextAppearance(android.R.style.TextAppearance_Medium);
                lightButton.setTextAppearance(android.R.style.TextAppearance_Medium);
                darkButton.setTextAppearance(android.R.style.TextAppearance_Medium);
                break;
            case R.id.largeTextButton:
                textSize = 2;
                smallTextButton.setTextAppearance(android.R.style.TextAppearance_Large);
                mediumTextButton.setTextAppearance(android.R.style.TextAppearance_Large);
                largeTextButton.setTextAppearance(android.R.style.TextAppearance_Large);
                lightButton.setTextAppearance(android.R.style.TextAppearance_Large);
                darkButton.setTextAppearance(android.R.style.TextAppearance_Large);
                break;
        }
    }

    public void onBackPressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Text Size", textSize);
        startActivity(intent);
    }
}
