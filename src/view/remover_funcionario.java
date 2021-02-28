/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import model.Funcionario;
import controller.FuncionarioDAO;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Gabriel Montserrat
 */
public class remover_funcionario extends javax.swing.JFrame {
    //DefaultTableModel tabela;
    String ID_temp;
    DefaultTableModel tabela;
    /**
     * Creates new form remover_funcionario
     */
    public remover_funcionario() {
        //this.tabela = (DefaultTableModel) Jtabela.getModel();
        initComponents();
        setIcon();
        setTitle("Remover Funcionário");
        tabela = (DefaultTableModel) JFuncionario.getModel();
        remover.disable();   
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        d_remover_funcionario = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Confirmacao = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        d_cancelar = new javax.swing.JButton();
        d_sim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JFuncionario = new javax.swing.JTable();
        id = new javax.swing.JFormattedTextField();

        d_remover_funcionario.setMinimumSize(new java.awt.Dimension(300, 150));

        jButton1.setText("Ok!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Removido com sucesso!");

        javax.swing.GroupLayout d_remover_funcionarioLayout = new javax.swing.GroupLayout(d_remover_funcionario.getContentPane());
        d_remover_funcionario.getContentPane().setLayout(d_remover_funcionarioLayout);
        d_remover_funcionarioLayout.setHorizontalGroup(
            d_remover_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_remover_funcionarioLayout.createSequentialGroup()
                .addGroup(d_remover_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(d_remover_funcionarioLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2))
                    .addGroup(d_remover_funcionarioLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton1)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        d_remover_funcionarioLayout.setVerticalGroup(
            d_remover_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_remover_funcionarioLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        Confirmacao.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Confirmacao.setMinimumSize(new java.awt.Dimension(300, 150));

        jLabel3.setText("Tem certeza que deseja remover?");

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
                    .addComponent(jLabel3))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        ConfirmacaoLayout.setVerticalGroup(
            ConfirmacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacaoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConfirmacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_sim)
                    .addComponent(d_cancelar))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Digite o ID do funcionário");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        remover.setText("Remover");
        remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removerMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removerMouseReleased(evt);
            }
        });
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        JFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JFuncionario);

        try {
            id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remover)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Funcionario f = new Funcionario();
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAO();
        //ID_temp = (Long.parseLong(id.getText()));
        //f.setID(Long.parseLong(id.getText()));
        ID_temp = id.getText();
        f.setID(id.getText());                  
        Funcionario temp = new Funcionario();
        temp = dao.read(f);
        tabela.addRow(new Object[]{
            temp.getID(),
            temp.getNome(),
            //temp.getLogin(),
            temp.getNivel()            
        });
        if("0" != f.getID()){
            remover.enable();
        }
        else{
            remover.disable();
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       d_remover_funcionario.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        Confirmacao.setVisible(true);
        Confirmacao.setLocationRelativeTo(null);         
       // d_remover_funcionario.setVisible(true);
       // d_remover_funcionario.setLocationRelativeTo(null);  // TODO add your handling code here:
    }//GEN-LAST:event_removerActionPerformed

    private void removerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseReleased
        //remover.disable();
    }//GEN-LAST:event_removerMouseReleased

    private void removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseEntered
        //remover.disable();
    }//GEN-LAST:event_removerMouseEntered

    private void d_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_cancelarActionPerformed
        Confirmacao.setVisible(false);
    }//GEN-LAST:event_d_cancelarActionPerformed

    private void d_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_simActionPerformed
        Confirmacao.setVisible(false);
        Funcionario f = new Funcionario();        
        FuncionarioDAO dao = new FuncionarioDAO();
        f.setID(ID_temp);
        //f.setID(ID_temp);
        dao.delete(f);  
        id.setText("");
        tabela.removeRow(0);
        remover.disable();        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(remover_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(remover_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(remover_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(remover_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new remover_funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacao;
    private javax.swing.JTable JFuncionario;
    private javax.swing.JButton buscar;
    private javax.swing.JButton d_cancelar;
    private javax.swing.JDialog d_remover_funcionario;
    private javax.swing.JButton d_sim;
    private javax.swing.JFormattedTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));
    }
}
