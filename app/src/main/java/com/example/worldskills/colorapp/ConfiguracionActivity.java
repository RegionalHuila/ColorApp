package com.example.worldskills.colorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ConfiguracionActivity extends AppCompatActivity {

    Spinner spOpciones;
    EditText etTiempoPalabra,etTiempoJuego,etNumeroIntentos;
    TextView ocultarIntentos,ocultarTiempoJuego;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        spOpciones = (Spinner) findViewById(R.id.spOpciones);
        etNumeroIntentos = (EditText)findViewById(R.id.etNumeroIntentos);
        etTiempoJuego = (EditText)findViewById(R.id.etTiempoJuego);
        etTiempoPalabra = (EditText)findViewById(R.id.etTiempoPalabra);
        ocultarIntentos = (TextView)findViewById(R.id.ocultarIntentos);
        ocultarTiempoJuego = (TextView)findViewById(R.id.ocultarTiempoJuego);


        String[] tipoJuego = {"Tiempo", "Intentos"};
         ArrayAdapter<String> arrayAdapter = ArrayAdapter.createFromResource(this, tipoJuego, android.R.layout.simple_list_item_1);
         spOpciones.setAdapter(arrayAdapter);


      spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              if (spOpciones.getSelectedItem().equals("Tiempo")){

              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });

    }
}
