package com.example.chefshop;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class InformacoesApp extends Application {
    public Socket socket;
    public ObjectOutputStream out;
    public ObjectInputStream in;

    private Usuario usuarioLogado;
    private Usuario usuarioInserido;

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

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
