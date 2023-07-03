package com.demo.CT.customersigninsignup;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerSignInResult;
import com.commercetools.api.models.customer.CustomerSignin;
import com.commercetools.api.models.me.MyCustomerDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepo {
    @Autowired
    ProjectApiRoot apiRoot;
    public Customer customerSignUp(CustomerDraft customerDraft) {
        return apiRoot.customers().post(customerDraft).executeBlocking().getBody().getCustomer();
    }


    public CustomerSignInResult customerSignIn(CustomerSignin customerDraft) {
        return apiRoot.login().post(customerDraft).executeBlocking().getBody();
    }
}
