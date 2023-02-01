package com.example.chefshop;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import modelDominio.Receita;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //obtendo o contexto
        informacoesApp = (InformacoesApp) getApplicationContext();

        if (informacoesApp.getListaReceitas() != null) {
            receitaAdapter = new ReceitaAdapter(informacoesApp.getListaReceitas(), trataCliqueItem); //criei o adapter;
            rvElementos.setLayoutManager(new LinearLayoutManager(VisualizacaoReceitasRecyclerActivity.this));
            rvElementos.setItemAnimator(new DefaultItemAnimator());
            rvElementos.setAdapter(receitaAdapter);
        }
    }

    //fora do onCreate mas dentro da activity eu vou criar o trata clique:
    //listener que vai tratar o clique nos elementos do recycler
    ReceitaAdapter.ReceitaOnClickListener trataCliqueItem = new ReceitaAdapter.ReceitaOnClickListener() {
        @Override
        public void onClickReceita(View view, int position) {
            //Obtendo o curso do clique:
            Receita minhaReceita = informacoesApp.getListaReceitas().get(position);
            //Chamar a tela -> criar a intent:
//            Intent it = new Intent(VisualizacaoReceitasRecyclerActivity.this,VisualizacaoDetalhadaActivity.class);
            //Adicionando o curso na solicitação:
//            it.putExtra("curso",meuCurso);
            //Enviando a solicitação:
//            startActivity(it);
        }
    };

}
