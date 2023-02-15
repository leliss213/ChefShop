package com.example.chefshop;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import modelDominio.Usuario;

public class PerfilUsuarioActivity extends AppCompatActivity {
    TextView tvNomeUser;
    Button bSairCliente;
    InformacoesApp informacoesApp;
    Usuario user,userLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvNomeUser = findViewById(R.id.tvNomeUser);
        bSairCliente = findViewById(R.id.bSairCliente);

        informacoesApp = (InformacoesApp) getApplicationContext();

        tvNomeUser.setText(informacoesApp.getUsuarioLogado().getNomeUsuario());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
