/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.*;
<<<<<<< Updated upstream
import java.util.ArrayList;
import modelDominio.Ingredientes;
import modelDominio.Receita;
=======
>>>>>>> Stashed changes

/**
 *
 * @author Aila e Alice
 */
public class ReceitaDao {
    private Connection con;
    
<<<<<<< Updated upstream
    public ReceitaDao() { // deve ser vazio e fazer a conexão dentro
=======
    public ReceitaDao() {
>>>>>>> Stashed changes
        con = Conector.getConnection();
    }
    
         // método que retorna todas as receitas cadastradas 
        public ArrayList<Receita>getLista(){
        PreparedStatement stmt = null; 
        ArrayList<Receita> listaReceita = new ArrayList<>();
       
        try {
            String sql = "select * from receita";
            // criando o statement
            stmt = con.prepareStatement(sql);
            
            //executando o script SQL
            ResultSet res = stmt.executeQuery();
            // se existe um resultado
            while (res.next()) {
                Receita r = new Receita(res.getInt("codreceita"), res.getInt("tipo"), res.getString("nomereceita"), (ArrayList<Ingredientes>) res.getArray("ingredientes"), res.getString("modopreparo"), res.getBytes("imagemreceita"));
                System.out.println(r);
                listaReceita.add(r);
                
            }
            /// fechar as conexões e statement 
            res.close();
            stmt.close();
            con.close();
            return listaReceita;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
