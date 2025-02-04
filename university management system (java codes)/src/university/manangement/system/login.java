package university.manangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;
    login(){

        JLabel heading = new JLabel("Admin Portal");
        heading.setBounds(90,10,200,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel labelName  = new JLabel("Username");
        labelName.setBounds(40,70,100,20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150,70,150,20);
        add(textFieldName);

        JLabel labelPass = new JLabel("Password");
        labelPass.setBounds(40,110,100,20);
        add(labelPass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,110,150,20);
        add(passwordField);

        login = new JButton("LOGIN");
        login.setBounds(40,160,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(180,160,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image I2 = I1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel img = new JLabel(I3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel IMG = new JLabel(i3);
        IMG.setBounds(0,0,600,300);
        add(IMG);

        setSize(600,300);
        setLocation(500,250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String username = textFieldName.getText();
            String password = passwordField.getText();
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                conn c = new conn();
                ResultSet resultset = c.statement.executeQuery(query);
                if(resultset.next()){
                    setVisible(false);
                    new main_class();

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");

                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
