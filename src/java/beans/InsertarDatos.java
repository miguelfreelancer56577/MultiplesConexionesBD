
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InsertarDatos {
        
    ResultSet rs = null;
    
    public void tipos_claves(Sql bd,Sql filas){
        try {
                        
            //recoje todos los usuarios de la base de datos que se van a almacenar
            rs = filas.SelecionaTodoTablaTiposClaves();
            
            //verifica que los datos de la segunda bd no se repitan en la primera
            while(rs.next()){
                //busca el usuario en la Primner gestor
                boolean busqueda = bd.buscarUsuIdentico(""+rs.getObject("usuario"), ""+rs.getObject("clave"), ""+rs.getObject("tipo"));
                // si el usuario no existe en la bd lo inserta en el primer gestor
                if(busqueda == false){
                   //inserta los datos en el primer gestor de bd
                    bd.InsertarTiposClaves(""+rs.getObject("usuario"), ""+rs.getObject("clave"), ""+rs.getObject("tipo"));
               } 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    
}
