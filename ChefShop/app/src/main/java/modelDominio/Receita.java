package modelDominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aila e alice
 */
public class Receita implements Serializable{
    private static final long serialVersionUID = 123456789L;

    private int codReceita;
    private int tipo; // Carnes -> 1, Massas -> 2, Saladas -> 3, Sobremesas -> 4, Sopas -> 5, Lanches -> 6
    private String nomeReceita;
    private ArrayList<Ingredientes> Ingredientes;
    private String modoPreparo;
    private byte[] imagemReceita;

    public Receita(int codReceita, int tipo, String nomeReceita, String modoPreparo, byte[] imagemReceita) {
        this.codReceita = codReceita;
        this.tipo = tipo;
        this.nomeReceita = nomeReceita;
        this.modoPreparo = modoPreparo;
        this.imagemReceita = imagemReceita;
    }

    public Receita(int codReceita) {
        this.codReceita = codReceita;
    }

    public Receita(int tipo, String nomeReceita, String modoPreparo, byte[] imagemReceita) {
        this.tipo = tipo;
        this.nomeReceita = nomeReceita;
        this.modoPreparo = modoPreparo;
        this.imagemReceita = imagemReceita;
    }

    public Receita(int codReceita, int tipo, String nomeReceita, String modoPreparo) {
        this.codReceita = codReceita;
        this.tipo = tipo;
        this.nomeReceita = nomeReceita;
        this.modoPreparo = modoPreparo;
    }

    public int getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(int codReceita) {
        this.codReceita = codReceita;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public byte[] getImagemReceita() {
        return imagemReceita;
    }

    public void setImagemReceita(byte[] imagemReceita) {
        this.imagemReceita = imagemReceita;
    }

    @Override
    public String toString() {
        return "Receita{" + "codReceita=" + codReceita + ", tipo=" + tipo + ", nomeReceita=" + nomeReceita + ", modoPreparo=" + modoPreparo + ", imagemReceita=" + imagemReceita + '}';
    }

//    Carnes -> 1, Massas -> 2, Saladas -> 3, Sobremesas -> 4, Sopas -> 5, Lanches -> 6
    public String getTipoLiteral(){
        String retorno = "";
        if (this.tipo == 1) {
            retorno = "Carnes";
        } else if (this.tipo == 2) {
            retorno = "Massas";
        } else if (this.tipo == 3) {
            retorno = "Saladas";
        } else if (this.tipo == 4) {
            retorno = "Sobremesas";
        } else if (this.tipo == 5) {
            retorno = "Sopas";
        } else if (this.tipo == 6) {
            retorno = "Lanches";
        }
        return retorno;
    }
}