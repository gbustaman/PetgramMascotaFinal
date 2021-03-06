package com.gecode.petgrammascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gecode.petgrammascotas.adapter.PageAdapter;
import com.gecode.petgrammascotas.vista.fragment.FragmentPerfil;
import com.gecode.petgrammascotas.vista.fragment.RecycleViewFragment;
import com.gecode.petgrammascotas.menu.About;
import com.gecode.petgrammascotas.menu.Contacto;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);
        //================== Creamos nuestro Toolbar personalizado. =====================//
        toolbar = (Toolbar)  findViewById(R.id.miToolBar);
        tabLayout = (TabLayout)  findViewById(R.id.tabLayout);
        viewPager = (ViewPager)  findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }
    private ArrayList <Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecycleViewFragment());
        fragments.add(new FragmentPerfil());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);

    }

    // ActionView Estrella: nos lleva a una nueva actividad (MascotasFavoritas)
   /* public  void  irSegundaActividad (View v) {
        Intent intent = new Intent(this,MascotasFavoritas.class);
        startActivity(intent);
    }*/



    //Creamos un menu a nuestra aplicacion principal.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent1 = new Intent(this, Contacto.class);
                startActivity(intent1);
                break;
            case R.id.mAbout:
                Intent intent2 = new Intent(this, About.class);
                startActivity(intent2);
                break;
        }return super.onOptionsItemSelected(item);
    }
}
