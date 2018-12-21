/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconn;

import java.sql.*;
import java.util.Scanner;

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
        System.out.println("Who are you looking for?\n");
        Scanner scan = new Scanner(System.in);
        String string = scan.next();
        checkDatabaseFor(string);
    }
    private static void checkDatabaseFor(String input){
        String sql = "SELECT * FROM lookAtThisMate WHERE strings = '" + input + "'";
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            String id = rs.getString("ID");
            System.out.println(id);
            }
        con.close();
        }
        catch(Exception e){
            System.out.println(e);}
    }
    
}
