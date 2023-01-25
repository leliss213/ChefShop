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
public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID = 123456789L;

    public Administrador(int codUsuario, String nomeUsuario, String login, String senha, String email) {
        super(codUsuario, nomeUsuario, login, senha, email);
    }

    public Administrador(int codUsuario) {
        super(codUsuario);
    }

    public Administrador(String nomeUsuario, String login, String senha, String email) {
        super(nomeUsuario, login, senha, email);
    }

    @Override
    public String toString() {
        return "Administrador{" + '}';
    }
    
}
