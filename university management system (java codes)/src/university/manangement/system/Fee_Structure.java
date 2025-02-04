package university.manangement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Fee_Structure extends JFrame implements ActionListener {
    JButton OK;
    Fee_Structure(){
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(380,10,400,30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane js = new JScrollPane(table);
        js.setBounds(0,80,1000,700);
        add(js);

        OK = new JButton("OK");
        OK.setBounds(400,50,150,25);
        OK.setBackground(Color.black);
        OK.setForeground(Color.WHITE);
        OK.addActionListener(this);
        add(OK);

        setSize(1000,800);
        setLocation(250,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==OK){
            try{
                setVisible(false);
            } catch (Exception E){
                E.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Fee_Structure();
    }
}