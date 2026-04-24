package com.example.aplicacionbanco;

import android.os.Bundle;
import android.widget.Button;

public class DatosActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDrawerAndToolbar(R.layout.datospersonales, "Datos Personales");

        Button btnContinuar = findViewById(R.id.btn_continuar);
        if (btnContinuar != null) {
            btnContinuar.setOnClickListener(v -> {
                navigateToActivity(DomicilioActivity.class);
            });
        }
    }
}