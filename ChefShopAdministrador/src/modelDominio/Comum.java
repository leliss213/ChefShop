/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author Aila
 */
public class Comum extends Usuario implements Serializable{
    private static final long serialVersionUID = 123456789L;

    public Comum(int codUsuario, String nomeUsuario, String login, String senha, String email) {
        super(codUsuario, nomeUsuario, login, senha, email);
    }
    public Comum(String login, String senha) {
        super(login, senha);
    }

    public Comum(int codUsuario) {
        super(codUsuario);
    }

    public Comum(String nomeUsuario, String login, String senha, String email) {
        super(nomeUsuario, login, senha, email);
    }

    @Override
    public String toString() {
        return "Comum{" + '}';
    }  
    
}
