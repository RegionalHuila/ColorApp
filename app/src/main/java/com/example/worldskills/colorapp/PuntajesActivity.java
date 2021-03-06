package com.example.worldskills.colorapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.worldskills.colorapp.baseDatos.AyudaBaseDatos;
import com.example.worldskills.colorapp.baseDatos.TablaDatos;

import java.util.ArrayList;

public class PuntajesActivity extends AppCompatActivity {


    //Instanciar elementos
    ListView lvLista;

    ArrayAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);

        AyudaBaseDatos ayudaBaseDatos = new AyudaBaseDatos(getApplicationContext());

        SQLiteDatabase database = ayudaBaseDatos.getWritableDatabase();


        lvLista= (ListView)findViewById(R.id.lvLista);

        AyudaBaseDatos db = new AyudaBaseDatos(getApplicationContext());
        lvLista.setAdapter((ListAdapter) db.llenarPuntaje());







    }
}
