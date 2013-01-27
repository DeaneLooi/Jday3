package jday.util;

import java.util.*;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
		
		public static void main(String[] args){
		
		final String jdaySend = "jday.sg@gmail.com";
		final String jdayPW = "jdayjday";
		String subject="Jday booking number";
		
		//send to yuwen acc
		String JdayTo ="d.yuwen.yw@gmail.com";
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(jdaySend, jdayPW);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(jdaySend));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JdayTo));
			message.setSubject(subject);
			message.setText("Dear member," + "\n" + "your booking number is: ");
 
			Transport.send(message);
			System.out.print("send");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

}
	}

