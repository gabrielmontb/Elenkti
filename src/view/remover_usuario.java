package view;

import java.awt.Toolkit;
import model.Usuario;
import controller.UsuarioDAO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Montserrat
 */
public class remover_usuario extends javax.swing.JFrame {
    int matricula_temp;
    public remover_usuario() {
        initComponents();
        setIcon();
        setTitle("Remover Usuário");
        jButton1.disable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        d_remover_us = new javax.swing.JDialog();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Confirmacao = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        d_cancelar = new javax.swing.JButton();
        d_sim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        JUsuario = new javax.swing.JTable();

        d_remover_us.setMinimumSize(new java.awt.Dimension(300, 150));

        jButton3.setText("Ok!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Removido com sucesso!");

        javax.swing.GroupLayout d_remover_usLayout = new javax.swing.GroupLayout(d_remover_us.getContentPane());
        d_remover_us.getContentPane().setLayout(d_remover_usLayout);
        d_remover_usLayout.setHorizontalGroup(
            d_remover_usLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_remover_usLayout.createSequentialGroup()
                .addGroup(d_remover_usLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(d_remover_usLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3))
                    .addGroup(d_remover_usLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButton3)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        d_remover_usLayout.setVerticalGroup(
            d_remover_usLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_remover_usLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(30, 30, 30))
        );

        Confirmacao.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Confirmacao.setMinimumSize(new java.awt.Dimension(300, 150));

        jLabel4.setText("Tem certeza que deseja remover?");

        d_cancelar.setText("Cancelar");
        d_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_cancelarActionPerformed(evt);
            }
        });

        d_sim.setText("Sim");
        d_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_simActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfirmacaoLayout = new javax.swing.GroupLayout(Confirmacao.getContentPane());
        Confirmacao.getContentPane().setLayout(ConfirmacaoLayout);
        ConfirmacaoLayout.setHorizontalGroup(
            ConfirmacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacaoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(ConfirmacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConfirmacaoLayout.createSequentialGroup()
                        .addComponent(d_sim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(d_cancelar))
                    .addComponent(jLabel4))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        ConfirmacaoLayout.setVerticalGroup(
            ConfirmacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacaoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConfirmacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_sim)
                    .addComponent(d_cancelar))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Digite a matrícula do usuário");

        matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaActionPerformed(evt);
            }
        });

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Telefone", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(JUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Confirmacao.setLocationRelativeTo(null); 
        Confirmacao.setVisible(true);
       // d_remover_us.setVisible(true);
       // d_remover_us.setLocationRelativeTo(null);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        d_remover_us.setVisible(false);        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) JUsuario.getModel();
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        matricula_temp = (Integer.parseInt(matricula.getText())); 
        u.setMatricula(Integer.parseInt(matricula.getText()));        
        Usuario temp = new Usuario();
        temp = dao.read(u);
        tabela.addRow(new Object[]{
            temp.getMatricula(),
            temp.getNome(),
            temp.getTelefone(),
            temp.getObservacao()
        }); 
        if(0 != u.getMatricula()){
            jButton1.enable();
        }
        else{
            jButton1.disable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaActionPerformed

    private void d_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_cancelarActionPerformed
        Confirmacao.setVisible(false);
    }//GEN-LAST:event_d_cancelarActionPerformed

    private void d_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_simActionPerformed
        Confirmacao.setVisible(false);
        Usuario u = new Usuario();        
        UsuarioDAO dao = new UsuarioDAO();
        u.setMatricula(matricula_temp);
        dao.delete(u); 
        jButton1.disable();// TODO add your handling code here:
    }//GEN-LAST:event_d_simActionPerformed

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
            java.util.logging.Logger.getLogger(remover_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(remover_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(remover_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(remover_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new remover_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacao;
    private javax.swing.JTable JUsuario;
    private javax.swing.JButton d_cancelar;
    private javax.swing.JDialog d_remover_us;
    private javax.swing.JButton d_sim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField matricula;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png"))); 
   }
}
