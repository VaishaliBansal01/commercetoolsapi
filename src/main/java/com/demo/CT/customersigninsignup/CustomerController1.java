package com.demo.CT.customersigninsignup;

import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerSignInResult;
import com.demo.CT.SpringEmailDemo.EmailSenderService;
import com.demo.CT.exceptions.CustomerNotFoundException;
import io.vrap.rmf.base.client.ApiHttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController1 {
    @Autowired
    CustomerService1 customerService;

    @Autowired
    private EmailSenderService emailSenderService;
    @PostMapping("/customer-sign-up")
    public String customerSignUp(@RequestBody CustomerDTO customerDTO) {
        Customer signInResult;
        try {
            signInResult  = customerService.customerSignUp(customerDTO);
                emailSenderService.sendEmail(signInResult.getEmail(),
                        "Customer Registration",
                        "Hey "+signInResult.getFirstName()+" your registration is succesful");

            return "registration successful";
        }
        catch (Exception e)
        {
            return (e.getMessage());
        }
    }
   @PostMapping("/customer-sign-in")
    public ResponseEntity<String> customerSignIn(@RequestBody CustomerDTO customerDTO) {
        CustomerSignInResult signInResult;
        try {
           signInResult = customerService.customerSignIn(customerDTO);
            String firstname = signInResult.getCustomer().getFirstName();
            String hi= "hi " + firstname + ", welcome to commercetools";
            return new ResponseEntity<>(hi, HttpStatus.OK);
        } catch(ApiHttpException e)
        {
          throw new CustomerNotFoundException(customerDTO.getEmail()+" is not found");
        }

    }
}