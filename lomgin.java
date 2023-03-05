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
