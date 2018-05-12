package com.gzr.StationLocator.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailClient {

	private JavaMailSender mailSender;
	private MailHTML mailHTML;
	 
    @Autowired
    public MailClient(JavaMailSender mailSender,MailHTML mailHTML) {
        this.mailSender = mailSender;
        this.mailHTML = mailHTML;
    }
 
    public void prepareAndSendSimple(String recipient, String message) {
        
    	MimeMessagePreparator preparator = mime->{
    		MimeMessageHelper messageHelper = new MimeMessageHelper(mime);
            messageHelper.setFrom("ivn.males@gmail.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Sample mail subject");
            messageHelper.setText(message);
    		
    		
    	};
    	
    	try {
            mailSender.send(preparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    	
    	
    }
    
 public void prepareAndSendHTML(String recipient, String message) {
        
    	MimeMessagePreparator preparator = mime->{
    		MimeMessageHelper messageHelper = new MimeMessageHelper(mime);
            messageHelper.setFrom("ivn.males@gmail.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Sample mail subject");
            
            String content = mailHTML.build(message);
            messageHelper.setText(content,true);
            
    		
    		
    	};
    	
    	try {
            mailSender.send(preparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    	
    	
    }
}
