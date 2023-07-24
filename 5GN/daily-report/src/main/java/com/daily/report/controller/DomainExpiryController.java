package com.daily.report.controller;

import com.daily.report.service.DomainExpiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class DomainExpiryController {

    @Autowired
    private DomainExpiryService domainExpiryService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmailWithAttachment() {
        try {
            domainExpiryService.sendEmailWithAttachment();
            return new ResponseEntity<>("Email sent successfully.", HttpStatus.OK);
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to send email.", HttpStatus.OK);
        }
    }
}