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

public class LoginActivity extends AppCompatActivity {
    EditText etLoginUsuario, etLoginSenha;
    Button bLoginEntrar,bLoginEsqueciSenha,bLoginRegistrar;
    InformacoesApp informacoesApp;
    Usuario user,userLogado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etLoginUsuario = findViewById(R.id.etLoginUsuario);
        etLoginSenha = findViewById(R.id.etLoginSenha);
        bLoginEntrar = findViewById(R.id.bLoginEntrar);
        bLoginEsqueciSenha = findViewById(R.id.bLoginEsqueciSenha);
        bLoginRegistrar = findViewById(R.id.bLoginRegistrar);

        informacoesApp = (InformacoesApp) getApplicationContext();
        //BOTÕES:
        //Botão Entrar:
        bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validando os campos
                if (!etLoginUsuario.getText().toString().equals("")) {
                    if (!etLoginSenha.getText().toString().equals("")) {
                        //Obtendo as informações
                        String usuario = etLoginUsuario.getText().toString();
                        String senha = etLoginSenha.getText().toString();

                        user = new Usuario(usuario,senha);

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConexaoSocketController ccont = new ConexaoSocketController(informacoesApp);
                                userLogado = ccont.login(user);
                                System.out.println(userLogado);

                                if (userLogado != null) {
                                    informacoesApp.setUsuarioLogado(userLogado);
                                    Intent it = new Intent(LoginActivity.this, CategoriasReceitasActivity.class);
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
                                            Toast.makeText(informacoesApp, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        });
                        thread.start();
                    } else {
                        etLoginSenha.setError("ERRO: Informe a senha.");
                    }
                } else {
                    etLoginUsuario.setError("ERRO: Informe o usuário.");
                }
            }
        });

        //Botão Esqueci a Senha:
        bLoginEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tem que abrir a tela de recuperação de senha
            }
        });

        //Botão Registre-se:
        bLoginRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tem que abrir a tela de cadastro
                Intent it = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
                startActivity(it);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
