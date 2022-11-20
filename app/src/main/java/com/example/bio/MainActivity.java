package com.example.bio;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{
    public String stateVal;
    EditText e1,e2,e3,d;
    TextView t1;
    Button b;
    RadioGroup r;
    String value;
    Adapter adapter;
    Spinner grades;
    String[] states = { "India", "USA", "China", "Japan", "Other"};


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        b = findViewById(R.id.b);
        t1 = findViewById(R.id.t1);
        e1 = findViewById(R.id.e11);
        e2 = findViewById(R.id.e12);
        e3 = findViewById(R.id.e13);
        d = findViewById(R.id.e14);
        grades = findViewById(R.id.spinner);
        grades.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,states);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        grades.setAdapter(aa);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                RadioButton r1 = (RadioButton) findViewById(R.id.r2);
                RadioButton r2 = (RadioButton) findViewById(R.id.r3);
                RadioButton r3 = (RadioButton) findViewById(R.id.r4);

                switch (checkedId) {
                    case R.id.r2:
                        value = (r1.getText().toString());
                        break;
                    case R.id.r3:
                        value = (r2.getText().toString());
                        break;
                    case R.id.r4:
                        value = (r3.getText().toString());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + checkedId);
                }

            }
        });



        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, pass, address, dob, state;

                name = e1.getText().toString();
                pass = e2.getText().toString();
                address = e3.getText().toString();
                dob = d.getText().toString();


                t1.setText("BIO DATA\n\n\n" + "Name: " + name + "\n\nPassword: " + pass +
                        "\n\nAddress: " + address + "\n\nGender:" + value +
                        "\n\nDate Of Birth:" + dob + "\n\nStates:"+stateVal);


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        stateVal = states[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
