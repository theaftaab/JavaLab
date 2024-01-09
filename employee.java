package MyJavaPractice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class displayInfo extends JFrame implements ActionListener{
    JLabel g1;
    JLabel g2;
    JLabel g3;
    JLabel g4;
    JLabel g5;
    JLabel g6;
    displayInfo(String name,String age,String payscale,String numFam,String addr,String gender){
        g1 = new JLabel();
        g1.setText("Name :"+name);
        g2 = new JLabel();
        g2.setText("Age : " + age);
        g3 = new JLabel();
        g3.setText("Payscale :  " + payscale);
        g4 = new JLabel();
        g4.setText("Number of family Members : " + numFam);
        g5 = new JLabel();
        g5.setText("Address : " + addr);
        g6 = new JLabel();
        g6.setText("gender :" +gender);
        this.add(g1);
        this.add(g2);
        this.add(g3);
        this.add(g4);
        this.add(g5);
        this.add(g6);
        this.setSize(200,400);
        this.setVisible(true);
        this.setLayout(new FlowLayout());

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
class eDataCollector extends JFrame implements ActionListener{
    JTextField name;
    JTextField age;
    JComboBox payscale;
    JTextField numFam;
    JTextField addr;
    JTextField gender;
    JButton submit;

    eDataCollector(){
        name = new JTextField();
        age = new JTextField();
        String[] list = {"less than 100", "100-200", "200-300"};
        payscale = new JComboBox(list);
        numFam = new JTextField();
        addr = new JTextField();
        gender = new JTextField();
        this.setLayout(new FlowLayout());
        name.setPreferredSize(new Dimension(250,20));
        age.setPreferredSize(new Dimension(250,20));
        payscale.setPreferredSize(new Dimension(250,20));
        numFam.setPreferredSize(new Dimension(250,20));
        addr.setPreferredSize(new Dimension(250,20));
        gender.setPreferredSize(new Dimension(250,20));
        submit = new JButton();
        submit.setPreferredSize(new Dimension(60,20));
        submit.addActionListener(this);
        name.setText("name");
        age.setText("Age");
//        payscale.setAction("name");
        numFam.setText("Num fam members");
        addr.setText("Address");
        gender.setText("Gender");
        submit.setText("Submit");
        this.add(name);
        this.add(age);
        this.add(payscale);
        this.add(numFam);
        this.add(addr);
        this.add(gender);
        this.add(submit);
        this.setSize(400,400);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
//            System.out.println(payscale.getSelectedItem());
            if(Integer.parseInt(age.getText()) > 22 && Integer.parseInt(age.getText()) < 60 ){
                displayInfo obj = new displayInfo(name.getText(), age.getText(), (String) payscale.getSelectedItem(), numFam.getText(), addr.getText(), gender.getText());
            }
            else{
                JOptionPane.showMessageDialog(this, "enter valid details");
//                message.createDialog(this, "enter valid details");
            }
        }
    }
}
public class employee {
    public static void main(String args[]){
        eDataCollector obj = new eDataCollector();
    }
}
