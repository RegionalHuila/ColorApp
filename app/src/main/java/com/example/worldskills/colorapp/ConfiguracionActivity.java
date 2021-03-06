package com.example.worldskills.colorapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ConfiguracionActivity extends AppCompatActivity {

    Spinner spOpciones;
    EditText etTiempoPalabra,etTiempoJuego,etNumeroIntentos;
    TextView ocultarIntentos,ocultarTiempoJuego;
    Button btnGuardarConfig;



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
        btnGuardarConfig = (Button)findViewById(R.id.btnGuardarConfig);

        ocultarIntentos.setVisibility(View.INVISIBLE);
        ocultarTiempoJuego.setVisibility(View.INVISIBLE);
        etNumeroIntentos.setVisibility(View.INVISIBLE);
        etTiempoJuego.setVisibility(View.INVISIBLE);

        btnGuardarConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfiguracionActivity.this,JuegoPersonalizadoActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences.edit();

         ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.array_tipo_juego, android.R.layout.simple_list_item_1);
         spOpciones.setAdapter(arrayAdapter);


      spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              if (spOpciones.getSelectedItem().equals("Tiempo")){
                    ocultarTiempoJuego.setVisibility(View.VISIBLE);
                    etTiempoJuego.setVisibility(View.VISIBLE);
                    ocultarIntentos.setVisibility(View.INVISIBLE);
                    etNumeroIntentos.setVisibility(View.INVISIBLE);
                    editor.putString("TIEMPOJUEGO",etTiempoJuego.getText().toString());
                    editor.putString("TIEMPOPALABRA",etTiempoPalabra.getText().toString());
                    editor.putString("TIPOJUEGO","tiempo");
                    String palabra = etTiempoPalabra.getText().toString();
                  Log.i("Palabra", ""+palabra);

              }else if (spOpciones.getSelectedItem().equals("Intentos")){
                  etNumeroIntentos.setVisibility(View.VISIBLE);
                  ocultarIntentos.setVisibility(View.VISIBLE);
                  ocultarTiempoJuego.setVisibility(View.INVISIBLE);
                  etTiempoJuego.setVisibility(View.INVISIBLE);
                  editor.putString("INTENTOSJUEGO",etNumeroIntentos.getText().toString());
                  editor.putString("TIEMPOPALABRA",etTiempoPalabra.getText().toString());
                  editor.putString("TIPOJUEGO","intentos");
                  String palabra = etTiempoPalabra.getText().toString();
                  Log.i("Palabra", ""+palabra);
              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });

    }
}
