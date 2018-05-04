// package where it belongs
package controller;

// import our classes
import model.MailData;
import network.MailNetwork;
import view.MailView;

// import java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * This class controls the mail view and usage
 */
public class MailController implements ActionListener{

    // instance attributes
    private MailData mailData;
    private MailView mailView;
    private MailNetwork mailNetwork;

    /***
     * COnstructor with parameters of the class
     * @param mailData MailData instance
     * @param mailView MailView instance
     */
    public MailController(MailData mailData, MailView mailView) {
        this.mailData = mailData;
        this.mailView = mailView;
    }

    /***
     * Override method action performed
     * @param e Event that's throw
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // send a mail if the send button is pressed
        if(e.getActionCommand().equals("Send")){
            sendMail(mailView.getMail());
            mailView.dispose();
        }

    }

    /***
     * This method sends a mail to a given mail
     * @param sendMail String with the send mail
     */
    private void sendMail(String sendMail) {
        String originMail = mailData.getUSER();
        String password = mailData.getPASSWORD();
        try {
            mailNetwork = new MailNetwork(originMail, password, sendMail, mailData.getMessage());
        } catch (Exception e) {
            mailView.popWindow(mailView, e.getMessage(), "Email error", "Error");
        }

    }

    /***
     * Method that manages the visibility of the mail view
     * @param b boolean with the visibility state
     */
    public void setVisible(boolean b){
        mailView.setVisible(b);
    }

    /***
     * method that sets de message to the mail data class
     * @param message String with the message
     */
    public void setMessage(String message) {
        mailData.setMessage(message);
    }
}
