package com.example.worldskills.colorapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoDefectoActivity extends AppCompatActivity implements View.OnClickListener {

    //Intanciamos todos los elementos

    ArrayList<String> palabrasColor = new ArrayList<>();
    ArrayList<String> colorPalabra = new ArrayList<>();
    CountDownTimer contador;
    Button btnColorUno, btnColorDos, btnColorTres, btnColorCuatro, btnPausa;
    int palabrasCorrectas = 0, palabrasIncorrectas = 0, palabrasDesplegadas = 0;
    TextView tvPalabrasIncorrectas, tvContadorPalabrasCorrectas, tvContadorPalabrsIncorrectas, tvPalabras, tvPalabrasDesplegadas;
    TextView tvTiempo, tvTiempoContador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_defecto);

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



        contador = new CountDownTimer(3000, 10) {
            @Override
            public void onTick(long l) {
                int tiempo = (int) l / 1000;
                tvTiempoContador.setText("" + (tiempo + 1));

            }

            @Override
            public void onFinish() {
                tvContadorPalabrsIncorrectas.setText("" + (++palabrasIncorrectas));
                cargarPalabras();
                cargarColores();

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
            if (tvContadorPalabrsIncorrectas.getText().equals("3")) {
                contador.cancel();
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Tu partida finalizo")
                        .setPositiveButton("Listo", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent menu = new Intent(JuegoDefectoActivity.this, MenuActivity.class);
                                startActivity(menu);
                            }
                        });

            } else {
                contador.cancel();
                asignarPalabrasColor();
                asignarColoresBotones();
                contador.cancel();
            }
        }
    }
}


