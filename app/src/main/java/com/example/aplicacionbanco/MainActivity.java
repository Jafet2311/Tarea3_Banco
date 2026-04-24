package com.example.aplicacionbanco;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDrawerAndToolbar(R.layout.activity_main, getString(R.string.title_main));
    }
}