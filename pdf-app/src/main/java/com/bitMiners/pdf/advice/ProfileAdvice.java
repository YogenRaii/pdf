package com.bitMiners.pdf.advice;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.email.EmailService;
import com.bitMiners.pdf.services.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfileAdvice {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;

    @After("execution(* com.bitMiners.pdf.repositories.impl.ProfileRepositoryImpl.update(..))")
    public void UpdateProfileEmail(JoinPoint jp) {
        Profile profile = (Profile) jp.getArgs()[0];
        User user = userService.getUserById(profile.getId());
        emailService.sendEmail(user.getEmail(), "Profile info", "Update Profile Sucessfully " +
                "Your username is: " + user.getUsername() + ". Your profile info is " + profile.toString());
    }
}
