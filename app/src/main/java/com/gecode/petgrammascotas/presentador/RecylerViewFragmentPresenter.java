package com.gecode.petgrammascotas.presentador;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.gecode.petgrammascotas.MascotasFavoritas;
import com.gecode.petgrammascotas.R;
import com.gecode.petgrammascotas.modelo.db.ConstructorMascotas;
import com.gecode.petgrammascotas.modelo.Mascota;
import com.gecode.petgrammascotas.vista.fragment.IReycleViewFragmentView;

import java.util.ArrayList;

/**
 * Created by gregorybr on 07-11-16.
 */

public class RecylerViewFragmentPresenter implements IRecylerViewFragmentPresenter{

    // Declaramos objetemos de forma global
    private IReycleViewFragmentView iReycleViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecylerViewFragmentPresenter(final IReycleViewFragmentView iReycleViewFragmentView, Context context) {
        this.iReycleViewFragmentView = iReycleViewFragmentView;
        this.context = context;

        obtenerMascotaBaseDatos();
        mostrarMascotaRV();
        ImageView img5Stars = (ImageView) ((Fragment)iReycleViewFragmentView).getActivity().findViewById(R.id.imgFavoritos);
        img5Stars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ArrayList<Mascota> mascotas5 = obtener5MejoresMascotas();
                Intent intent = new Intent(((Fragment)iReycleViewFragmentView).getActivity(), MascotasFavoritas.class);
                for (int i=0; i<mascotas5.size(); i++){
                    intent.putExtra(((Fragment)iReycleViewFragmentView).getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas5.get(i));
                }
                ((Fragment)iReycleViewFragmentView).startActivity(intent);
            }
        });

    }

    @Override
    public void obtenerMascotaBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTodasMascotas();

    }

    @Override
    public void mostrarMascotaRV() {
        iReycleViewFragmentView.inicializarAdaptadorRV(iReycleViewFragmentView.crearAdaptador(mascotas));
        iReycleViewFragmentView.generarLinearLayoutVerticcal();
    }

    @Override
    public ArrayList<Mascota> obtener5MejoresMascotas() {
        constructorMascotas = new ConstructorMascotas(this.context);
        return constructorMascotas.obtener5MejoresMascotas();
    }
}
