/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalho2bimestre.view;
import com.mycompany.trabalho2bimestre.bean.Produto;
import com.mycompany.trabalho2bimestre.bean.Venda;
import com.mycompany.trabalho2bimestre.bean.Vendedor;
import com.mycompany.trabalho2bimestre.dao.ProdutoDao;
import com.mycompany.trabalho2bimestre.dao.VendaDao;
import com.mycompany.trabalho2bimestre.dao.VendedorDao;
import com.mycompany.trabalho2bimestre.util.ConnectionFactory;
import com.mycompany.trabalho2bimestre.view.models.ProdutoComboBoxModel;
import com.mycompany.trabalho2bimestre.view.models.VendaTableModel;
import com.mycompany.trabalho2bimestre.view.models.VendedorComboBoxModel;
import com.mycompany.trabalho2bimestre.view.models.VendedorTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author drmsugano
 */
public class VendaGerenciar extends javax.swing.JFrame {
    private VendaTableModel tbm;
    private ProdutoComboBoxModel produtoCbm;
    private VendedorComboBoxModel vendedorCbm;
    private Venda linhaSelecionada = null;
    /**
     * Creates new form VendaGerenciar
     */
    public VendaGerenciar() {
        initComponents();
        jtId.setEditable(false);

        tbm = new VendaTableModel();
        jtVenda.setModel(tbm);

        produtoCbm = new ProdutoComboBoxModel();
        jcProduto.setModel(produtoCbm);
        
        vendedorCbm = new VendedorComboBoxModel();
        jcVendedor.setModel(vendedorCbm);
        popula();
        jtVenda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = jtVenda.getSelectedRow();
                linhaSelecionada = tbm.get(linha);
                populaForm(linhaSelecionada);
            }
        });
    }

    private void popula() {
        VendaDao vendaDao = new VendaDao(ConnectionFactory.createConnectionToMySQL());
        tbm.addList(vendaDao.findALL());
        
        ProdutoDao produtoDao = new ProdutoDao(ConnectionFactory.createConnectionToMySQL());
        produtoCbm.addAll(produtoDao.findALL());
        
        VendedorDao vendedorDao = new VendedorDao(ConnectionFactory.createConnectionToMySQL());
        vendedorCbm.addAll(vendedorDao.findALL());
    }

    private void populaForm(Venda v) {
        jtId.setText(String.valueOf(v.getId()));
        jcProduto.setSelectedItem(v.getProduto());
        jcVendedor.setSelectedItem(v.getVendedor());
        jtValor.setText(String.valueOf(v.getValor())); // Adicionando o valor ao formulário
    }

    private void limpaForm() {
        jtId.setText("");
        jcProduto.setSelectedIndex(-1);
        jcVendedor.setSelectedIndex(-1);
        jtValor.setText(""); // Limpa o campo de valor
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcProduto = new javax.swing.JComboBox<>();
        jcVendedor = new javax.swing.JComboBox<>();
        jtId = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVenda = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venda");

        jLabel2.setText("ID:");

        jLabel4.setText("Produto:");

        jLabel3.setText("Vendedor:");

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jtVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtVenda);

        jLabel5.setText("Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbCadastrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbExcluir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jcProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar)
                    .addComponent(jbCadastrar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        if (jcProduto.getSelectedIndex() == -1 || jcVendedor.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Todos os campos precisam estar preenchidos");
        } else {
            Venda venda = new Venda();
            venda.setProduto((Produto) jcProduto.getSelectedItem());
            venda.setVendedor((Vendedor) jcVendedor.getSelectedItem());
            venda.setValor(Double.parseDouble(jtValor.getText()));
            venda.setData(new Date());
            VendaDao dao = new VendaDao(ConnectionFactory.createConnectionToMySQL());
            dao.create(venda);
            JOptionPane.showMessageDialog(this, "Venda Cadastrada");
            tbm.add(venda);
            limpaForm();
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        if (linhaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda na tabela");
        } else {
            if (jcProduto.getSelectedIndex() == -1 || jcVendedor.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Todos os campos precisam estar preenchidos");
            } else {
                linhaSelecionada.setProduto((Produto) jcProduto.getSelectedItem());
                linhaSelecionada.setVendedor((Vendedor) jcVendedor.getSelectedItem());
                linhaSelecionada.setValor(Double.parseDouble(jtValor.getText()));
                VendaDao dao = new VendaDao(ConnectionFactory.createConnectionToMySQL());
                dao.update(linhaSelecionada);
                tbm.fireTableDataChanged();
                limpaForm();
                linhaSelecionada = null;
            }
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        if (linhaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda na tabela");
        } else {
            int opcao = JOptionPane.showConfirmDialog(this, "Confirma a exclusão?");
            if (opcao == JOptionPane.YES_OPTION) {
                int id = linhaSelecionada.getId();
                VendaDao dao = new VendaDao(ConnectionFactory.createConnectionToMySQL());
                dao.delete(id);
                tbm.remove(linhaSelecionada);
                limpaForm();
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(VendaGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaGerenciar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<Produto> jcProduto;
    private javax.swing.JComboBox<Vendedor> jcVendedor;
    private javax.swing.JTextField jtId;
    private javax.swing.JFormattedTextField jtValor;
    private javax.swing.JTable jtVenda;
    // End of variables declaration//GEN-END:variables
}
