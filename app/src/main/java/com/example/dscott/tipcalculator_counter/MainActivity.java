package com.example.dscott.tipcalculator_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton tenPercent;
    RadioButton fifteenPercent;
    RadioButton twentyPercent;
    RadioButton customPercent;
    Button calculate;
    Button reset;
    EditText bill;
    EditText people;
    TextView finalTotal;
    double tip;
    double total;
    double totalPerPeep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tenPercent = findViewById(R.id.tenPercent);
        fifteenPercent = findViewById(R.id.fifteenPercent);
        twentyPercent = findViewById(R.id.twentyPercent);
        customPercent = findViewById(R.id.customPercent);
        calculate = findViewById(R.id.calcButton);
        reset = findViewById(R.id.resetButton);
        bill = findViewById(R.id.billAmount);
        people = findViewById(R.id.numPeeps);
        finalTotal = findViewById(R.id.finalTotal);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Turn user inputs into usable ints
                int subTotal = Integer.parseInt(bill.getText().toString());
                int numPeeps = Integer.parseInt(people.getText().toString());

                if (twentyPercent.isChecked()) {
                    tip = .2;
                }
                if (fifteenPercent.isChecked()) {
                    tip = .15;
                }
                if (tenPercent.isChecked()) {
                    tip = .1;
                }
                if (customPercent.isChecked()) {
                    int customTip = Integer.parseInt(customPercent.getText().toString());
                    tip = customTip / 100.0;
                }
                else{
                    tip = 0.0;
                }

                total = (subTotal * tip) + subTotal;
                totalPerPeep = total/numPeeps;

                finalTotal.setText("$"+ total);



            }
        });
    }
}
