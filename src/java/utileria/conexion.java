/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utileria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mary
 */
public class conexion {

       public Connection SQLServer(){
       Connection con=null;

        try {
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=usuarios;user=sa;password=Passw0rd06;");

            }//termina try
                   catch (SQLException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }//termina catch
                   catch (ClassNotFoundException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }//termina catch
       return con;
       }
       
       public Connection oracled(){
       Connection con=null;

        try {
                 Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "USUARIOS", "SYSTEM");

            }//termina try
                   catch (SQLException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }//termina catch
                   catch (ClassNotFoundException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }//termina catch
       return con;
       }
       
              public Connection mySql(){
       Connection con=null;

        try {
                 Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/usuarios", "root", "root");

            }//termina try
                   catch (SQLException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }//termina catch
                   catch (ClassNotFoundException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }//termina catch
       return con;
       }
       
}
