package com.example.proyectotommyeduca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.proyectotommyeduca.data.BD;
import com.example.proyectotommyeduca.modelo.Colegio;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton btn_Video,btn_Mapa;
    private Spinner spinner_Colegio;
    private Adapter adapter_Colegio;
    private ArrayAdapter<Colegio> adapterColegio;
    public static Colegio colegio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Video = findViewById(R.id.button_Video);
        btn_Mapa = findViewById(R.id.button_Mapa);
        spinner_Colegio = findViewById(R.id.spinner_Colegio);

        BD bd = new BD(getApplicationContext());
        List<Colegio> listaCategorias = bd.get_AllColegio();

        adapterColegio = new ArrayAdapter<Colegio>(this,android.R.layout.simple_expandable_list_item_1,listaCategorias);
        spinner_Colegio.setAdapter(adapterColegio);
        init();

    }
    private void init(){
        btn_Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Colegio col = (Colegio) spinner_Colegio.getSelectedItem();
                colegio = col;

                Intent i = new Intent(getApplicationContext(), Seleccion_de_Videos.class);
                startActivity(i);
            }
        });
        btn_Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Colegio col = (Colegio) spinner_Colegio.getSelectedItem();
                colegio = col;

                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);

            }
        });
    }
}