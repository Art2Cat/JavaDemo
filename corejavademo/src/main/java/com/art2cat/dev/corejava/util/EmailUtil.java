package com.art2cat.dev.corejava.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 25/12/2017
 */
public class EmailUtil {
    
    /**
     * Utility method to send simple HTML email
     */
    public static void sendEmail(Session session, String toEmail, String subject,
        String body)
        throws MessagingException {
        
        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        
        // msg.setFrom(new InternetAddress("no_reply@journaldev.com", "NoReply-JD"));
        //
        // msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));
        
        msg.setSubject(subject, "UTF-8");
        
        msg.setText(body, "UTF-8");
        
        msg.setSentDate(new Date());
        
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        System.out.println("Message is ready");
        Transport.send(msg);
        
        System.out.println("EMail Sent Successfully!!");
        
    }
    
    /**
     * Utility method to send email with attachment
     */
    public static void sendAttachmentEmail(Session session, String toEmail, String subject,
        String body,
        List<String> files) throws MessagingException {
        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        
        msg.setSubject(subject, "UTF-8");
        
        msg.setSentDate(new Date());
        
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        
        // Create the message body part
        BodyPart messageBodyPart = new MimeBodyPart();
        
        // Fill the message
        messageBodyPart.setText(body);
        
        // Create a multipart message for attachment
        Multipart multipart = new MimeMultipart();
        
        // Set text message part
        multipart.addBodyPart(messageBodyPart);
        
        for (String path : files) {
            Path filePath = Paths.get(path);
            File file = filePath.toFile();
            if (file.exists() && file.isFile()) {
                attachFile(multipart, Paths.get(path));
            }
        }
        
        // Send the complete message parts
        msg.setContent(multipart);
        
        // Send message
        Transport.send(msg);
        System.out.println("EMail Sent Successfully with attachment!!");
    }
    
    /**
     * Attach file to mail
     */
    private static void attachFile(Multipart multipart, Path filePath) throws MessagingException {
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filePath.toString());
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filePath.getFileName().toString());
        //Trick is to add the content-id header here
        if (isImageFormat(filePath.getFileName().toString().toLowerCase())) {
            messageBodyPart
                .setHeader("Content-ID", String.format("%s", filePath.getFileName().toString()));
        }
        multipart.addBodyPart(messageBodyPart);
    }
    
    /**
     * Verify the file is an image.
     */
    private static boolean isImageFormat(String fileName) {
        return Stream.of(".jpg", ".jpeg", ".png", ".gif").anyMatch(fileName::contains);
    }
    
    /**
     * Attach image file.
     */
    private static void attachImageFile(Multipart multipart, Path filePath)
        throws MessagingException {
        attachFile(multipart, filePath);
        BodyPart messageBodyPart = new MimeBodyPart();
        
        //third part for displaying image in the email body
        messageBodyPart.setContent(
            String.format("<h1>Attached Image</h1>" + "<img src='cid:%s'>",
                filePath.getFileName().toString()),
            "text/html");
        multipart.addBodyPart(messageBodyPart);
    }
    
    /**
     * Utility method to send image in email body
     */
    public static void sendImageEmail(Session session, String toEmail, String subject,
        String body,
        Map<String, String> filePaths) throws MessagingException {
        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        
        msg.setSubject(subject, "UTF-8");
        
        msg.setSentDate(new Date());
        
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        
        // Create the message body part
        BodyPart messageBodyPart = new MimeBodyPart();
        
        messageBodyPart.setText(body);
        
        // Create a multipart message for attachment
        Multipart multipart = new MimeMultipart();
        
        // Set text message part
        multipart.addBodyPart(messageBodyPart);
        
        // Second part is image attachment
        if (!filePaths.isEmpty()) {
            Set<String> keys = filePaths.keySet();
            for (String type : keys) {
                Path filePath = Paths.get(filePaths.get(type));
                if (type.equals("image")) {
                    attachImageFile(multipart, filePath);
                } else {
                    attachFile(multipart, filePath);
                }
            }
        }
        
        //Set the multipart message to the email message
        msg.setContent(multipart);
        
        // Send message
        Transport.send(msg);
        System.out.println("EMail Sent Successfully with image!!");
    }
}
