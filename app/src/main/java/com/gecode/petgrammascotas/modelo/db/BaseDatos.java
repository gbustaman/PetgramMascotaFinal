package com.gecode.petgrammascotas.modelo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gecode.petgrammascotas.R;

/**
 * Created by gregorybr on 07-11-16.
 */

public class BaseDatos extends SQLiteOpenHelper {
    // Variable Global
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se crea la estructura de la Base de Datos de la tabla
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS  + " ("+
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT NOT NULL," +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER NOT NULL," +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_LIKES    + " INTEGER NOT NULL DEFAULT 0" +
                                        " )";

        db.execSQL (queryCrearTablaMascota);
        if (validaExistenciaTabla(db)){
            insertarDatosIniciales(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    // Preguntamos si existe la Tabla:

    public boolean validaExistenciaTabla (SQLiteDatabase db){
        String query = "SELECT count(*) FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        int cantidad = 0;
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            cantidad = registros.getInt(0);
        }
        //db.close();
        return (cantidad <= 0);
    }

    // Obtener toda la tabla de mascotas ( devolvera de forma en ArrayList)

    public void insertarDatosIniciales(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Muñeco");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_2);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Laica");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_3);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Petrolero");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_4);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Valvula");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_5);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Gordo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_6);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mariposa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_7);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Campeón");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_8);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Dumbo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_9);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chimbo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_10);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Lasi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_19_11);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        //db.close();
    }
}
