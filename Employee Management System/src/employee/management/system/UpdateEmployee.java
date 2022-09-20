package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfeducation, tflname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation;
    JLabel lblempId,lblaadhar;
    JButton add, back;
    String empId;
    UpdateEmployee(String empId) {
        setResizable(false);
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        ImageIcon myicon = new ImageIcon(getClass().getResource("emsicon.png"));
        setIconImage(myicon.getImage());
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add employee.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        image.add(heading);
        
        JLabel labelname = new JLabel("First Name    :");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblname);
        
        JLabel labellname = new JLabel("Last Name");
        labellname.setBounds(400, 150, 150, 30);
        labellname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labellname);
        
        tflname = new JTextField();
        tflname.setBounds(600, 150, 150, 30);
        image.add(tflname);
        
        JLabel labeldob = new JLabel("Date of Birth :");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        image.add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        image.add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        image.add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        image.add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        image.add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        image.add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number   :");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelaadhar);
        
        lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        lblaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee id :");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblempId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where Employee_ID='"+empId+"'";
           ResultSet rs= c.s.executeQuery(query);
           
           while(rs.next()){
               lblname.setText(rs.getString("First_Name"));
               tflname.setText(rs.getString("Last_Name"));
               lbldob.setText(rs.getString("DOB"));
               tfsalary.setText(rs.getString("Salary"));
               tfaddress.setText(rs.getString("Address"));
               tfphone.setText(rs.getString("Phone"));
               tfemail.setText(rs.getString("Email"));
               tfeducation.setText(rs.getString("Education"));
               lblaadhar.setText(rs.getString("Aadhar"));
               tfdesignation.setText(rs.getString("Designation"));
               lblempId.setText(rs.getString("Employee_ID"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
        
            String lname = tflname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) tfeducation.getText();
            String designation = tfdesignation.getText();
         
             try {
                Conn conn = new Conn();
                String query = "update  employee set Last_Name='"+lname+"',Salary='"+salary+"', Address='"+address+"', Phone='"+phone+"', Email='"+email+"',Education= '"+education+"',Designation= '"+designation+"' where Employee_ID='"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}