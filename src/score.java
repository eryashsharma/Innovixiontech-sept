
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class score {

public void insertUpdateDeleteStudent(char operation, Integer sid, Integer cid,double scr,String descp)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        // i for insert
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("INSERT INTO `score`(`student_id`, `course_id`, `student_score`, `description`) VALUES (?,?,?,?)");
                ps.setInt(1, sid);
                ps.setInt(2, cid);
                ps.setDouble(3, scr);
                ps.setString(4, descp);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Score Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        if(operation == 'u')// u for update
//        {
//            try {
//                ps = con.prepareStatement("UPDATE `course` SET `label`= ?,`hours_number`= ? WHERE `id` = ?");
//                ps.setString(1, label);
//                ps.setInt(2, hours);
//                ps.setInt(3, id);
//                if(ps.executeUpdate() > 0){
//                    JOptionPane.showMessageDialog(null, "Course Data Updated");
//                }
//            
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        if(operation == 'd')// d for delete
//        {
//            try {
//                ps = con.prepareStatement("DELETE FROM `course` WHERE `id` = ?");
//                ps.setInt(1, id);
//                if(ps.executeUpdate() > 0){
//                    JOptionPane.showMessageDialog(null, "Course Deleted");
//                }
//            
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }    
    
}
