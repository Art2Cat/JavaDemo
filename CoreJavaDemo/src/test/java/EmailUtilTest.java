import com.art2cat.dev.corejava.EmailUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * PACKAGE_NAME
 *
 * @author Rorschach
 * @date 25/12/2017
 */
public class EmailUtilTest {
    
    // telnet smtp.gmail.com 587
    
    private Properties createEmailProperties() {
        Properties mailProp = new Properties();
        // SMTP Host
        mailProp.put("mail.smtp.host", "smtp-mail.outlook.com");
        //TLS Port
        mailProp.put("mail.smtp.port", "587");
        // mailProp.put("mail.transport.protocol", "smtp");
        mailProp.put("mail.smtp.connectiontimeout", "25000");
        mailProp.put("mail.smtp.timeout", "25000");
        mailProp.put("mail.smtp.writetimeout", "25000");
        // enable authentication
        mailProp.put("mail.smtp.auth", "true");
        return mailProp;
    }
    
    @Test
    public void testSimpleMail() {
        System.out.println("SimpleEmail Start");
        
        String emailID = "yiming.whz@gmail.com";
        
        Session session = Session.getInstance(createEmailProperties(), null);
        
        try {
            EmailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
        } catch (MessagingException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void testTSLMail() {
        final String fromEmail = "tes@test.com";
        final String password = "password";
        final String toEmail = "toemail@email.com";
        System.out.println("TLSEmail Start");
        Properties mailProp = new Properties();
        // SMTP Host
        mailProp.put("mail.smtp.host", "pop-mail.outlook.com");
        //TLS Port
        mailProp.put("mail.smtp.port", "995");
        mailProp.put("mail.transport.protocol", "pop");
        mailProp.put("mail.smtp.connectiontimeout", "25000");
        mailProp.put("mail.smtp.timeout", "25000");
        mailProp.put("mail.smtp.writetimeout", "25000");
        // Enabling SMTP Authentication
        mailProp.put("mail.smtp.auth", "true");
        mailProp.put("mail.smtp.starttls.enable", "true");
        
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(mailProp, auth);
        
        try {
            EmailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body");
        } catch (MessagingException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void testSSLMail() {
        final String fromEmail = "tes@test.com";
        final String password = "password";
        final String toEmail = "toemail@email.com";
        
        System.out.println("SSLEmail Start");
        Properties mailProp = new Properties();
        // SMTP Host
        mailProp.put("mail.smtp.host", "smtp.gmail.com");
        //TLS Port
        mailProp.put("mail.smtp.port", "587");
        mailProp.put("mail.smtp.connectiontimeout", "25000");
        mailProp.put("mail.smtp.timeout", "25000");
        mailProp.put("mail.smtp.writetimeout", "25000");
        // Enabling SMTP Authentication
        mailProp.put("mail.smtp.auth", "true");
        mailProp.put("mail.smtp.starttls.enable", "true");
        // SSL Port
        mailProp.put("mail.smtp.socketFactory.port", "587");
        // SSL Factory Class
        mailProp.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        
        Session session = Session.getDefaultInstance(mailProp, auth);
        System.out.println("Session created");
        try {
            EmailUtil.sendEmail(session, toEmail, "SSLEmail Testing Subject", "SSLEmail Testing Body");
        } catch (MessagingException e) {
            e.printStackTrace();
            Assert.fail();
        }
        
        // EmailUtil.sendAttachmentEmail(session, toEmail, "SSLEmail Testing Subject with Attachment",
        //                               "SSLEmail Testing Body with Attachment");
        //
        // EmailUtil.sendImageEmail(session, toEmail, "SSLEmail Testing Subject with Image",
        //                          "SSLEmail Testing Body with Image");
        
    }
}
