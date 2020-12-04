/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utl.idgs702.prestamosutl.datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Carrizal
 */
public class Conexion 
{
    private Connection conn;
    private String userName;
    private String password;
    private String url; //3306 local host mysql
    
    public Conexion(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/inventariosutl?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
            userName = "root";
            password = "root";
            
        }
        catch (Exception e)
        {            
            throw new RuntimeException(e);
        }
    }
    
    public Connection getConn(){
        return conn;
    }
    
    public Connection abrir() throws Exception{
        conn = DriverManager.getConnection(url,userName,password );
                return conn;
    }
    
    public void cerrar(){
        try
        {
            if (conn != null)
            {
                conn.close();
                conn = null;
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
