package com.example.worldskills.colorapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.worldskills.colorapp.baseDatos.AyudaBaseDatos;
import com.example.worldskills.colorapp.baseDatos.TablaDatos;

import java.util.ArrayList;

public class PuntajesActivity extends AppCompatActivity {


    //Instanciar elementos
    ListView lvLista;
    ArrayList listaPuntajes;
    ArrayAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);

        lvLista= (ListView)findViewById(R.id.lvLista);

        AyudaBaseDatos db = new AyudaBaseDatos(context);
        SQLiteDatabase datos = db.getReadableDatabase();
        String sql = "SELECT * FROM puntajes ORDER BY puntos LIMIT 4";
        Cursor consulta = datos.rawQuery(sql,null);
        if (consulta.moveToFirst()){
            do {
                long puntajes = consulta.getLong(consulta.getColumnIndexOrThrow(TablaDatos.AdaptadorEntrada.COLUMNA_PUNTAJE));
                listaPuntajes.add(puntajes);
            }while (consulta.moveToNext());
          //  listaPuntajes.set(adapter);
            consulta.close();
        }





    }
}
