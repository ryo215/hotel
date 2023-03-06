package hotel;

import java.sql.*;
import javax.swing.*;


public class Koneksi {
    public Connection con;
    public Statement stat;
    
    private static final String DATABASE_NAME = "lelang";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
   
    public Koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
            stat = con.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
}















----------------------------
package mencobauhuy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class koneksiuhuy {
    private static Connection Connect;
    public static Connection conn;
    public static Statement st;
    public static Connection getKoneksi(){
        if(Connect == null){
            try{
                String url      =   "jdbc:mysql://localhost:3306/mencobauhuy";
                String username =   "root";
                String password =   "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Connect = DriverManager.getConnection(url, username,password);
                System.out.println("Koneksi Berhasil");
            }catch(SQLException e){
                System.out.println("Koneksi Gagal");
            }
        } return Connect;
    }

    static Connection getConnection() {
        if(Connect == null){
            try{
                String url      =   "jdbc:mysql://localhost:3306/mencobauhuy";
                String username =   "root";
                String password =   "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Connect = DriverManager.getConnection(url, username,password);
                System.out.println("Koneksi Berhasil");
            }catch(SQLException e){
                System.out.println("Koneksi Gagal");
            }
        } return Connect;
    } //To change body of generated methods, choose Tools | Templates.
    }
