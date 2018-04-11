package view;

import controller.MailController;

import javax.swing.*;

public class MailView extends JDialog {

    private JButton jbSend;
    private JTextField jtfMail;


    public MailView() {

        jbSend = new JButton("Send");

    }

    public void registerController(MailController mailController) {
        jbSend.addActionListener(mailController);
        jbSend.setActionCommand("Send");

    }

    public String getMail(){
        return jtfMail.getText();
    }
}
