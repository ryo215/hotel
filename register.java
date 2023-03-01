import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



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
