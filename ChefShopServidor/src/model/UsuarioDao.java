package model;

import factory.Conector;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import modelDominio.Administrador;
import modelDominio.Comum;
import modelDominio.Usuario;

/**
 *
 * @author Aila e Alice
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
        String senhaHash = null;
        try {
		MessageDigest md = MessageDigest.getInstance("MD5"); //md instancia md5
                // md5 - código de hash
                
                //método digest pra pegar a senha em vetor:
		BigInteger senhaHashDigitada = new BigInteger(1, md.digest(user.getSenha().getBytes())); //vetor de bytes p int
                senhaHash = senhaHashDigitada.toString();
                System.out.println("Senha em hash: " + senhaHash);
                        
            } catch (NoSuchAlgorithmException e) {
		System.out.println("Erro ao carregar o MessageDigest");
            }
        
        try {
            String sql = "select * from usuario where login = ? and senha = ?";
            //criar o statement e trocar os parametros:
            stmt = con.prepareStatement(sql); // Vai preparar o script de cima pra q eu possa trocar os dois ?;
            stmt.setString(1, user.getLogin()); // Trocando o primeiro ? pelo login
            stmt.setString(2, senhaHash); // Trocando o segundo ? pela senha
            
            
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
                                                        res.getString("email"),
                                                        res.getInt("tipo"));
                } else {
                    //é um usuário comum
                    userSelecionado = new Comum(res.getInt("codusuario"),
                                                res.getString("nomeusuario"),
                                                res.getString("login"),
                                                res.getString("senha"),
                                                res.getString("email"),
                                                res.getInt("tipo"));
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
    
    public int inserirUsuario(Usuario user){
        PreparedStatement stmt = null;

        try{
            try{
               con.setAutoCommit(false);
               String sql = "insert into Usuario(login,senha,tipo) values(?,?,2);";
               stmt = con.prepareStatement(sql);
               String senhaHash = null;
               try {
                    MessageDigest md = MessageDigest.getInstance("MD5"); // MD5, SHA-1, SHA-256

                    BigInteger senhaHashCadastrada = new BigInteger(1, md.digest(user.getSenha().getBytes()));
                    senhaHash = senhaHashCadastrada.toString();
                    System.out.println(senhaHashCadastrada);

                } catch (NoSuchAlgorithmException e) {
                    System.out.println("Erro ao carregar o MessageDigest");
                }
               stmt.setString(1, user.getLogin());
               stmt.setString(2, senhaHash);
               /*
               int tipo;
                if (user instanceof Administrador){
                    tipo = 1;
                }else{
                    tipo = 0;
                }
                //stmt.setInt(5, ((usr instanceof Administrador) ? 1 : 0));

                stmt.setInt(5, tipo);*/
               stmt.execute();
               con.commit();
               return -1;
            }catch(SQLException e){
                e.printStackTrace();
                try {
                    con.rollback(); // cancelando a transação 
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
            }
        finally{
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
