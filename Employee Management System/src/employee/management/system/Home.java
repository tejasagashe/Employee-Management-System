
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add,view,update,remove;
    Home(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front1.gif"));
        Image i2=i1.getImage().getScaledInstance(700, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700,450);
        add(image);
        
        JLabel heading =new JLabel ("Employee Management System");
        heading.setBounds(100,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(200,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View Employee");
        view.setBounds(370,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(200,170,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(370,170,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
       setSize(700,450);
       setLocation(250,100);
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
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
        
    }
     public static void main(String args[]){
        new Home();
    }
}
