/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view;

import com.mycompany.trabalho3bimestre.bean.Equipe;
import com.mycompany.trabalho3bimestre.dao.EquipeDao;
import com.mycompany.trabalho3bimestre.view.models.EquipeTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author drmsugano
 */
public class EquipeGerenciar extends javax.swing.JFrame {

    private EquipeTableModel tbm = new EquipeTableModel();
    private Equipe linhaSelecionada = null;

    /**
     * Creates new form EquipeGerenciar
     */
    public EquipeGerenciar() throws ParseException {
        initComponents();
        jtId.setEditable(false);
        MaskFormatter maskDataInicio = new MaskFormatter("##/##/####");
        maskDataInicio.install(jtDataInicio);
        MaskFormatter maskDataFim = new MaskFormatter("##/##/####");
        maskDataFim.install(jtDataFim);
        popula();
        jtEquipe.setModel(tbm);
        jtEquipe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = jtEquipe.getSelectedRow();
                linhaSelecionada = tbm.get(linha);
                populaForm(linhaSelecionada);
            }
        });
    }

    private void popula() {
        EquipeDao dao = new EquipeDao();
        tbm.addList(dao.getList());
    }

    private void limpaForm() {
        jtId.setText("");
        jtNome.setText("");
        jtDataInicio.setText("");
        jtDataFim.setText("");
    }

    private void populaForm(Equipe equipe) {
        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        jtId.setText(String.valueOf(equipe.getId()));
        jtNome.setText(equipe.getNome());
        jtDataInicio.setText(formatData.format(equipe.getDataInicio()));
        jtDataFim.setText(equipe.getDataFim() != null ? formatData.format(equipe.getDataFim()) : "");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtNome = new javax.swing.JTextField();
        jtDataInicio = new javax.swing.JFormattedTextField();
        jtDataFim = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEquipe = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcFiltro = new javax.swing.JComboBox<>();
        jbFiltro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(677, 536));

        jLabel1.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipes");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("ID:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Data Inicio:");

        jLabel5.setText("Data Fim:");

        jtEquipe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtEquipe);

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtrar Equipes:");

        jcFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativa", "Inativa" }));

        jbFiltro.setText("Filtrar");
        jbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtDataFim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(jtDataInicio, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jcFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCadastrar)
                            .addComponent(jbEditar)
                            .addComponent(jbExcluir))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbFiltro))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        if (jtNome.getText().isBlank() || jtDataInicio.getText().isBlank() || jtDataFim.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Só é possivel cadastrar se todos os campos estiverem preenchidos");
        } else {
            Equipe equipe = new Equipe();
            equipe.setNome(jtNome.getText());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                equipe.setDataInicio(format.parse(jtDataInicio.getText()));
                equipe.setDataFim(format.parse(jtDataFim.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(EquipeGerenciar.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (equipe.getDataFim().after(equipe.getDataInicio()) == false) {
                JOptionPane.showMessageDialog(this, "Data do final da equipe é maior que a data de Inicio");
            } else {
                EquipeDao dao = new EquipeDao();
                dao.salvar(equipe);
                JOptionPane.showMessageDialog(this, "Equipe Cadastrada");
                tbm.add(equipe);
                limpaForm();
            }
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        if (linhaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma equipe na tabela");
        }
        if (jtNome.getText().isBlank() || jtDataInicio.getText().isBlank() || jtDataFim.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Só é possivel cadastrar se todos os campos estiverem preenchidos");
        } else {
            EquipeDao dao = new EquipeDao();
            linhaSelecionada.setNome(jtNome.getText());
            try {
                linhaSelecionada.setDataInicio(formatData.parse(jtDataInicio.getText()));
                linhaSelecionada.setDataFim(formatData.parse(jtDataFim.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(EquipeGerenciar.class.getName()).log(Level.SEVERE, null, ex);
            }
            linhaSelecionada.setId(Integer.parseInt(jtId.getText()));
            if (linhaSelecionada.getDataFim().after(linhaSelecionada.getDataInicio()) == false) {
                JOptionPane.showMessageDialog(this, "Data do final da equipe é maior que a data de Inicio");
            } else {
                dao.atualizar(linhaSelecionada);
                tbm.fireTableDataChanged();
                linhaSelecionada = null;
            }
        }
    }//GEN-LAST:event_jbEditarActionPerformed
    
    private void filtrarEquipe()
    {
        String filtro = (String) jcFiltro.getSelectedItem();
        if (filtro != null && !filtro.isEmpty()) {
            EquipeDao dao = new EquipeDao();
            List<Equipe> equipesFiltradas = dao.retrieveFiltro((String) filtro);
            tbm.setList(equipesFiltradas);
            tbm.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Status para filtrar.");
        }
    }
    
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (linhaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto da tabela");
            return;
        }
        int opcao = JOptionPane.showConfirmDialog(this, "Confirma a exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            long id = linhaSelecionada.getId();
            EquipeDao dao = new EquipeDao();
            boolean equipeTemFuncionario = dao.verificarEquipe((int)id);
            if (equipeTemFuncionario) {
                JOptionPane.showMessageDialog(this, "Não é possível excluir a equipe pois há funcionários cadastrados nesta equipe.");
                return;
            }
            try {
                dao.remover(id);
                JOptionPane.showMessageDialog(this, "Equipe excluída com sucesso.");
                tbm.remove(linhaSelecionada);
                limpaForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir a equipe: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltroActionPerformed
        // TODO add your handling code here:
        filtrarEquipe();
    }//GEN-LAST:event_jbFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(EquipeGerenciar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipeGerenciar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipeGerenciar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipeGerenciar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EquipeGerenciar().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(EquipeGerenciar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFiltro;
    private javax.swing.JComboBox<String> jcFiltro;
    private javax.swing.JFormattedTextField jtDataFim;
    private javax.swing.JFormattedTextField jtDataInicio;
    private javax.swing.JTable jtEquipe;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables
}
