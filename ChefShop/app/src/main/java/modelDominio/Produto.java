/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author Aila e alice
 */
public class Produto implements Serializable{
    private static final long serialVersionUID = 123456789L;

    private String nomeProduto;
    private int unidade; // Colher de Sopa -> 0, Colher de Chá -> 1, Xícara -> 2, Gramas -> 3, Quilos -> 4, Unidade -> 5, Pitada -> 6
    private int codProduto;

    public Produto(String nomeProduto, int unidade) {
        this.nomeProduto = nomeProduto;
        this.unidade = unidade;
    }

    public Produto(int codProduto, String nomeProduto, int unidade) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.unidade = unidade;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", nomeProduto=" + nomeProduto + ", unidade=" + unidade + '}';
    }

    public String getUnidadeLiteral() {
        String retorno = "";
        if (this.unidade == 0) {
            retorno = "Colher de Sopa";
        } else if (this.unidade == 1) {
            retorno = "Colher de Chá";
        } else if (this.unidade == 2) {
            retorno = "Xícara";
        } else if (this.unidade == 3){
            retorno = "Gramas";
        } else if (this.unidade == 4) {
            retorno = "Quilos";
        } else if (this.unidade == 5) {
            retorno = "Unidade";
        } else if (this.unidade == 6){
            retorno = "Pitada";
        }

        return retorno;
    }

}
