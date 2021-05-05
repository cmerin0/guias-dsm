package com.example.guia8firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddPersonActivity extends AppCompatActivity {

    EditText etDui, etNombre, etFechaNacimiento, etGenero, etPeso, etAltura;
    String key="", dui="", nombre="", fechaNacimiento="", genero="", peso="", altura="", accion="";
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        initialize();
    }

    private void initialize() {
        etDui = findViewById(R.id.editDui);
        etNombre = findViewById(R.id.editNombre);
        etFechaNacimiento = findViewById(R.id.editFechaNacimiento);
        etGenero = findViewById(R.id.editGenero);
        etPeso = findViewById(R.id.editPeso);
        etAltura = findViewById(R.id.editAltura);
        btnSave = findViewById(R.id.buttonSave);
        btnCancel = findViewById(R.id.buttonCancel);
        btnSave.setOnClickListener(v -> {
            save();
        });

        btnCancel.setOnClickListener(v -> {
            cancel();
        });

        Bundle data = getIntent().getExtras();
        key = data.getString("key");
        dui = data.getString("dui");
        nombre = data.getString("nombre");
        fechaNacimiento = data.getString("fechaNacimiento");
        genero = data.getString("genero");
        peso = data.getString("peso");
        altura = data.getString("altura");
        accion = data.getString("accion");

        etDui.setText(dui);
        etNombre.setText(nombre);
        etFechaNacimiento.setText(fechaNacimiento);
        etGenero.setText(genero);
        etPeso.setText(peso);
        etAltura.setText(altura);
    }

    public void save() {
        String dui = etDui.getText().toString();
        String nombre = etNombre.getText().toString();
        String fechaNacimiento = etFechaNacimiento.getText().toString();
        String genero = etGenero.getText().toString();
        String peso = etPeso.getText().toString();
        String altura = etAltura.getText().toString();
        Person persona = new Person(dui, nombre, fechaNacimiento, genero, peso, altura);
        if(accion.equals("a")) {
            PersonActivity.refPersonas.push().setValue(persona);
        }
        else {
            PersonActivity.refPersonas.child(key).setValue(persona);
        }

        finish();
    }

    public void cancel() {
        finish();
    }
}