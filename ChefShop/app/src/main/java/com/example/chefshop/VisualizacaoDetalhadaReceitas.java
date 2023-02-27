package com.example.chefshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import modelDominio.Receita;

public class VisualizacaoDetalhadaReceitas extends AppCompatActivity {
    ImageView ivVisualizacaoDetalhadaReceitasImagem;
    TextView tvVisualizacaoDetalhadaReceitasNome,tvVisualizacaoDetalhadaReceitasIngredientes,tvVisualizacaoDetalhadaReceitasModoPreparo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao_detalhada_receitas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ivVisualizacaoDetalhadaReceitasImagem = findViewById(R.id.ivVisualizacaoDetalhadaReceitasImagem);
        tvVisualizacaoDetalhadaReceitasNome = findViewById(R.id.tvVisualizacaoDetalhadaReceitasNome);
        tvVisualizacaoDetalhadaReceitasIngredientes = findViewById(R.id.tvVisualizacaoDetalhadaReceitasIngredientes);
        tvVisualizacaoDetalhadaReceitasModoPreparo = findViewById(R.id.tvVisualizacaoDetalhadaReceitasModoPreparo);


        Intent it = getIntent();
        final Receita receita = (Receita) it.getSerializableExtra("receita");
        if (it!=null) {
            tvVisualizacaoDetalhadaReceitasNome.setText(receita.getNomeReceita());
            tvVisualizacaoDetalhadaReceitasModoPreparo.setText(receita.getModoPreparo());
            tvVisualizacaoDetalhadaReceitasIngredientes.setText(receita.getNomesIngredientes(receita.getIngredientes()).toString());
            Bitmap bitmap = BitmapFactory.decodeByteArray(receita.getImagemReceita(), 0, receita.getImagemReceita().length);
            ivVisualizacaoDetalhadaReceitasImagem.setImageBitmap(bitmap);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
