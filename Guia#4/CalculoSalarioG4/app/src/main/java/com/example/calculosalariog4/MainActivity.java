package com.example.calculosalariog4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etHours;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText)findViewById(R.id.etName);
        etHours = (EditText)findViewById(R.id.etHours);
        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SalaryCalculation.class);
                i.putExtra("etName", etName.getText().toString());
                i.putExtra("etHours", etHours.getText().toString());
                startActivity(i);
            }
        });
    }
}