// package where it belongs
package controller;

// import our classes
import model.MailData;
import network.MailNetwork;
import view.MailView;

// import java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the mail view and usage
 */
public class MailController implements ActionListener{

    // instance attributes
    private MailData mailData;
    private MailView mailView;

    /**
     * Constructor with parameters of the class
     * @param mailData MailData instance
     * @param mailView MailView instance
     */
    public MailController(MailData mailData, MailView mailView) {
        this.mailData = mailData;
        this.mailView = mailView;
    }

    /**
     * Override method action performed
     * @param e Event that's throw
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // send a mail if the send button is pressed and the mail is proper entry
        if(e.getActionCommand().equals("Send")){
            if (checkMailEntry()){
                sendMail(mailView.getMail());
                mailView.dispose();
            }else{
                mailView.popWindow(mailView, "Wrong mail entry", "Incorrect Entry", "Warning");
            }
        }
    }

    /**
     * This method sends a mail to a given mail
     * @param sendMail String with the send mail
     */
    private void sendMail(String sendMail) {
        String originMail = mailData.getUSER();
        String password = mailData.getPASSWORD();
        try {
            new MailNetwork(originMail, password, sendMail, mailData.getMessage());
        } catch (Exception e) {
            mailView.popWindow(mailView, e.getMessage(), "Email error", "Error");
        }

    }

    /**
     * Method that manages the visibility of the mail view
     * @param b boolean with the visibility state
     */
    public void setVisible(boolean b){
        mailView.setVisible(b);
    }

    /**
     * method that sets de message to the mail data class
     * @param message String with the message
     */
    public void setMessage(String message) {
        mailData.setMessage(message);
    }


    /**
     * This method checks if the mail entry is correct
     * @return
     */
    private boolean checkMailEntry(){
        String mail = mailView.getMail();
        if (mail.equals("") || !mail.contains("@") || !mail.contains(".")){
            return false;
        }
        return true;
    }

}
