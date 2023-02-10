/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import modelDominio.Produto;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Aila
 */
public class ProdutoDao {

    private Connection con;

    public ProdutoDao() {
        con = Conector.getConnection();
    }

    public ArrayList<Produto> getListaProdutos(String nome) {
        Statement stmt = null; // usado para rodar SQL
        ArrayList<Produto> listaprodutos = new ArrayList<Produto>();

        try {
            // cria o objeto para rodar o SQL
            stmt = con.createStatement();
            // passando a string SQL que faz o SELECT
            ResultSet res = stmt.executeQuery("select * from produto");

            // Percorrendo o resultado - res
            while (res.next()) {
                // criando o objeto e pegando dados do res.
                Produto prod = new Produto(res.getInt("codproduto"),
                                            res.getString("nomeproduto"),
                                            res.getInt("unidade"));
                // adicionando na lista auxiliar
                listaprodutos.add(prod);
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return listaprodutos; // retornando a lista
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }
}
