package com.example.worldskills.colorapp.baseDatos;

import android.provider.BaseColumns;

public final class TablaDatos {

    private TablaDatos() {}

   //Clase que sirve para las columnas de las tablas
    public static class AdaptadorEntrada implements BaseColumns {
        public static final String NOMBRE_TABLA = "puntajes";
        public static final String COLUMNA_PUNTAJE = "puntos";

    }
}