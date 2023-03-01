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
public class Ingredientes implements Serializable{
    private static final long serialVersionUID = 123456789L;

    private int codIngrediente;
    private float quantidadeIngredientes;
    private Produto produto;
//    private int codReceita;
//    private int codProduto;

//    public Ingredientes(int codIngrediente, float quantidadeIngredientes, int codProduto) {
//        this.codIngrediente = codIngrediente;
//        this.quantidadeIngredientes = quantidadeIngredientes;
//        this.codProduto = codProduto;
//    }



    public Ingredientes(float quantidadeIngredientes, Produto produto) {
        this.quantidadeIngredientes = quantidadeIngredientes;
        this.produto = produto;
    }

//    public Ingredientes(float quantidadeIngredientes, Produto produto, int codReceita) {
//        this.quantidadeIngredientes = quantidadeIngredientes;
//        this.produto = produto;
//        this.codReceita = codReceita;
//    }

    public Ingredientes(int codIngrediente, float quantidadeIngredientes, Produto produto) {
        this.codIngrediente = codIngrediente;
        this.quantidadeIngredientes = quantidadeIngredientes;
        this.produto = produto;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public float getQuantidadeIngredientes() {
        return quantidadeIngredientes;
    }

    public void setQuantidadeIngredientes(float quantidadeIngredientes) {
        this.quantidadeIngredientes = quantidadeIngredientes;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }



    @Override
    public String toString() {
        return "Ingredientes{" + "codIngrediente=" + codIngrediente + ", quantidadeIngredientes=" + quantidadeIngredientes + ", produto=" + produto + '}';
    }

//    public int getCodReceita() {
//        return codReceita;
//    }
//
//    public void setCodReceita(int codReceita) {
//        this.codReceita = codReceita;
//    }
//
//    public int getCodProduto() {
//        return codProduto;
//    }
//
//    public void setCodProduto(int codProduto) {
//        this.codProduto = codProduto;
//    }



}
