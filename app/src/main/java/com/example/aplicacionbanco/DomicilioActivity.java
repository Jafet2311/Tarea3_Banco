package com.example.aplicacionbanco;

import android.os.Bundle;
import android.widget.Button;

public class DomicilioActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDrawerAndToolbar(R.layout.domicilio, getString(R.string.title_domicilio));

        Button btnContinuar = findViewById(R.id.btn_continuar);
        if (btnContinuar != null) {
            btnContinuar.setOnClickListener(v -> {
                navigateToActivity(IngresosActivity.class);
            });
        }
    }
}