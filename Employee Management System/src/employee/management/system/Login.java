
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     JTextField usernamebox,passbox;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        usernamebox =new JTextField();
        usernamebox.setBounds(150,20,150,30);
        add(usernamebox);
        
        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(40,70,100,30);
        add(lblpass);
        
        passbox =new JTextField();
        passbox.setBounds(150,70,150,30);
        add(passbox);
        
        JButton login = new JButton("Log in");
        login.setBounds(150,130,150,30);
        login.setBackground(new Color(0,0,100));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Login page.png"));
        Image i2=i1.getImage().getScaledInstance(300, 120, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(150, 20, 600,120);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        try{
            String username=usernamebox.getText();
            String password=passbox.getText();
            
            Conn c=new Conn();
            String query="select * from login where username= '"+username+"' and password='"+password+"'";
            
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
