package university.manangement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class school_det extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton exit, print, search;
    school_det(){
        getContentPane().setBackground(Color.CYAN);
        JLabel heading = new JLabel("Search By School_ID Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);
        try{
            conn c = new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from school");
            while(resultSet.next()){
                choice.add(resultSet.getString("school_id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from school");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0,100,900,600);
        add(js);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        exit = new JButton("EXIT");
        exit.setBounds(220,70,80,20);
        exit.addActionListener(this);
        add(exit);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String q = "select * from school where school_id = '"+choice.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));


            }catch(Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()==exit){
            setVisible(false);
        } else if(e.getSource()==print){
            try{
                table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        new school_det();
    }
}
