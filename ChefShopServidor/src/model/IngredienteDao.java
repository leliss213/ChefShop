/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Ingredientes;
import modelDominio.Produto;

/**
 *
 * @author Aila
 */
public class IngredienteDao {
    private Connection con;
    
    public IngredienteDao() {
        con = Conector.getConnection();
    }
    
    public ArrayList<Ingredientes>getListaIngredientes(int codReceita){
        PreparedStatement pstmt = null; 
        ArrayList<Ingredientes> listaIngredientes = new ArrayList<>();
       
        try {
            String sql = "select * from ingrediente inner join produto "
                    + "on ingrediente.codproduto = produto.codproduto where ingrediente.codreceita = ?";
            
            // criando o statement
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, codReceita);
            //executando o script SQL
            ResultSet res = pstmt.executeQuery();
            // se existe um resultado     
            while (res.next()) {
                Produto produto = new Produto(res.getInt("codproduto"),res.getString("nomeproduto"),res.getInt("unidade"));
                Ingredientes ingredientes = new Ingredientes(res.getInt("codingrediente"),res.getFloat("quantidade"),produto);
                listaIngredientes.add(ingredientes);
            }
            /// fechar as conexões e statement 
            res.close();
            pstmt.close();
            con.close();
            return listaIngredientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
