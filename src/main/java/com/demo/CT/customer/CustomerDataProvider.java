package com.demo.CT.customer;

import ch.qos.logback.core.net.server.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.type.FieldDefinition;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypeDraft;
import com.demo.CT.config.CTConfiguration;
import com.demo.CT.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerDataProvider {


@Autowired
    ProjectApiRoot apiRoot;

    public Customer createCustomer(CustomerDraft customerDraft) {

        return apiRoot
                .customers()
                .post(customerDraft)
                .executeBlocking()
                .getBody()
                .getCustomer();
    }

    public Type createCustom(TypeDraft typeDraft) {

        return apiRoot.types().post(typeDraft).executeBlocking().getBody();
    }

    public CustomerToken createCustomerToken(CustomerCreatePasswordResetToken token)
    {
        return apiRoot.customers().passwordToken().post(token).executeBlocking().getBody();
    }
    public Customer resetPassword(CustomerResetPassword crp)
    {
        return apiRoot.customers().passwordReset().post(crp).executeBlocking().getBody();
    }

    public Customer rtPass (CustomerChangePassword ccp)
    {

        return apiRoot.customers().password().post(ccp).executeBlocking().getBody();
    }


    public CustomerSignInResult getCustomerByLogin(CustomerSignin csi) {

        return apiRoot.login().post(csi).executeBlocking().getBody();
    }



    public Customer vc(String id)
    {
        return apiRoot.customers().withId(id).get().executeBlocking().getBody();
    }

    public CustomerToken getEmailVerificationToken(CustomerCreateEmailToken customerCreateEmailToken) {
        return apiRoot.customers().emailToken().post(customerCreateEmailToken).executeBlocking().getBody();
    }

    public String verifyEmail(String token) {
        Customer body = apiRoot.customers().emailConfirm()
                .post(CustomerEmailVerify.builder()
                        .tokenValue(token)
                        .build())
                .executeBlocking().getBody();
        return "success";
    }

    public Customer getCustomerByEmailToken(String tokenValue) {
        return apiRoot.customers().withEmailToken(tokenValue).get().executeBlocking().getBody();
    }
}
