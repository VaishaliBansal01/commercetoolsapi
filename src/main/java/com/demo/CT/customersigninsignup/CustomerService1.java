package com.demo.CT.customersigninsignup;

import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerSignInResult;
import com.commercetools.api.models.customer.CustomerSignin;
import com.commercetools.api.models.me.MyCustomerDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService1 {
    @Autowired
    CustomerRepo customerRepo;
    public Customer customerSignUp(CustomerDTO customerDTO) {
        CustomerDraft customerDraft = CustomerDraft
                .builder()
                .email(customerDTO.getEmail())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .password(customerDTO.getPassword())
                .build();
        return customerRepo.customerSignUp(customerDraft);
    }

    public CustomerSignInResult customerSignIn(CustomerDTO customerDTO) {
        CustomerSignin customerDraft = CustomerSignin.builder()
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .build();
        return customerRepo.customerSignIn(customerDraft);
    }
}
