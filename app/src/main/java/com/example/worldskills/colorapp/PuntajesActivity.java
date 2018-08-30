package com.example.worldskills.colorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.worldskills.colorapp.baseDatos.AyudaBaseDatos;

import java.util.ArrayList;

public class PuntajesActivity extends AppCompatActivity {


    //Instanciar elementos
    ListView lvLista;
    ArrayList<String> listaPuntajes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);

        lvLista= (ListView)findViewById(R.id.lvLista);

        //AyudaBaseDatos db = new AyudaBaseDatos()


    }
}
