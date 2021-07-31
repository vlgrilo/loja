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
import modelo.ModeloCliente;

/**
 *
 * @author Victor
 */
public class ControleCliente {
    ConectaBanco conex = new ConectaBanco();
    ModeloCliente mod = new ModeloCliente();
    
    public void Salvar(ModeloCliente mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into clientes (nome_cliente, endereco_cliente, complemento_cliente, bairro_cliente, cidade_cliente, cep_cliente, telefone_cliente, celular_cliente) values(?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getEndereco());
            pst.setString(3,mod.getComplemento());
            pst.setString(4,mod.getCidade());
            pst.setString(5,mod.getBairro());
            pst.setString(6,mod.getCep());
            pst.setString(7,mod.getTelefone());
            pst.setString(8,mod.getCelular());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar cliente\nErro: "+ex);
        }
        conex.desconecta();
    }
    
    public void Editar(ModeloCliente mod){
       conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update clientes set nome_cliente=?, endereco_cliente=?, complemento_cliente=?, bairro_cliente=?, cidade_cliente=?, cep_cliente=?, telefone_cliente=?, celular_cliente=? where id_cliente=?");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getEndereco());
            pst.setString(3,mod.getComplemento());
            pst.setString(4,mod.getCidade());
            pst.setString(5,mod.getBairro());
            pst.setString(6,mod.getCep());
            pst.setString(7,mod.getTelefone());
            pst.setString(8,mod.getCelular());
            pst.setInt(9,mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração do cliente\nErro: "+ex);
        }   
       conex.desconecta();
    }
    
    public void Excluir (ModeloCliente mod){
        conex.conexao();        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from clientes where id_cliente=?");
            pst.setInt(1,mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cliente excluido com sucasso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir cliente\nErro: "+ex);
        }
        conex.desconecta();
    }
    
    public ModeloCliente buscaCliente(ModeloCliente mod){
        conex.conexao();
        conex.executaSql("select *from clientes where nome_cliente like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setId(conex.rs.getInt("id_cliente"));
            mod.setNome(conex.rs.getString("nome_cliente"));
            mod.setEndereco(conex.rs.getString("endereco_cliente"));
            mod.setComplemento(conex.rs.getString("complemento_cliente"));
            mod.setCidade(conex.rs.getString("cidade_cliente"));
            mod.setBairro(conex.rs.getString("bairro_cliente"));
            mod.setCep(conex.rs.getString("cep_cliente"));
            mod.setTelefone(conex.rs.getString("telefone_cliente"));
            mod.setCelular(conex.rs.getString("celular_cliente"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar cliente\nCliente não cadastrado");
        }
        conex.desconecta();
        return mod;
    }
}
