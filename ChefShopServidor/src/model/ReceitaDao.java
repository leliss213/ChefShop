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
    public ArrayList<Receita>getLista(int tipo){
        Statement stmt = null; 
        ArrayList<Receita> listaReceita = new ArrayList<>();

        try {
            stmt = con.createStatement();
            String sql = "select * from receita where tipo = "+tipo;            

            //executando o script SQL
            ResultSet res = stmt.executeQuery(sql);
            // se existe um resultado
            while (res.next()) {
                Receita r = new Receita(res.getInt("codreceita"), res.getInt("tipo"), res.getString("nomereceita"), res.getString("modopreparo"), res.getBytes("imagem"));
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
    
    // Inserir receita
    public int inserir(Receita receita){
        PreparedStatement stmt = null; 
        
        try {
            try {
                String sql = "insert into receita (tipo, nomereceita, modopreparo, imagem) values (?,?,?,?);";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, receita.getTipo());
                stmt.setString(2, receita.getNomeReceita());
                stmt.setString(3, receita.getModoPreparo());
                stmt.setBytes(4, receita.getImagemReceita());
                stmt.execute();
                con.commit();
                
                PreparedStatement stmt2 = null;
                PreparedStatement stmt3 = con.prepareStatement("select last_insert_id() from receita;");
                ResultSet result = null;
                result = stmt3.executeQuery();
                result.next();
                
                int ultimoidReceita = Integer.valueOf(result.getString(1));
                for (Ingredientes ingredientes : receita.getIngredientes()) { //pra cada ingrediente percorre a lista
                    String sql2 = "insert into ingrediente (quantidade, codproduto, codreceita) values (?,?,?);";
                    stmt2 = con.prepareStatement(sql2);
                    stmt2.setFloat(1, ingredientes.getQuantidadeIngredientes());
                    stmt2.setInt(2, ingredientes.getProduto().getCodProduto());
                    stmt2.setInt(3, ultimoidReceita);
                    stmt2.execute();
                }
                con.commit();
                stmt.close();
                stmt2.close();
                stmt3.close();
                return -1; // <- indica que tudo deu CERTO
                
            } catch(SQLException e){
                try {
                    con.rollback(); // cancelando a transação 
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
            
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch(SQLException ex){
                ex.printStackTrace();
                
            }                
        }
    }
    
    // Excluir receita
    public int excluir(Receita receita) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "delete from receita where codreceita = ? ";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setInt(1, receita.getCodReceita());
                
                //executar o SCRIPT SQL
                stmt.execute();
                //efetivar a transação
                con.commit();
                return -1; // <- indica que tudo deu CERTO
            } catch (SQLException e) {
                try {
                    con.rollback(); // cancelando a transação 
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally {// isto será executado dando ERRO ou NÃO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    // Alterar receita
        
    
    
}
    
