/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import controlador.Cadastro;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */


@Stateless
public class CadastroDAO {
    
    
    
    
    public void Cadastro(Cadastro cadastro){
      Connection con = ConnectionFactory.getConexao();
      PreparedStatement ps=null;
      String sql = "INSERT INTO chamados (patrimonio, status, ajuda, dataini, datafec) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(cadastro.getPatrimonio()));
            ps.setString(2, cadastro.getStatus());
            ps.setString(3, cadastro.getAjuda());
            ps.setString(4, cadastro.getDataIni());
            ps.setNull(5, java.sql.Types.NULL);
            
            
            ps.executeUpdate();
            
                       
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
         ConnectionFactory.closeConexao(con,ps);
        }
        
        
    }
    
}

