package com.demo.CT.customer;

import com.commercetools.api.client.ProjectApiRoot;

import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.graph_ql.GraphQLRequest;
import com.commercetools.api.models.graph_ql.GraphQLResponse;
import com.commercetools.api.models.graph_ql.GraphQLVariablesMap;
import com.commercetools.api.models.type.Type;
import com.demo.CT.SpringEmailDemo.EmailSenderService;
import com.demo.CT.dto.CustomerDto;
import com.demo.CT.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private EmailService emailService;
    @Autowired
    ProjectApiRoot projectApiRoot;
    @Autowired
    CustomerService customerService;

   @PostMapping("/createCustomer")
   public Customer createCustomer(@RequestBody CustomerDto customerInfo)
   {
       log.info("customerInfo={}",customerInfo);
     return customerService.createCustomer(customerInfo);
//       return customer;
   }
   @GetMapping("/customers")
   public CustomerPagedQueryResponse getAllCustomer()
   {
       return projectApiRoot.customers().get().executeBlocking().getBody();
   }
    @GetMapping("/customers/graphql/{id}")
    public GraphQLResponse getAllCustomerGraphQl(@PathVariable String id)
    {
        return projectApiRoot.graphql().post(GraphQLRequest.builder().query("query Customers($id:String) {\n" +
                        " customer(id:$id){\n" +
                        "   id\n" +
                        "    email\n" +
                        "  }\n" +
                        "}").variables(GraphQLVariablesMap.builder().addValue("id",id).build()).build())
                .executeBlocking().getBody();
    }
//   @GetMapping("/customers/{id}")
//     public Customer getCustomerById(@PathVariable String id)
//   {
//      return cs.getById(id);
//   }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id){
       return customerService.getById(id);
    }
   @DeleteMapping("/customers`/{id}")
   public Customer deleteCustomer(@PathVariable String id)
   {
       return projectApiRoot.customers().withId(id).delete().addVersion(1).executeBlocking().getBody();
   }
  @PostMapping("/{id}")
   public Customer updateCustomer(@PathVariable String id,@RequestBody CustomerUpdate customerUpdate)
   {

       return projectApiRoot.customers().withId(id).post(customerUpdate).executeBlocking().getBody();
   }
  @PostMapping("/custom-type")
   public Type createCustom (@RequestBody CustomerDto customerInfo)
   {
       return customerService.createCustom(customerInfo);
   }

@PostMapping("/token")
 public CustomerToken createCustomerToken(@RequestBody CustomerDto customerInfo)
 {
     return customerService.createCustomerToken(customerInfo);
 }
 @PostMapping("/reset-password")
 public Customer resetp(@RequestBody CustomerDto customerInfo)
 {

     return customerService.resetPassword(customerInfo);
 }
@PostMapping("/change-password/{id}")
public Customer changePass(@RequestBody CustomerDto customerInfo, @PathVariable String id)
{
    return customerService.changePassword(customerInfo,id);
}
@PostMapping("/login")
public CustomerSignInResult getCusByLogin(@RequestBody CustomerDto customerInfo)
{

    return customerService.login(customerInfo);
}
@PostMapping("/create-token/{id}")
public String getEmailVerificationToken(@PathVariable String id)
{
    Customer customer = projectApiRoot.customers().withId(id).get().executeBlocking().getBody();
    CustomerToken verificationToken = customerService.getEmailVerificationToken(id);
    String token = verificationToken.getValue();

    emailService.sendSimpleMail(customer.getEmail(),
            "Email verification",
            "http://localhost:8085/verify-email/"+token);
    return token;

}
@GetMapping("/verify-email/{token}")
public String verifyEmail(@PathVariable String token) {
    return customerService.verifyEmail(token);
}
@GetMapping("/customer-by-email-token/{tokenValue}")
public Customer getCustomerByEmailToken(@PathVariable String tokenValue)
{
   return customerService.getCustomerByEmailToken(tokenValue);

}

}
