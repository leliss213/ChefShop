package com.example.chefshop;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import controller.ConexaoSocketController;

public class MainActivity extends AppCompatActivity {
    Button bMainEntrar;

    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //obtendo o contexto:
        informacoesApp = (InformacoesApp) getApplicationContext();

        bMainEntrar = findViewById(R.id.bMainEntrar);

        //criando a thread para efetuar a conexão com servidor
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexaoSocketController controller = new ConexaoSocketController(informacoesApp); //tenho a chamada do socket
                boolean resultado = controller.criaConexao();

                if (resultado == true) {
                    // Sincronizando as threads para agir na tela
                    //método que faz a sincronização das threads
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // se o resultado da chamada for true, a conexao foi efetuada
                            Toast.makeText(informacoesApp, "Conexão efetuada com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(informacoesApp, "Conexão não efetuada", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
//        teste
        //executando a thread
        thread.start();

        bMainEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criando a intent
                Intent it = new Intent(MainActivity.this, LoginActivity.class);
                //Iniciando ela
                startActivity(it);
                Toast.makeText(informacoesApp, "entrou intent", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
