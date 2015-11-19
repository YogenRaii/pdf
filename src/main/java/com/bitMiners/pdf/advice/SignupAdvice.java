package com.bitMiners.pdf.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.email.EmailService;

@Aspect
@Component
public class SignupAdvice {
	@Autowired
	private EmailService emailService;

	@After("execution(* com.bitMiners.pdf.repository.repositoryImpl.UserRepositoryImpl.add(..))")
	public void aopEmail(JoinPoint jp) {
		System.out.println("hello sabin");
		User user = (User) jp.getArgs()[0];
//		emailService.sendEmail(user.getEmail(), "Registration info","Registered Sucessfully to Programming discussion forum!! "+
//				"Your username is: "+user.getUsername()+". Share your idea in PdF...");
//		
	}
}
