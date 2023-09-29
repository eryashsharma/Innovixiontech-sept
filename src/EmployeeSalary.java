
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author yashs
 */
public class EmployeeSalary extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeSalary
     */
    Connection con;
    PreparedStatement ps;
    public EmployeeSalary() {
        initComponents();
       
        
       setTitle("Payroll Management System");
        getContentPane().setBackground(Color.yellow);
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollmangement","root","");
        }catch(Exception ee)
        {
            JOptionPane.showMessageDialog(null,ee);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c1 = new javax.swing.JComboBox<>();
        c2 = new javax.swing.JComboBox<>();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c1.setForeground(new java.awt.Color(255, 0, 0));
        c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 30));

        c2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c2.setForeground(new java.awt.Color(255, 0, 0));
        c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        getContentPane().add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 200, 30));

        b2.setBackground(new java.awt.Color(255, 102, 0));
        b2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b2.setForeground(new java.awt.Color(0, 0, 102));
        b2.setText("Back");
        b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 220, 30));

        b1.setBackground(new java.awt.Color(255, 102, 0));
        b1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b1.setForeground(new java.awt.Color(0, 0, 102));
        b1.setText("Calculate");
        b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 220, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmpID", "NAME", "Month", "Year", "total_leave", "sick_leave", "casual_leave", "BASIC_SALARY", "DA", "ESI", "PF", "ANNUAL PACKAGE", "TDS_TAX", "TOTAL_SALARY", "exceed_leave", "final_salary"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1100, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void insert(int x, Object m, Object y) {
    int basic_salary = 0;

    int empid = 0, sick_leave = 0, casual_leave = 0, total_leave = 0;
    String name = "", month = "", year = "";
    try {
        // Get basic salary
        ps = con.prepareStatement("SELECT basic_salary FROM employeedetails WHERE empid = ?");
        ps.setInt(1, x);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            basic_salary = rs.getInt(1);
        }

        // Get data from attendance
        ps = con.prepareStatement("SELECT * FROM attendance WHERE empid = ? AND month = ? AND year = ?");
        ps.setInt(1, x);
        ps.setObject(2, m);
        ps.setObject(3, y);
        ResultSet rs1 = ps.executeQuery();
        if (rs1.next()) {
            empid = rs1.getInt(1);
            name = rs1.getString(2);
            month = rs1.getString(3);
            year = rs1.getString(4);
            total_leave = rs1.getInt(5);
            sick_leave = rs1.getInt(6);
            casual_leave = rs1.getInt(7);
        }

        // Perform calculations
        int da = basic_salary * 50 / 100;
        int esi = basic_salary * 2 / 100;
        int pf = basic_salary * 6 / 100;
        int in_hand = (basic_salary + da - esi - pf);
        int package1 = in_hand * 12;
        int tds_Tax = 0;
        if (package1 <= 300000) {
            tds_Tax = 0;
        } else if (package1 > 300000 && package1 <= 500000) {
            tds_Tax = (package1 - 300000) * 10 / 100;
        } else if (package1 > 500000 && package1 <= 1000000) {
            int c = package1 - 500000;
            int d = package1 - c - 300000;
            tds_Tax = (c * 20 / 100) + (d * 10 / 100);
        } else {
            int c = package1 - 1000000;
            int d = package1 - c - 500000;
            int e = package1 - c - d - 300000;
            tds_Tax = (c * 30 / 100) + (d * 20 / 100) + (e * 10 / 100);
        }
        int total_salary = in_hand - (tds_Tax / 12);

        int oneday = total_salary / 30;
        int final_salary = 0;
        int exceed_leave = total_leave - (sick_leave + casual_leave);
        if (exceed_leave > 0) {
            final_salary = total_salary - (exceed_leave * oneday);
        } else {
            final_salary = total_salary;
        }

        // Insert into the salary table
        ps = con.prepareStatement("INSERT INTO salary (empid, name, month, year, total_leave, sick_leave, casual_leave, basic_salary, da, esi, pf, package1, tds_Tax, total_salary, exceed_leave, final_salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, empid);
        ps.setString(2, name);
        ps.setString(3, month);
        ps.setString(4, year);
        ps.setInt(5, total_leave);
        ps.setInt(6, sick_leave);
        ps.setInt(7, casual_leave);
        ps.setInt(8, basic_salary);
        ps.setInt(9, da);
        ps.setInt(10, esi);
        ps.setInt(11, pf);
        ps.setInt(12, package1);
        ps.setInt(13, tds_Tax);
        ps.setInt(14, total_salary);
        ps.setInt(15, exceed_leave);
        ps.setInt(16, final_salary);
        ps.executeUpdate();
    } catch (Exception ee) {
        JOptionPane.showMessageDialog(null, ee);
        System.out.println(ee);
    }
}

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
       
   DefaultTableModel model = (DefaultTableModel) table.getModel();
model.setRowCount(0); // Clear existing rows

try {
    Object month = c1.getSelectedItem();
    Object year = c2.getSelectedItem();
    
    // Establish the database connection (replace "your_connection_info" with actual connection details)
    
    
    PreparedStatement ps = con.prepareStatement("select * from salary where month=? and year=?");
    ps.setObject(1, month);
    ps.setObject(2, year);
    
    // Prepare and execute a SQL query to fetch data from the "attendance" table
    ResultSet rs = ps.executeQuery();
    
    while (rs.next()) {
        // Extract data from the ResultSet and add it to the JTable
        model.addRow(new Object[] {
            rs.getInt("empid"),
            rs.getString("name"),
            rs.getString("month"),
            rs.getString("year"),
            rs.getInt("total_leave"),
            rs.getInt("sick_leave"),
            rs.getInt("casual_leave"),
            rs.getInt("basic_salary"),
            rs.getInt("da"),
            rs.getInt("esi"),
            rs.getInt("pf"),
            rs.getInt("package1"),
            rs.getInt("tds_Tax"),
            rs.getInt("total_salary"),
            rs.getInt("exceed_leave"),
            rs.getInt("final_salary")
        });
    }
    
    // Close the ResultSet, PreparedStatement, and the database connection
    rs.close();
    ps.close();
    con.close();
} catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex);
        System.out.println(ex);
}

    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        this.setVisible(false);
        new Employee_info().setVisible(true);
    }//GEN-LAST:event_b2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeSalary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JComboBox<String> c1;
    private javax.swing.JComboBox<String> c2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void display(int i, Object month, Object year) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}