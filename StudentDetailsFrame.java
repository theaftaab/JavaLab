package MyJavaPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class SInfo{
    String name_val;
    String usn_val;
    int age_val;
    String address_val;
    double sgpa1_val;
    double sgpa2_val;
    double sgpa3_val;
    double sgpa4_val;
    public SInfo(String name_val, String usn_val, int age_val, String address_val,double sgpa1_val, double sgpa2_val, double sgpa3_val,double sgpa4_val){
        this.name_val = name_val;
        this.address_val = address_val;
        this.age_val = age_val;
        this.usn_val = usn_val;
        this.sgpa1_val = sgpa1_val;
        this.sgpa2_val = sgpa2_val;
        this.sgpa3_val = sgpa3_val;
        this.sgpa4_val = sgpa4_val;
    }
    double CalculateCGPA(){
        double cgpa = (sgpa1_val + sgpa2_val + sgpa3_val + sgpa4_val)/4;
        return cgpa;
    }
    void DisplayDetails(){
        System.out.println(this.name_val);
        System.out.println(this.usn_val);
        System.out.println(this.age_val);
        System.out.println(this.address_val);
        System.out.println(this.sgpa1_val);
        System.out.println(this.sgpa2_val);
        System.out.println(this.sgpa3_val);
        System.out.println(this.sgpa4_val);

    }
}
class GUI extends JFrame implements ActionListener{
    static HashMap<String, SInfo> studentDetails = new HashMap<>();
    JButton submitBtn = new JButton("Submit");
    JTextField name = new JTextField();
    JTextField usn = new JTextField();
    JTextField age = new JTextField();
    JTextField address = new JTextField();
    JTextField sgpa1 = new JTextField();
    JTextField sgpa2 = new JTextField();
    JTextField sgpa3 = new JTextField();
    JTextField sgpa4 = new JTextField();
    JButton displayBtn = new JButton("Display");

    GUI(){
        this.setSize(400,400);
        this.setLayout(new FlowLayout());

        submitBtn.addActionListener(this);
        displayBtn.addActionListener(this);

        name.setPreferredSize(new Dimension(250,20));
        name.setText("Name");
        usn.setPreferredSize(new Dimension(250,20));
        usn.setText("usn");
        age.setPreferredSize(new Dimension(250,20));
        age.setText("age");
        address.setPreferredSize(new Dimension(250,20));
        address.setText("address");
        sgpa1.setPreferredSize(new Dimension(250,20));
        sgpa1.setText("SGPA 1");
        sgpa2.setPreferredSize(new Dimension(250,20));
        sgpa2.setText("SGPA 2");
        sgpa3.setPreferredSize(new Dimension(250,20));
        sgpa3.setText("SGPA 3");
        sgpa4.setPreferredSize(new Dimension(250,20));
        sgpa4.setText("SGPA 4");
        this.add(name);
        this.add(usn);
        this.add(address);
        this.add(age);
        this.add(sgpa1);
        this.add(sgpa2);
        this.add(sgpa3);
        this.add(sgpa4);
        this.add(submitBtn);
        this.add(displayBtn);

        this.setVisible(true);

//        this.getDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    String name_val;
    String usn_val;
    int age_val;
    String address_val;
    double sgpa1_val;
    double sgpa2_val;
    double sgpa3_val;
    double sgpa4_val;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitBtn){
            System.out.println("Button pressed");
            this.name_val = name.getText();
            this.age_val = Integer.parseInt(age.getText());
            this.usn_val = usn.getText();
            this.address_val = address.getText();
            this.sgpa1_val = Double.parseDouble(sgpa1.getText());
            this.sgpa2_val = Double.parseDouble(sgpa2.getText());
            this.sgpa3_val = Double.parseDouble(sgpa3.getText());
            this.sgpa4_val = Double.parseDouble(sgpa4.getText());
            if(sgpa1_val < 10.1 && sgpa2_val <10.1  && sgpa3_val < 10.1 && sgpa4_val < 10.1 && age_val > 18 && age_val <= 30){
                SInfo student = new SInfo(this.name_val, this.usn_val, this.age_val, this.address_val, this.sgpa1_val, this.sgpa2_val, this.sgpa3_val, this.sgpa4_val);
                System.out.println("The cgpa is " + student.CalculateCGPA());
                studentDetails.put(this.usn_val, student);
                student.DisplayDetails();
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter Valid Details");
//                this.add(err);
            }

        }
        if (e.getSource() == displayBtn) {
            // Open a new frame to display the contents of the HashMap
            JFrame displayFrame = new JFrame("Student Details");
            displayFrame.setSize(400, 400);
            displayFrame.setLayout(new FlowLayout());

            // Iterate over the HashMap and display the student details
            for (HashMap.Entry<String, SInfo> entry : studentDetails.entrySet()) {
                String usn = entry.getKey();
                SInfo student = entry.getValue();

                JLabel usnLabel = new JLabel("USN: " + usn);
                JLabel nameLabel = new JLabel("Name: " + student.name_val);
                JLabel ageLabel = new JLabel("Age: " + student.age_val);
                JLabel addressLabel = new JLabel("Address: " + student.address_val);
                JLabel sgpa1Label = new JLabel("SGPA 1: " + student.sgpa1_val);
                JLabel sgpa2Label = new JLabel("SGPA 2: " + student.sgpa2_val);
                JLabel sgpa3Label = new JLabel("SGPA 3: " + student.sgpa3_val);
                JLabel sgpa4Label = new JLabel("SGPA 4: " + student.sgpa4_val);

                displayFrame.add(usnLabel);
                displayFrame.add(nameLabel);
                displayFrame.add(ageLabel);
                displayFrame.add(addressLabel);
                displayFrame.add(sgpa1Label);
                displayFrame.add(sgpa2Label);
                displayFrame.add(sgpa3Label);
                displayFrame.add(sgpa4Label);
            }

            displayFrame.setVisible(true);
        }

    }
}
public class StudentDetailsFrame{
    public static void main(String args[]){
        GUI obj = new GUI();

    }
}