/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ConectaBanco {
   
    public Statement stm;   //prepara e realiza pesquisa no banco de dados
    public ResultSet rs;    //armazena o resultado de uma pesquisa passada para o statement 
    public Connection con; //realiza a conexão com o banco de dados 
    private String driver = "org.postgresql.Driver";    //identifica o serviço de banco de dados
    private String caminho = "jdbc:postgresql://localhost:5432/loja";   //seta o local do banco de dados
    private String usuario = "postgres";    //usuario postgresql
    private String senha = "victor";    //senha postgresql
    
    public void conexao(){  //realiza conexão com o banco de dados
        try {
            System.setProperty("jdbc.Drivers", driver); //seta propriedade do driver de conexão
            con = DriverManager.getConnection(caminho, usuario, senha);    //realiza a conexão com o banco de dados
            //JOptionPane.showMessageDialog(null,"Conectado com Sucesso");    
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro de Conexão\nErro: "+ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro executar sql"+ex);
        }        
    }
        
    public void desconecta(){   //metodo para fechar a conexãp cpm banco de dados
        try {
            con.close();   //fecha a conexão
            //JOptionPane.showMessageDialog(null,"Desconectado com Sucesso");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao fechar conexão com BD:\n"+ex.getMessage());
        }
    }
}
