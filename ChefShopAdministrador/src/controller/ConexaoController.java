/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Produto;
import modelDominio.Receita;
import modelDominio.Usuario;

/**
 *
 * @author aila e alice
 */
public class ConexaoController {
    private ObjectOutputStream out; // tudo que a gente manda pro servidor
    private ObjectInputStream in;// tudo que a gente recebe do servidor
    
    // Próximo atributo armazena o usuário que está conectado:
    public Usuario usuario;

    //CONSTRUTOR: só com o out e o in
    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }
    
    //Método que vai fazer o login no sistema:
    public Usuario efetuarLogin(Usuario user){ //"Usuario user" vai tentar fazer login, vai ser devolvido se o login der certo;
        // Implementar a comunicação com o servidor: o tal protocolo de comunicação
        String msg;
        try {
            out.writeObject("EfetuarLogin"); //mandar algo pro servidor: out
            msg = (String)in.readObject(); //o servidor responde ok; aqui vou ler o ok
            out.writeObject(user); //enviando o usuario que tentou fazer o login
            Usuario usrlogin = (Usuario) in.readObject(); //recebo o usuario que fez login
            return usrlogin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean usuarioIserir(Usuario user){
        String msg = "";
        try{
            out.writeObject("UsuarioInserir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(user); // escrevendo o user
            msg = (String) in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Produto> produtoLista(){
        String msg;
        try{
            out.writeObject("ProdutoLista");
            msg = (String) in.readObject(); // lendo ok
            ArrayList<Produto> listaproduto = (ArrayList<Produto>) in.readObject();
            return listaproduto;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public Boolean inserir(Receita rc){
        String msg = "";
        try{
            out.writeObject("ReceitaInserir");
            msg = (String) in.readObject();
            out.writeObject(rc);
            msg = (String) in.readObject();
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Receita> receitaLista(int tipo){
        String msg;
        ArrayList<Receita> listaReceitas = null;
        try{
            out.writeObject("ListaReceitas");
            msg = (String)in.readObject();
            if(msg.equals("ok")){
                out.writeObject(tipo);
                msg = (String)in.readObject();
                if(msg.equals("ok")){
                    listaReceitas = (ArrayList<Receita>) in.readObject(); 
                }
            }      
            return listaReceitas;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean receitaExcluir(Receita rc){
        String msg = "";
        try{
            out.writeObject("ReceitaExcluir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(rc);
            msg = (String) in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
}
