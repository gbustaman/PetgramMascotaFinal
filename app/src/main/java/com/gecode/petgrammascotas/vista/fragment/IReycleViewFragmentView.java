package com.gecode.petgrammascotas.vista.fragment;

import com.gecode.petgrammascotas.adapter.AdapterMascota;
import com.gecode.petgrammascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by gregorybr on 07-11-16.
 */

public interface IReycleViewFragmentView {

    public void generarLinearLayoutVerticcal();

    public AdapterMascota crearAdaptador (ArrayList<Mascota> lstmascotas);

    public void inicializarAdaptadorRV(AdapterMascota adaptador);
}
