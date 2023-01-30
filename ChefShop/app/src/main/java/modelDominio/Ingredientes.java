package modelDominio;

import java.io.Serializable;

/**
 *
 * @author Aila e alice
 */
public class Ingredientes implements Serializable{
    private static final long serialVersionUID = 123456789L;

    private int codIngrediente;
    private int quantidadeIngredientes;
    private Produto produto;

    public Ingredientes(int codIngrediente, int quantidadeIngredientes, Produto produto) {
        this.codIngrediente = codIngrediente;
        this.quantidadeIngredientes = quantidadeIngredientes;
        this.produto = produto;
    }



}