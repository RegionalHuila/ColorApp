package com.example.worldskills.colorapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoPersonalizadoActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> palabrasColor = new ArrayList<>();
    ArrayList<String> colorPalabra = new ArrayList<>();
    CountDownTimer contador;
    Button btnColorUno, btnColorDos, btnColorTres, btnColorCuatro, btnPausa;
    int palabrasCorrectas = 0, palabrasIncorrectas = 0, palabrasDesplegadas = 0;
    TextView tvPalabrasIncorrectas, tvContadorPalabrasCorrectas, tvContadorPalabrsIncorrectas, tvPalabras, tvPalabrasDesplegadas;
    TextView tvTiempo, tvTiempoContador;
    String tiempoOIntento, tiempoPalabra ,tipoJuego;
    int tiempoOIntentos , tiempoPalabras ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_personalizado);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String tiempoOIntento = preferences.getString("TIEMPOJUEGO", "No hay");
        String tiempoPalabra = preferences.getString("TIEMPOPALABRA", "No hay");
        String tipoJuego = preferences.getString("TIPOJUEGO", "No hay");

        int tiempoOIntentos = Integer.parseInt(tiempoOIntento);
        int tiempoPalabras = Integer.parseInt(tiempoPalabra);

        if (tipoJuego.toString().equals("tiempo")) {
            porTiempo();
        } else {
            porIntentos();
        }

    }

    private void porIntentos() {
        btnColorUno = (Button) findViewById(R.id.btnColorUno);
        btnColorDos = (Button) findViewById(R.id.btnColorDos);
        btnColorTres = (Button) findViewById(R.id.btnColorTres);
        btnColorCuatro = (Button) findViewById(R.id.btnColorCuatro);
        tvContadorPalabrasCorrectas = (TextView) findViewById(R.id.tvContadorPalabrasCorrectas);
        tvContadorPalabrsIncorrectas = (TextView) findViewById(R.id.tvContadorPalabrasIncorrectas);
        tvPalabrasDesplegadas = (TextView) findViewById(R.id.tvPalabrasDesplegadas);
        tvPalabras = (TextView) findViewById(R.id.tvPalabrasColor);
        tvTiempoContador = (TextView) findViewById(R.id.tvTiempoContador);
        btnPausa = (Button) findViewById(R.id.btnPausa);

        cargarPalabras();
        cargarColores();
        asignarColoresBotones();
        asignarPalabrasColor();

        btnColorUno.setOnClickListener(this);
        btnColorDos.setOnClickListener(this);
        btnColorTres.setOnClickListener(this);
        btnColorCuatro.setOnClickListener(this);
        btnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador.cancel();
                asignarColoresBotones();
                asignarPalabrasColor();
                contador.start();

            }
        });


        tiempoPalabras = tiempoPalabras * 1000;

        contador = new CountDownTimer(tiempoPalabras, 10) {
            @Override
            public void onTick(long l) {
                int tiempo = (int) l / 1000;
                tvTiempoContador.setText("" + (tiempo + l));

            }

            @Override
            public void onFinish() {
                tvContadorPalabrsIncorrectas.setText("" + (++palabrasIncorrectas));
                if (palabrasDesplegadas == tiempoOIntentos) {
                    contador.cancel();
                    Toast.makeText(getApplicationContext(), "Su partida Finalizo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(JuegoPersonalizadoActivity.this,MenuActivity.class);
                    startActivity(intent);
                } else {
                    contador.cancel();
                    asignarPalabrasColor();
                    asignarColoresBotones();
                    contador.start();
                }
            }
        };
        contador.start();
    }

    private void asignarPalabrasColor() {
        int indice;
        Collections.shuffle(palabrasColor);
        indice = (int) (Math.random() * palabrasColor.size());
        tvPalabras.setText(palabrasColor.get(indice));
        Collections.shuffle(colorPalabra);
        indice = (int) (Math.random() * colorPalabra.size());
        tvPalabras.setTextColor(Color.parseColor(colorPalabra.get(indice)));
        tvPalabrasDesplegadas.setText("" + (++palabrasDesplegadas));
    }

    private void asignarColoresBotones() {
        seleccionarColorAleatorio(btnColorUno);
        seleccionarColorAleatorio(btnColorDos);
        seleccionarColorAleatorio(btnColorTres);
        seleccionarColorAleatorio(btnColorCuatro);
        cargarColores();
    }

    private void seleccionarColorAleatorio(Button btnOpcion) {
        int indiceAleatorio;

        Collections.shuffle(colorPalabra);
        indiceAleatorio = (int) (Math.random() * colorPalabra.size());

        btnOpcion.setBackgroundColor(Color.parseColor(colorPalabra.get(indiceAleatorio)));
        colorPalabra.remove(indiceAleatorio);


    }

    private void cargarColores() {
        colorPalabra.add("#FFFF4043");
        colorPalabra.add("#FF0073FF");
        colorPalabra.add("#FF48BE04");
        colorPalabra.add("#FFFFFF00");
    }

    private void cargarPalabras() {
        palabrasColor.add("Rojo");
        palabrasColor.add("Azul");
        palabrasColor.add("Verde");
        palabrasColor.add("Amarillo");
    }

    @Override
    public void onClick(View view) {
        ColorDrawable color = (ColorDrawable) view.getBackground();

        if (color.getColor() == tvPalabras.getCurrentTextColor()) {
            contador.cancel();
            tvContadorPalabrasCorrectas.setText("" + (++palabrasCorrectas));
            asignarColoresBotones();
            asignarPalabrasColor();
            contador.start();
        } else {
            tvContadorPalabrsIncorrectas.setText("" + (++palabrasIncorrectas));
            if (palabrasDesplegadas == tiempoOIntentos) {
                contador.cancel();
                Toast.makeText(getApplicationContext(), "Su partida Finalizo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(JuegoPersonalizadoActivity.this,MenuActivity.class);
                startActivity(intent);
            } else {
                contador.cancel();
                asignarPalabrasColor();
                asignarColoresBotones();
                contador.start();
            }
        }
    }


    private void porTiempo() {
    }

}
