package com.gecode.petgrammascotas.presentador;

import com.gecode.petgrammascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by gregorybr on 07-11-16.
 */

public interface IRecylerViewFragmentPresenter {

    public void obtenerMascotaBaseDatos();
    public void  mostrarMascotaRV();

    public ArrayList<Mascota> obtener5MejoresMascotas();
}
