package com.ait.main.utills;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	
	@Autowired
	private JavaMailSender send;
        
	public void sendMail(String subject,String body,String to,File f ) {
		
		
		 try{
			 
			 MimeMessage mimeMsg = send.createMimeMessage();
			 
			 MimeMessageHelper helper=new MimeMessageHelper(mimeMsg, true);
			 
			 helper.setSubject(subject);
			 helper.setText(body,true);
			 helper.setTo(to);
			 helper.addAttachment("plan.xmls",f);
			 
			 send.send(mimeMsg);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		     
	}
}
