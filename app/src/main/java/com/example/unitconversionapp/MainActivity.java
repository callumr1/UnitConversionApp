package com.example.unitconversionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Callum on 12/03/2018.
 *
 * This is the main activity, it is responsible for most of the functionality of the app including:
 *  - Currency Conversion Calculation
 *  - Event handling
 */

public class MainActivity extends AppCompatActivity{

    private Spinner metricSpinner;
    private EditText metricText;

    private Spinner imperialSpinner;
    private EditText imperialText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        metricSpinner = findViewById(R.id.metricSpinner);
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        metricText = findViewById(R.id.metricText);
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
                                case "yards": {
                                    if (metricText.getText().toString().isEmpty()) {
                                        imperialText.setText(String.valueOf(0));
                                    }
                                    double amount = Double.parseDouble(metricText.getText().toString());
                                    double total = (amount * 0.00109361);
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
        imperialText = findViewById(R.id.imperialText);

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
                    } catch (Exception e) {}
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

        public void changeToSettingsActivity(View view){
        // Call when the user taps on the setting button
            Intent intent = new Intent(this, settingsActivity.class);
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

}