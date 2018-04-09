package network;


import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class MailNetwork {


    public void sendMail(String origin, String password, String to, String message){

        String host ="smtp.gmail.com" ;
        boolean sessionDebug = false;

        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.required", "true");

        try{

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(properties, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(origin));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Table Reservation");
            msg.setSentDate(new Date());
            msg.setText(message);

            Transport transport=mailSession.getTransport("smtp");
            transport.connect(host, origin, password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        }catch(Exception ex) {
            System.out.println(ex);
        }

    }
}
