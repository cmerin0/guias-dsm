package com.example.guia8firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refPersonas = database.getReference("personas");

    Query consultaOrdenada = refPersonas.orderByChild("nombre");

    List<Person> personas;
    ListView listPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        initialize();
    }

    private void initialize() {
        FloatingActionButton fabAdd= findViewById(R.id.fabAdd);
        listPersonas = findViewById(R.id.listPersonas);

        listPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), AddPersonActivity.class);
                intent.putExtra("accion","e");
                intent.putExtra("key", personas.get(i).getKey());
                intent.putExtra("dui",personas.get(i).getDui());
                intent.putExtra("nombre",personas.get(i).getNombre());
                intent.putExtra("fechaNacimiento",personas.get(i).getFechaNacimiento());
                intent.putExtra("genero",personas.get(i).getGenero());
                intent.putExtra("peso",personas.get(i).getPeso());
                intent.putExtra("altura",personas.get(i).getAltura());
                startActivity(intent);
            }
        });

        listPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder alert = new AlertDialog.Builder(PersonActivity.this);
                alert.setMessage("¿Está seguro que desea eliminar el registro?")
                        .setTitle("Confirmación");

                alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        PersonActivity.refPersonas.child(personas.get(position).getKey()).removeValue();
                        Toast.makeText(PersonActivity.this, "¡Registro borrado!",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(PersonActivity.this, "¡Operación de borrado cancelada!",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
                return true;
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddPersonActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","");
                i.putExtra("dui","");
                startActivity(i);
            }
        });

        personas = new ArrayList<>();

        // Cambiarlo refProductos a consultaOrdenada para ordenar lista
        consultaOrdenada.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Procedimiento que se ejecuta cuando hubo algun cambio
                // en la base de datos
                // Se actualiza la coleccion de personas
                personas.removeAll(personas);
                for (DataSnapshot dato : dataSnapshot.getChildren()) {
                    Person persona = dato.getValue(Person.class);
                    persona.setKey(dato.getKey());
                    personas.add(persona);
                }

                PersonAdapter adapter = new PersonAdapter(PersonActivity.this, personas);
                listPersonas.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}