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
    private int quantidadeIngredientes;
    private Produto produto;

    public Ingredientes(int codIngrediente, int quantidadeIngredientes, Produto produto) {
//se voces quisererm ter a lista de produtos dentro da receita nao pode ser Produto produto, 
//teria que ser um arraylist, ficaria assim ArrayList<Produto> listaProdutos;
        this.codIngrediente = codIngrediente;
        this.quantidadeIngredientes = quantidadeIngredientes;
        this.produto = produto;
    }
    
    
    
}
