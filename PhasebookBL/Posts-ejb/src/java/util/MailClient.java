package util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


/**
 *  Nome: MailClient
 *  Finalidade: Esta classe tem como finalidade o envio de emails
 *  @author: Nuno Khan
 *
 **/
public class MailClient{
    
    /**
    * Envia um email ao user caso o target se encontre numa zona proibida.
    * 1- Receber os parametros user, pass, mailServer, to, subject e messageBody
    * 2- Enviar o email para o user
    * Data de criacao: 30/04/2011
    * @author: Nuno Khan
    * @param user - string com o username 
    * @param pass - string com a password 
    * @param mailServer - string com o nome do servidor de email
    * @param to - string com o endereço email do destinatario 
    * @param subject - string com o assunto do email 
    * @param messageBody - string com o corpo do email 
    */
    public void sendMail(String user, String pass, String mailServer, String to, String subject, String messageBody)
            throws MessagingException, AddressException {
        
        // Setup mail server
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");

        // Get a mail session
        Session session = Session.getDefaultInstance(props, null);

        // Define a new mail message
        Message message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);

        // Create a message part to represent the body text
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(messageBody);

        //use a MimeMultipart as we need to handle the file attachments
        Multipart multipart = new MimeMultipart();

        //add the message body to the mime message
        multipart.addBodyPart(messageBodyPart);

        // Put all message parts in the message
        message.setContent(multipart);

        // Send the message
        Transport t = session.getTransport("smtps");
        try {
            t.connect(mailServer, user, pass);
            t.sendMessage(message, message.getAllRecipients());
        } finally {
            t.close();
        }
    }
 } 