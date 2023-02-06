/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Aila
 */
public class FormCategorias extends javax.swing.JFrame {

    /**
     * Creates new form FormCategorias
     */
    public FormCategorias() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBCarnes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBMassas = new javax.swing.JButton();
        jBSaladas = new javax.swing.JButton();
        jBSobremesas = new javax.swing.JButton();
        jBSopas = new javax.swing.JButton();
        jBLanches = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCarnes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/carne.png"))); // NOI18N

        jLabel1.setText("Adicione, edite e exclua receitas por categoria:");

        jBMassas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/massas.png"))); // NOI18N

        jBSaladas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/salada.png"))); // NOI18N

        jBSobremesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/sobremesas.png"))); // NOI18N

        jBSopas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/sopas.png"))); // NOI18N

        jBLanches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/lanches.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBCarnes)
                            .addComponent(jBSobremesas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBSopas)
                            .addComponent(jBMassas))
                        .addGap(57, 57, 57)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSaladas)
                    .addComponent(jBLanches))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCarnes)
                    .addComponent(jBMassas)
                    .addComponent(jBSaladas))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSobremesas)
                    .addComponent(jBSopas)
                    .addComponent(jBLanches))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCarnes;
    private javax.swing.JButton jBLanches;
    private javax.swing.JButton jBMassas;
    private javax.swing.JButton jBSaladas;
    private javax.swing.JButton jBSobremesas;
    private javax.swing.JButton jBSopas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
