package com.example.unitconversionapp;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner metricSpinner;
    private EditText metricText;

    private Spinner imperialSpinner;
    private EditText imperialText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        metricSpinner = findViewById(R.id.metricSpinner);
        metricText = findViewById(R.id.metricText);

        imperialSpinner = findViewById(R.id.imperialSpinner);
        imperialText = findViewById(R.id.imperialText);

        imperialText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String imperialUnit = imperialSpinner.getSelectedItem().toString();
                System.out.println(imperialUnit);
                String metricUnit = metricSpinner.getSelectedItem().toString();
                System.out.println(metricUnit);

                try {
                    if (imperialUnit.equals("inches")) {
                        if (metricUnit.equals("mm")) {
                            if (imperialText.getText().toString().isEmpty()) {
                                metricText.setText(String.valueOf(0));
                            }
                            double amount = Double.parseDouble(imperialText.getText().toString());
                            System.out.println(amount);
                            double total = (amount * 25.4);
                            System.out.println(total);
                            metricText.setText(String.valueOf(total));
                        }
                        else if (metricUnit.equals("cm")) {
                            if (imperialText.getText().toString().isEmpty()) {
                                metricText.setText(String.valueOf(0));
                            }
                            double amount = Double.parseDouble(imperialText.getText().toString());
                            System.out.println(amount);
                            double total = (amount * 2.54);
                            System.out.println(total);
                            metricText.setText(String.valueOf(total));
                        }
                        else if (metricUnit.equals("m")) {
                            if (imperialText.getText().toString().isEmpty()) {
                                metricText.setText(String.valueOf(0));
                            }
                            double amount = Double.parseDouble(imperialText.getText().toString());
                            System.out.println(amount);
                            double total = (amount * 0.0254);
                            System.out.println(total);
                            metricText.setText(String.valueOf(total));
                        }
                    }
                }catch(Exception e){}
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String imperialUnit = imperialSpinner.getSelectedItem().toString();
        String metricUnit = metricSpinner.getSelectedItem().toString();
        if(metricUnit.equals("mm")){
            if(imperialUnit.equals("inches")){
                long amount = Long.parseLong(metricText.getText().toString());
                long total = (long) (amount * 0.03937);
                imperialText.setText(String.valueOf(total));
            }
            else if(imperialUnit.equals("yards")){
                long amount = Long.parseLong(metricText.getText().toString());
                long total = (long) (amount * 0.03937);
                imperialText.setText(String.valueOf(total));
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}