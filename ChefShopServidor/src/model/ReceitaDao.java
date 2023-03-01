/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import factory.Conector;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelDominio.Ingredientes;
import modelDominio.Receita;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelDominio.Produto;
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
    public ArrayList<Receita> getLista(int tipo) throws SQLException {
        ArrayList<Receita> listaReceita = new ArrayList<Receita>();

        String sql = "SELECT * FROM receita WHERE tipo = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, tipo);
        try  {
            ResultSet res = pstmt.executeQuery();
            if(res != null){
                while (res.next()) { //pra cada linha de resultado que tiver, ele add um obj Receita
                Receita r = new Receita(res.getInt("codreceita"), 
                                        res.getInt("tipo"), 
                                        res.getString("nomereceita"), 
                                        res.getString("modopreparo"), 
                                        res.getBytes("imagem"));

                ArrayList<Ingredientes> listaIngredientes = new ArrayList<>(); //cria
                IngredienteDao dao = new IngredienteDao();
                listaIngredientes = dao.getListaIngredientes(r.getCodReceita()); //preenchida com os ingred da receita
                r.setIngredientes(listaIngredientes); //a lista de ingred é definida pra receita r
                listaReceita.add(r); //e a receita é adicionada na lista de receita
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaReceita;
    }
    
    // Inserir receita
    public int inserir(Receita receita){
        PreparedStatement stmt = null; 
        System.out.println("inserir dentro do dao");
        System.out.println(receita);
        System.out.println("Receita: " + receita.getNomeReceita() + ", ingredientes: " + receita.getIngredientes().size());
        try {
            try {
                con.setAutoCommit(false); //desativar o commit automático pra controlar a transação na mão
                String sql = "insert into receita (tipo, nomereceita, modopreparo, imagem) values (?,?,?,?);";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, receita.getTipo());
                stmt.setString(2, receita.getNomeReceita());
                stmt.setString(3, receita.getModoPreparo());
                stmt.setBytes(4, receita.getImagemReceita());
                stmt.execute();
                con.commit();
                System.out.println(receita);
                PreparedStatement stmt2 = null;  // usado pra inserir cada ingrediente da receita no banco
                PreparedStatement stmt3 = con.prepareStatement("select last_insert_id() from receita;"); //obtem o ID da última receita inserida
                ResultSet result = null;
                result = stmt3.executeQuery();
                result.next();
                
                int ultimoidReceita = Integer.valueOf(result.getString(1));
                for (Ingredientes ingredientes : receita.getIngredientes()) { 
                    //percorre a lista de ingredientes e insere eles no banco:
                    String sql2 = "insert into ingrediente (quantidade, codproduto, codreceita) values (?,?,?);";
                    stmt2 = con.prepareStatement(sql2);
                    stmt2.setFloat(1, ingredientes.getQuantidadeIngredientes());
                    stmt2.setInt(2, ingredientes.getProduto().getCodProduto());
                    stmt2.setInt(3, ultimoidReceita);
                    stmt2.execute();
                    con.commit(); //ativa o modo de commit automático
                }
                
                stmt.close();
                stmt2.close();
                return -1; // <- se deu CERTO retorna -1
                
            } catch(SQLException e){
                System.out.println("Erro ao cadastrar a receita!");
                e.printStackTrace();
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
                con.setAutoCommit(false);
                
                // PPRIMEIRO DELETE -> INGREDIENTES
                
                System.out.println(receita);
                String sql = "delete from ingrediente where ingrediente.codreceita = ?;" ;
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, receita.getCodReceita());
                
                // SEGUNDO DELETE -> RECEITA
                
                stmt.execute();
                sql = "delete from receita where codReceita = ?;";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, receita.getCodReceita());
                
                // EXECUTANDO OS COMANDOS
                
                stmt.execute();
                con.commit();
                return -1;
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
    
    
}
    
