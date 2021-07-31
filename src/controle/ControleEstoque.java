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
import modelo.ModeloEstoque;

/**
 *
 * @author Victor
 */
public class ControleEstoque {
    ModeloEstoque mod = new ModeloEstoque();
    ConectaBanco conex = new ConectaBanco();
    
    public void Salvar(ModeloEstoque mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into produtos (nome_produto, preco_produto, quantidade_produto) values (?, ?, ?)");
            pst.setString(1, mod.getNomeProduto());
            pst.setFloat(2, mod.getPrecoCompra());
            pst.setInt(3, mod.getQuantidadeProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar Produto\nErro: "+ex);
        }
        conex.desconecta();
    }
    
    public ModeloEstoque Busca(ModeloEstoque mod){
        conex.conexao();
        conex.executaSql("select *from produtos where nome_produto like '%" +mod.getPesquisa() + "%'");
        try {
            conex.rs.first();
            mod.setIdProduto(conex.rs.getInt("id_produto"));
            mod.setNomeProduto(conex.rs.getString("nome_produto"));
            mod.setPrecoCompra(conex.rs.getFloat("preco_produto"));
            mod.setQuantidadeProduto(conex.rs.getInt("quantidade_produto"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar produto\nProduto não cadastrado");
        }
        conex.desconecta();
        return mod;
    }
    
     public void Editar(ModeloEstoque mod){
       conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produtos set nome_produto=?, preco_produto=?, quantidade_produto=? where id_produto=?");
            pst.setString(1,mod.getNomeProduto());
            pst.setFloat(2,mod.getPrecoCompra());
            pst.setInt(3,mod.getQuantidadeProduto());
            pst.setInt(4,mod.getIdProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Produto alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração do produto\nErro: "+ex);
        }   
       conex.desconecta();
    }
     
      public void Excluir (ModeloEstoque mod){
        conex.conexao();        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from produtos where id_produto=?");
            pst.setInt(1,mod.getIdProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Produto excluido com sucasso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir Produto\nErro: "+ex);
        }
        conex.desconecta();
    }
}
