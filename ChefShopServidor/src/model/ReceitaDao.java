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
        
//    public int inserir(Receita receita) {
//        //vai receber o script SQL de INSERT 
//        PreparedStatement stmt = null;
//        try {
//            try {
//                // desliga o autocommit
//                con.setAutoCommit(false);
//                String sql = "insert into bike (modelo,codmarca,preco,imagem,datalancamento) values (?,?,?,?,?)";
//                stmt = con.prepareStatement(sql);
//                //substituir os ? do script SQL
//                stmt.setString(1, bk.getModelo());
//                stmt.setInt(2, bk.getMarca().getCodmarca());
//                stmt.setDouble(3, bk.getPreco());
//                stmt.setBytes(4, bk.getImagem());
//                stmt.setDate(5, new java.sql.Date(bk.getDataLancamento().getTime()));
//                //executar o SCRIPT SQL
//                stmt.execute();
//                //efetivar a transação
//                con.commit();
//                return -1; // <- indica que tudo deu CERTO
//            } catch (SQLException e) {
//                try {
//                    con.rollback(); // cancelando a transação 
//                    e.printStackTrace();
//                    return e.getErrorCode(); // devolvendo o erro
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                    return ex.getErrorCode();
//                }
//            }
//        } finally {// isto será executado dando ERRO ou NÃO
//            try {
//                stmt.close();
//                con.setAutoCommit(true);
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return e.getErrorCode();
//            }
//        }
}
    
