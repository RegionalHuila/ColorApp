package com.example.worldskills.colorapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JuegoPersonalizadoActivity extends AppCompatActivity {
    TextView palabrasColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_personalizado);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        palabrasColor = (TextView)findViewById(R.id.tvPalabrasColorPersonalizado);
 String prueba = preferences.getString("TIEMPOJUEGO","default");
        Log.i("tiempo Juego: ",prueba);

    }
}
