/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private int tipo;

    //CONSTRUTORES
    public Usuario(int codUsuario, String nomeUsuario, String login, String senha, String email, int tipo) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
    } //construtor com todos os atributos: usado pra edição e mostrar na tela

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    } //construtor só com o codigo: utilizado para deletar

    public Usuario(String nomeUsuario, String login, String senha, String email, int tipo) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }



//    //TOSTRING
//    @Override
//    public String toString() {
//        return "Usuario{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", email=" + email + '}';
//    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", email=" + email + ", tipo=" + tipo + '}';
    }

}