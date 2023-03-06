package hotel;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import lelang.menu.*;



public class Login extends javax.swing.JFrame {
    private String sql;
    private ResultSet rs;
    private Connection con;
    private Statement stat;
    private Koneksi kon = new Koneksi();
    private UserSession session = new UserSession();
    private Encrypt enc = new Encrypt();
    private UserSession a;
    private List<UserSession> list;
        
        
        /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(this);
        
        con = kon.con;
        stat = kon.stat;
        this.setTitle("Login");
        jTextField1.requestFocus();
    }
        
        
        
        
        private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        new Register().show();
        this.dispose();
    }
        
        
        
        
        
        
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here
        if(jTextField1.getText().isEmpty() && jPasswordField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                String pass;
                pass = enc.getMD5EncryptedValue(jPasswordField1.getText());

                sql = "SELECT * FROM tb_petugas INNER JOIN tb_level ON tb_petugas.id_level = tb_level.id_level WHERE username='" + jTextField1.getText() +"' AND password='" + pass +"'";
                rs = stat.executeQuery(sql);

                if(rs.next()){
                    if(jTextField1.getText().equals(rs.getString("username"))){
                        if(rs.getString("level").equalsIgnoreCase("administrator")){
                            list = new ArrayList<UserSession>();
                            a = new UserSession();
                            a.setId(rs.getInt("id_petugas"));
                            a.setUsername(rs.getString("username"));
                            a.setPassword(rs.getString("password"));
                            a.setName(rs.getString("nama_petugas"));
                            a.setLevel(rs.getString("level"));
                            list.add(a);

                            new Admin().show();
                            this.dispose();
                        }else{
                            list = new ArrayList<UserSession>();
                            a = new UserSession();
                            a.setId(rs.getInt("id_petugas"));
                            a.setUsername(rs.getString("username"));
                            a.setPassword(rs.getString("password"));
                            a.setName(rs.getString("nama_petugas"));
                            a.setLevel(rs.getString("level"));
                            list.add(a);

                            new Petugas().show();
                            this.dispose();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Gagal\nUsername atau Password salah","Informasi",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    sql = "SELECT * FROM tb_masyarakat WHERE username='" + jTextField1.getText() +"' AND password='" + pass +"'";
                    rs = stat.executeQuery(sql);

                    if(rs.next()){
                        if(jTextField1.getText().equals(rs.getString("username"))){
                            list = new ArrayList<UserSession>();
                            a = new UserSession();
                            a.setId(rs.getInt("id_user"));
                            a.setUsername(rs.getString("username"));
                            a.setPassword(rs.getString("password"));
                            a.setName(rs.getString("nama_lengkap"));
                            list.add(a);

                            new User().show();
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(null,"Gagal\nUsername atau Password salah","Informasi",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Gagal\nUsername atau Password salah","Informasi",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
        
        
        
        











...............................................
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class lomgin extends javax.swing.JFrame {
        Connection Connect;
    Statement st;
    ResultSet rs;
    String sql;
    /**
     * Creates new form 
     */
    
    public lomgin() {
        
         initComponents();
    }





if (txtusername.getText().equals("")){
         JOptionPane.showMessageDialog(null, "dont forget to fill username");
         txtusername.requestFocus();
        }
        else if(txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"dont forget fill password");
            txtpassword.requestFocus();
        }
        else if(txtusername.getText().contains("ryo")&& txtpassword.getText().contains("123")){
            new home().show();
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "username or password doesnt match");
        }
    }
