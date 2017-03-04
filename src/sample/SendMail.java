package sample;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Created by Max Krawiec on 09/11/2016.
 */

/* DOESN'T WORK WITH NON-GMAIL EMAIL */

public class SendMail {

    //Try adding this to the submit button when a problem is submitted

    public SendMail(Admin a, String sender, String host, String title, String text , String myFileName)
    {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set sender
            message.setFrom(new InternetAddress(sender));

            // Set recipient
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(a.getEmail()));

            // Set subject
            message.setSubject(title);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            message.setText(text);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Add the attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(myFileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(myFileName);
            multipart.addBodyPart(messageBodyPart);//

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Sent...");
        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}