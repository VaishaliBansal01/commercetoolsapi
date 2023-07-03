package com.demo.CT.email;

import com.commercetools.api.models.customer.Customer;
import com.demo.CT.customer.CustomerService;
import com.demo.CT.email.EmailDetails;
import com.demo.CT.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    CustomerService customerService;

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
//        @PostMapping("/sendMail")
//    public String sendMail(@RequestBody EmailDetails details)
//        {
////            Customer customer =customerService.createCustomer();
//        String status = emailService.sendSimpleMail(details);
//
//        return status;
//    }
}