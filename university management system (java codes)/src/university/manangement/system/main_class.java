package university.manangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class main_class extends JFrame implements ActionListener {
    main_class(){
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icon/muj.png"));
        Image I2 = I1.getImage().getScaledInstance(1540,750,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel img = new JLabel(I3);
        add(img);

        JMenuBar mb = new JMenuBar();

        JMenu newInfo = new JMenu("ADD NEW ");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem faculty_info = new JMenuItem("Add New Faculty");
        faculty_info.setBackground(Color.WHITE);
        faculty_info.addActionListener(this);
        newInfo.add(faculty_info);

        JMenuItem student_info = new JMenuItem("Add New Student");
        student_info.setBackground(Color.WHITE);
        student_info.addActionListener(this);
        newInfo.add(student_info);

        JMenu viewDetails = new JMenu("VIEW DETAILS");
        viewDetails.setForeground(Color.BLACK);
        mb.add(viewDetails);

        JMenuItem faculty_det = new JMenuItem("Faculty Details");
        faculty_det.setBackground(Color.WHITE);
        faculty_det.addActionListener(this);
        viewDetails.add(faculty_det);

        JMenuItem student_det = new JMenuItem("Student Details");
        student_det.setBackground(Color.WHITE);
        student_det.addActionListener(this);
        viewDetails.add(student_det);



        JMenu update = new JMenu("UPDATE DETAILS");
        update.setForeground(Color.BLACK);
        mb.add(update);

        JMenuItem faculty_up = new JMenuItem("Update Faculty Info");
        faculty_up.setBackground(Color.WHITE);
        faculty_up.addActionListener(this);
        update.add(faculty_up);

        JMenuItem student_up = new JMenuItem("Update Student Info");
        student_up.setBackground(Color.WHITE);
        student_up.addActionListener(this);
        update.add(student_up);

        JMenu scdep = new JMenu("SCHOOL AND DEPARTMENT ");
        scdep.setForeground(Color.BLACK);
        mb.add(scdep);

        JMenuItem school_info = new JMenuItem("View School Details");
        school_info.setBackground(Color.WHITE);
        school_info.addActionListener(this);
        scdep.add(school_info);

        JMenuItem dep_info = new JMenuItem("View Department Details");
        dep_info.setBackground(Color.WHITE);
        dep_info.addActionListener(this);
        scdep.add(dep_info);

        JMenu exm = new JMenu("EXAMINATION ");
        exm.setForeground(Color.BLACK);
        mb.add(exm);

        JMenuItem mrk = new JMenuItem("Enter Marks");
        mrk.setBackground(Color.WHITE);
        mrk.addActionListener(this);
        exm.add(mrk);

        JMenuItem mrk_det = new JMenuItem("View Result");
        mrk_det.setBackground(Color.WHITE);
        mrk_det.addActionListener(this);
        exm.add(mrk_det);

        JMenu pay = new JMenu("PAYMENTS ");
        pay.setForeground(Color.BLACK);
        mb.add(pay);

        JMenuItem fs = new JMenuItem("Fee Structure");
        fs.setBackground(Color.WHITE);
        fs.addActionListener(this);
        pay.add(fs);

        JMenuItem pfe = new JMenuItem("Pay Fee");
        pfe.setBackground(Color.WHITE);
        pfe.addActionListener(this);
        pay.add(pfe);

        JMenu utility = new JMenu("UTILITY");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        JMenuItem cale = new JMenuItem("Calendar");
        cale.setBackground(Color.WHITE);
        cale.addActionListener(this);
        utility.add(cale);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        

        JMenu exit = new JMenu("EXIT");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);






        setJMenuBar(mb);

        setSize(1540,850);
       setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(15);
        } else if(sm.equalsIgnoreCase("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Faculty Details")){
            try{
                new teacherDet();
            } catch (Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Enter Marks")){
            try{
                new enter_marks();
            } catch (Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("View Result")){
            try{
                new mark_det();
            } catch (Exception E){
                E.printStackTrace();
            }
        }  else if(sm.equalsIgnoreCase("Pay Fee")){
            try{
                new StudentFeeForm();
            } catch (Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Fee Structure")){
            try{
                new Fee_Structure();
            } catch (Exception E){
                E.printStackTrace();
            }
        }else if(sm.equalsIgnoreCase("Student Details")){
            try{
                new StudentDet();
            } catch (Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Calendar")){
            try{

                new cale();

            } catch(Exception E){
                E.printStackTrace();
            }
        }else if(sm.equalsIgnoreCase("Add New Faculty")){
            try{

                new Add_Faculty();

            } catch(Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Add New Student")){
            try{

                new add_student();

            } catch(Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("View School Details")){
            try{

                  new school_det();

            } catch(Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("View Department Details")){
            try{

               new dep_det();

            } catch(Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Update Student Info")){
            try{
                new update_stud();
            } catch(Exception E){
                E.printStackTrace();
            }
        } else if(sm.equalsIgnoreCase("Update Faculty Info")){
            try{
                new update_fac();
            } catch(Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
