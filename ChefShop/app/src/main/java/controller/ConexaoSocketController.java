package controller;

import com.example.chefshop.InformacoesApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Receita;
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
                userLogado = (Usuario) informacoesApp.in.readObject(); //salvo o usuario pra usar depois
                return userLogado; //tem q ter retorno de usuario
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
    public String inserir(Usuario user) {
        String msgRecebida;
        try {
            informacoesApp.out.writeObject("inserirUsuario");
            msgRecebida = (String) informacoesApp.in.readObject();

            if (msgRecebida.equals("ok")) {
                informacoesApp.out.writeObject(user);
                msgRecebida = (String) informacoesApp.in.readObject();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException classe) {
            classe.printStackTrace();
            return null;
        }
        return msgRecebida;
    }

    public ArrayList<Receita> listaReceitas(int tipo){
        ArrayList<Receita> listaReceitas =null;
        String msgRecebida = "";
        try {
            informacoesApp.out.writeObject("ListaReceitas");
            msgRecebida = (String)informacoesApp.in.readObject(); //lendo o ok
            if(msgRecebida.equals("ok")){
                informacoesApp.out.writeObject(tipo); //transmitindo a variavel q recebi como parametro
                msgRecebida = (String) informacoesApp.in.readObject();
                if(msgRecebida.equals("ok")){
                    listaReceitas = (ArrayList<Receita>) informacoesApp.in.readObject();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            listaReceitas = null;
        } catch (ClassNotFoundException classe) {
            classe.printStackTrace();
            listaReceitas = null;
        }
        return listaReceitas;
    }

}
