package com.infinitid.veterinaria;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbr;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuItem;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mContacto:
                //Intent intent = new Intent(this, ActivityAbout.class);
                //startActivity(intent);
                break;
            case R.id.mAcercaDe:
                //Intent intent1 = new Intent(this, ActivitySettings.class);
                //startActivity(intent1);
                break;
        }

        return super.onOptionsItemSelected(item);
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
