package university.manangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class StudentDet extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;
    StudentDet(){
        getContentPane().setBackground(Color.CYAN);

        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);
        try{
            conn c = new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from student");
            while(resultSet.next()){
                choice.add(resultSet.getString("roll"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
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
            String q = "select * from student where roll = '"+choice.getSelectedItem()+"'";
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
            new add_student();
        } else if(e.getSource() == update){
            new update_stud();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDet();
    }
}
