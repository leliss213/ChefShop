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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCBCategoriaReceita = new javax.swing.JComboBox<>();
        jTFNomeReceita = new javax.swing.JTextField();
        jBAdicionarImg = new javax.swing.JButton();
        jLImagem = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBProduto = new javax.swing.JComboBox<>();
        jCBUnidadeMedida = new javax.swing.JComboBox<>();
        jFTFQuantidade = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jBAdicionarIngrediente = new javax.swing.JButton();
        jBLimpaProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBDeletar = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAIngredientes = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAModoPreparo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Receita");

        jPanel1.setBackground(new java.awt.Color(251, 251, 248));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Cadastrar uma receita:");

        jLabel2.setText("Nome da Receita:");

        jLabel3.setText("Categoria:");

        jCBCategoriaReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a categoria", "1 - Carnes", "2 - Massas", "3 - Saladas", "4 - Sobremesas", "5 - Sopas", "6 - Lanches" }));
        jCBCategoriaReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaReceitaActionPerformed(evt);
            }
        });

        jTFNomeReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeReceitaActionPerformed(evt);
            }
        });

        jBAdicionarImg.setBackground(new java.awt.Color(251, 251, 248));
        jBAdicionarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/adicionar.png"))); // NOI18N
        jBAdicionarImg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBAdicionarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarImgActionPerformed(evt);
            }
        });

        jLImagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Adicionando Ingredientes:");

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

        jFTFQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel5.setText("Quantidade:");

        jBAdicionarIngrediente.setBackground(new java.awt.Color(196, 255, 170));
        jBAdicionarIngrediente.setText("Adicionar");
        jBAdicionarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarIngredienteActionPerformed(evt);
            }
        });

        jBLimpaProd.setBackground(new java.awt.Color(196, 255, 170));
        jBLimpaProd.setText("Limpar");
        jBLimpaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpaProdActionPerformed(evt);
            }
        });

        jLabel6.setText("Modo de Preparo:");

        jPanel2.setBackground(new java.awt.Color(139, 187, 84));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jBDeletar.setBackground(new java.awt.Color(139, 187, 84));
        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });

        jBSalvar.setBackground(new java.awt.Color(139, 187, 84));
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setBackground(new java.awt.Color(139, 187, 84));
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(196, 255, 170));

        jTAIngredientes.setColumns(20);
        jTAIngredientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTAIngredientes.setRows(5);
        jTAIngredientes.setEnabled(false);
        jScrollPane1.setViewportView(jTAIngredientes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(196, 255, 170));

        jTAModoPreparo.setColumns(20);
        jTAModoPreparo.setRows(5);
        jScrollPane2.setViewportView(jTAModoPreparo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCBCategoriaReceita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTFNomeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCBUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jFTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBAdicionarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBLimpaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBAdicionarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFNomeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCBCategoriaReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 71, Short.MAX_VALUE)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBAdicionarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpaProd)
                    .addComponent(jBAdicionarIngrediente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAIngredientes;
    private javax.swing.JTextArea jTAModoPreparo;
    private javax.swing.JTextField jTFNomeReceita;
    // End of variables declaration//GEN-END:variables
}
