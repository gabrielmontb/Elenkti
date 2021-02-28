package controller;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Montserrat
 */
public class UsuarioDAO {
     public void create(Usuario u){
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (matricula,nome,telefone,observacao) VALUES (?,?,?,?)");
           // stmt.setInt(1, (int) u.getID());
            stmt.setInt(1,u.getMatricula());
            stmt.setString(2,u.getNome());            
            stmt.setInt(3, u.getTelefone());
            stmt.setString(4, u.getObservacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     public void update(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuario SET telefone = ?, observacao = ? WHERE matricula = ?");
            stmt.setInt(1,u.getTelefone());
            stmt.setString(2, u.getObservacao());  
            stmt.setInt(3,u.getMatricula());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     public void delete(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE matricula = ?");              
            stmt.setInt(1,u.getMatricula());            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     public Usuario read(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;       
        Usuario usuario = new Usuario();         
        try{
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE ? = matricula"); 
            stmt.setInt(1, u.getMatricula());            
            rs = stmt.executeQuery();  
            while(rs.next()){                
                 usuario.setMatricula(rs.getInt("matricula"));            
                 usuario.setNome(rs.getString("nome"));                 
                 usuario.setObservacao(rs.getString("observacao"));    
                 usuario.setTelefone(rs.getInt("telefone")); 
            }          
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Procurar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }             
        return usuario;
    }
     public List<Usuario> read_all(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        
        List<Usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setMatricula(rs.getInt("matricula"));
                usuario.setNome(rs.getString("nome"));                 
                usuario.setObservacao(rs.getString("observacao"));    
                usuario.setTelefone(rs.getInt("telefone"));
                usuarios.add(usuario);           
                
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);            
        }        
        return usuarios;       
    }
    
     
}
