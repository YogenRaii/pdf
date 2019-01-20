package com.bitMiners.pdf.advice;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.email.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SignupAdvice {
    @Autowired
    private EmailService emailService;

    @AfterReturning("execution(* com.bitMiners.pdf.services.impl.UserServiceImpl.addUser(..))")
    public void aopEmail(JoinPoint jp) {
        User user = (User) jp.getArgs()[0];
        emailService.sendEmail(user.getEmail(), "Registration info", "Registered Sucessfully to Programming discussion forum!! " +
                "Your username is: " + user.getUsername() + ". Share your idea in PdF...");
    }
}
