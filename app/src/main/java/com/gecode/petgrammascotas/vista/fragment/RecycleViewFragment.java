package com.gecode.petgrammascotas.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gecode.petgrammascotas.R;
import com.gecode.petgrammascotas.adapter.AdapterMascota;
import com.gecode.petgrammascotas.modelo.Mascota;
import com.gecode.petgrammascotas.presentador.IRecylerViewFragmentPresenter;
import com.gecode.petgrammascotas.presentador.RecylerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by gregorybr on 30-10-16.
 */

public class RecycleViewFragment extends Fragment implements IReycleViewFragmentView {
    ArrayList<Mascota> lstmascotas;
    private RecyclerView listadoMascotas;
    private IRecylerViewFragmentPresenter presenter;

    public RecycleViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycleview,container,false);
        // Creamos el RecyclerView
        listadoMascotas = (RecyclerView) v.findViewById( R.id.rvMascota );
        presenter = new RecylerViewFragmentPresenter(this, getActivity());
        return v;

    }

    // DataSet: Cargamos los datos que queremos mostrar
   /* public  void  inicializarDatos(){
        lstmascotas = new ArrayList<>();
        lstmascotas.add(new Mascota(R.drawable.mascota_19_2,"Muñeco","5"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_3,"Laica","6"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_4,"Petrolero","7"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_5,"Valvula","13"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_6,"Gordo","52"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_7,"Mariposa","2"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_8,"Campeón","15"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_9,"Dumbo","7"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_10,"Chimbo","1"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_11,"Lasi","10"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_12,"Poker","5"));
        lstmascotas.add(new Mascota(R.drawable.mascota_19_13,"Thimboy","98"));

    }*/

    @Override
    public void generarLinearLayoutVerticcal() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager( llm );
    }

    @Override
    public AdapterMascota crearAdaptador(ArrayList<Mascota> lstmascotas) {
        AdapterMascota adaptador = new AdapterMascota(lstmascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AdapterMascota adaptador) {
        listadoMascotas.setAdapter(adaptador);
    }


}
