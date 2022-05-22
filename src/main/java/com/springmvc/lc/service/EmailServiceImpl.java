package com.springmvc.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
	
	@Autowired
	private JavaMailSender javaMailSenderImpl;
	
	public void sendEmail(String userName, String crushName, String emailTo, String result) {
			
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emailTo);
		mailMessage.setSubject("LC App Result");
		mailMessage.setText("Hi "+userName+ " \n Lc App result for the " +userName+" and "+crushName+" is \n"+result);
	
		javaMailSenderImpl.send(mailMessage);
	}

}
