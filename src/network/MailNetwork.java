// package where it belongs
package network;

// import java classes
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


/**
 * Class that manages all the connections with the webmail service
 */
public class MailNetwork extends Thread{

    // defining variables
    private String origin;
    private String password;
    private String to;
    private String message;

    /**
     * Constructor with parameters of the class
     * @param origin String variable of origin webmail direction or acount
     * @param password String variable with the password of the mail
     * @param to String variable with the webmail direction where to send
     * @param message String variable with the message to send
     */
    public MailNetwork(String origin, String password, String to, String message) {
        this.origin = origin;
        this.password = password;
        this.to = to;
        this.message = message;
        start();

    }

    /**
     * Method that override method run sends the e-mail
     */
    @Override
    public void run(){

        try {
            sendMail();
            // if the mail cannot be send interrupt the thread
        } catch (Exception e) {
            interrupt();
        }
    }

    /**
     * Method that sends the mail
     * @throws Exception if something goes wrong throw an exception
     */
    private void sendMail() throws Exception{

        // stables gmail host
        String host = "smtp.gmail.com" ;

        // generate and set mail propierties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.required", "true");

        // set send data
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(properties, null);
        mailSession.setDebug(false);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(origin));
        InternetAddress[] address = {new InternetAddress(to)};

        // write mail
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject("Table Reservation");
        msg.setSentDate(new Date());
        msg.setText(message);

        // send message
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(host, origin, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();


    }
}
