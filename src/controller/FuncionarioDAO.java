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
import model.Funcionario;

/**
 *
 * @author Gabriel Montserrat
 */
public class FuncionarioDAO {
    
    public void create(Funcionario f){ //Inserindo funcionário no Banco de Dados
        Connection con = ConnectionFactory.getConnection(); //Realizando conexão
        PreparedStatement stmt = null; //Criando variável para fazer a conversão dos parâmentros para o Banco
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (ID,nome,nivel,senha) VALUES (?,?,?,?)");
            //Comando para inserir no Banco
            stmt.setString(1,f.getID());
            //stmt.setString(2,f.getLogin());
            stmt.setString(2,f.getNome());
            stmt.setBoolean(3,f.getNivel());
            stmt.setString(4, f.getSenha());
            
            stmt.executeUpdate(); //Atualizando banco de dados
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void delete(Funcionario f){ // Excluindo funcionario do banco de dados
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE ID = ?");     //comando DELETE SQL          
            stmt.setString(1,f.getID()); //Passando ID do funcionário à ser excluído
            stmt.executeUpdate(); //Atualizando banco
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update(Funcionario f){ // Editando funcionário do Banco de dados
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nivel = ?, senha = ? WHERE id = ?");
            // Comando UPDATE, atualizando nível e senha do funcionário através de seu ID
            stmt.setBoolean(1,f.getNivel());
            stmt.setString(2, f.getSenha());  
            stmt.setString(3,f.getID());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        public Funcionario read(Funcionario f){ //Função para visualizar um único usuário
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;       
        Funcionario funcionario = new Funcionario();  //funcionário temporário para retornar dados      
        try{
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE ? = ID");  
            stmt.setString(1,f.getID()); //Procurando funcionário pelo seu ID            
            rs = stmt.executeQuery();  //ExecuteQuery retorna os resultados da consulta 
            while(rs.next()){ //Funcionario recebe os atributos em RS (executequery)
                 funcionario.setID(rs.getString("ID"));
                 //funcionario.setLogin(rs.getString("login"));            
                 funcionario.setNivel(rs.getBoolean("nivel"));
                 funcionario.setNome(rs.getString("nome"));
                 funcionario.setSenha(rs.getString("senha"));    
            }   
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Procurar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }             
        return funcionario; //retornando o resultado da consulta
    }
        public List<Funcionario> read_all(){ //retorna todos os funcionários do banco
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        
        List<Funcionario> funcionarios = new ArrayList<>(); //funcionarios recebe um array list
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario"); //seleciona todos os funcionarios do banco
            rs = stmt.executeQuery();            
            while(rs.next()){ //enquanto houver próximo funcionário, adcionar em funcionario
                Funcionario funcionario = new Funcionario();
                funcionario.setID(rs.getString("ID"));
                funcionario.setNome(rs.getString("nome"));   
                funcionario.setNivel(rs.getBoolean("nivel"));
                //funcionario.setLogin(rs.getString("login"));                
                funcionarios.add(funcionario); //adcionando funcionario no array list
                
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);            
        }
        
        return funcionarios;  //retornando funcionarios      
    }
        public boolean checkLogin(String login, String senha){ //função para verificar login e senha do usuário
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        boolean check = false;  // variável para retornar se verificação foi confirmada ou nao
        List<Funcionario> funcionarios = new ArrayList<>();        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE ID = ? AND senha = ?");
            //procura alguém que possui o login e a senha informados de acordo
            stmt.setString(1, login); 
            stmt.setString(2, senha);
            rs = stmt.executeQuery();            
            if(rs.next()){ //verifica se foi encontrado                
                 check = true; //variável de verificação é setada para TRUE, confirmando que foi encontrado
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);            
        }
        
        return check; //retorna true ou false            
       
    }
}
