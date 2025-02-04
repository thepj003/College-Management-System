package university.manangement.system;

import javax.swing.*;
import java.awt.*;

public class cale extends JFrame{
    cale(){
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icon/cale.png"));
        Image I2 = I1.getImage().getScaledInstance(1540,750,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel img = new JLabel(I3);
        add(img);
        setSize(1540,850);
        setVisible(true);
    }
    public static void main(String[] args) {
        new cale();
    }
}
