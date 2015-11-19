package com.bitMiners.pdf.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.email.EmailService;
import com.bitMiners.pdf.service.ProfileService;
import com.bitMiners.pdf.service.UserService;

@Aspect
@Component
public class ProfileAdvice {
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;
	@After("execution(* com.bitMiners.pdf.repository.repositoryImpl.ProfileRepositoryImpl.update(..))")
	public void UpdateProfileEmail(JoinPoint jp) {
		Profile profile = (Profile) jp.getArgs()[0];
		User user = userService.getUserById(profile.getId());
		System.out.println("hello "+ user.getUsername());
		emailService.sendEmail(user.getEmail(), "Profile info","Update Profile Sucessfully "+
				"Your username is: "+user.getUsername()+". Your profile info is " + profile.toString());
//		
	}
}
