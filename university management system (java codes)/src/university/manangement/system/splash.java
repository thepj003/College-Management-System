package university.manangement.system;

import javax.swing.*;
import java.awt.*;
public class splash extends JFrame implements Runnable{
    Thread t;
    splash(){
        JLabel heading = new JLabel("MANIPAL UNIVERSITY Admin Portal");
        heading.setBounds(50, 10, 1000, 60);
        heading.setFont(new Font("Tahoma", Font.BOLD, 50));
        heading.setForeground(Color.black);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        t = new Thread(this);
        t.start();

        setVisible(true);
        int x=1;
        for(int i = 2;i<=600;i+=4, x+=1){
            setLocation(600-((i+x)/2), 350-(i/2));
            setSize(i +3*x, i+x/2);

            try{
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    public void run(){
        try {
            Thread.sleep(7000);
            setVisible(false);
            new login();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new splash();
    }
}
