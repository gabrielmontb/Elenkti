package view;

import java.awt.Toolkit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Equipamento;
import model.Usuario;
import controller.EquipamentoDAO;
import controller.UsuarioDAO;

/**
 *
 * @author Gabriel Montserrat
 */
public class menu_admin extends javax.swing.JFrame {

    /**
     * Creates new form menu_admin
     */
    public menu_admin() {
        initComponents();
        setIcon();
        setTitle("Elenktí");
    }
    public String hora(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = (Date) Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
        String dataFormatada = sdf.format(hora);
        return dataFormatada;
    }
    public void readJtable(){
        DefaultTableModel tabela = (DefaultTableModel) JEquipamentos.getModel();
        Equipamento e = new Equipamento();
        EquipamentoDAO dao = new EquipamentoDAO();
        Usuario u = new Usuario();
        UsuarioDAO Udao = new UsuarioDAO();        
        e.setId(Integer.parseInt(id_equipamento.getText()));
        u.setMatricula(Integer.parseInt(matricula.getText()));
        Equipamento temp_equipamento = new Equipamento();
        Usuario temp_usuario = new Usuario();
        temp_equipamento = dao.read(e);
        temp_usuario = Udao.read(u);
        if(temp_equipamento.getId() == 0){
            dialogo_equipamento.setVisible(true);
            dialogo_equipamento.setLocationRelativeTo(null); 
        }
        else{
            if(temp_usuario.getMatricula() == 0){
                dialogo_usuario.setVisible(true);
                dialogo_usuario.setLocationRelativeTo(null); 
            }
            else{
                tabela.addRow(new Object[]{
                temp_equipamento.getId(),
                temp_equipamento.getNome(),
                temp_equipamento.getSala(),
                temp_usuario.getNome(),
                temp_usuario.getMatricula(),
                temp_usuario.getTelefone(),
                hora(),
                false   
                });                
            }
        }        
    }
    public void remove(int linha){
        DefaultTableModel tabela = (DefaultTableModel) JEquipamentos.getModel();
        tabela.removeRow(linha);       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo_sair = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        d_cancelar = new javax.swing.JButton();
        d_sair = new javax.swing.JButton();
        dialogo_usuario = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        dialogo_equipamento = new javax.swing.JDialog();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        id_equipamento = new javax.swing.JTextField();
        matricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JEquipamentos = new javax.swing.JTable();
        sair = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_funcionario = new javax.swing.JMenu();
        editar_funcionario = new javax.swing.JMenuItem();
        adicionar_funcionario = new javax.swing.JMenuItem();
        excluir_funcionario = new javax.swing.JMenuItem();
        visualizar_funcionario = new javax.swing.JMenuItem();
        menu_equipamentos = new javax.swing.JMenu();
        editar_equipamentos = new javax.swing.JMenuItem();
        adicionar_equipamento = new javax.swing.JMenuItem();
        excluir_equipamentos = new javax.swing.JMenuItem();
        visualizar_equipamentos = new javax.swing.JMenuItem();
        menu_usuarios = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        dialogo_sair.setMinimumSize(new java.awt.Dimension(300, 150));

        jLabel3.setText("Deseja realmente sair do sistema?");

        d_cancelar.setText("Cancelar");
        d_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_cancelarActionPerformed(evt);
            }
        });

        d_sair.setText("Sair");
        d_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogo_sairLayout = new javax.swing.GroupLayout(dialogo_sair.getContentPane());
        dialogo_sair.getContentPane().setLayout(dialogo_sairLayout);
        dialogo_sairLayout.setHorizontalGroup(
            dialogo_sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo_sairLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(dialogo_sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogo_sairLayout.createSequentialGroup()
                        .addComponent(d_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(d_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        dialogo_sairLayout.setVerticalGroup(
            dialogo_sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo_sairLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(dialogo_sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_cancelar)
                    .addComponent(d_sair))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        dialogo_usuario.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogo_usuario.setMinimumSize(new java.awt.Dimension(300, 150));

        jButton2.setText("OK!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuário não cadastrado!");

        javax.swing.GroupLayout dialogo_usuarioLayout = new javax.swing.GroupLayout(dialogo_usuario.getContentPane());
        dialogo_usuario.getContentPane().setLayout(dialogo_usuarioLayout);
        dialogo_usuarioLayout.setHorizontalGroup(
            dialogo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo_usuarioLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogo_usuarioLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        dialogo_usuarioLayout.setVerticalGroup(
            dialogo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogo_usuarioLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
        );

        dialogo_equipamento.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogo_equipamento.setMinimumSize(new java.awt.Dimension(300, 150));

        jButton3.setText("Ok!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Equipamento não cadastrado!");

        javax.swing.GroupLayout dialogo_equipamentoLayout = new javax.swing.GroupLayout(dialogo_equipamento.getContentPane());
        dialogo_equipamento.getContentPane().setLayout(dialogo_equipamentoLayout);
        dialogo_equipamentoLayout.setHorizontalGroup(
            dialogo_equipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogo_equipamentoLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(dialogo_equipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogo_equipamentoLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogo_equipamentoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(75, 75, 75))))
        );
        dialogo_equipamentoLayout.setVerticalGroup(
            dialogo_equipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogo_equipamentoLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id_equipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_equipamentoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Equipamento");

        jLabel2.setText("Matrícula");

        JEquipamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipamento", "Sala", "Nome", "Matrícula", "Telefone", "Horário", "Entregue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JEquipamentosMouseClicked(evt);
            }
        });
        JEquipamentos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JEquipamentosPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(JEquipamentos);
        if (JEquipamentos.getColumnModel().getColumnCount() > 0) {
            JEquipamentos.getColumnModel().getColumn(0).setPreferredWidth(30);
            JEquipamentos.getColumnModel().getColumn(1).setPreferredWidth(120);
            JEquipamentos.getColumnModel().getColumn(3).setPreferredWidth(150);
            JEquipamentos.getColumnModel().getColumn(4).setPreferredWidth(70);
            JEquipamentos.getColumnModel().getColumn(5).setPreferredWidth(100);
            JEquipamentos.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        menu_funcionario.setText("Funcionários");

        editar_funcionario.setText("Alterar");
        editar_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_funcionarioActionPerformed(evt);
            }
        });
        menu_funcionario.add(editar_funcionario);

        adicionar_funcionario.setText("Cadastrar");
        adicionar_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionar_funcionarioActionPerformed(evt);
            }
        });
        menu_funcionario.add(adicionar_funcionario);

        excluir_funcionario.setText("Remover");
        excluir_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_funcionarioActionPerformed(evt);
            }
        });
        menu_funcionario.add(excluir_funcionario);

        visualizar_funcionario.setText("Visualizar");
        visualizar_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizar_funcionarioActionPerformed(evt);
            }
        });
        menu_funcionario.add(visualizar_funcionario);

        jMenuBar1.add(menu_funcionario);

        menu_equipamentos.setText("Equipamentos");

        editar_equipamentos.setText("Alterar");
        editar_equipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_equipamentosActionPerformed(evt);
            }
        });
        menu_equipamentos.add(editar_equipamentos);

        adicionar_equipamento.setText("Cadastrar");
        adicionar_equipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionar_equipamentoActionPerformed(evt);
            }
        });
        menu_equipamentos.add(adicionar_equipamento);

        excluir_equipamentos.setText("Remover");
        excluir_equipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_equipamentosActionPerformed(evt);
            }
        });
        menu_equipamentos.add(excluir_equipamentos);

        visualizar_equipamentos.setText("Visualizar");
        visualizar_equipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizar_equipamentosActionPerformed(evt);
            }
        });
        menu_equipamentos.add(visualizar_equipamentos);

        jMenuBar1.add(menu_equipamentos);

        menu_usuarios.setText("Usuários");

        jMenuItem3.setText("Alterar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_usuarios.add(jMenuItem3);

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_usuarios.add(jMenuItem1);

        jMenuItem4.setText("Remover");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_usuarios.add(jMenuItem4);

        jMenuItem2.setText("Visualizar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_usuarios.add(jMenuItem2);

        jMenuBar1.add(menu_usuarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sair)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(id_equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel1)
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void id_equipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_equipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_equipamentoActionPerformed

    private void d_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_cancelarActionPerformed
    dialogo_sair.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_d_cancelarActionPerformed

    private void adicionar_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionar_funcionarioActionPerformed
    new cadastrar_funcionario().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_adicionar_funcionarioActionPerformed

    private void visualizar_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizar_funcionarioActionPerformed
    new visualizar_funcionario().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_visualizar_funcionarioActionPerformed

    private void editar_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_funcionarioActionPerformed
    new alterar_funcionario().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_editar_funcionarioActionPerformed

    private void excluir_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_funcionarioActionPerformed
    new remover_funcionario().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_excluir_funcionarioActionPerformed

    private void adicionar_equipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionar_equipamentoActionPerformed
    new cadastrar_equipamento().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_adicionar_equipamentoActionPerformed

    private void visualizar_equipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizar_equipamentosActionPerformed
    new visualizar_equipamento().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_visualizar_equipamentosActionPerformed

    private void editar_equipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_equipamentosActionPerformed
    new alterar_equipamento().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_editar_equipamentosActionPerformed

    private void excluir_equipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_equipamentosActionPerformed
    new remover_equipamento().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_excluir_equipamentosActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
    dialogo_sair.setVisible(true);
    dialogo_sair.setLocationRelativeTo(null); 
    }//GEN-LAST:event_sairActionPerformed

    private void d_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_sairActionPerformed
      new login().setVisible(true);   
      setVisible(false);
    }//GEN-LAST:event_d_sairActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       new visualizar_usuario().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new cadastrar_usuario().setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new alterar_usuario().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new remover_usuario().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        readJtable();
        matricula.setText("");
       id_equipamento.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed
   
    private void JEquipamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JEquipamentosMouseClicked
      int linha;
      Object selecionado;
      String confirma, confirmacao;      
      //god = JEquipamentos.getRowSelectionAllowed(); //Verifica se alguma linha está senco selecionada
      linha = JEquipamentos.getSelectedRow(); // Verifica qual linha está sendo selecionada
      selecionado = (JEquipamentos.getValueAt(linha, 7)); //pega o objeto que está sendo selecionado na coluna 7 (entregue) 
      confirma = selecionado.toString();
      confirmacao = "true"; //inicializa em true
      if(confirma == confirmacao){ //verifica se é true ou não (se foi entregue ou não)
          remove(linha); //chama função para remoção da linha selecionada
      } 
        
    }//GEN-LAST:event_JEquipamentosMouseClicked

    private void JEquipamentosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JEquipamentosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_JEquipamentosPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dialogo_usuario.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogo_equipamento.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JEquipamentos;
    private javax.swing.JMenuItem adicionar_equipamento;
    private javax.swing.JMenuItem adicionar_funcionario;
    private javax.swing.JButton d_cancelar;
    private javax.swing.JButton d_sair;
    private javax.swing.JDialog dialogo_equipamento;
    private javax.swing.JDialog dialogo_sair;
    private javax.swing.JDialog dialogo_usuario;
    private javax.swing.JMenuItem editar_equipamentos;
    private javax.swing.JMenuItem editar_funcionario;
    private javax.swing.JMenuItem excluir_equipamentos;
    private javax.swing.JMenuItem excluir_funcionario;
    private javax.swing.JTextField id_equipamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField matricula;
    private javax.swing.JMenu menu_equipamentos;
    private javax.swing.JMenu menu_funcionario;
    private javax.swing.JMenu menu_usuarios;
    private javax.swing.JRadioButton sair;
    private javax.swing.JMenuItem visualizar_equipamentos;
    private javax.swing.JMenuItem visualizar_funcionario;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));
    }
}
