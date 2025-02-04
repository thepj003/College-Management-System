package university.manangement.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class add_student extends JFrame implements ActionListener {
    JTextField textName;
    JTextField textfName, textAdd, textph, textem, textper, textper2, textad;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseB, depopB;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong()%9000L)+1000L);

    add_student(){
        getContentPane().setBackground(Color.ORANGE);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        textfName = new JTextField();
        textfName.setBounds(600,150,150,30);
        add(textfName);

        JLabel empID = new JLabel("Roll No.");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        empText = new JLabel("14930"+ f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        cdob =  new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

        JLabel addr = new JLabel("Address");
        addr.setBounds(50,250,200,30);
        addr.setFont(new Font("serif", Font.BOLD, 20));
        add(addr);

        textAdd = new JTextField();
        textAdd.setBounds(200,250,150,30);
        add(textAdd);

        JLabel ph = new JLabel("Phone");
        ph.setBounds(400,250,200,30);
        ph.setFont(new Font("serif", Font.BOLD, 20));
        add(ph);

        textph = new JTextField();
        textph.setBounds(600,250,150,30);
        add(textph);

        JLabel em = new JLabel("Email");
        em.setBounds(50,300,200,30);
        em.setFont(new Font("serif", Font.BOLD, 20));
        add(em);

        textem = new JTextField();
        textem.setBounds(200,300,150,30);
        add(textem);

        JLabel per = new JLabel("10th Percentage");
        per.setBounds(400,300,200,30);
        per.setFont(new Font("serif", Font.BOLD, 20));
        add(per);

        textper = new JTextField();
        textper.setBounds(600,300,150,30);
        add(textper);

        JLabel per2 = new JLabel("12th Percentage");
        per2.setBounds(50,350,200,30);
        per2.setFont(new Font("serif", Font.BOLD, 20));
        add(per2);

        textper2 = new JTextField();
        textper2.setBounds(200,350,150,30);
        add(textper2);

        JLabel ad = new JLabel("Aadhar Number");
        ad.setBounds(400,350,200,30);
        ad.setFont(new Font("serif", Font.BOLD, 20));
        add(ad);

        textad = new JTextField();
        textad.setBounds(600,350,150,30);
        add(textad);

        JLabel qu = new JLabel("Course");
        qu.setBounds(50,400,200,30);
        qu.setFont(new Font("serif", Font.BOLD, 20));
        add(qu);

        String course[] = {"B.Tech", "M.Tech", "Ph.D"};
        courseB = new JComboBox(course);
        courseB.setBounds(200,400,150,30);
        courseB.setBackground(Color.WHITE);
        add(courseB);

        JLabel dep = new JLabel("Branch");
        dep.setBounds(400,400,200,30);
        dep.setFont(new Font("serif", Font.BOLD, 20));
        add(dep);

        String depop[] = {"CSE", "CCE", "EEC", "ME", "IOT", "AIML", "CE", "IT", "DS", "RME"};

        depopB = new JComboBox(depop);
        depopB.setBounds(600,400,150,30);
        depopB.setBackground(Color.WHITE);
        add(depopB);

        submit = new JButton("Submit");
        submit.setBounds(250,600,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,600,120,30);
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
            String Tname = textName.getText();
            String Fname = textfName.getText();
            String empID = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAdd.getText();
            String phone = textph.getText();
            String email = textem.getText();
            String x = textper.getText();
            String xii = textper2.getText();
            String aadhar = textad.getText();
            String course = (String) courseB.getSelectedItem();
            String dep = (String) depopB.getSelectedItem();
            try{
                String q = "insert into student values('"+Tname+"', '"+Fname+"','"+empID+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+dep+"' )";
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
        new add_student();
    }
}
