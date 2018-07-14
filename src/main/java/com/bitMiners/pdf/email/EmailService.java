package com.bitMiners.pdf.email;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
