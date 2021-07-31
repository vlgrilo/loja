/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConectaBanco;
import modelo.ModeloVenda;

/**
 *
 * @author Victor
 */
public class ControleVenda {

    int codProd, codCliente;

    ConectaBanco conex = new ConectaBanco();

    public void adicionaItem(ModeloVenda mod) {
        achaCodProduto(mod.getNomeProduto());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into itens_venda_produto(id_venda, id_produto, quantidade) values(?, ?, ?)");
            pst.setInt(1, mod.getIdVenda());
            pst.setInt(2, codProd);
            pst.setInt(3, mod.getQuantidadeItem());
            pst.execute();
            //baixa de estoque
            int quant = 0, resul = 0;
            conex.executaSql("select *from produtos where nome_produto = '" + mod.getNomeProduto() + "'");
            conex.rs.first();
            quant = conex.rs.getInt("quantidade_produto");
            resul = quant - mod.getQuantidadeItem();
            pst = conex.con.prepareStatement("update produtos set quantidade_produto=? where nome_produto=?");
            pst.setInt(1, resul);
            pst.setString(2, mod.getNomeProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto adicionado");
            conex.desconecta();
        } catch (SQLException ex) {
            attItem(mod);
            conex.desconecta();
            //JOptionPane.showMessageDialog(null, "Erro ao adicionar produto: Produto ja adicionado!");
        }
    }

    public void attItem(ModeloVenda mod) {
        achaCodProduto(mod.getNomeProduto());
        conex.conexao();
        try {
            conex.executaSql("select *from produtos where id_produto = '" + codProd + "'");
            conex.rs.first();
            int qtdestoque = conex.rs.getInt("quantidade_produto");
            System.out.println("" + qtdestoque);

            conex.executaSql("select *from itens_venda_produto where id_produto = '" + codProd + "' and id_venda= '" + mod.getIdVenda() + "' ");
            conex.rs.first();
            int qtdvenda = conex.rs.getInt("quantidade");
            System.out.println("" + qtdvenda);

            int totalprod = qtdestoque + qtdvenda;

            PreparedStatement pst = conex.con.prepareStatement("update produtos set quantidade_produto=? where id_produto=?");
            pst.setInt(1, totalprod);
            pst.setInt(2, codProd);
            pst.execute();

            pst = conex.con.prepareStatement("update itens_venda_produto set quantidade=? where id_venda=? and id_produto=?");
            pst.setInt(1, mod.getQuantidadeItem());
            pst.setInt(2, mod.getIdVenda());
            pst.setInt(3, codProd);
            pst.execute();

            // DAR BAIXA NOVAMENTE
            int resul = totalprod - mod.getQuantidadeItem();
            pst = conex.con.prepareStatement("update produtos set quantidade_produto=? where id_produto=?");
            pst.setInt(1, resul);
            pst.setInt(2, codProd);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto atualizado");
            conex.desconecta();
        } catch (SQLException ex) {
            conex.desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto: Produto ja adicionado!");
        }
    }

    public void removeItem(ModeloVenda mod) {
        achaCodProduto(mod.getNomeProduto());
        conex.conexao();
        try {
            conex.executaSql("select *from produtos where id_produto = '" + codProd + "'");
            conex.rs.first();
            int qtdestoque = conex.rs.getInt("quantidade_produto");
            System.out.println("" + qtdestoque);

            conex.executaSql("select *from itens_venda_produto where id_produto = '" + codProd + "' and id_venda= '" + mod.getIdVenda() + "' ");
            conex.rs.first();
            int qtdvenda = conex.rs.getInt("quantidade");
            System.out.println("" + qtdvenda);

            int totalprod = qtdestoque + qtdvenda;

            PreparedStatement pst = conex.con.prepareStatement("update produtos set quantidade_produto=? where id_produto=?");
            pst.setInt(1, totalprod);
            pst.setInt(2, codProd);
            pst.execute();

            pst = conex.con.prepareStatement("delete from itens_venda_produto where id_venda=? and id_produto=?");
            pst.setInt(1, mod.getIdVenda());
            pst.setInt(2, codProd);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
            conex.desconecta();
        } catch (SQLException ex) {
            conex.desconecta();
            //JOptionPane.showMessageDialog(null, "Erro ao adicionar produto: Produto ja adicionado!");
        }
    }

    public void achaCodProduto(String nome) {
        conex.conexao();
        conex.executaSql("select *from produtos where nome_produto ='" + nome + "'");
        try {
            conex.rs.first();
            codProd = conex.rs.getInt("id_produto");
            conex.desconecta();
        } catch (SQLException ex) {
            conex.desconecta();
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }

    public void FechaVenda(ModeloVenda mod) {

        AchaCliente(mod.getNomeCliente());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update venda set valor_venda=?, id_cliente=? where id_venda=?");
            pst.setFloat(1, mod.getValorVenda());
            pst.setInt(2, codCliente);
            pst.setInt(3, mod.getIdVenda());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda finalizada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a venda\nErro: " + ex);
        }
        conex.desconecta();
    }

    public void AchaCliente(String nome) {
        conex.conexao();
        try {
            conex.executaSql("select *from clientes where nome_cliente= '" + nome + "'");
            conex.rs.first();
            codCliente = conex.rs.getInt("id_cliente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao achar cliente\nErro: " + ex);
        }
        conex.desconecta();
    }

    public void CancelaVenda() {
        conex.conexao();
        PreparedStatement pst;
        conex.executaSql("select *from venda inner join itens_venda_produto "
                + "on venda.id_venda = itens_venda_produto.id_venda inner join produtos "
                + "on itens_venda_produto.id_produto = produtos.id_produto where valor_venda = 0");
        try {
            conex.rs.first();
            do {
                int qtdProd = conex.rs.getInt("quantidade_produto");
                int qtdVend = conex.rs.getInt("quantidade");
                int soma = qtdProd + qtdVend;
                pst = conex.con.prepareStatement("update produtos set quantidade_produto=? where id_produto=?");
                pst.setInt(1, soma);
                pst.setInt(2, conex.rs.getInt("id_produto"));
                pst.execute();
                pst = conex.con.prepareStatement("delete from itens_venda_produto where id_venda=?");
                pst.setInt(1, conex.rs.getInt("id_venda"));
                pst.execute();
            } while (conex.rs.next());
            pst = conex.con.prepareStatement("delete from venda where valor_venda=?");
            pst.setInt(1, 0);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso");
        }
        conex.desconecta();
    }
}
