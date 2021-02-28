package controller;

import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Equipamento;

/**
 *
 * @author Gabriel Montserrat
 */
public class EquipamentoDAO {
    
    public void create(Equipamento eq){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO equipamento (descricao,id,nome,sala) VALUES (?,?,?,?)");
            stmt.setString(1, eq.getDescricao());
            stmt.setInt(2, (int) eq.getId());
            stmt.setString(3, eq.getNome());
            stmt.setInt(4, eq.getSala());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void update(Equipamento e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE equipamento SET nome = ?, sala = ?, descricao = ? WHERE ID = ?");
            stmt.setString(1,e.getNome());
            stmt.setInt(2,e.getSala());
            stmt.setString(3,e.getDescricao());  
            stmt.setLong(4,e.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     public void delete(Equipamento e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM equipamento WHERE id = ?");              
            stmt.setInt(1, (int) e.getId());            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public Equipamento read(Equipamento e){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;       
        Equipamento equipamento = new Equipamento();
        try{
            stmt = con.prepareStatement("SELECT * FROM equipamento WHERE ? = ID"); 
            stmt.setLong(1,e.getId());            
            rs = stmt.executeQuery();               
            while(rs.next()){
                 equipamento.setId(rs.getInt("ID"));            
                 equipamento.setNome(rs.getString("nome"));                 
                 equipamento.setDescricao(rs.getString("descricao"));    
                 equipamento.setSala(rs.getInt("sala")); 
            }          
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Procurar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }             
        return equipamento;
    }
    public List<Equipamento> read_all(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        
        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM equipamento");
            rs = stmt.executeQuery();            
            while(rs.next()){
                Equipamento equipamento = new Equipamento();
                equipamento.setId(rs.getInt("ID"));
                equipamento.setNome(rs.getString("nome"));                 
                equipamento.setDescricao(rs.getString("descricao"));    
                equipamento.setSala(rs.getInt("sala"));
                equipamentos.add(equipamento);           
                
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);            
        }        
        return equipamentos;       
    }
}
