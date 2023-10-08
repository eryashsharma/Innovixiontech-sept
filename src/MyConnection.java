import java.sql.*;
import javax.swing.JOptionPane;
 
public class MyConnection {
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagement","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}
