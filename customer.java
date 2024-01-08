package  MyJavaPractice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static MyJavaPractice.start.ItemDet;

class start extends JFrame implements ActionListener {

    static HashMap<String, String> CustDet = new HashMap<>();
    static HashMap<String, Integer> ItemDet = new HashMap<>();
    // adding preliminary details
    JLabel mob = new JLabel("Enter Mobile number");
    JTextField mobText = new JTextField();
    JButton submit = new JButton("Submit");

    start() {

        this.setSize(400, 400);
        mobText.setPreferredSize(new Dimension(250,20));
        this.setLayout(new FlowLayout()); // Add this line to set the layout manager
        this.add(mob);
        this.add(mobText);
        this.add(submit);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CustDet.put("9164811216", "aftaab");
        CustDet.put("9035781499", "Faheemah");
        ItemDet.put("01",300);
        ItemDet.put("02",250);
        if (e.getSource() == submit){
            String mobileNumber = mobText.getText();
//            System.out.println("Entered Mobile Number: " + mobileNumber);
            if(CustDet.containsKey(mobileNumber)){
                Shop sh = new Shop();

            }
            else{
                CreateCust cus = new CreateCust();
            }
        }

    }
}
class Shop extends JFrame implements ActionListener{
    JTextField itemID = new JTextField();
    JTextField itemQuantity = new JTextField();
    JButton calc = new JButton();

    Shop(){
        this.setSize(400,400);
        itemID.setPreferredSize(new Dimension(250,20));
        itemID.setText("Enter Item ID");

        itemQuantity.setPreferredSize(new Dimension(250,20));
        itemQuantity.setText("Enter Quantity");
        calc.setText("Calculate");
        calc.addActionListener(this);
        this.setLayout(new FlowLayout());
        this.add(itemID);
        this.add(itemQuantity);
        this.add(calc);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== calc){
            String id = itemID.getText();
            if(ItemDet.containsKey(id)){
                int itemPrice = ItemDet.get(id) * Integer.parseInt(itemQuantity.getText());
                String message = "Total Price is "+ itemPrice;
                JOptionPane.showMessageDialog(this, message);
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Iem ID");
            }

        }

    }
}
public class customer {
    public static void main(String args[]) {

        start obj = new start();
    }
}