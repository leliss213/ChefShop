package factory;
import java.sql.*; //importando o connection

/**
 *
 * @author aila e alice
 */
public class Conector {
    // Declarar uma variavel que vai armazenar a conexão:
    private static Connection con; // Importar o Connection manualmente
    
    // Método que faz a conexão:
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/"; // Caminho do banco, onde ele está; (3306 porta)
            String banco = "chefshop";
            String usuario = "root"; // Usuario de conexao com o banco;
            String senha = ""; // Senha de conexao com o mysql;
            con = DriverManager.getConnection(url+banco,usuario,senha);
            System.out.println("Conectado com sucesso no banco: "+banco);
            return con;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime os erros;
            return null; // Caso de erro ele nao faz a conexao;
        }
    }
}
