package com.example.aplicacionbanco;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class IngresosActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDrawerAndToolbar(R.layout.ingresos, getString(R.string.title_ingresos));

        Button btnFinalizar = findViewById(R.id.btn_finalizar);
        if (btnFinalizar != null) {
            btnFinalizar.setOnClickListener(v -> {
                Toast.makeText(this, "Registro completado con éxito", Toast.LENGTH_LONG).show();
                navigateToActivity(MainActivity.class);
            });
        }
    }
}