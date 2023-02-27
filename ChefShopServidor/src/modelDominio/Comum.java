package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aila e alice
 */
public class Comum extends Usuario implements Serializable{
    private static final long serialVersionUID = 123456789L;
    
    //CONSTRUTORES
    public Comum(int codUsuario, String nomeUsuario, String login, String senha, String email, int tipo) {
        super(codUsuario, nomeUsuario, login, senha, email, tipo);
    }

    public Comum(int codUsuario) {
        super(codUsuario);
    }

    public Comum(String nomeUsuario, String login, String senha, String email, int tipo) {
        super(nomeUsuario, login, senha, email, tipo);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return super.toString()+"Comum{" + '}';
    }
    
}
