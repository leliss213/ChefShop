package controller;

import com.example.chefshop.InformacoesApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class ConexaoSocketController {

    InformacoesApp informacoesApp;

    // Método construtor:
    public ConexaoSocketController(InformacoesApp informacoesApp) {
        this.informacoesApp = informacoesApp;
    }

    // Método para criar conexão:
    public boolean criaConexao () {
        boolean resultado;
        try {
            informacoesApp.socket = new Socket("10.0.2.2", 12345); // Criando o socket
            informacoesApp.out = new ObjectOutputStream(informacoesApp.socket.getOutputStream()); //criando um novo canal de saida (out) a partir do socket criado na linha de cima
            informacoesApp.in = new ObjectInputStream(informacoesApp.socket.getInputStream());
            resultado = true;

        } catch (IOException ioe) {
            ioe.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    // Método pra efetuar login:
    public Usuario login(Usuario user) {
        Usuario userLogado = null;
        String msgRecebida;
        try {
            informacoesApp.out.writeObject("EfetuarLogin");
            msgRecebida = (String) informacoesApp.in.readObject();

            if (msgRecebida.equals("ok")) {
                informacoesApp.out.writeObject(user);
                userLogado = (Usuario) informacoesApp.in.readObject();
                return userLogado;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException classe) {
            classe.printStackTrace();
            return null;
        }
        return userLogado;
    }

    // Método pra inserir um usuario:
    public Usuario inserir(Usuario user) {
        Usuario userInserido = null;
        String msgRecebida;
        try {
            informacoesApp.out.writeObject("InserirUsuario");
            msgRecebida = (String) informacoesApp.in.readObject();

            if (msgRecebida.equals("ok")) {
                informacoesApp.out.writeObject(user);
                userInserido = (Usuario) informacoesApp.in.readObject();
                return userInserido;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException classe) {
            classe.printStackTrace();
            return null;
        }
        return userInserido;
    }

}
