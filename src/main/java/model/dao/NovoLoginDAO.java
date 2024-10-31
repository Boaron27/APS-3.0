package model.dao;

import connection.ConnectionFactory;

import controlador.NovoLogin;
import controlador.NovoLoginBean;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
@Stateless
public class NovoLoginDAO {
    
    
    
    public void novoLogin(NovoLogin novoLogin){
      Connection con = ConnectionFactory.getConexao();
      PreparedStatement ps = null; 
        try {
            ps = con.prepareStatement("INSERT INTO usuario(nome,email,senha,cargo,departamento) VALUES(?,?,?,?,?)");
            ps.setString(1,novoLogin.getNome());
            ps.setString(2,novoLogin.getEmail());
            ps.setString(3,novoLogin.getSenha());
            ps.setString(4,novoLogin.getCargo());
            ps.setString(5,novoLogin.getDepartamento());
            
            
            ps.executeUpdate();
            
                       
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
         ConnectionFactory.closeConexao(con,ps);
        }
        
    }
     public boolean logar (String email, String senha){
        
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt=con.prepareStatement("SELECT * FROM usuario WHERE email=? and senha=?;");
            stmt.setString(1, email);
            stmt.setString(2,senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConexao(con,stmt,rs);
        }
        return check;
    }
    
}