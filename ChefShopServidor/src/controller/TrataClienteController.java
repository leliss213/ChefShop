package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.ReceitaDao;
import model.UsuarioDao;
import modelDominio.Usuario;

/**
 *
 * @author aila e alice
 */
public class TrataClienteController extends Thread{
    private ObjectInputStream in; //Através do in eu vou receber todas as requisições vindas dos clientes
    private ObjectOutputStream out; //Através do out eu vou escrever a resposta por meu cliente
    private Socket s; //id do cliente conectado
    private int idUnico; 
    
    //CONSTRUTOR 
    public TrataClienteController(ObjectInputStream in, ObjectOutputStream out, Socket s, int idUnico) {
        this.in = in;
        this.out = out;
        this.s = s;
        this.idUnico = idUnico;
    }
    
    //insert code -> override method -> RUN
    @Override
    public void run() {
        String comando;
        System.out.println("Esperando comandos do cliente: "+idUnico);
        
        try {
            comando = (String) in.readObject(); //fazendo a leitura dos dados que tão entrando e armazenando em uma string
            while(!comando.equalsIgnoreCase("fim")){ //eu fico dentro desse loop enquanto tiver recebendo comandos que não sejam fim.
                //tratando os comandos que vem do cliente
                System.out.println("Cliente "+idUnico+" enviou comando "+comando);
                // Aqui teremos que tratar todos os comandos vindos do cliente;
                // TESTES:
                if (comando.equalsIgnoreCase("EfetuarLogin")){ //dentro das "" é o mesmo comando do ConexaoController no cliente
                    out.writeObject("ok");
                    Usuario user = (Usuario)in.readObject(); //recebi o usuario do cliente
                    // Consultar no banco de dados para ver se o user existe:
                    UsuarioDao usdao = new UsuarioDao();
                    Usuario userlogado = usdao.efetuarLogin(user);
                    out.writeObject(userlogado);
                } else if (comando.equalsIgnoreCase("ListaReceitas")){
                    out.writeObject("ok");
                    int tipo = (int) in.readObject();
                    ReceitaDao dao = new ReceitaDao();
                    out.writeObject(dao.getLista(tipo));
                } else if (comando.equalsIgnoreCase("inserirUsuario")) {
                    out.writeObject("ok"); 
                    Usuario user = (Usuario) in.readObject();
                    // criando um Dao para armazenar no Banco
                    UsuarioDao userdao = new UsuarioDao();
                    userdao.inserirUsuario(user);
                    out.writeObject("ok"); 
                }


//cadastro
                
                //relendo
                comando = (String) in.readObject(); //relendo o próximo comando
            }
        } catch (Exception e) {
            e.printStackTrace(); //se der algum erro vai imprimir
        }
        //veio o comando fim
        try {
            System.out.println("Cliente "+idUnico+" desconectou");
            this.in.close(); //fechar o canal de entrada
            this.out.close(); //fechar o canal de saida
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
