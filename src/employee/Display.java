package employee;

import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Display {
    Display() {
        JFrame frame1 = new JFrame("Database Result");
        JTable table;
        JButton b1;
        PreparedStatement pst;
        String[] columnNames = {"Employee Name", "Father Name", "Age", "Date of Birth", "Address", "Phone No", "Email", "Education", "Post", "Adhar No", "ID" };

        b1 = new JButton("Cancel");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.add(b1, BorderLayout.SOUTH);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        Font F1 = new Font("serif",Font.BOLD,30);


        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);


        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);



        try {
            //Class.forName(driverName);
            Connection con = DriverManager.getConnection("jdbc:mysql:///newdb","root","12010517");
            String sql = "select * from employee";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            int i = 0;
            while (rs.next()) {
                String name = rs.getString(1);
                String father = rs.getString(2);
                String age = rs.getString(3);
                String dob = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String education = rs.getString(8);
                String post = rs.getString(9);
                String aadhar = rs.getString(10);
                String emp_id = rs.getString(11);
                //String class1 = rs.getString(3);

                model.addRow(new Object[]{name, father, age, dob, address, phone, email, education, post, aadhar, emp_id});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(1500, 500);

    }

    public static void main(String[] args) {
        Display d = new Display();
    }
}
