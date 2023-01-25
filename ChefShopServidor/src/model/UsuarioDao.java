package model;

import factory.Conector;
import java.sql.*;
import modelDominio.Administrador;
import modelDominio.Comum;
import modelDominio.Usuario;

/**
 *
 * @author alice
 */
public class UsuarioDao {
    /** Dao: Data Access Object: pega os dados do banco e tranfosrma em objetos de classe:
     fazer os selects inserts deletes e updates */
    
    private Connection con;
    
    //CONSTRUTOR:
    public UsuarioDao() {
        con = Conector.getConnection();
    }
    
    public Usuario efetuarLogin(Usuario user){
        PreparedStatement stmt = null; //em um statement eu rodo um script;
        Usuario userSelecionado = null;
        
        try {
            String sql = "select * from usuario\n" +
                        "where login = ? and senha = ?";
            //criar o statement e trocar os parametros:
            stmt = con.prepareStatement(sql); // Vai preparar o script de cima pra q eu possa trocar os dois ?;
            stmt.setString(1, user.getLogin()); // Trocando o primeiro ? pelo login
            stmt.setString(2, user.getSenha()); // Trocando o segundo ? pela senha
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            if (res.next()){ // o next garantiu que estou no primeiro registro do banco
                
                // Testar o campo tipo pra verificar se o usuario é do tipo Administrador ou Comum
                if (res.getInt("tipo") == 1){ //"tipo" -> nome igual o do banco;
                    //é um administrador
                    userSelecionado = new Administrador(res.getInt("codusuario"),
                                                        res.getString("nomeusuario"),
                                                        res.getString("login"),
                                                        res.getString("senha"),
                                                        res.getString("email"));
                } else {
                    //é um usuário comum
                    userSelecionado = new Comum(res.getInt("codusuario"),
                                                res.getString("nomeusuario"),
                                                res.getString("login"),
                                                res.getString("senha"),
                                                res.getString("email"));
                }
            }
            // Fechar as conexões e statements:
            res.close();
            stmt.close();
            con.close();
            return userSelecionado;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
}