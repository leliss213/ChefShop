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
import android.widget.Toast;

import controller.ConexaoSocketController;
import modelDominio.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {
    EditText etNomeUsuario, etSenhaUsuario;
    Button bCadastrarUsuario;
    InformacoesApp informacoesApp;
    Usuario user,userInserido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etNomeUsuario = findViewById(R.id.etNomeUsuario);
        etSenhaUsuario = findViewById(R.id.etSenhaUsuario);
        bCadastrarUsuario = findViewById(R.id.bCadastrarUsuario);

        informacoesApp = (InformacoesApp) getApplicationContext();

        //Botão Cadastre-se:
        bCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validando os campos
                if (!etNomeUsuario.getText().toString().equals("")) {
                    if (!etSenhaUsuario.getText().toString().equals("")) {
                        //Obtendo as informações
                        String usuario = etNomeUsuario.getText().toString();
                        String senha = etSenhaUsuario.getText().toString();
                        user = new Usuario(usuario,senha);

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConexaoSocketController ccont = new ConexaoSocketController(informacoesApp);
                                //userInserido = ccont.inserir(user);
                                String msgRecebida = ccont.inserir(user);
                                if (msgRecebida.equals("ok")) {
                                    informacoesApp.setUsuarioInserido(userInserido);
                                    Intent it = new Intent(CadastroUsuarioActivity.this, LoginActivity.class);
                                    startActivity(it);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "IRU DEU CERTO", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                } else {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "Ocorreu um erro", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        });

                        thread.start();


                    } else {
                        etSenhaUsuario.setError("ERRO: Informe uma senha.");
                    }
                } else {
                    etNomeUsuario.setError("ERRO: Informe um usuário.");
                }
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
