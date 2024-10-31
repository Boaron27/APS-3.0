package connection;

import jakarta.ejb.Startup;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


@Startup
public class ConnectionFactory {
    
    
    private static final String DRIVER="org.postgresql.Driver";
    private static final String url="jdbc:postgresql://localhost:5432/dbaps3";
    private static final String user = "postgres";
    private static final String password = "root";
    
    
    
    public static Connection getConexao(){
        
        try{
            Class.forName(DRIVER);
            
             return DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException ex){
            
            throw new RuntimeException("Erro de conexão", ex);
 
        }
    }
        public static void closeConexao(Connection con){
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public static void closeConexao(Connection con, PreparedStatement stmt){
        closeConexao(con);
            try {
                if (stmt !=null) {
                    stmt.close();
                }      
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
    public static void closeConexao(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConexao(con,stmt);
            try {
                if (rs !=null) {
                    rs.close();
                }      
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
    
}