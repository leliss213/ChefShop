package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author aila e alice
 */
public class Principal {
    // Criando o método main que vai executar o servidor:
    public static void main(String[] args) {
        Connection con; //declarar conexao que vai armazenar a conexao com banco; PS: Lembrar de importar a mão;
        con = Conector.getConnection();
        
        try {
            // criar o servidor socket
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado. Aguardando conexões.");
            // Chamando e executando a classe ConectaServidor 
            ConectaServidor s1 = new ConectaServidor(servidor,con);
            
        } catch (IOException ex) {
            ex.printStackTrace(); // se já tem um servidor rodando na porta 12345 vai dar erro;
        }
    }
    
}

//Classe para fazer o tratamento das conexões com os clientes
class ConectaServidor extends Thread{ 
    private ServerSocket servidor; //atributo do serversocket
    private int idUnico = 0; //vai ser incrementado a cada cliente que conectar
    private Connection con;
    
    //CONSTRUTOR
    public ConectaServidor(ServerSocket servidor, Connection con) {
        this.servidor = servidor;
        this.con = con;
        this.start(); //inicializa a thread
    }
        
    //MÉTODO RUN - metodo que executa a thread
    @Override
    public void run() {
        try {
            while(true){
                Socket cliente = this.servidor.accept(); //criando um socket; esperando conexões vindas do cliente
                System.out.println("Um novo cliente conectou: "+cliente);
                
                // criando o stream de entrada e saida:
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                idUnico++; //a cada cliente que conecta a gente incrementa;
                System.out.println("Inicializando uma thread para o cliente: "+idUnico);
                TrataClienteController trataCliente = new TrataClienteController(in, out, cliente, idUnico);
                trataCliente.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
