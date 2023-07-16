import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class SendEmail
{  
 public static void send(String receiver, String subject, String mes){ 
      String to = receiver;//change accordingly  
      String from = "radu.serbanescu@365.univ-ovidius.ro";//change accordingly  
      String host = "localhost";//or IP address  
  
     //Get the session object  
      Properties properties = System.getProperties();  
      properties.setProperty("mail.smtp.host", host);  
      Session session = Session.getDefaultInstance(properties);  
  
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
         message.setSubject(subject);  
         message.setText(mes);  
  
         // Send message  
         Transport.send(message);  
         System.out.println("Message sent successfully....");  
  
      }catch (MessagingException mex) {mex.printStackTrace();}  
   }
}  