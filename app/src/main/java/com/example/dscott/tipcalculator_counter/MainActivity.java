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
    EditText customTip;
    TextView finalTotal;
    TextView finalTotalPerPeep;
    double tip = 0.0;
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
        customTip = findViewById(R.id.customTip);
        finalTotal = findViewById(R.id.finalTotal);
        finalTotalPerPeep = findViewById(R.id.finalTotalPerPeep);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Turn user inputs into usable ints
                int subTotal = Integer.parseInt(bill.getText().toString());
                int numPeeps = Integer.parseInt(people.getText().toString());

                if (twentyPercent.isChecked()) {
                    tip = .2;
                }
                else if(fifteenPercent.isChecked()) {
                    tip = .15;
                }
                else if(tenPercent.isChecked()) {
                    tip = .1;
                }
                else if(customPercent.isChecked()) {
                    double custom = Double.parseDouble(customTip.getText().toString());
                    tip = custom / 100.0;
                }


                total = (subTotal * tip) + subTotal;
                totalPerPeep = total/numPeeps;

                finalTotal.setText("$" + total);
                finalTotalPerPeep.setText("$" + totalPerPeep);


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                tenPercent.setChecked(false);
                fifteenPercent.setChecked(false);
                twentyPercent.setChecked(false);
                customPercent.setChecked(false);

                bill.getText().clear();
                people.getText().clear();

            }
        });
    }
}
