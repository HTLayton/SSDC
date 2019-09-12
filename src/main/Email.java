package main;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
	public static void main(String[] args) {
		
		sendEmail("grantw99@gmail.com", "Test 1", "This is simply a test.\nIgnore it.");
		
	}
	
	public static void sendEmail(String target, String subject, String body) {
		final String username = "securesoftwaredevelopers123@gmail.com";
		final String password = "password123!@#";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		
		try {		
			Message message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(target));
			message.setSubject(subject);
			message.setText(body);
			
			Transport.send(message);
			
			System.out.print("Done");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
