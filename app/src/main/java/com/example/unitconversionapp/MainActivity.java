package com.example.unitconversionapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Callum on 12/03/2018.
 *
 * This is the main activity, it is responsible for most of the functionality of the app including:
 *  - Currency Conversion Calculation
 *  - Handling of text input, spinner changing
 */

public class MainActivity extends AppCompatActivity {

    private Spinner metricSpinner;
    private EditText metricText;

    private Spinner imperialSpinner;
    private EditText imperialText;

    private Button settingsButton;
    private TextView fromTextView;
    private TextView toTextView;

    public static Activity activity;
    private static int textSize = 2;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        settingsButton = findViewById(R.id.settingsButton);
        fromTextView = findViewById(R.id.fromTextView);
        toTextView = findViewById(R.id.toTextView);

        Intent intent = getIntent();
        textSize = intent.getIntExtra("Text Size", 2);

        if (textSize == 0) {
            //metricText.setTextAppearance(android.R.style.TextAppearance_Small);
            //imperialText.setTextAppearance(android.R.style.TextAppearance_Small);
            settingsButton.setTextAppearance(android.R.style.TextAppearance_Small);
            fromTextView.setTextAppearance(android.R.style.TextAppearance_Small);
            toTextView.setTextAppearance(android.R.style.TextAppearance_Small);
        } else if (textSize == 1) {
            //metricText.setTextAppearance(android.R.style.TextAppearance_Medium);
            //imperialText.setTextAppearance(android.R.style.TextAppearance_Medium);
            settingsButton.setTextAppearance(android.R.style.TextAppearance_Medium);
            fromTextView.setTextAppearance(android.R.style.TextAppearance_Medium);
            toTextView.setTextAppearance(android.R.style.TextAppearance_Medium);
        } else if (textSize == 2) {
            //metricText.setTextAppearance(android.R.style.TextAppearance_Large);
            //imperialText.setTextAppearance(android.R.style.TextAppearance_Large);
            settingsButton.setTextAppearance(android.R.style.TextAppearance_Large);
            fromTextView.setTextAppearance(android.R.style.TextAppearance_Large);
            toTextView.setTextAppearance(android.R.style.TextAppearance_Large);
        }

        activity = this;

        metricSpinner = findViewById(R.id.metricSpinner);
        // Converts the units when a different unit is selected from the metricSpinner
        metricSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                String imperialUnit = imperialSpinner.getSelectedItem().toString();
                String metricUnit = metricSpinner.getSelectedItem().toString();
                try {
                    if (imperialUnit.equals("inches")) {
                        switch (metricUnit) {
                            case "mm": {
                                if (imperialText.getText().toString().isEmpty()) {
                                    metricText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(imperialText.getText().toString());
                                double total = (amount * 25.4);
                                total = RoundNumber(total);
                                metricText.setText(String.valueOf(total));
                                break;
                            }
                            case "cm": {
                                if (imperialText.getText().toString().isEmpty()) {
                                    metricText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(imperialText.getText().toString());
                                double total = (amount * 2.54);
                                total = RoundNumber(total);
                                metricText.setText(String.valueOf(total));
                                break;
                            }
                            case "m": {
                                if (imperialText.getText().toString().isEmpty()) {
                                    metricText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(imperialText.getText().toString());
                                double total = (amount * 0.0254);
                                total = RoundNumber(total);
                                metricText.setText(String.valueOf(total));
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    if (imperialUnit.equals("foot")) {
                        switch (metricUnit) {
                            case "mm": {
                                if (imperialText.getText().toString().isEmpty()) {
                                    metricText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(imperialText.getText().toString());
                                double total = (amount * 304.8);
                                total = RoundNumber(total);
                                metricText.setText(String.valueOf(total));
                                break;
                            }
                            case "cm": {
                                if (imperialText.getText().toString().isEmpty()) {
                                    metricText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(imperialText.getText().toString());
                                double total = (amount * 30.48);
                                total = RoundNumber(total);
                                metricText.setText(String.valueOf(total));
                                break;
                            }
                            case "m": {
                                if (imperialText.getText().toString().isEmpty()) {
                                    metricText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(imperialText.getText().toString());
                                double total = (amount * 0.3048);
                                total = RoundNumber(total);
                                metricText.setText(String.valueOf(total));
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        metricText = findViewById(R.id.metricText);
        // Converts the units when the user inputs data into the metricText
        metricText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String imperialUnit = imperialSpinner.getSelectedItem().toString();
                String metricUnit = metricSpinner.getSelectedItem().toString();
                if (metricText.hasFocus()) {
                    try {
                        if (metricUnit.equals("mm")) {
                            switch (imperialUnit) {
                                case "inches": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 0.0393701);
                                    total = RoundNumber(total);
                                    imperialText.setText(String.valueOf(total));
                                    break;
                                }
                                case "foot": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 0.00328084);
                                    total = RoundNumber(total);
                                    imperialText.setText(String.valueOf(total));
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (metricUnit.equals("cm")) {
                            switch (imperialUnit) {
                                case "inches": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 0.393701);
                                    total = RoundNumber(total);
                                    imperialText.setText(String.valueOf(total));
                                    break;
                                }
                                case "foot": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 0.0328084);
                                    total = RoundNumber(total);
                                    imperialText.setText(String.valueOf(total));
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (metricUnit.equals("m")) {
                            switch (imperialUnit) {
                                case "inches": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 39.3701);
                                    total = RoundNumber(total);
                                    imperialText.setText(String.valueOf(total));
                                    break;
                                }
                                case "foot": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 3.28084);
                                    total = RoundNumber(total);
                                    imperialText.setText(String.valueOf(total));
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        imperialSpinner = findViewById(R.id.imperialSpinner);
        // Converts the units when a different unit is selected from the imperialSpinner
        imperialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                String imperialUnit = imperialSpinner.getSelectedItem().toString();
                String metricUnit = metricSpinner.getSelectedItem().toString();
                try {
                    if (metricUnit.equals("mm")) {
                        switch (imperialUnit) {
                            case "inches": {
                                if (metricText.getText().toString().isEmpty()) {
                                    imperialText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(metricText.getText().toString());
                                double total = (amount * 0.0393701);
                                total = RoundNumber(total);
                                imperialText.setText(String.valueOf(total));
                                break;
                            }
                            case "foot": {
                                if (metricText.getText().toString().isEmpty()) {
                                    imperialText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(metricText.getText().toString());
                                double total = (amount * 0.00328084);
                                total = RoundNumber(total);
                                imperialText.setText(String.valueOf(total));
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    if (metricUnit.equals("cm")) {
                        switch (imperialUnit) {
                            case "inches": {
                                if (metricText.getText().toString().isEmpty()) {
                                    imperialText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(metricText.getText().toString());
                                double total = (amount * 0.393701);
                                total = RoundNumber(total);
                                imperialText.setText(String.valueOf(total));
                                break;
                            }
                            case "foot": {
                                if (metricText.getText().toString().isEmpty()) {
                                    imperialText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(metricText.getText().toString());
                                double total = (amount * 0.0328084);
                                total = RoundNumber(total);
                                imperialText.setText(String.valueOf(total));
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    if (metricUnit.equals("m")) {
                        switch (imperialUnit) {
                            case "inches": {
                                if (metricText.getText().toString().isEmpty()) {
                                    imperialText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(metricText.getText().toString());
                                double total = (amount * 39.3701);
                                total = RoundNumber(total);
                                imperialText.setText(String.valueOf(total));
                                break;
                            }
                            case "foot": {
                                if (metricText.getText().toString().isEmpty()) {
                                    imperialText.setText(String.valueOf(0));
                                }
                                double amount = Double.parseDouble(metricText.getText().toString());
                                double total = (amount * 3.28084);
                                total = RoundNumber(total);
                                imperialText.setText(String.valueOf(total));
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imperialText = findViewById(R.id.imperialText);
        // Converts the units when the user inputs data into the imperialText
        imperialText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String imperialUnit = imperialSpinner.getSelectedItem().toString();
                String metricUnit = metricSpinner.getSelectedItem().toString();
                if (imperialText.hasFocus()) {
                    try {
                        if (imperialUnit.equals("inches")) {
                            switch (metricUnit) {
                                case "mm": {
                                    if (imperialText.getText().toString().isEmpty()) {
                                        metricText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(imperialText.getText().toString());
                                    double total = (amount * 25.4);
                                    total = RoundNumber(total);
                                    metricText.setText(String.valueOf(total));
                                    break;
                                }
                                case "cm": {
                                    if (imperialText.getText().toString().isEmpty()) {
                                        metricText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(imperialText.getText().toString());
                                    double total = (amount * 2.54);
                                    total = RoundNumber(total);
                                    metricText.setText(String.valueOf(total));
                                    break;
                                }
                                case "m": {
                                    if (imperialText.getText().toString().isEmpty()) {
                                        metricText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(imperialText.getText().toString());
                                    double total = (amount * 0.0254);
                                    total = RoundNumber(total);
                                    metricText.setText(String.valueOf(total));
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (imperialUnit.equals("foot")) {
                            switch (metricUnit) {
                                case "mm": {
                                    if (imperialText.getText().toString().isEmpty()) {
                                        metricText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(imperialText.getText().toString());
                                    double total = (amount * 304.8);
                                    total = RoundNumber(total);
                                    metricText.setText(String.valueOf(total));
                                    break;
                                }
                                case "cm": {
                                    if (imperialText.getText().toString().isEmpty()) {
                                        metricText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(imperialText.getText().toString());
                                    double total = (amount * 30.48);
                                    total = RoundNumber(total);
                                    metricText.setText(String.valueOf(total));
                                    break;
                                }
                                case "m": {
                                    if (imperialText.getText().toString().isEmpty()) {
                                        metricText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(imperialText.getText().toString());
                                    double total = (amount * 0.3048);
                                    total = RoundNumber(total);
                                    metricText.setText(String.valueOf(total));
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        constraintLayout = findViewById(R.id.mainLayout);
        constraintLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            @Override
            public void onSwipeLeft() {
                Intent intent = new Intent(MainActivity.this, settingsActivity.class);
                intent.putExtra("Text Size", textSize);
                startActivity(intent);
            }
        });
    }

    public void changeToSettingsActivity(View view) {
        // Call when the user taps on the setting button
        Intent intent = new Intent(this, settingsActivity.class);
        intent.putExtra("Text Size", textSize);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        //Setting up the metric spinner with the metric array
        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this, R.array.metric_array, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metricSpinner.setAdapter(fromAdapter);

        //Setting up the imperial spinner with te imperial array
        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this, R.array.imperial_array, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imperialSpinner.setAdapter(toAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    public double RoundNumber(double num){
        num = num*100;
        num = Math.round(num);
        num = num/100;
        return num;
    }

    public static Activity getActivity() {
        return activity;
    }
}