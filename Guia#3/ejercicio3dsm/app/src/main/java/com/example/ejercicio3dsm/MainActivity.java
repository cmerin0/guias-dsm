package com.example.ejercicio3dsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView n;
    private int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = (TextView)findViewById(R.id.txvNumber);
        if(savedInstanceState != null){
            c = savedInstanceState.getInt("counter");
            n.setText(String.valueOf(c));
        }
    }

    public void addOne(View v){
        c = Integer.parseInt(n.getText().toString());
        if(c < 9)
            c++;
        else
            c = 0;
        n.setText(String.valueOf(c));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", c);
    }
}