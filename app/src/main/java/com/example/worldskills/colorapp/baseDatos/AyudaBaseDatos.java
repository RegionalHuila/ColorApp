package com.example.worldskills.colorapp.baseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudaBaseDatos extends SQLiteOpenHelper {

    public static final String NOMBRE_BASE_DATOS = "colorapp.db";
    public static final int VERSION_BASE_DATOS = 1;


    //Se crea la tabla usuarios con soloun campo el cual corresponde a puntaje
    private static final String CREAR_TABLA =
            "CREATE TABLE " + TablaDatos.AdaptadorEntrada.NOMBRE_TABLA + " (" +
                    TablaDatos.AdaptadorEntrada._ID + " INTEGER PRIMARY KEY," +
                    TablaDatos.AdaptadorEntrada.COLUMNA_PUNTAJE + " )";

    //Se elimina la tabla
    private static final String ELIMINAR_TABLA =
            "DROP TABLE IF EXISTS " + TablaDatos.AdaptadorEntrada.NOMBRE_TABLA;

    public AyudaBaseDatos(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaDatos.AdaptadorEntrada.NOMBRE_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ELIMINAR_TABLA);
        onCreate(db);
    }
}
