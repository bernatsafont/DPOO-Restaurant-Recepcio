package view;

import controller.MailController;
import model.MailData;

import javax.swing.*;
import java.awt.*;

public class MailView extends JFrame {

    private JButton jbSend;
    private JTextField jtfMail;


    public MailView() {
        // create jpanel main mail view
        JPanel jpMail = new JPanel();
        // create layout
        jpMail.setLayout(new GridBagLayout());

        // set main to everything
        jpMail.setBorder(BorderFactory.createTitledBorder("Send mail with data"));

        // set components to the bag
        GridBagConstraints c = new GridBagConstraints();

        // label with the username
        JLabel jlUsername = new JLabel("Your e-mail:    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,20,10,10);
        c.gridwidth = 1;
        jpMail.add(jlUsername, c);
//TODO : Buidar camp abans d'entregar
        jtfMail = new JTextField("ls29308@salleurl.edu");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.insets = new Insets(10,20,10,10);
        c.gridwidth = 2;
        jpMail.add(jtfMail, c);

        jbSend = new JButton("Send");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.insets = new Insets(10,20,10,10);
        c.gridwidth = 3;
        jpMail.add(jbSend, c);

        add(jpMail);

        // general settings of the window
        setSize(400,200);
        setTitle("Email");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setVisible(true);

    }

    public void registerController(MailController mailController) {
        jbSend.addActionListener(mailController);
        jbSend.setActionCommand("Send");

    }

    public String getMail(){
        return jtfMail.getText();
    }

    /***
     * Method to generate message dialog
     * @param view the view where show message
     * @param message String with the message
     * @param title String with the title
     * @param type String with the type of error
     */
    public void popWindow(MailView view, String message, String title, String type){
        // compare the type of error that has to be launch
        switch (type) {
            case "Error":
                JOptionPane.showMessageDialog(view, message, title, JOptionPane.ERROR_MESSAGE);
                break;
            case "Warning":
                JOptionPane.showMessageDialog(view, message, title, JOptionPane.WARNING_MESSAGE);
                break;
            case "Info":
                JOptionPane.showMessageDialog(view, message, title, JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }
}
