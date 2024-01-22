package com.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmailController {
	
	 @Value("${spring.mail.username}") private String sender;
	 
	 @Autowired
	 JavaMailSender javaMailSender;
	 
	 @GetMapping("/email-send")
	 public ResponseEntity<?> sendSimpleMail()
	    {
	 
	       
	 SimpleMailMessage mailMessage=new SimpleMailMessage();
	            
	            
	 
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo("abc@gmail.com");
	            mailMessage.setText("Hi ,write msg here...");
	            mailMessage.setSubject("write subject");
	 
	            
	            javaMailSender.send(mailMessage);
	            
	            return new ResponseEntity<>(HttpStatus.OK);
	            
	    }

}
