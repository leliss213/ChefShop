package com.example.chefshop;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import modelDominio.Usuario;

public class CategoriasReceitasActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    ImageButton ibCategoriaCarnes,ibCategoriaMassas,ibCategoriaSaladas,ibCategoriaSobremesas,ibCategoriaSopas,ibCategoriaLanches,ibPerfilUsuario,ibTelaInicial;
    InformacoesApp informacoesApp;
    BottomNavigationView bnvCategorias;

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
        bnvCategorias = findViewById(R.id.bnvMenu);

        informacoesApp = (InformacoesApp) getApplicationContext();

        bnvCategorias.setOnNavigationItemSelectedListener(this);

//        //BOTÕES:
//        //Botão Categoria Carnes:
        ibCategoriaCarnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CategoriasReceitasActivity.this, VisualizacaoReceitasRecyclerActivity.class);
                //tenho q transmitir o parametro do tipo clicado
                it.putExtra("tipo",1);
                startActivity(it);
            }
        });

        //Botão Categoria Massas:
        ibCategoriaMassas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CategoriasReceitasActivity.this, VisualizacaoReceitasRecyclerActivity.class);
                //tenho q transmitir o parametro do tipo clicado
                it.putExtra("tipo",2);
                startActivity(it);
            }
        });

        //Botão Categoria Saladas:
        ibCategoriaSaladas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CategoriasReceitasActivity.this, VisualizacaoReceitasRecyclerActivity.class);
                //tenho q transmitir o parametro do tipo clicado
                it.putExtra("tipo",3);
                startActivity(it);
            }
        });

        //Botão Categoria Sobremesas:
        ibCategoriaSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CategoriasReceitasActivity.this, VisualizacaoReceitasRecyclerActivity.class);
                //tenho q transmitir o parametro do tipo clicado
                it.putExtra("tipo",4);
                startActivity(it);
            }
        });

        //Botão Categoria Sopas:
        ibCategoriaSopas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CategoriasReceitasActivity.this, VisualizacaoReceitasRecyclerActivity.class);
                //tenho q transmitir o parametro do tipo clicado
                it.putExtra("tipo",5);
                startActivity(it);
            }
        });

        //Botão Categoria Lanches:
        ibCategoriaLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CategoriasReceitasActivity.this, VisualizacaoReceitasRecyclerActivity.class);
                //tenho q transmitir o parametro do tipo clicado
                it.putExtra("tipo",6);
                startActivity(it);
            }
        });

//        //Botão Perfil:
//        ibPerfilUsuario.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(CategoriasReceitasActivity.this, PerfilUsuarioActivity.class);
//                startActivity(it);
//            }
//        });
//
//        //Botão Tela Inicial:
//        ibTelaInicial.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent it = new Intent(CategoriasReceitasActivity.this, CategoriasReceitasActivity.class);
////                startActivity(it);
//            }
//        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //metodo da barrinha
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.categorias:
                Intent it= new Intent(this, CategoriasReceitasActivity.class);
                startActivity(it);
            return true;

            case R.id.perfil:
                it = new Intent(this, PerfilUsuarioActivity.class);
                startActivity(it);
        }
        return false;
    }
}
