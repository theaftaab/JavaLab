package MyJavaPractice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static MyJavaPractice.start.CustDet;

public class CreateCust extends JFrame implements ActionListener {
    JTextField phone = new JTextField();
    JTextField name = new JTextField();
    JButton submit = new JButton();
    CreateCust(){
        this.setLayout(new FlowLayout());
        this.setSize(300,300);
        phone.setPreferredSize(new Dimension(250,20));
        phone.setText("Enter Phone number");
        name.setPreferredSize(new Dimension(250,20));
        name.setText("Enter name");
        submit.setText("Submit");
        submit.addActionListener(this);
        this.add(phone);
        this.add(name);
        this.add(submit);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            CustDet.put(phone.getText(), name.getText());
            System.out.print(CustDet);

        }
    }
}
