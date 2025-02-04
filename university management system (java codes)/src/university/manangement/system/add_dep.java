package university.manangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_dep extends JFrame implements ActionListener {
    JTextField depName, depID, schoolID;
    JButton submit, cancel;
    JComboBox schoolB;

    add_dep(){
        getContentPane().setBackground(new Color(16,176,252));

        JLabel heading = new JLabel("New Department Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Department Name");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        depName = new JTextField();
        depName.setBounds(220,150,150,30);
        add(depName);

        JLabel id = new JLabel("Department ID");
        id.setBounds(450,150,200,30);
        id.setFont(new Font("serif", Font.BOLD, 20));
        add(id);

        depID = new JTextField();
        depID.setBounds(600,150,150,30);
        add(depID);

        JLabel school = new JLabel("School ID");
        school.setBounds(50,200,100,30);
        school.setFont(new Font("serif", Font.BOLD, 20));
        add(school);

        String sc[] = {"SCSE", "SCCE", "SEE", "SME", "SIT", "SCE"};

        schoolB = new JComboBox(sc);
        schoolB.setBounds(220,200,150,30);
        schoolB.setBackground(Color.WHITE);
        add(schoolB);


        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit){
            String DepName = depName.getText();
            String DepID = depID.getText();

            String schoolID = (String) schoolB.getSelectedItem();

            try{
                String q = "insert into department values('"+DepName+"', '"+DepID+"','"+schoolID+"')";
                conn c = new conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Inserted Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new add_dep();
    }
}
