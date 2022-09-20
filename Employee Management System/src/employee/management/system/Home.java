
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add,view,update,remove,Logout;
    Home(){
        ImageIcon myicon = new ImageIcon(getClass().getResource("emsicon.png"));
        setIconImage(myicon.getImage());
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front1.png"));
        Image i2=i1.getImage().getScaledInstance(700, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700,450);
        add(image);
        
        JLabel heading =new JLabel ("Employee Management System");
        heading.setBounds(100,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,27));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(130,80,180,40);
        add.setBackground(new Color(22, 160, 133));
        add.setForeground(new Color(255, 255, 255));
        add.setFont(new Font("Calibri", Font.BOLD, 18));
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View Employee");
        view.setBounds(370,80,180,40);
        view.setBackground(new Color(22, 160, 133));
        view.setForeground(new Color(255, 255, 255));
        view.setFont(new Font("Calibri", Font.BOLD, 18));
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(130,170,180,40);
        update.setBackground(new Color(22, 160, 133));
        update.setForeground(new Color(255, 255, 255));
        update.setFont(new Font("Calibri", Font.BOLD, 18));
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(370,170,180,40);
        remove.setBackground(new Color(22, 160, 133));
        remove.setForeground(new Color(255, 255, 255));
        remove.setFont(new Font("Calibri", Font.BOLD, 18));
        remove.addActionListener(this);
        image.add(remove);
        
        Logout=new JButton("Log out");
        Logout.setBounds(250,250,180,40);
        Logout.setBackground(new Color(22, 160, 133));
        Logout.setForeground(new Color(255, 255, 255));
        Logout.setFont(new Font("Calibri", Font.BOLD, 18));
        Logout.addActionListener(this);
        image.add(Logout);
        
       setSize(700,450);
       setLocation(400, 150);
       setVisible(true);
       setResizable(false);
    }
    
   
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
           
        } else if (ae.getSource() == update) {
           setVisible(false);
           new ViewEmployee();
        } else if(ae.getSource()==remove){
            setVisible(false);
            new RemoveEmployee();
        }else{
            setVisible(false);
            new Login();
        }
        
    }
     public static void main(String args[]){
        new Home();
    }
}
