package com.rishabh.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender mailsender;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(EmailUtil.class);
	
	public void sendItinerary(String toAddress,String filepath){
		
		LOGGER.info("Inside Send Ininerary()");
		
		MimeMessage message=mailsender.createMimeMessage() ;
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary for your Flight");
			mimeMessageHelper.setText("Please find your Itinerary Attached.");
			mimeMessageHelper.addAttachment("Itinerary", new File(filepath));
			mailsender.send(message);
			
		}catch(MessagingException e){
			
			LOGGER.error("Exception inside send Intinerary "+e);
					
		}
		
		
		
		
	}

}
