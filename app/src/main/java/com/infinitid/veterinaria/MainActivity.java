package com.infinitid.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageView imgElegidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        imgElegidos = (ImageView) findViewById(R.id.imgElegidos);
        imgElegidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAElegios();
            }
        });

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptador();

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.bulldog, "Iara","3"));
        mascotas.add(new Mascota(R.drawable.cchihuahua, "Marimar","5"));
        mascotas.add(new Mascota(R.drawable.cocker, "Guada","5"));
        mascotas.add(new Mascota(R.drawable.dalmata,"Keeper","5"));
        mascotas.add(new Mascota(R.drawable.grandanes, "Grandote","4"));
        mascotas.add(new Mascota(R.drawable.labrador, "Laiza","4"));
        mascotas.add(new Mascota(R.drawable.siberiano, "Laika","2"));
    }

    public void IrAElegios(){
        Intent intent = new Intent(MainActivity.this, ListaFavoritos.class);
        startActivity(intent);
    }
}
