package com.example.calculosalariog4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SalaryCalculation extends AppCompatActivity {

    private TextView etResponse;
    private Button btnFinish;
    String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_calculation);
        etResponse = (TextView) findViewById(R.id.tvResponse);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("etName");
        int hours = Integer.parseInt(bundle.getString("etHours"));
        calculateSalary(hours, name);
        etResponse.setText(response);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void calculateSalary(int hours, String name){
        double salary = hours * 8.50;
        double netSalary = salary * (0.91);
        response += "El Salario de "+name+" es $"+Math.round(salary)+"\n Descuentos: \n\t";
        response += "1.ISSS: $"+Math.round(salary*0.02)+"\n\t2.AFP: $"+Math.round(salary*0.03)+"\n\t3.RENTA: $"+Math.round(salary*0.04);
        response += "\nEl Salario Neto es: $"+Math.round(netSalary);
    }

}