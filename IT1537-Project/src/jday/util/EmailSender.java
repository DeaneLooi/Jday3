package jday.util;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jday.entities.Member;



public class EmailSender {
		
	private final String jdaySend = "jday.sg@gmail.com";
	private final String jdayPW = "jdayjday";
	private String email = "";
	private Session session = null;
	private Member m = null;
	
		public EmailSender(Member member) {
		super();
		member.retrieveMemberInfo();
		this.m = member;
		this.email = member.getEmail() ;
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		  session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(jdaySend, jdayPW);
			}
		  });
		}
		public void sendBookingNumber(int i){

			String subject="Jday booking number";
			
			//get from database
			String JdayTo = email;
	 
			try {
	 
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(jdaySend));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JdayTo));
				message.setSubject(subject);
				message.setText("Dear member," + "\n" + "your booking number is: "+ i);
	 
				Transport.send(message);
				System.out.print("send");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}

		public void sendRegisterNumber(int i){

			String subject="Jday register number";
			
			//get from database
			String JdayTo = email;
			
	 
			try {
	 
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(jdaySend));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JdayTo));
				message.setSubject(subject);
				message.setText("Dear member," + "\n" + "your register number is: "+ i);
	 
				Transport.send(message);
				System.out.print("send");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
		
		public void sendMemberId(){

			String subject="Jday new member id";
			
			//get from database
			String JdayTo = email;
			
	 
			try {
	 
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(jdaySend));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JdayTo));
				message.setSubject(subject);
				message.setText("Dear member," + "\n" + "your new member Id is: "+ m.getMemberid()+"\n " +
						"your new pin is :"+m.getPin());
	 
				Transport.send(message);
				System.out.print("send");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
		
		public void sendPin(String pin){

			String subject="Jday new pin";
			
			//get from database
			String JdayTo = email;
			
	 
			try {
	 
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(jdaySend));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JdayTo));
				message.setSubject(subject);
				message.setText("Dear member," + "\n" + "your new pin is: "+ pin);
	 
				Transport.send(message);
				System.out.print("send");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
		
		public boolean sendValidation() throws AddressException, MessagingException{
			boolean valid = false;
			String subject="Jday Email Verification";
			
			//get from database
			String JdayTo = email;
			
	 
			try {
	 
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(jdaySend));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JdayTo));
				message.setSubject(subject);
				message.setText("Dear "+m.getName()+"," + "\n" + "this is sent to verify your email address. \nYou would receive your Jday account information shortly.");
	 
				Transport.send(message);
				valid = true;
			} catch (SendFailedException e) {
				valid = false;
				
			}
			
			return valid;
	}
		
	}

