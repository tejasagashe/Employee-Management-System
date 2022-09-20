
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    Choice cempId;
    JButton delete,back;
    RemoveEmployee(){
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon myicon = new ImageIcon(getClass().getResource("emsicon.png"));
        setIconImage(myicon.getImage());
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add employee.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1000, 400);
        add(image);
        
        JLabel lblempId=new JLabel("Employee ID");
        lblempId.setBounds(50,50,100,30);
        lblempId.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(lblempId);
        
        cempId=new Choice();
        cempId.setBounds(200,55,170,30);
        image.add(cempId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cempId.add(rs.getString("Employee_ID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,100,100,30);
        lblname.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(lblname);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200,100,100,30);
        labelname.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(labelname);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(50,150,100,30);
        lblphone.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(lblphone);
        
        JLabel labelphone=new JLabel();
        labelphone.setBounds(200,150,100,30);
        labelphone.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(labelphone);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(50,200,100,30);
        lblemail.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(lblemail);
        
        JLabel labelemail=new JLabel();
        labelemail.setBounds(200,200,300,30);
        labelemail.setFont(new Font("Calibri", Font.BOLD, 18));
        image.add(labelemail);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where Employee_ID='"+cempId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("First_Name"));
                labelphone.setText(rs.getString("Phone"));
                labelemail.setText(rs.getString("Email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                
            try{
                Conn c=new Conn();
                String query="select * from employee where Employee_ID='"+cempId.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    labelname.setText(rs.getString("First_Name"));
                    labelphone.setText(rs.getString("Phone"));
                    labelemail.setText(rs.getString("Email"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            }
        });
       
        delete  =new JButton("Delete");
        delete.setBounds(50,300,120,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Calibri", Font.BOLD, 15));
        delete.addActionListener(this);
        image.add(delete);
        
        back  =new JButton("Back");
        back.setBounds(220,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Calibri", Font.BOLD, 15));
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(700,400);
        setLocation(400,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();
                String query="delete from employee where Employee_ID='"+cempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee information deleted successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
           setVisible(false);
           new Home();
        }
    }
    public static void main(String args[]){
        new RemoveEmployee();
    }
}
