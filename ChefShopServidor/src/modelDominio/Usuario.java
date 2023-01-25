package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aila e alice
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 123456789L;
    //ATRIBUTOS
    private int codUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String email;
    
    //CONSTRUTORES
    public Usuario(int codUsuario, String nomeUsuario, String login, String senha, String email) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    } //construtor com todos os atributos: usado pra edição e mostrar na tela 

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    } //construtor só com o codigo: utilizado para deletar

    public Usuario(String nomeUsuario, String login, String senha, String email) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    } //construtor sem o codigo: usado para inserção de usuário
    
    //GETTERS E SETTERS
    public int getCodUsuario() {
        return codUsuario;
    }
    
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", email=" + email + '}';
    }
}
