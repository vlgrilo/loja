/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleEstoque;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.ConectaBanco;
import modelo.ModeloEstoque;
import modelo.ModeloTabela;

/**
 *
 * @author Victor
 */
public class TelaEstoque extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEstoque
     */
    ConectaBanco conex = new ConectaBanco();
    ModeloEstoque mod = new ModeloEstoque();
    ControleEstoque control = new ControleEstoque();
    int flag = 0;

    public void setPosicao() { //centraliza tela
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public TelaEstoque() {
        initComponents();
        preencherTabela("select *from produtos order by nome_produto");
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
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        pesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cod:");

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        id.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantidade:");

        quantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        quantidade.setEnabled(false);
        quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantidadeKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Pre??o de Venda:");

        valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        valor.setEnabled(false);

        novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cart_add.png"))); // NOI18N
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

        nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nome.setEnabled(false);

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

        pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cart_edit.png"))); // NOI18N
        editar.setText("Editar");
        editar.setEnabled(false);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cart_delete.png"))); // NOI18N
        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(excluir)
                        .addGap(10, 10, 10)
                        .addComponent(pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novo)
                    .addComponent(salvar)
                    .addComponent(pesquisar)
                    .addComponent(sair)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar)
                    .addComponent(editar)
                    .addComponent(excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        flag = 1;
        salvar.setEnabled(true);
        cancelar.setEnabled(true);
        nome.setEnabled(true);
        novo.setEnabled(false);
        pesquisa.setEnabled(false);
        pesquisar.setEnabled(false);
        editar.setEnabled(false);
        excluir.setEnabled(false);
        quantidade.setEnabled(true);
        valor.setEnabled(true);
        quantidade.setText("");
        valor.setText("");
        nome.setText("");
        id.setText("");
        pesquisa.setText("");
    }//GEN-LAST:event_novoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        nome.setText("");
        id.setText("");
        quantidade.setText("");
        valor.setText("");
        quantidade.setEnabled(false);
        valor.setEnabled(false);
        salvar.setEnabled(false);
        cancelar.setEnabled(false);
        nome.setEnabled(false);
        novo.setEnabled(true);
        pesquisa.setEnabled(true);
        pesquisar.setEnabled(true);
    }//GEN-LAST:event_cancelarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        flag = 2;
        salvar.setEnabled(true);
        cancelar.setEnabled(true);
        nome.setEnabled(true);
        valor.setEnabled(true);
        quantidade.setEnabled(true);
        novo.setEnabled(false);
        pesquisa.setEnabled(false);
        pesquisar.setEnabled(false);
        editar.setEnabled(false);
        excluir.setEnabled(false);
        pesquisa.setText("");
    }//GEN-LAST:event_editarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        if (flag == 1) {
            if (nome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha nome para continuar");
                nome.requestFocus();
            } else if (valor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha pre??o de venda para continuar");
                valor.requestFocus();
            } else if (quantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha quantidade para continuar");
                quantidade.requestFocus();
            } else {
                try {
                    conex.conexao();
                    conex.executaSql("select *from produtos where nome_produto='" + nome.getText() + "'");
                    conex.rs.first();
                    String testanome = conex.rs.getString("nome_produto");
                    if (testanome.equals(nome.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "Produto com mesmo nome ja cadastrado");
                        nome.requestFocus();
                    } else {
                        mod.setNomeProduto(nome.getText());
                        mod.setPrecoCompra(Float.parseFloat(valor.getText().replace(",", ".")));
                        mod.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
                        control.Salvar(mod);
                        nome.setText("");
                        id.setText("");
                        quantidade.setText("");
                        valor.setText("");
                        quantidade.setEnabled(false);
                        valor.setEnabled(false);
                        salvar.setEnabled(false);
                        cancelar.setEnabled(false);
                        nome.setEnabled(false);
                        novo.setEnabled(true);
                        pesquisa.setEnabled(true);
                        pesquisar.setEnabled(true);
                        preencherTabela("select *from produtos order by nome_produto");
                    }
                } catch (SQLException ex) {
                    mod.setNomeProduto(nome.getText());
                    mod.setPrecoCompra(Float.parseFloat(valor.getText().replace(",", ".")));
                    mod.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
                    control.Salvar(mod);
                    nome.setText("");
                    id.setText("");
                    quantidade.setText("");
                    valor.setText("");
                    quantidade.setEnabled(false);
                    valor.setEnabled(false);
                    salvar.setEnabled(false);
                    cancelar.setEnabled(false);
                    nome.setEnabled(false);
                    novo.setEnabled(true);
                    pesquisa.setEnabled(true);
                    pesquisar.setEnabled(true);
                    preencherTabela("select *from produtos order by nome_produto");
                }
            }
        } else {
            try {
                conex.conexao();
                conex.executaSql("select *from produtos where nome_produto='" + nome.getText() + "'");
                conex.rs.first();
                String testanome = conex.rs.getString("nome_produto");
                if (testanome.equals(nome.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Produto com mesmo nome ja cadastrado");
                    nome.requestFocus();
                } else {
                    mod.setIdProduto((Integer.parseInt(id.getText())));
                    mod.setNomeProduto(nome.getText());
                    mod.setPrecoCompra(Float.parseFloat(valor.getText().replace(",", ".")));
                    mod.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
                    control.Editar(mod);
                    nome.setText("");
                    id.setText("");
                    quantidade.setText("");
                    valor.setText("");
                    quantidade.setEnabled(false);
                    valor.setEnabled(false);
                    salvar.setEnabled(false);
                    cancelar.setEnabled(false);
                    nome.setEnabled(false);
                    novo.setEnabled(true);
                    pesquisa.setEnabled(true);
                    pesquisar.setEnabled(true);
                    preencherTabela("select *from produtos order by nome_produto");
                }
            } catch (SQLException ex) {
                mod.setIdProduto((Integer.parseInt(id.getText())));
                mod.setNomeProduto(nome.getText());
                mod.setPrecoCompra(Float.parseFloat(valor.getText().replace(",", ".")));
                mod.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
                control.Editar(mod);
                nome.setText("");
                id.setText("");
                quantidade.setText("");
                valor.setText("");
                quantidade.setEnabled(false);
                valor.setEnabled(false);
                salvar.setEnabled(false);
                cancelar.setEnabled(false);
                nome.setEnabled(false);
                novo.setEnabled(true);
                pesquisa.setEnabled(true);
                pesquisar.setEnabled(true);
                preencherTabela("select *from produtos order by nome_produto");
            }
        }
        conex.desconecta();
    }//GEN-LAST:event_salvarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        mod.setPesquisa(pesquisa.getText());
        ModeloEstoque model = control.Busca(mod);
        id.setText(String.valueOf(model.getIdProduto()));
        nome.setText(model.getNomeProduto());
        valor.setText(String.valueOf(model.getPrecoCompra()));
        quantidade.setText(String.valueOf(model.getQuantidadeProduto()));
        editar.setEnabled(true);
        excluir.setEnabled(true);
        preencherTabela("select *from produtos where nome_produto like'%" + mod.getPesquisa() + "%'");
        nome.setText("");
        id.setText("");
        quantidade.setText("");
        valor.setText("");
        pesquisa.setText("");
    }//GEN-LAST:event_pesquisarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir este produto?", "Excluir", resposta);
        if (resposta == JOptionPane.YES_OPTION) {
            mod.setIdProduto(Integer.parseInt(id.getText()));
            control.Excluir(mod);
            nome.setText("");
            id.setText("");
            quantidade.setText("");
            valor.setText("");
            pesquisa.setText("");
            quantidade.setEnabled(false);
            valor.setEnabled(false);
            salvar.setEnabled(false);
            cancelar.setEnabled(false);
            nome.setEnabled(false);
            novo.setEnabled(true);
            pesquisa.setEnabled(true);
            pesquisar.setEnabled(true);
            excluir.setEnabled(false);
            editar.setEnabled(false);
            preencherTabela("select *from produtos order by nome_produto");
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        id.setText("");
        nome.setText("");
        quantidade.setText("");
        valor.setText("");
        quantidade.setEnabled(false);
        valor.setEnabled(false);
        salvar.setEnabled(false);
        cancelar.setEnabled(false);
        nome.setEnabled(false);
        novo.setEnabled(true);
        pesquisa.setEnabled(true);
        pesquisar.setEnabled(true);
        editar.setEnabled(true);
        excluir.setEnabled(true);
        String id_produto = "" + tabela.getValueAt(tabela.getSelectedRow(), 0);
        conex.conexao();
        conex.executaSql("select *from produtos where id_produto='" + id_produto + "'");
        try {
            conex.rs.first();
            id.setText(String.valueOf(conex.rs.getInt("id_produto")));
            nome.setText(conex.rs.getString("nome_produto"));
            quantidade.setText(String.valueOf(conex.rs.getInt("quantidade_produto")));
            valor.setText(String.valueOf(conex.rs.getFloat("preco_produto")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar cliente" + ex);
        }
        conex.desconecta();
    }//GEN-LAST:event_tabelaMouseClicked

    private void quantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_quantidadeKeyTyped

    public void preencherTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Pre??o de Venda", "Quantidade"};
        conex.conexao();
        conex.executaSql(Sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("id_produto"), conex.rs.getString("nome_produto"), conex.rs.getFloat("preco_produto"), conex.rs.getInt("quantidade_produto")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Busque por outro produto para preencher tabela");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(59);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(505);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(275);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editar;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField quantidade;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
