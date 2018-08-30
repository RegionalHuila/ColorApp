package com.example.worldskills.colorapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoDefectoActivity extends AppCompatActivity {

    //Intanciamos todos los elementos

    ArrayList<String> palabrasColor;
    ArrayList<String> colorBotones;
    CountDownTimer contador;
    Button btnColorUno, btnColorDos, btnColorTres, btnColorCuatro;
    int palabrasCorrectas = 0, palabrasIncorrectas = 0;
    TextView tvPalabrasCorrectas, tvPalabrasIncorrectas,tvContadorPalabrasCorrectas,tvContadorPalabrsIncorrectas,tvPalabrasColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_defecto);

        btnColorUno = (Button)findViewById(R.id.btnColorUno);
        btnColorDos =(Button)findViewById(R.id.btnColorDos);
        btnColorTres = (Button)findViewById(R.id.btnColorTres);
        btnColorCuatro = (Button)findViewById(R.id.btnColorCuatro);

        tvPalabrasCorrectas = (TextView)findViewById(R.id.tvPalabrasAcertadas);
        tvPalabrasIncorrectas = (TextView)findViewById(R.id.tvPalabrasIncorrectas);
        tvContadorPalabrasCorrectas = (TextView)findViewById(R.id.tvContadorPalabrasCorrectas);
        tvContadorPalabrsIncorrectas = (TextView)findViewById(R.id.tvContadorPalabrasIncorrectas);
        tvPalabrasColor = (TextView)findViewById(R.id.tvPalabrasColor);

        cargarPalabras();
        cargarColores();
        //asignarColoresBotones();
        asignarPalabrasColor();



        contador = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
                int tiempo = (int) (l/1000);
            }

            @Override
            public void onFinish() {

            }
        };
        contador.start();





    }

    private void asignarPalabrasColor() {
        int indice;
        Collections.shuffle(palabrasColor);
        indice = (int) (Math.random()*palabrasColor.size());


    }

    private void asignarColoresBotones(Button btnOption) {
        seleccionarColorAleatorio(btnColorUno);
        seleccionarColorAleatorio(btnColorDos);
        seleccionarColorAleatorio(btnColorTres);
        seleccionarColorAleatorio(btnColorCuatro);
        cargarColores();
    }

    private void seleccionarColorAleatorio(Button btnColorUno) {
    }

    private void cargarColores() {
        colorBotones.add("#FFFF4043");
        colorBotones.add("#FF0073FF");
        colorBotones.add("#FF48BE04");
        colorBotones.add("#FFFFFF00");
    }

    private void cargarPalabras() {
        palabrasColor.add("Rojo");
        palabrasColor.add("Azul");
        palabrasColor.add("Verde");
        palabrasColor.add("Amarillo");
    }
}
