package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.enviodeemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	private static final int PORT = 587;
	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final String SMTP_USERNAME = "avaliacaolikertinfnet@gmail.com";
	private static final String SMTP_PASSWORD = "projetofinal2017";
	private static final String FROM = "avaliacaolikertinfnet@gmail.com";
	private static final String CHARSET = "text/html; charset=UTF-8";
	
	public static void enviarEmail(String emailTo) throws Exception {
		Session session = Session.getInstance(getSystemProperties(),
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
				}
			});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FROM));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
		message.setSubject("teste e-mail");
		message.setContent("Testando o corpo do e-mail.", CHARSET);

		Transport.send(message);
	}
	
	private static Properties getSystemProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.socketFactory.port", PORT);
                props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", PORT);
		return props;
	}
			
}