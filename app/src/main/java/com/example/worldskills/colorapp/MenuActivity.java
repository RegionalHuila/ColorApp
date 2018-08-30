package com.example.worldskills.colorapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    //Se declara variables
    Button btnJugar, btnConfiguracion, btnPuntajes;
    TextView tvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Se instancia variables
        btnConfiguracion = (Button)findViewById(R.id.btnConfiguracion);
        btnJugar = (Button)findViewById(R.id.btnJugar);
        btnPuntajes = (Button)findViewById(R.id.btnPuntajes);
        tvMenu = (TextView) findViewById(R.id.tvMenu);

        Typeface fuentes = Typeface.createFromAsset(getAssets(),"assets/brlnsdb.ttf");
        tvMenu.setTypeface(fuentes);

        btnPuntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puntajes = new Intent(MenuActivity.this,PuntajesActivity.class);
                startActivity(puntajes);
            }
        });
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jugar = new Intent(MenuActivity.this,PuntajesActivity.class);
                startActivity(jugar);
            }
        });
        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jugar = new Intent(MenuActivity.this,ConfiguracionActivity.class);
                startActivity(jugar);
            }
        });
    }
}
