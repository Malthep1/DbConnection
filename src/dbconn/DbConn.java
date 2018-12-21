/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconn;

import java.sql.*;

/**
 *
 * @author Malth
 */
public class DbConn {

    private static Connection  con;
    
    public static void OpenConnection() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("");
            String url = "jdbc:sqlserver://mssql7.gear.host:1433;databaseName=danknok;user=danknok;password=Bo2H4FE_6?Rw;";
            con  = DriverManager.getConnection(url);
            System.out.println("Connection completed");
        }
        catch(Exception e){
            System.out.println(e);}
    }
    
    public static void main(String[] args) {
        OpenConnection();
    }
    
}
