package controller;

import model.MailData;
import network.MailNetwork;
import view.MailView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailController implements ActionListener{

    private MailData mailData;
    private MailView mailView;
    private MailNetwork mailNetwork;

    public MailController(MailData mailData, MailView mailView) {
        this.mailData = mailData;
        this.mailView = mailView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Send")){
            sendMail(mailView.getMail());
            mailView.dispose();
        }

    }

    private void sendMail(String sendMail) {
        String originMail = mailData.getUSER();
        String password = mailData.getPASSWORD();
        try {
            mailNetwork = new MailNetwork(originMail, password, sendMail, mailData.getMessage());
        } catch (Exception e) {
            mailView.popWindow(mailView, e.getMessage(), "Email error", "Error");
        }

    }

    public void setVisible(boolean b){
        mailView.setVisible(b);
    }

    public void setMessage(String message) {
        mailData.setMessage(message);
    }
}
