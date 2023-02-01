package com.example.chefshop;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import modelDominio.Usuario;

public class CategoriasReceitasActivity extends AppCompatActivity {
    ImageButton ibCategoriaCarnes,ibCategoriaMassas,ibCategoriaSaladas,ibCategoriaSobremesas,ibCategoriaSopas,ibCategoriaLanches,ibPerfilUsuario,ibTelaInicial;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_receitas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ibCategoriaCarnes = findViewById(R.id.ibCategoriaCarnes);
        ibCategoriaMassas = findViewById(R.id.ibCategoriaMassas);
        ibCategoriaSaladas = findViewById(R.id.ibCategoriaSaladas);
        ibCategoriaSobremesas = findViewById(R.id.ibCategoriaSobremesas);
        ibCategoriaSopas = findViewById(R.id.ibCategoriaSopas);
        ibCategoriaLanches = findViewById(R.id.ibCategoriaLanches);

        informacoesApp = (InformacoesApp) getApplicationContext();

        //BOTÕES:
        //Botão Categoria Carnes:
        ibCategoriaCarnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Massas:
        ibCategoriaMassas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Saladas:
        ibCategoriaSaladas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Sobremesas:
        ibCategoriaSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Sopas:
        ibCategoriaSopas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Categoria Lanches:
        ibCategoriaLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Perfil:
        ibPerfilUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CategoriasReceitasActivity.this, PerfilUsuarioActivity.class);
                startActivity(it);
            }
        });

        //Botão Tela Inicial:
        ibTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent it = new Intent(CategoriasReceitasActivity.this, CategoriasReceitasActivity.class);
//                startActivity(it);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
