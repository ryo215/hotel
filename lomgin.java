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






String user     = usertext1.getText();
 
        String password = pass1.getText();
 
 
 
        String cekuser      = null;
 
        String cekpassword  = null;
 
 
 
try {
            java.sql.Statement stat = Connect.createStatement();
            ResultSet result=stat.executeQuery ("select * from koneksi where "
                    + "user='" + "password='" +usertext1.getText()+"'");
            if (result.next()) {
                if (pass1.getText().equals(result.getString("pass"))){
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                this.dispose();
                } else {
                        JOptionPane.showMessageDialog(rootPane,"Password Salah");
                        pass1.setText("");
                        usertext1.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "User Tidak Ditemukan");
                usertext1.setText("");
                pass1.setText("");
                usertext1.requestFocus();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal");
        }
    
    }
