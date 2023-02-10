/*2
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author alice
 */
public class ChefShopAdministrador {
    public static ConexaoController ccont;
    
    public static void main(String[] args) {
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream out;
        
        try {
            //Conexão com o servidor:
            socket = new Socket("127.0.0.1", 12345); //ip do servidor e a porta
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Cliente conectado no servidor!");
            
            ccont = new ConexaoController(out,in); //esse ccont é o conexaocontroller, é pra não precisar criar sempre um conexao controller;
  
            FormPrincipal frmprincipal = new FormPrincipal();
            frmprincipal.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace(); //imprime o erro q aconteceu
        }
    }
}
