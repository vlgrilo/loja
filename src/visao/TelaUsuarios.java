/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleUsuario;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.ConectaBanco;
import modelo.ModeloTabela;
import modelo.ModeloUsuario;

/**
 *
 * @author Victor
 */
public class TelaUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaUsuarios
     */
    ModeloUsuario mod = new ModeloUsuario();
    ControleUsuario control = new ControleUsuario();
    ConectaBanco conex = new ConectaBanco();
    int flag = 0;

    public void setPosicao() { //centraliza tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public TelaUsuarios() {
        initComponents();
        conex.conexao();
        preencherTabela("select *from login order by nome");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        confirmasenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        pesquisa = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("COD:");

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nome.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Login:");

        login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Senha:");

        senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        senha.setEnabled(false);

        confirmasenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmasenha.setEnabled(false);
        confirmasenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmasenhaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Confirmar Senha:");

        novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group_add.png"))); // NOI18N
        novo.setText("Novo");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        salvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        salvar.setText("Salvar");
        salvar.setEnabled(false);
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group_edit.png"))); // NOI18N
        editar.setText("Editar");
        editar.setEnabled(false);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group_delete.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        sair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        sair.setText("Fechar");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmasenha))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sair)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(confirmasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novo)
                    .addComponent(salvar)
                    .addComponent(cancelar)
                    .addComponent(pesquisar)
                    .addComponent(sair)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar)
                    .addComponent(excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmasenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmasenhaActionPerformed

    }//GEN-LAST:event_confirmasenhaActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        flag = 1;
        salvar.setEnabled(true);
        cancelar.setEnabled(true);
        nome.setEnabled(true);
        novo.setEnabled(false);
        pesquisa.setEnabled(false);
        pesquisar.setEnabled(false);
        editar.setEnabled(false);
        confirmasenha.setEnabled(true);
        excluir.setEnabled(false);
        login.setEnabled(true);
        senha.setEnabled(true);
        senha.setText("");
        login.setText("");
        nome.setText("");
        confirmasenha.setText("");
        id.setText("");
        pesquisa.setText("");
    }//GEN-LAST:event_novoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        if (flag == 1) {
            if (nome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha nome para continuar");
                nome.requestFocus();
            } else if (login.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha login para continuar");
                login.requestFocus();
            } else if (senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha senha para continuar");
                senha.requestFocus();
            } else if (confirmasenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Confirme senha para continuar");
                confirmasenha.requestFocus();
            } else {
                if (senha.getText().equals(confirmasenha.getText())) {
                    conex.conexao();
                    try {
                        conex.executaSql("select *from login where id_login='" + id.getText() + "'");
                        conex.rs.first();
                        String testalogin = conex.rs.getString("login");
                        if (testalogin.equals(login.getText())) {
                            JOptionPane.showMessageDialog(rootPane, "Login ja cadastrado");
                            login.requestFocus();
                        } else {
                            mod.setNome(nome.getText());
                            mod.setLogin(login.getText());
                            mod.setSenha(senha.getText());
                            control.Salvar(mod);
                            nome.setText("");
                            login.setText("");
                            senha.setText("");
                            confirmasenha.setText("");
                            salvar.setEnabled(false);
                            cancelar.setEnabled(false);
                            nome.setEnabled(false);
                            login.setEnabled(false);
                            senha.setEnabled(false);
                            confirmasenha.setEnabled(false);
                            novo.setEnabled(true);
                            pesquisa.setEnabled(true);
                            pesquisar.setEnabled(true);
                            preencherTabela("select *from login order by nome");
                        }
                    } catch (SQLException ex) {
                        mod.setNome(nome.getText());
                        mod.setLogin(login.getText());
                        mod.setSenha(senha.getText());
                        control.Salvar(mod);
                        nome.setText("");
                        login.setText("");
                        senha.setText("");
                        confirmasenha.setText("");
                        salvar.setEnabled(false);
                        cancelar.setEnabled(false);
                        nome.setEnabled(false);
                        login.setEnabled(false);
                        senha.setEnabled(false);
                        confirmasenha.setEnabled(false);
                        novo.setEnabled(true);
                        pesquisa.setEnabled(true);
                        pesquisar.setEnabled(true);
                        preencherTabela("select *from login order by nome");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "As senhas n??o correspondem!");
                }
            }
        } else {
            if (nome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha nome para continuar");
                nome.requestFocus();
            } else if (login.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha login para continuar");
                login.requestFocus();
            } else if (senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha senha para continuar");
                senha.requestFocus();
            } else if (confirmasenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Confirme senha para continuar");
                confirmasenha.requestFocus();
            } else {
                if (senha.getText().equals(confirmasenha.getText())) {
                    mod.setId((Integer.parseInt(id.getText())));
                    mod.setNome(nome.getText());
                    mod.setLogin(login.getText());
                    mod.setSenha(senha.getText());
                    control.Editar(mod);
                    nome.setText("");
                    login.setText("");
                    senha.setText("");
                    confirmasenha.setText("");
                    salvar.setEnabled(false);
                    cancelar.setEnabled(false);
                    nome.setEnabled(false);
                    login.setEnabled(false);
                    senha.setEnabled(false);
                    confirmasenha.setEnabled(false);
                    novo.setEnabled(true);
                    pesquisa.setEnabled(true);
                    pesquisar.setEnabled(true);
                    preencherTabela("select *from login order by nome");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "As senhas n??o correspondem!");
                }
            }

        }
    }//GEN-LAST:event_salvarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        nome.setText("");
        login.setText("");
        senha.setText("");
        confirmasenha.setText("");
        id.setText("");
        salvar.setEnabled(false);
        cancelar.setEnabled(false);
        nome.setEnabled(false);
        login.setEnabled(false);
        senha.setEnabled(false);
        confirmasenha.setEnabled(false);
        novo.setEnabled(true);
        pesquisa.setEnabled(true);
        pesquisar.setEnabled(true);
    }//GEN-LAST:event_cancelarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        conex.conexao();
        try {
            flag = 2;
            conex.executaSql("select *from login where login='" + login.getText() + "'");
            conex.rs.first();
            if (conex.rs.getInt("adm") == 1) {
                JOptionPane.showMessageDialog(rootPane, "Conta de administrador nao pode ser alterada");
            } else {
                salvar.setEnabled(true);
                cancelar.setEnabled(true);
                nome.setEnabled(true);
                senha.setEnabled(true);
                confirmasenha.setEnabled(true);
                novo.setEnabled(false);
                pesquisa.setEnabled(false);
                pesquisar.setEnabled(false);
                editar.setEnabled(false);
                excluir.setEnabled(false);
                pesquisa.setText("");
                conex.desconecta();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        conex.conexao();
        try {
            int resposta = 0;
            conex.executaSql("select *from login where id_login='" + id.getText() + "'");
            conex.rs.first();
            if (conex.rs.getInt("adm") == 1) {
                JOptionPane.showMessageDialog(rootPane, "Conta de administrador nao pode ser excluida");
            } else {
                resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir Usuario?", "Excluir", resposta);
                if (resposta == JOptionPane.YES_OPTION) {
                    mod.setId(Integer.parseInt(id.getText()));
                    control.Excluir(mod);
                    nome.setText("");
                    login.setText("");
                    senha.setText("");
                    confirmasenha.setText("");
                    id.setText("");
                    pesquisa.setText("");
                    salvar.setEnabled(false);
                    cancelar.setEnabled(false);
                    nome.setEnabled(false);
                    login.setEnabled(false);
                    senha.setEnabled(false);
                    confirmasenha.setEnabled(false);
                    novo.setEnabled(true);
                    pesquisa.setEnabled(true);
                    pesquisar.setEnabled(true);
                    editar.setEnabled(false);
                    excluir.setEnabled(false);
                    preencherTabela("select *from login order by nome");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
    }//GEN-LAST:event_excluirActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        mod.setPesquisa(pesquisa.getText());
        ModeloUsuario model = control.Busca(mod);
        id.setText(String.valueOf(model.getId()));
        nome.setText(model.getNome());
        login.setText(model.getLogin());
        senha.setText(model.getSenha());
        confirmasenha.setText(model.getSenha());
        preencherTabela("select *from login where nome like'%" + mod.getPesquisa() + "%'");
        nome.setText("");
        login.setText("");
        confirmasenha.setText("");
        senha.setText("");
        id.setText("");
        pesquisa.setText("");
    }//GEN-LAST:event_pesquisarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        id.setText("");
        nome.setText("");
        login.setText("");
        senha.setText("");
        confirmasenha.setText("");
        novo.setEnabled(true);
        login.setEnabled(false);
        senha.setEnabled(false);
        confirmasenha.setEnabled(false);
        nome.setEnabled(false);
        salvar.setEnabled(false);
        editar.setEnabled(false);
        excluir.setEnabled(false);
        pesquisar.setEnabled(true);
        cancelar.setEnabled(false);
        pesquisa.setEnabled(true);
        String nome_usuario = "" + tabela.getValueAt(tabela.getSelectedRow(), 0);
        conex.conexao();
        conex.executaSql("select *from login where id_login='" + nome_usuario + "'");
        try {
            conex.rs.first();
            id.setText(String.valueOf(conex.rs.getInt("id_login")));
            nome.setText(conex.rs.getString("nome"));
            login.setText(conex.rs.getString("login"));
            senha.setText(conex.rs.getString("senha"));
            confirmasenha.setText(conex.rs.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar usuario" + ex);
        }
        conex.desconecta();
        editar.setEnabled(true);
        excluir.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    public void preencherTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Login"};
        conex.conexao();
        conex.executaSql(Sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("id_login"), conex.rs.getString("nome"), conex.rs.getString("login")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Busque por outro usuario para preencher tabela");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(525);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(293);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JPasswordField confirmasenha;
    private javax.swing.JButton editar;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField login;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
