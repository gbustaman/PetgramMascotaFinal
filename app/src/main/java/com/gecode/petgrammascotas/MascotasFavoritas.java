package com.gecode.petgrammascotas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gecode.petgrammascotas.adapter.AdapterMascota;
import com.gecode.petgrammascotas.modelo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private RecyclerView listadoMascotas;
    ArrayList<Mascota> lstmascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar toolPersonalizado = (Toolbar) findViewById(R.id.abFavotito);
        setSupportActionBar(toolPersonalizado);

        int size = getResources().getTextArray(R.array.pmascotas).length;
        lstmascotas = new ArrayList<Mascota>();
        for (int i=0; i<size; i++){
            //obtengo el objeto serializado
            lstmascotas.add((Mascota) getIntent().getSerializableExtra(getResources().getTextArray(R.array.pmascotas)[i].toString()));
        }


        listadoMascotas = (RecyclerView) findViewById( R.id.rvMascota );
        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager( llm );
        //inicializarListaMascotas();
        inicializarAdaptador();
        agregarFAB();
    }

    // DataSet: Cargamos los datos que queremos mostrar
    /*public  void  inicializarListaMascotas(){
        lstmascotas = new ArrayList<>();
        lstmascotas.add(new Mascota("Valvula", R.drawable.mascota_19_5, 0));
        lstmascotas.add(new Mascota("Gordo", R.drawable.mascota_19_6,0));
        lstmascotas.add(new Mascota("Campeón", R.drawable.mascota_19_8,0));
        lstmascotas.add(new Mascota("Lasi", R.drawable.mascota_19_11, 0));
        lstmascotas.add(new Mascota("Thimboy", R.drawable.mascota_19_13,0));
    }*/

    public void inicializarAdaptador(){
        AdapterMascota adaptador = new AdapterMascota(lstmascotas,this);
        listadoMascotas.setAdapter(adaptador);
    }

    // Retorna a la Primera Activida al dar Click en el boton retroceso
    public  void  irPrimeraActividad (View v) {
        finish();
    }

    // Accion del boton Camara, solo nos muestra un mensaje por el momento.
    public void agregarFAB(){
        FloatingActionButton mFAB = (FloatingActionButton) findViewById(R.id.FAB_Camera);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,getString(R.string.floating_mensaje), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
