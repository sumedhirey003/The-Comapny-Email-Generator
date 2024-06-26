import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class emailApplicationUI {
    private JFrame frame;
    private JTextField fntxt1;
    private JTextField lntxt2;
    private JLabel txt1Label;
    private JLabel txt2Label;
    private JRadioButton salesrb;
    private JRadioButton devrb;
    private JRadioButton accrb;
    private JRadioButton nonerb;
    private JButton generateYourEmailButton;
    private JButton cancelButton;
    private JPanel emailUI;

    public emailApplicationUI() {
        frame = new JFrame("Company Email Generator");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(7,2));


        //UI components
        txt1Label = new JLabel("Enter First Name");
        fntxt1 = new JTextField();

        txt2Label = new JLabel("Enter Last Name");
        lntxt2 = new JTextField();

        JLabel departmentLabel = new JLabel("Select your department");
        salesrb = new JRadioButton("Sales");
        devrb = new JRadioButton("Development");
        accrb = new JRadioButton("Accounting");
        nonerb = new JRadioButton("None of the Above");

        //grouping the buttons so that only one option is selected
        ButtonGroup departmentGroup = new ButtonGroup();
        departmentGroup.add(salesrb);
        departmentGroup.add(devrb);
        departmentGroup.add(accrb);
        departmentGroup.add(nonerb);

        //defining my action button what it does
        generateYourEmailButton = new JButton("Generate your Email");
        cancelButton = new JButton("Cancel");

        //adding all my components to the frame to be displayed in the UI
        frame.add(txt1Label);
        frame.add(fntxt1);
        frame.add(txt2Label);
        frame.add(lntxt2);
        frame.add(departmentLabel);
        frame.add(new JLabel()); // an empty label for the alignment
        frame.add(salesrb);
        frame.add(devrb);
        frame.add(accrb);
        frame.add(nonerb);
        frame.add(generateYourEmailButton);
        frame.add(cancelButton);

        //adding action listener
        generateYourEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateEmail();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
    private void generateEmail(){
        String firstName = fntxt1.getText();
        String lastName = lntxt2.getText();
        String department = "";

        if(salesrb.isSelected()){
            department ="sales";
        } else if (devrb.isSelected()){
            department ="dev";
        }else if(accrb.isSelected()){
            department ="acct";
        }else {
            JOptionPane.showMessageDialog(frame,"Please select a Department."+ "Error" + JOptionPane.ERROR_MESSAGE);
        }

        //Generating email and password using Email class
        Email email = new Email(firstName,lastName,department);

        //displaying the result in new dailog box
        JOptionPane.showMessageDialog(frame, "Hello "+firstName + "\nEmail: "+ email.getEmail()+ "\nPassword: "+ email.getPassword()+
                "\nYour MailBox Capacity is "+ email.getMailboxCapacity()+"mb" +
                "\nGenerated Email and (temp)Password " + JOptionPane.INFORMATION_MESSAGE );
    }
    //end of the project
}
