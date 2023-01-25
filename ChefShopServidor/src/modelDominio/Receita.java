/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aila
 */
public class Receita implements Serializable{
    private static final long serialVersionUID = 123456789L;
    
    private int codReceita;
    private int tipo; //categoria da receita
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

    
}
