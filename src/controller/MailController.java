package controller;

import model.MailData;
import view.MailView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailController implements ActionListener{

    private MailData mailData;
    private MailView mailView;

    public MailController(MailData mailData, MailView mailView) {
        this.mailData = mailData;
        this.mailView = mailView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Send")){
            sendMail(mailView.getMail());
        }

    }

    private void sendMail(String sendMail) {
        String originMail = mailData.getUSER();
        String password = mailData.getPASSWORD();

    }
}
