
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/starting page.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700,500);
        add(image);
        
        JLabel heading = new JLabel("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(50,10,120,40);
        heading.setFont(new Font("serif",Font.PLAIN,25));
        heading.setBackground(Color.BLACK);
        image.add(heading);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(350,250,250,50);
        clickhere.setBackground(new Color(75,138,187));
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
       
        setSize(700, 500);
        setLocation(200,50);
        setVisible(true);
        
        while(true){
            heading.setVisible(true);
            try{
                Thread.sleep(700);
            }catch (Exception e){
                e.printStackTrace();
            }
            
            heading.setVisible(false);
            try{
                Thread.sleep(700);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
        new Splash();
    }
}
