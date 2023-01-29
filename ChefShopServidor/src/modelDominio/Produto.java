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
public class Produto implements Serializable{
    private static final long serialVersionUID = 123456789L;
    
    private int codProduto;
    private String nomeProduto;
    private int quantidadeUnidade;//NAO TINHA ESSE ATRIBUTO EM PRODUTO, FOI ADICIONADO NO BANCO DE DADOS TBM COMO INT
    private int unidade; // Colher de Sopa -> 0, Colher de Chá -> 1, Xícara -> 2, Gramas -> 3, Quilos -> 4, Unidade -> 5, Pitada -> 6

    public Produto(String nomeProduto, int quantidadeUnidade, int unidade) {
        this.nomeProduto = nomeProduto;
        this.quantidadeUnidade = quantidadeUnidade;
        this.unidade = unidade;
    }

    public Produto(int codProduto, String nomeProduto, int quantidadeUnidade, int unidade) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeUnidade = quantidadeUnidade;
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
    
        
}
