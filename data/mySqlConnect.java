/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication.data;

import java.sql.*;
import jfx.messagebox.MessageBox;


/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class mySqlConnect {
    // cadena de conexion
    private Connection connect;
    // nombre de la base de datos
    private final String DbName;
    // servidor de base de datos
    private final String Server;
    // usuario con acceso a los datos
    private final String User;
    // contraseña del usuario
    private final String Password;
    
    /** Creates a new instance of BasedeDatos
     * @param server
     * @param dbName
     * @param user
     * @param password */
public mySqlConnect(String server, String dbName, String user, String password) {
    this.DbName = dbName;
    this.Server = server;
    /* 
     * Ejemplo de Server
     * "jdbc:mysql://localhost/"
     */
    this.User = user;
    this.Password = password;
}
 
    /**
     * Establece una conexión
     */
    public void beginConnect(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection((Server+DbName),User,Password);
    }
    catch(ClassNotFoundException | SQLException e){
        System.out.println("Error al conectar con la base de datos, intentelo nuevamente...");
        String mensaje = "Error al conectar con la base de datos, intentelo nuevamente";
        MessageBox.show(null,mensaje,"Mensaje",MessageBox.ICON_INFORMATION| MessageBox.OK );
    }
}
 
    /**
     * Devuelve la conexión establecida
     * @return
     */
    public Connection getConnect(){
        return connect;
    }
 
    /**
     * Cierra un result set
     * @param rs
     */
    public void CloseRs(ResultSet rs){
        if(rs !=null){
            try{
                rs.close();
            }
            catch(SQLException e){
                System.out.print("No es posible cerrar la Conexion");
            }
        }
    }
 
    /**
     * Cierra una declaración (statement)
     * @param stmt
     */
    public void CloseStmt(java.sql.Statement stmt){
        if(stmt !=null){
            try{
                stmt.close();
            }
            catch(SQLException e){
                System.out.print("No es posible cerrar la Conexion");
            }
        }
    }
 
    /**
     * Cierra una conexión
     */
    public void Close(){
        if(connect !=null){
            try{
                connect.close();
            }
            catch(SQLException e){
                 System.out.print("No es posible cerrar la Conexion");
            }
        }
    }
    
}
