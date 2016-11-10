package com.gecode.petgrammascotas.adapter;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gecode.petgrammascotas.ListaMascotas;
import com.gecode.petgrammascotas.R;
import com.gecode.petgrammascotas.modelo.db.ConstructorMascotas;
import com.gecode.petgrammascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by gregorybr on 28-10-16.
 */

public class AdapterMascota extends RecyclerView.Adapter<AdapterMascota.MascotaViewHolder> {

    private int idCardView;
    private  ArrayList<Mascota> mascotas;
    Activity activity;

    public AdapterMascota( ArrayList<Mascota> mascotas, Activity activity ) {
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @Override
    public AdapterMascota.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_mascotas, parent, false );
        return new MascotaViewHolder( v );
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get( position );
        holder.imgFoto.setImageResource( mascota.getFoto() );
        holder.tvNombreMascota.setText( mascota.getNombreMascota() );
        holder.tvRaiting.setText( String.valueOf (mascota.getLikes()) );



        if (ListaMascotas.class == activity.getClass()) {
            holder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    constructorMascotas.likesMascota(mascota);
                    holder.tvRaiting.setText(String.valueOf(mascota.getLikes()));

                    Snackbar.make(v,"Diste like a" + mascota.getNombreMascota(), Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreMascota;
        private TextView tvRaiting;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            tvNombreMascota = (TextView) itemView.findViewById( R.id.tvNombreMascotaCV );
            imgFoto = (ImageView) itemView.findViewById( R.id.imgFotoMascota );
            tvRaiting = (TextView) itemView.findViewById( R.id.tvRaitingCV );
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }

    }
}
