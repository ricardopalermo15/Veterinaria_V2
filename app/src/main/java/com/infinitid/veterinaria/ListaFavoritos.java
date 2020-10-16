package com.infinitid.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ListaFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotasE;
    private RecyclerView listaMascotasE;
    private ImageView imgSubir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        imgSubir = (ImageView) findViewById(R.id.imgSubir);
        imgSubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolverAMain();
            }
        });

        listaMascotasE = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasE.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasE, this);
        listaMascotasE.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotasE = new ArrayList<Mascota>();

        mascotasE.add(new Mascota(R.drawable.cocker, "Guada   ","5"));
        mascotasE.add(new Mascota(R.drawable.cchihuahua, "Marimar ","5"));
        mascotasE.add(new Mascota(R.drawable.dalmata,"Keeper  ","5"));
        mascotasE.add(new Mascota(R.drawable.grandanes, "Grandote","4"));
        mascotasE.add(new Mascota(R.drawable.labrador, "Laiza   ","4"));
    }

    public void VolverAMain(){
        Intent intent = new Intent(ListaFavoritos.this, MainActivity.class);
        startActivity(intent);
    }
}