package com.gecode.petgrammascotas.modelo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gecode.petgrammascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by gregorybr on 07-11-16.
 */

public class ConstructorMascotas {

    private Context context;
    private BaseDatos baseDatos;

    public ConstructorMascotas(Context context) {
        this.context = context;
        this.baseDatos = new BaseDatos(this.context);
    }

    // Metodo obtener los datos

    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas;
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        mascotas = deRegistrosAMascotas(registros);
        db.close();
        return mascotas;
    }


    public ArrayList<Mascota> obtener5MejoresMascotas(){
        ArrayList<Mascota> mascotas;
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTAS +" ORDER BY "+ ConstantesBaseDatos.TABLE_MASCOTAS_LIKES +" DESC LIMIT 5";
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        mascotas = deRegistrosAMascotas(registros);
        db.close();
        return mascotas;
    }

    private ArrayList<Mascota> deRegistrosAMascotas(Cursor registros){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        return mascotas;
    }

    public void likesMascota(Mascota mascota){
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();

        String queryActualizarPuntajeTablaMascota = "UPDATE " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " SET " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " = " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + "+1 " +
                "WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + Integer.toString(mascota.getId());

        db.execSQL(queryActualizarPuntajeTablaMascota);

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + " = " + mascota.getId();
        Cursor dato_mascota = db.rawQuery(query, null);
        if (dato_mascota.moveToNext()){
            mascota.setLikes(dato_mascota.getInt(3));
        }

        db.close();
    }

}
