/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Ingredientes;
import modelDominio.Receita;
/**
 *
 * @author Aila e Alice
 */
public class ReceitaTableModel extends AbstractTableModel{

    private ArrayList<Receita> listaReceitas;

    public ReceitaTableModel(ArrayList<Receita> listaReceitas) {
        this.listaReceitas = listaReceitas;
    }
    
    @Override
    public int getRowCount() {
        return listaReceitas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Receita rc = listaReceitas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:  return rc.getNomeReceita();
            case 1:  return rc.getModoPreparo();
            case 2:  return rc.getNomesIngredientes(rc.getIngredientes());
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:  return "Nome da Receita";
            case 1:  return "Modo de Preparo";
            case 2:  return "Ingredientes";
            default: return "NoName";
        }
    }
    
    public Receita getReceita(int row){
        return listaReceitas.get(row);
    }
    
}
