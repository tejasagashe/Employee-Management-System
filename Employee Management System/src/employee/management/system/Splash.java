
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(100,-15, 600, 60);
        heading.setFont(new Font("Monospaced", Font.BOLD, 30));
        heading.setForeground(new Color(32,60,81));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/starting page.gif"));
        Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 35, 700, 400);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(190, 441, 300, 50);
        clickhere.setBackground(new Color(32,60,81));
        clickhere.setFont(new Font("Impact", Font.PLAIN, 25));
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        add(clickhere);
        
        
        setSize(700, 535);
        setLocation(400, 100);
        setVisible(true);
        
//        while(true) {
//            heading.setVisible(true);
//            try {
//                Thread.sleep(1200);
//            } catch (Exception e){
//                
//            }
//            
//            heading.setVisible(false);
//            try {
//                Thread.sleep(1200);
//            } catch (Exception e){
//                
//            }
//        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}