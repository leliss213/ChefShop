///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controller;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import modelDominio.Usuario;
//
///**
// *
// * @author aila e alice
// */
//public class ConexaoController {
//    private ObjectOutputStream out; // tudo que a gente manda pro servidor
//    private ObjectInputStream in;// tudo que a gente recebe do servidor
//    
//    // Próximo atributo armazena o usuário que está conectado:
//    public Usuario usuario;
//
//    //CONSTRUTOR: só com o out e o in
//    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
//        this.out = out;
//        this.in = in;
//    }
//    
//    //Método que vai fazer o login no sistema:
//    public Usuario efetuarLogin(Usuario user){ //"Usuario user" vai tentar fazer login, vai ser devolvido se o login der certo;
//        // Implementar a comunicação com o servidor: o tal protocolo de comunicação
//        String msg;
//        try {
//            out.writeObject("EfetuarLogin"); //mandar algo pro servidor: out
//            msg = (String)in.readObject(); //o servidor responde ok; aqui vou ler o ok
//            out.writeObject(user); //enviando o usuario que tentou fazer o login
//            Usuario usrlogin = (Usuario) in.readObject(); //recebo o usuario que fez login
//            return usrlogin;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    } 
//    
//}
