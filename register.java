import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

or

package hotel;

import java.sql.*;
import javax.swing.*;




public class Register extends javax.swing.JFrame {
    private String sql;
    private Connection con;
    private ResultSet rs;
    private Statement stat;
    private Koneksi kon = new Koneksi();
    private Encrypt enc = new Encrypt();
 
 
 
 /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        setLocationRelativeTo(this);
        
       
        con = kon.con;
        stat = kon.stat;
        this.setTitle("Register");
        jTextField1.requestFocus();
    }
 
 
 
 
 if(jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jPasswordField1.getText().isEmpty() || jPasswordField2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else if(jPasswordField1.getText().length() < 7 || jPasswordField2.getText().length() < 7){
            JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else if(jTextField2.getText().length() <= 10){
            JOptionPane.showMessageDialog(null, "No.Telpon minimal terdiri dari 10 angka","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                String pass;
                pass = enc.getMD5EncryptedValue(jPasswordField2.getText());
                
                sql = "SELECT * FROM tb_masyarakat WHERE username='"+ jTextField3.getText() +"'";
                rs = stat.executeQuery(sql);
            
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Username sudah terdaftar","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    sql = "INSERT INTO tb_masyarakat VALUES ("+ null +", '"+ jTextField1.getText() +"', '"+ jTextField3.getText() +"', '"+ pass +"', '"+ jTextField2.getText() +"')";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Berhasi mendaftar, silahkan login!");

                    new Login().show();
                    this.dispose();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }



private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        new Login().show();
        this.dispose();
    }







............................................
String user         = jTextField1.getText();
 
 String password     = jPasswordField1.getText();
 
 
 
 String cekuser      = null;
 
 try {
 
 Connection Connect = koneksiuhuy.getKoneksi();
 
 Statement st = (Statement) Connect.createStatement();
 
 String query = "SELECT username FROM register WHERE username = '"+jTextField1.getText()+"' "
 
 + " and password = '"+jPasswordField1.getText()+"'";
 
 ResultSet rs = st.executeQuery(query);
 
 while(rs.next()){
 
 cekuser = rs.getString("username, password");
 
 }
 
 rs.close();
 
 st.close();
 
 } catch (SQLException e){
 
 System.out.println("Error");
 
 }
 
 if(cekuser!=null){
 
 String pesan = "Username Sudah Terdaftar, Ganti Yang lain !";
 
 JOptionPane.showMessageDialog(null,pesan,"Kesalahan",
 
 JOptionPane.INFORMATION_MESSAGE);
 
 }
 
 {
 
 String pesan2 = "Password Tidak Cocok";
 
 JOptionPane.showMessageDialog(null,pesan2,"Kesalahan",
 
 JOptionPane.INFORMATION_MESSAGE);
 
 {
 
 try {
 
 Connection Connect = koneksiuhuy.getKoneksi();
 
 String query = "INSERT INTO register VALUES ('"+jTextField1.getText()+"', '"+jPasswordField1.getText()+"')";
 
 PreparedStatement ps = (PreparedStatement) Connect.prepareStatement(query);
 
 ps.executeUpdate(query);
 
 
 
 String pesan3 = "AKUN ANDA BERHASIL TERDAFTAR";
 
 JOptionPane.showMessageDialog(null,pesan3,"BERHASIL",
 
 JOptionPane.INFORMATION_MESSAGE);
 
 dispose();
 
 new lomgin().setVisible(true);
 
 } catch (SQLException e){
 
 
 
 }
 }
   
   
 }


}
