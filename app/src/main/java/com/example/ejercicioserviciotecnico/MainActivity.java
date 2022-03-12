package com.example.ejercicioserviciotecnico;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout myDrawer;
    NavigationView myNav;
    Toolbar myToolbar;


    ActionBarDrawerToggle toogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawerView);
        myNav = findViewById(R.id.nav_view);
        myToolbar = findViewById(R.id.mysToolbar);

        setSupportActionBar(myToolbar);
        myNav.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.contenido, new FragmentoInicio()).commit();
        setTitle("HOME");

        toogle = setDrawerToogle();
        myDrawer.addDrawerListener(toogle);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }

    @Override
    protected  void onPostCreate(@Nullable Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }

    private ActionBarDrawerToggle setDrawerToogle(){
        return new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(toogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (item.getItemId()){
                    case R.id.nav_Registro:
                        ft.replace(R.id.contenido, new FragmentoRegistro()).commit();
                        break;
                    case R.id.nav_Busqueda:
                        ft.replace(R.id.contenido, new FragmentoBusqueda()).commit();
                        break;
                    case R.id.nav_Modificar:
                        ft.replace(R.id.contenido, new FragmentoModificacion()).commit();
                        break;
                    case R.id.nav_Eliminar:
                        ft.replace(R.id.contenido, new FragmentoEliminar()).commit();
                        break;
                    case R.id.nav_Inicio:
                        ft.replace(R.id.contenido, new FragmentoInicio()).commit();
                        break;
            }
            return true;
        }


}

