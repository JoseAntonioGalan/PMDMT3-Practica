package com.example.pmdmt3_practica;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.*;

public class SecondaryActivity extends AppCompatActivity implements View.OnClickListener {

    int day,month,year;
    TextView lblHoroscopo;
    TextView lblEdad;
    ImageView imgHoroscopo;
    String horoscopo;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        lblHoroscopo = findViewById(R.id.lblHoroscopo);
        imgHoroscopo = findViewById(R.id.imgHoroscopo);
        lblEdad = findViewById(R.id.lblEdad);

        imgHoroscopo.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            day = extras.getInt("day");
            month = extras.getInt("month");
            year = extras.getInt("year");

            String edad = edad(day,month,year);
            lblEdad.setText(edad);
            horoscopo = horoscopo(day, month);
            lblHoroscopo.setText("Eres "+horoscopo);
            cambiarImagen(horoscopo);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String edad(int dia, int mes, int anio){
        Period edad = Period.between(LocalDate.of(anio, mes,dia), LocalDate.now());
        String fecha = edad.getYears() + " años, " + edad.getMonths() + " meses y " + edad.getDays() + " dias";
        return fecha;
    }

    public void cambiarImagen(String horoscopo){

        switch (horoscopo){
            case "Aries":
                imgHoroscopo.setImageResource(R.drawable.ic_aries);
                break;
            case "Tauro":
                imgHoroscopo.setImageResource(R.drawable.ic_taurus);
                break;
            case "Geminis":
                imgHoroscopo.setImageResource(R.drawable.ic_gemini);
                break;
            case "Cancer":
                imgHoroscopo.setImageResource(R.drawable.ic_cancer);
                break;
            case "Leo":
                imgHoroscopo.setImageResource(R.drawable.ic_leo);
                break;
            case "Virgo":
                imgHoroscopo.setImageResource(R.drawable.ic_virgo);
                break;
            case "Libra":
                imgHoroscopo.setImageResource(R.drawable.ic_libra);
                break;
            case "Escorpio":
                imgHoroscopo.setImageResource(R.drawable.ic_scorpio);
                break;
            case "Sagitario":
                imgHoroscopo.setImageResource(R.drawable.ic_sagittarius);
                break;
            case "Capricornio":
                imgHoroscopo.setImageResource(R.drawable.ic_capricorn);
                break;
            case "Acuario":
                imgHoroscopo.setImageResource(R.drawable.ic_aquarius);
                break;
            case "Piscis":
                imgHoroscopo.setImageResource(R.drawable.ic_pisces);
                break;
        }

    }

    public void hipervinculo(String enlace){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(enlace));
        startActivity(intent);
    }

    public String horoscopo(int day, int month){
        String horoscopo = "";
        switch (month){
            case 1:
                if (day>=20){
                    horoscopo = "Acuario";
                }else{
                    horoscopo = "Capricornio";
                }
                break;
            case 2:
                if (day>=19){
                    horoscopo = "Piscis";
                }else{
                    horoscopo = "Acuario";
                }
                break;
            case 3:
                if (day>=21){
                    horoscopo = "Aries";
                }else{
                    horoscopo = "Piscis";
                }
                break;
            case 4:
                if (day>=20){
                    horoscopo = "Tauro";
                }else{
                    horoscopo = "Aries";
                }
                break;
            case 5:
                if (day>=21){
                    horoscopo = "Geminis";
                }else{
                    horoscopo = "Tauro";
                }
                break;
            case 6:
                if (day>=21){
                    horoscopo = "Cancer";
                }else{
                    horoscopo = "Geminis";
                }
                break;
            case 7:
                if (day>=23){
                    horoscopo = "Leo";
                }else{
                    horoscopo = "Cancer";
                }
                break;
            case 8:
                if (day>=23){
                    horoscopo = "Virgo";
                }else{
                    horoscopo = "Leo";
                }
                break;
            case 9:
                if (day>=23){
                    horoscopo = "Libra";
                }else{
                    horoscopo = "Virgo";
                }
                break;
            case 10:
                if (day>=23){
                    horoscopo = "Escorpio";
                }else{
                    horoscopo = "Libra";
                }
                break;
            case 11:
                if (day>=22){
                    horoscopo = "Sagitario";
                }else{
                    horoscopo = "Escorpio";
                }
                break;
            case 12:
                if (day>=22){
                    horoscopo = "Capricornio";
                }else{
                    horoscopo = "Sagitario";
                }
                break;
        }
        return  horoscopo;
    }

    @Override
    public void onClick(View v) {

        if (v.equals(imgHoroscopo)){
            switch (horoscopo){
                case "Aries":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/aries");
                    break;
                case "Tauro":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/tauro");
                    break;
                case "Geminis":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/geminis");
                    break;
                case "Cancer":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/cancer");
                    break;
                case "Leo":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/leo");
                    break;
                case "Virgo":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/virgo");
                    break;
                case "Libra":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/libra");
                    break;
                case "Escorpio":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/escorpio");
                    break;
                case "Sagitario":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/sagitario");
                    break;
                case "Capricornio":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/capricornio");
                    break;
                case "Acuario":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/acuario");
                    break;
                case "Piscis":
                    hipervinculo("https://www.esperanzagraciaoficial.es/horoscopo-semanal/piscis");
                    break;
            }
        }

    }
}