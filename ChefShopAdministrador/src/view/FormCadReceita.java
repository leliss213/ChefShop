/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelDominio.Ingredientes;
import modelDominio.Produto;
import modelDominio.Receita;
import view.util.Imagem;
import view.util.ComboBoxProduto;

/**
 *
 * @author Aila
 */
public class FormCadReceita extends javax.swing.JFrame {
    
    private Imagem imagem = null;
    private ArrayList<Ingredientes>listaIngredientes;
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    
    private void preencheComboBoxProduto() {
        
        listaProdutos = ChefShopAdministrador.ccont.produtoLista();
        ComboBoxProduto.preencheComboBoxProduto(-1, jCBProduto, listaProdutos, false);
    }
    
    private void limpaCampos() {
    
        jTFNomeReceita.setText("");
        jCBCategoriaReceita.setSelectedIndex(0);
        jCBProduto.setSelectedIndex(0);
        jCBUnidadeMedida.setSelectedIndex(7);
        jFTFQuantidade.setText("");
        listaIngredientes.isEmpty();
        jTAIngredientes.setText("");
        jTAModoPreparo.setText("");
    }
    
    private void limpaProd() {
    
        jCBProduto.setSelectedIndex(0);
        jCBUnidadeMedida.setSelectedIndex(7);
        jFTFQuantidade.setText("");
    }
    
    private void limpaProd2() {
    
        jCBProduto.setSelectedIndex(0);
        jCBUnidadeMedida.setSelectedIndex(7);
        jFTFQuantidade.setText("");
        listaIngredientes.isEmpty();
        jTAIngredientes.setText("");
    }
    
    /**
     * Creates new form FormCadReceita
     */
    public FormCadReceita() {
        initComponents();
        
        
        jCBUnidadeMedida.setSelectedIndex(7);
        preencheComboBoxProduto();
        listaIngredientes = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNomeReceita = new javax.swing.JTextField();
        jCBCategoriaReceita = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCBProduto = new javax.swing.JComboBox<>();
        jCBUnidadeMedida = new javax.swing.JComboBox<>();
        jBAdicionarIngrediente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAIngredientes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAModoPreparo = new javax.swing.JTextArea();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jBAdicionarImg = new javax.swing.JButton();
        jLImagem = new javax.swing.JLabel();
        jFTFQuantidade = new javax.swing.JFormattedTextField();
        jBLimpaProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Receita");

        jLabel1.setText("Cadastrar uma receita:");

        jLabel2.setText("Nome da Receita:");

        jLabel3.setText("Categoria:");

        jTFNomeReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeReceitaActionPerformed(evt);
            }
        });

        jCBCategoriaReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a categoria", "1 - Carnes", "2 - Massas", "3 - Saladas", "4 - Sobremesas", "5 - Sopas", "6 - Lanches" }));
        jCBCategoriaReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaReceitaActionPerformed(evt);
            }
        });

        jLabel4.setText("Adicionando Ingredientes:");

        jLabel5.setText("Quantidade:");

        jCBProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um produto" }));
        jCBProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProdutoActionPerformed(evt);
            }
        });

        jCBUnidadeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colher de Sopa", "Colher de Chá ", "Xícara ", "Gramas", "Quilos ", "Unidade", "Pitada", "Unidade de Medida" }));
        jCBUnidadeMedida.setEnabled(false);
        jCBUnidadeMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBUnidadeMedidaActionPerformed(evt);
            }
        });

        jBAdicionarIngrediente.setText("Adicionar");
        jBAdicionarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarIngredienteActionPerformed(evt);
            }
        });

        jTAIngredientes.setColumns(20);
        jTAIngredientes.setRows(5);
        jTAIngredientes.setEnabled(false);
        jScrollPane1.setViewportView(jTAIngredientes);

        jLabel6.setText("Modo de Preparo:");

        jTAModoPreparo.setColumns(20);
        jTAModoPreparo.setRows(5);
        jScrollPane2.setViewportView(jTAModoPreparo);

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });

        jBAdicionarImg.setText("Adicionar Imagem");
        jBAdicionarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarImgActionPerformed(evt);
            }
        });

        jLImagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jFTFQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jBLimpaProd.setText("Limpar");
        jBLimpaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpaProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCBUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jFTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBAdicionarIngrediente))
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBLimpaProd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBCategoriaReceita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTFNomeReceita)))
                                        .addGap(27, 27, 27)
                                        .addComponent(jBAdicionarImg)
                                        .addGap(33, 33, 33))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFNomeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAdicionarImg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBCategoriaReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(jLImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpaProd)
                    .addComponent(jBAdicionarIngrediente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBCancelar)
                    .addComponent(jBDeletar))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNomeReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeReceitaActionPerformed
        // TODO add your handling code here:s
    }//GEN-LAST:event_jTFNomeReceitaActionPerformed

    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBDeletarActionPerformed

    private void jBAdicionarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarImgActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser1 = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        jFileChooser1.addChoosableFileFilter(imageFilter);
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagem = new Imagem(jFileChooser1.getSelectedFile());
            jLImagem.setIcon(imagem.getImageIcon()); 
            //jblImagem é um label grande na tela para aparecer a imagem
        }
    }//GEN-LAST:event_jBAdicionarImgActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        // TODO add your handling code here:
        float quantidade;
        try {
            quantidade = ((Number) jFTFQuantidade.getValue()).floatValue();  
        } catch (Exception e) {
            quantidade = 0;
        }
        if(!jTFNomeReceita.getText().isEmpty()){
            if(imagem.getImagem()!=null){
                if(jTAIngredientes.getText().isEmpty()){
                    if(jTAModoPreparo.getText().isEmpty()){
         
                        
                                  
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Erro! Descreva o modo de preparo da receita.");
                        jTAModoPreparo.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro! Você não adicionou nenhum ingrediente.");
                    jFTFQuantidade.requestFocus();
                    jCBProduto.requestFocus();
                    jCBUnidadeMedida.requestFocus();
                } 
            }else{
                JOptionPane.showMessageDialog(rootPane, "Erro! Selecione uma imagem para a receita."); 
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Erro! Defina o nome da receita.");
            jTFNomeReceita.requestFocus();   
        }
        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAdicionarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarIngredienteActionPerformed
//      // TODO add your handling code here:
        float quantidade = 0;
        quantidade = ((Number)jFTFQuantidade.getValue()).floatValue();    
        Produto produto = listaProdutos.get(jCBProduto.getSelectedIndex());
        Ingredientes ingrediente = new Ingredientes(0, quantidade, produto);
        listaIngredientes.add(ingrediente);
        String msgFormatada = ingrediente.getQuantidadeIngredientes() + " x " + ingrediente.getProduto().getNomeProduto() + " (" + ingrediente.getProduto().getUnidadeLiteral()+ ")\n";
        jTAIngredientes.append(msgFormatada);
        limpaProd();
        jTAIngredientes.setLineWrap(true);
        
        
    }//GEN-LAST:event_jBAdicionarIngredienteActionPerformed

    private void jCBCategoriaReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaReceitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBCategoriaReceitaActionPerformed

    private void jCBUnidadeMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBUnidadeMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBUnidadeMedidaActionPerformed

    private void jCBProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProdutoActionPerformed
        // TODO add your handling code here:
        Produto prod = listaProdutos.get(jCBProduto.getSelectedIndex());
        jCBUnidadeMedida.setSelectedIndex(prod.getUnidade());        
    }//GEN-LAST:event_jCBProdutoActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBLimpaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpaProdActionPerformed
        // TODO add your handling code here:
        limpaProd2();
    }//GEN-LAST:event_jBLimpaProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionarImg;
    private javax.swing.JButton jBAdicionarIngrediente;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBDeletar;
    private javax.swing.JButton jBLimpaProd;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBCategoriaReceita;
    private javax.swing.JComboBox<String> jCBProduto;
    private javax.swing.JComboBox<String> jCBUnidadeMedida;
    private javax.swing.JFormattedTextField jFTFQuantidade;
    private javax.swing.JLabel jLImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAIngredientes;
    private javax.swing.JTextArea jTAModoPreparo;
    private javax.swing.JTextField jTFNomeReceita;
    // End of variables declaration//GEN-END:variables
}
