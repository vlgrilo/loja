/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConectaBanco;

/**
 *
 * @author Victor
 */
public class TelaLogin extends javax.swing.JFrame {

    ConectaBanco conex = new ConectaBanco();

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conex.conexao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        login = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });

        senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });
        senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Login:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senha)
                    .addComponent(login, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(220, 214));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String a = null;
        conex.executaSql("select count(1) from login");
        try {
            conex.rs.next();
            a = (conex.rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (a.equals("0")) {
            int resposta = 0;
            resposta = JOptionPane.showConfirmDialog(rootPane, "Nenhum usuario cadastrado, deseja cadastrar?", "Cadastro de Administrador", resposta);
            if (resposta == JOptionPane.YES_OPTION) {
                TelaCadAdm teste = new TelaCadAdm();
                teste.setVisible(true);
                dispose();
            }
        } else {
            try {
                conex.executaSql("select *from login where login='" + login.getText() + "'");
                conex.rs.first();
                if (conex.rs.getString("senha").equals(senha.getText())) {
                    String nome = conex.rs.getString("nome");
                    JOptionPane.showMessageDialog(rootPane, "Bem-Vindo", "Bem-Vindo", 1);
                    if (conex.rs.getInt("adm") == 1) {
                        TelaPrincipalAdm tela = new TelaPrincipalAdm(nome);
                        tela.setVisible(true);
                    } else {
                        TelaPrincipalFunc tela = new TelaPrincipalFunc(nome);
                        tela.setVisible(true);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha Invalidos", "Erro", 1);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha Invalidos", "Erro", 1);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String a = null;
            conex.executaSql("select count(1) from login");
            try {
                conex.rs.next();
                a = (conex.rs.getString(1));
            } catch (SQLException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (a.equals("0")) {
                int resposta = 0;
                resposta = JOptionPane.showConfirmDialog(rootPane, "Nenhum usuario cadastrado, deseja cadastrar?", "Cadastro de Administrador", resposta);
                if (resposta == JOptionPane.YES_OPTION) {
                    TelaCadAdm teste = new TelaCadAdm();
                    teste.setVisible(true);
                    dispose();
                }
            } else {
                try {
                    conex.executaSql("select *from login where login='" + login.getText() + "'");
                    conex.rs.first();
                    if (conex.rs.getString("senha").equals(senha.getText())) {
                        String nome = conex.rs.getString("nome");
                        JOptionPane.showMessageDialog(rootPane, "Bem-Vindo", "Bem-Vindo", 1);
                        if (conex.rs.getInt("adm") == 1) {
                            TelaPrincipalAdm tela = new TelaPrincipalAdm(nome);
                            tela.setVisible(true);
                        } else {
                            TelaPrincipalFunc tela = new TelaPrincipalFunc(nome);
                            tela.setVisible(true);
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha Invalidos", "Erro", 1);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha Invalidos", "Erro", 1);
                }
            }
        }
    }//GEN-LAST:event_loginKeyPressed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String a = null;
            conex.executaSql("select count(1) from login");
            try {
                conex.rs.next();
                a = (conex.rs.getString(1));
            } catch (SQLException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (a.equals("0")) {
                int resposta = 0;
                resposta = JOptionPane.showConfirmDialog(rootPane, "Nenhum usuario cadastrado, deseja cadastrar?", "Cadastro de Administrador", resposta);
                if (resposta == JOptionPane.YES_OPTION) {
                    TelaCadAdm teste = new TelaCadAdm();
                    teste.setVisible(true);
                    dispose();
                }
            } else {
                try {
                    conex.executaSql("select *from login where login='" + login.getText() + "'");
                    conex.rs.first();
                    if (conex.rs.getString("senha").equals(senha.getText())) {
                        String nome = conex.rs.getString("nome");
                        JOptionPane.showMessageDialog(rootPane, "Bem-Vindo", "Bem-Vindo", 1);
                        if (conex.rs.getInt("adm") == 1) {
                            TelaPrincipalAdm tela = new TelaPrincipalAdm(nome);
                            tela.setVisible(true);
                        } else {
                            TelaPrincipalFunc tela = new TelaPrincipalFunc(nome);
                            tela.setVisible(true);
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha Invalidos", "Erro", 1);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha Invalidos", "Erro", 1);
                }
            }
        }
    }//GEN-LAST:event_senhaKeyPressed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
