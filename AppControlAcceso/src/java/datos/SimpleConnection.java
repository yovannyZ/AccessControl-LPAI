/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrador
 */
public class SimpleConnection {
    
    public static Connection cn=null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=dbPrueba;User=sa;Password=Developer2016");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
    
}
