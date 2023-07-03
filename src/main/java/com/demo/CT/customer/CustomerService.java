package com.demo.CT.customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.type.*;
import com.demo.CT.config.CTConfiguration;
import com.demo.CT.dto.CustomerDto;
//import com.demo.CT.dto.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.RequestEntity.post;
@Service
public class CustomerService {


    ProjectApiRoot apiRoot = CTConfiguration.createApiClient();
    @Autowired
    CustomerDataProvider cdp;




    public Customer createCustomer(CustomerDto info){
//CustomerDraft cd=new;
        //Modelmapper m=new ModdelaMppare();
        //TrrgetTypeClass targetClassInstance=m.convert(info,cd);

//        CustomerDraft customerDraft= new CustomerDraftImpl();
       /* customerDraft.setEmail(info.getEmail());
        customerDraft.setFirstName(info.getFirstName());
        customerDraft.setLastName(info.getLastName());
        customerDraft.setPassword(info.getPassword());*/
  CustomerDraft customerDraft = CustomerDraft.builder()
          .email(info.getEmail())
          .firstName(info.getFirstName())
          .lastName(info.getLastName())
          .password(info.getPassword())
//          .custom(customFieldsDraftBuilder -> customFieldsDraftBuilder
//                  .type(typeResourceIdentifierBuilder -> typeResourceIdentifierBuilder.key(info.getCustomKey()))
//                  .fields(fieldContainerBuilder -> fieldContainerBuilder.addValue(info.getFildName(),info.getEmailP())))
          .build();

        return cdp.createCustomer(customerDraft);
    }

    public static void updateCustomer(CustomerUpdate customerUpdate,CustomerDto customerInfo)
    {
        CustomerUpdate customer1= CustomerUpdate
                .builder()
                .version(customerUpdate.getVersion())
                .plusActions(actionbuilder->actionbuilder.setFirstNameBuilder().firstName(customerInfo.getFirstName()))
                .build();
    }

    public Type createCustom(CustomerDto customerInfo)
    {
          FieldDefinition fieldDefinition = FieldDefinition
                  .builder()
                  .type(FieldType.stringBuilder().build())
                  .name(customerInfo.getCustomFieldName())
                  .label(LocalizedString.ofEnglish(customerInfo.getCustomLabel()))

                  .inputHint(TypeTextInputHint.SINGLE_LINE)
//                  .required(customerInfo.customRequired)
                  .build();
          TypeDraft typeDraft= TypeDraft
                  .builder()
                  .fieldDefinitions(List.of(fieldDefinition))
                  .key(customerInfo.getCustomKey())
                  .name(LocalizedString.ofEnglish(customerInfo.getCustomTypeName()))
                  .resourceTypeIds(List.of(ResourceTypeId.CUSTOMER)).build();
        return cdp.createCustom(typeDraft);
    }

    public CustomerToken createCustomerToken(CustomerDto customerInfo)
    {
        CustomerCreatePasswordResetToken token= CustomerCreatePasswordResetToken.builder()
                .email(customerInfo.getEmail()).build();
        return cdp.createCustomerToken(token);
    }

    public Customer resetPassword(CustomerDto customerInfo)
    {
       CustomerResetPassword crp = CustomerResetPassword.builder()
               .version(customerInfo.getVersion())
               .tokenValue(customerInfo.getTokenValue())
               .newPassword(customerInfo.getNewPassword())
               .build();
        return cdp.resetPassword(crp);
    }
    public Customer changePassword(CustomerDto customerInfo,String id)
    {
        CustomerChangePassword ccp = CustomerChangePassword.builder()
                .version(customerInfo.getVersion())
                .id(id)
                .currentPassword(customerInfo.getCurrentPassword())
                .newPassword(customerInfo.getNewPassword())
                .build();

        return cdp.rtPass(ccp);
    }

   public CustomerSignInResult login(CustomerDto customerInfo)
   {
       CustomerSignin csi = CustomerSignin .builder()
               .email(customerInfo.getEmail())
               .password(customerInfo.getPassword())
               .build();
       return cdp.getCustomerByLogin(csi);
   }


    public Customer getById(String id){
         return apiRoot.customers()
                 .withId(id)
                 .get()
                 .executeBlocking()
                 .getBody();
    }

    public CustomerToken getEmailVerificationToken(String id) {
        CustomerCreateEmailToken customerCreateEmailToken = CustomerCreateEmailToken
                .builder()
                .id(id)
                .ttlMinutes(5000L)
                .build();
        return cdp.getEmailVerificationToken(customerCreateEmailToken);
    }

    public String verifyEmail(String token) {

        return cdp.verifyEmail(token);
    }

    public Customer getCustomerByEmailToken(String tokenValue) {
       return cdp.getCustomerByEmailToken(tokenValue);
    }
}
