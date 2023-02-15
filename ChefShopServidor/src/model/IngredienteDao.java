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
    
    public ArrayList<Ingredientes>getListaIngredientes(){
        PreparedStatement stmt = null; 
        ArrayList<Ingredientes> listaIngredientes = new ArrayList<>();
       
        try {
            String sql = "select * from ingredientes";
            // criando o statement
            stmt = con.prepareStatement(sql);
            
            //executando o script SQL
            ResultSet res = stmt.executeQuery();
            // se existe um resultado     
            while (res.next()) {
                //Ingredientes ing = new Ingredientes(res.getInt("codingrediente"), res.getInt("quantidadeingredientes"), );
                //System.out.println(ing);
                //listaIngredientes.add(ing);
                
            }
            /// fechar as conexões e statement 
            res.close();
            stmt.close();
            con.close();
            return listaIngredientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
