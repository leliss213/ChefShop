/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Ingredientes;
import modelDominio.Receita;
/**
 *
 * @author Aila e Alice
 */
public class ReceitaDao {
    private Connection con;

    public ReceitaDao() { // deve ser vazio e fazer a conexão dentro
        con = Conector.getConnection();
    }
         // método que retorna todas as receitas cadastradas 
        public ArrayList<Receita>getLista(){
        Statement stmt = null; 
        ArrayList<Receita> listaReceita = new ArrayList<>();
       
        try {
            stmt = con.createStatement();
            String sql = "select * from receita";            
            
            //executando o script SQL
            ResultSet res = stmt.executeQuery(sql);
            // se existe um resultado
            while (res.next()) {
                Receita r = new Receita(res.getInt("codreceita"), res.getInt("tipo"), res.getString("nomereceita"), res.getString("modopreparo"), res.getBytes("imagemreceita"));
                //Receita r = new Receita(res.getInt("codreceita"), res.getInt("tipo"), res.getString("nomereceita"), res.getString("modopreparo"));
                //ERRO TA AQUI
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
