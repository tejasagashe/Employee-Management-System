
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     JTextField usernamebox;
     JPasswordField passbox;
    Login(){
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon myicon = new ImageIcon(getClass().getResource("emsicon.png"));
        setIconImage(myicon.getImage());
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Calibri", Font.BOLD, 18));
        add(lblusername);
        
        usernamebox =new JTextField();
        usernamebox.setBounds(150,20,180,30);
        add(usernamebox);
        
        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(40,70,100,30);
        lblpass.setForeground(Color.WHITE);
        lblpass.setFont(new Font("Calibri", Font.BOLD, 18));
        add(lblpass);
        
        passbox =new JPasswordField();
        passbox.setBounds(150,70,180,30);
        add(passbox);
        
        JButton login = new JButton("Log in");
        login.setBounds(149,130,180,40);
        login.setBackground(new Color(28, 40, 51 ));
        login.setForeground(new Color(229, 231, 233));
        login.addActionListener(this);
        login.setFont(new Font("Calibri", Font.BOLD, 20));
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login pg1.png"));
        Image i2=i1.getImage().getScaledInstance(300, 120, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(150, 20, 600,120);
        add(image);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/login bg.jpg"));
        Image I2=I1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel Image=new JLabel(I3);
        Image.setBounds(0, 0, 600,300);
        add(Image);
        
        
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
                JOptionPane.showMessageDialog(null, "Login Successful!");
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
