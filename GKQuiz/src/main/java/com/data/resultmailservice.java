package com.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@ConditionalOnProperty(prefix = "spring.mail", value = { "username", "host", "password" })
public class resultmailservice {

	
	@Autowired
	JavaMailSender mailSender;
	
	public void sendSimpleSpittleEmail(User user, userresult result) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("noreply@gkquiz.com");
		message.setTo(user.getEmail());
		message.setSubject("GK quiz result");
		message.setText("Hello" + user.getFullName()+ "Please find below the result of the quiz ");
		message.setText("Correct Answers : " + result.getCorrect()+" " + "Incorerct Answers : "+ result.getIncorrect());
				
		mailSender.send(message);
		}
	
	
}
