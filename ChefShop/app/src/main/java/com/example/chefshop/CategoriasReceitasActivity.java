package com.example.chefshop;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import modelDominio.Usuario;

public class CategoriasReceitasActivity extends AppCompatActivity {
    Button bCategoriaCarnes,bCategoriaMassas,bCategoriaSaladas,bCategoriaSobremesas,bCategoriaSopas,bCategoriaLanches;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_receitas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bCategoriaCarnes = findViewById(R.id.bCategoriaCarnes);
        bCategoriaMassas = findViewById(R.id.bCategoriaMassas);
        bCategoriaSaladas = findViewById(R.id.bCategoriaSaladas);
        bCategoriaSobremesas = findViewById(R.id.bCategoriaSobremesas);
        bCategoriaSopas = findViewById(R.id.bCategoriaSopas);
        bCategoriaLanches = findViewById(R.id.bCategoriaLanches);

        informacoesApp = (InformacoesApp) getApplicationContext();

        //BOTÕES:
        //Botão Categoria Carnes:
        bCategoriaCarnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Massas:
        bCategoriaMassas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Saladas:
        bCategoriaSaladas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Sobremesas:
        bCategoriaSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Sopas:
        bCategoriaSopas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Lanches:
        bCategoriaLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
