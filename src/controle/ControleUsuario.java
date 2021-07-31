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
import modelo.ModeloUsuario;

/**
 *
 * @author Victor
 */
public class ControleUsuario {

    ConectaBanco conex = new ConectaBanco();
    ModeloUsuario mod = new ModeloUsuario();

    public void Salvar(ModeloUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into login (nome, login, senha) values(?, ?, ?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario\nErro: " + ex);
        }
        conex.desconecta();
    }

    public void Admin(ModeloUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into login (nome, login, senha, adm) values(?, ?, ?, ?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setString(4, mod.getAdm());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario\nErro: " + ex);
        }
        conex.desconecta();
    }

    public void Editar(ModeloUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update login set nome=?, login=?, senha=? where id_login=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setInt(4, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do usuario\nErro: " + ex);
        }
        conex.desconecta();
    }

    public void Excluir(ModeloUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from login where id_login=?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario excluido com sucasso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuario\nErro: " + ex);
        }
        conex.desconecta();
    }

    public ModeloUsuario Busca(ModeloUsuario mod) {
        conex.conexao();
        conex.executaSql("select *from login where nome like '%" + mod.getPesquisa() + "%'");
        try {
            conex.rs.first();
            mod.setId(conex.rs.getInt("id_login"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setLogin(conex.rs.getString("login"));
            mod.setSenha(conex.rs.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuario\nUsuario não cadastrado");
        }
        conex.desconecta();
        return mod;
    }
}
