package university.manangement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class teacherDet extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;
    teacherDet(){
        getContentPane().setBackground(new Color(192,164,252));

        JLabel heading = new JLabel("Search By Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);
        try{
            conn c = new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from teacher");
            while(resultSet.next()){
                choice.add(resultSet.getString("empID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
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

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        add = new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(420,70,80,20);
        update.addActionListener(this);
        add(update);

        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String q = "select * from teacher where empID = '"+choice.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));


            }catch(Exception E){
                E.printStackTrace();
            }
        } else if(e.getSource()== print){
            try{
                table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        } else if(e.getSource() == add){
            setVisible(false);
            new Add_Faculty();
        } else if(e.getSource() == update){
            new update_fac();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new teacherDet();
    }
}
