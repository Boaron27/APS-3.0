package model.dao;

import connection.ConnectionFactory;

import controlador.Conta;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
@Stateless
public class ContaDAO {
    
    
    
    public void Conta(Conta conta){
        
        
        
        
        try (Connection con =ConnectionFactory.getConexao()
                ;PreparedStatement ps = con.prepareStatement("INSERT INTO conta(email,senha) VALUES(?,?)")){

            ps.setString(1,conta.getEmail());
            ps.setString(2,conta.getSenha());

            
            
            ps.executeUpdate();
            
                       
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
}