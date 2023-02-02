package com.example.chefshop;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Receita;
import modelDominio.Usuario;

public class InformacoesApp extends Application {
    public Socket socket;
    public ObjectOutputStream out;
    public ObjectInputStream in;
    private ArrayList<Receita> listaReceitas;

    private Usuario usuarioLogado;
    private Usuario usuarioInserido;

    //onCreate
    @Override
    public void onCreate() {
        super.onCreate();
    }

    //getters
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public Usuario getUsuarioInserido() {
        return usuarioInserido;
    }


    //setters
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    public void setUsuarioInserido(Usuario usuarioInserido) {
        this.usuarioInserido = usuarioInserido;
    }
}
