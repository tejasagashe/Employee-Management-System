
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;
    ViewEmployee(){
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon myicon = new ImageIcon(getClass().getResource("emsicon.png"));
        setIconImage(myicon.getImage());
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/view bg.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1100, 700);
        add(image);
        
        JLabel searchlbl=new JLabel("Search By Employee ID");
        searchlbl.setBounds(20,20,150,20);
        image.add(searchlbl);
        
        cemployeeId =new Choice();
        cemployeeId.setBounds(180,20,150,20);
        image.add(cemployeeId);
        
        
        
         try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
           
            while(rs.next()){
                cemployeeId.add(rs.getString("Employee_ID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        table = new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1100,600);
        image.add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(new Color(22, 160, 133));
        search.setForeground(new Color(255, 255, 255));
        search.setFont(new Font("Calibri", Font.BOLD, 14));
        search.addActionListener(this);
        image.add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(new Color(22, 160, 133));
        print.setForeground(new Color(255, 255, 255));
        print.setFont(new Font("Calibri", Font.BOLD, 14));
        print.addActionListener(this);
        image.add(print);
        
        
        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.setBackground(new Color(22, 160, 133));
        update.setForeground(new Color(255, 255, 255));
        update.setFont(new Font("Calibri", Font.BOLD, 14));
        update.addActionListener(this);
        image.add(update);
        
        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.setBackground(new Color(22, 160, 133));
        back.setForeground(new Color(255, 255, 255));
        back.setFont(new Font("Calibri", Font.BOLD, 14));
        back.addActionListener(this);
        image.add(back);
        
        setSize(1100,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query ="select * from employee where Employee_ID='"+cemployeeId.getSelectedItem()+"'";
            
            try{
              Conn c=new Conn();
              ResultSet rs=c.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e){
                e.printStackTrace();
            } 
        }else if(ae.getSource()==print){
             try{
              table.print();
            } catch(Exception e){
                e.printStackTrace();
            } 
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new ViewEmployee();
    }
}
