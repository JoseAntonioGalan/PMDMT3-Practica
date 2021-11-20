package com.example.pmdmt3_practica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtSeleccionarFecha;
    Button btnEnviar;
    Button btnLimpiar;
    int year, month, day;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSeleccionarFecha = findViewById(R.id.txtFechaSeleccionada);
        btnEnviar = findViewById(R.id.btnCalcularHoroscopo);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        txtSeleccionarFecha.setOnClickListener(this);
        btnEnviar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.equals(btnLimpiar)){
            txtSeleccionarFecha.setText("");
        }else if (v.equals(txtSeleccionarFecha)){
            Calendar calendario = Calendar.getInstance();
            year = calendario.get(Calendar.YEAR);
            month = calendario.get(Calendar.MONTH);
            day = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int anio, int mes, int dia) {
                    date = dia+"/"+(mes+1)+"/"+anio;
                    year = anio;
                    month = mes+1;
                    day = dia;
                    txtSeleccionarFecha.setText(date);
                }
            }
            ,year, month, day);
            dialog.show();
        }else if (v.equals(btnEnviar)){
            if (txtSeleccionarFecha.length() == 0){
                Toast.makeText(this, "Introduce una fecha correcta", Toast.LENGTH_SHORT).show();
            }else if (comprobacionFecha(txtSeleccionarFecha.getText().toString())){
                Toast.makeText(this, "Introduce una fecha correcta", Toast.LENGTH_SHORT).show();
            }else{
                Intent intentoSecundario = new Intent(this, SecondaryActivity.class);
                intentoSecundario.putExtra("day", day);
                intentoSecundario.putExtra("month",month);
                intentoSecundario.putExtra("year",year);
                startActivity(intentoSecundario);
            }
        }
    }

    public boolean comprobacionFecha(String fechaSeleccionada){
        boolean correcto = true;
        String[] fechaFraccionada = fechaSeleccionada.split("/");
        Date fechaactual = new Date(System.currentTimeMillis());
        String fechaInicio = fechaFraccionada[2]+"-"+fechaFraccionada[1]+"-"+fechaFraccionada[0];
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fechaInicioDate = date.parse(fechaInicio);
            //comprueba si es que inicio esta después que fecha actual
            if(fechaInicioDate.after(fechaactual)){
                correcto = true;
            }else{
                correcto = false;
            }
        } catch (ParseException e) {
            Log.e("Fecha Seleccionada","Error en la fecha que se le ha pasado");
        }


        return  correcto;
    }



}