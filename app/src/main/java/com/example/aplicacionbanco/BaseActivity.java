package com.example.aplicacionbanco;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupDrawerAndToolbar(int layoutResId, String title) {
        setContentView(layoutResId);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        if (drawerLayout != null && navigationView != null) {
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, toolbar,
                    android.R.string.ok, android.R.string.cancel);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();

                    if (id == R.id.nav_datos) {
                        Log.i("BancoApp", "Navegando a Datos Personales");
                        Toast.makeText(BaseActivity.this, "Abriendo Datos Personales", Toast.LENGTH_SHORT).show();
                        navigateToActivity(DatosActivity.class);
                    } else if (id == R.id.nav_domicilio) {
                        Log.i("BancoApp", "Navegando a Domicilio");
                        Toast.makeText(BaseActivity.this, "Abriendo Domicilio", Toast.LENGTH_SHORT).show();
                        navigateToActivity(DomicilioActivity.class);
                    } else if (id == R.id.nav_ingresos) {
                        Log.i("BancoApp", "Navegando a Ingresos");
                        Toast.makeText(BaseActivity.this, "Abriendo Ingresos", Toast.LENGTH_SHORT).show();
                        navigateToActivity(IngresosActivity.class);
                    } else if (id == R.id.nav_help) {
                        Log.i("BancoApp", "AYUDA - Desde Navigation Drawer");
                        Toast.makeText(BaseActivity.this, "Ayuda - Centro de ayuda", Toast.LENGTH_SHORT).show();
                    } else if (id == R.id.nav_settings) {
                        Log.i("BancoApp", "CONFIGURACIÓN - Desde Navigation Drawer");
                        Toast.makeText(BaseActivity.this, "Configuración - Ajustes de la app", Toast.LENGTH_SHORT).show();
                    } else if (id == R.id.nav_exit) {
                        Log.i("BancoApp", "SALIR - Cerrando aplicación");
                        Toast.makeText(BaseActivity.this, "Saliendo...", Toast.LENGTH_SHORT).show();
                        finishAffinity();
                    }

                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
            });
        }
    }

    protected void navigateToActivity(Class<?> targetActivity) {
        if (getClass() != targetActivity) {
            startActivity(new Intent(this, targetActivity));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (id == R.id.action_help) {
            Log.i("BancoApp", "AYUDA - Desde Action Bar");
            Toast.makeText(this, "Ayuda - ¿Necesitas asistencia?", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Log.i("BancoApp", "CONFIGURACIÓN - Desde Action Bar");
            Toast.makeText(this, "Configuración - Personaliza tu experiencia", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_exit) {
            Log.i("BancoApp", "SALIR - Cerrando aplicación desde Action Bar");
            Toast.makeText(this, "Saliendo...", Toast.LENGTH_SHORT).show();
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}