<%@page import="beans.InsertarDatos"%>
<%@page import="beans.Sql"%>
<%@page import="java.sql.ResultSet"%>
<%

InsertarDatos insertarDatos = new InsertarDatos();

Sql SqlServer = new Sql("sqlserver");

Sql MySql = new Sql("mysql");

Sql oracled = new Sql("oracled");

insertarDatos.tipos_claves(SqlServer, MySql);
insertarDatos.tipos_claves(SqlServer, oracled);

insertarDatos.tipos_claves(MySql, oracled);
insertarDatos.tipos_claves(MySql, SqlServer);

insertarDatos.tipos_claves(oracled,SqlServer);
insertarDatos.tipos_claves(oracled, MySql);

    
    SqlServer.closeConexion();
    MySql.closeConexion();
    
    /*

 * ResultSet rs = null;
    Sql miSql = new Sql("sqlserver");
    
    rs = miSql.SelecionaTodoTablaTiposClaves();
    
    int id = miSql.InsertarTiposClaves("xxx", "xxx", "xxxx");
    
    out.println(id+ "<br>");
    
    boolean buscarUsu = miSql.buscarUsuIdentico("carlos", "2", "invitado");
    
    out.println(buscarUsu+ "<br>");
    
    while(rs.next()){
        out.println("id de usuario: "+rs.getObject("id")+" nombre usuario:"+rs.getObject("usuario")+" clave usuario: "+rs.getObject("clave")+" tipo usuario: "+rs.getObject("tipo")+"<br>");
    }
    
    rs.close();
    miSql.closeConexion();

    */

    
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
