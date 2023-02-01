package com.example.chefshop;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

public class VisualizacaoReceitasRecyclerActivity extends AppCompatActivity {
    RecyclerView rvElementos;
    ReceitaAdapter receitaAdapter;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao_receitas_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvElementos = (RecyclerView) findViewById(R.id.rvElementos);

        //obtendo o contexto
        informacoesApp = (InformacoesApp) getApplicationContext();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
