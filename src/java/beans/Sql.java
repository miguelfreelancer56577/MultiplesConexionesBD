/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utileria.conexion;

/**
 *
 * @author Administrador
 */
public class Sql implements Serializable {
    
    private  conexion con=new conexion();//se crea una instancia
    private  Connection micon= null;
    private  PreparedStatement st=null;
    private  ResultSet rs=null;
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public Sql(String sgbd) {
        propertySupport = new PropertyChangeSupport(this);
        
        if( sgbd.equalsIgnoreCase("mysql") ){
            micon = con.mySql();
        }else if( sgbd.equalsIgnoreCase("sqlserver") ){
            micon = con.SQLServer();
        }else if( sgbd.equalsIgnoreCase("oracled") ){
            micon = con.oracled();
        }
        
    }
    
    public ResultSet SelecionaTodoTablaTiposClaves() throws SQLException{
        try {            
            st = micon.prepareStatement("select * from tipos_claves");
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs = st.executeQuery();
        
    }//SelectAllSocio
    
    public boolean buscarUsuIdentico(String usuario, String clave, String tipo){
        
        boolean usu = false;
        
        try {         
            st = micon.prepareStatement("SELECT * FROM tipos_claves where usuario='"+usuario+"' and clave='"+clave+"' and tipo='"+tipo+"'");
            rs = st.executeQuery();
            if(rs.next()){
                usu = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }// termina la funcion buscarUsuIdentico
    
    public int InsertarTiposClaves(String usuario,String clave, String tipo) throws SQLException{
        int executeUpdate = 0;
        try {
            
            st = micon.prepareStatement("insert into tipos_claves(usuario,clave,tipo) values('"+usuario+"', '"+clave+"', '"+tipo+"')");
            
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return executeUpdate = st.executeUpdate();

    }//Insertar datos en la tabla tipos_claves
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public void closeConexion(){
        try {      
            micon.close();
            st.close();
            rs.close();
        } //closeConexionSocio
        catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//closeConexionSocio
    
}
