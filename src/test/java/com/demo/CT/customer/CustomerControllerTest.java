package com.demo.CT.customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerBuilder;
import com.commercetools.api.models.customer.CustomerDraft;
import com.demo.CT.dto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest(classes = CustomerControllerTest.class)
public class CustomerControllerTest {
    @InjectMocks
    CustomerController customerController;
     @Mock
    CustomerService customerService;
    @Mock
     CustomerDto customerDto;

  /*  @BeforeEach
    void init()
    {
        //expected
      customerDto = CustomerDto.builder()
                .email("v@gyil.com")
                .firstName("Vaish")
                .build();
    }*/
    @Test
    void test_createCustomer()
    {
//        customerService.createCustomer(customerDto);
        Customer customer= CustomerBuilder.of().email("v@gyil.com").buildUnchecked();

        Mockito.when(customerService.createCustomer(any())).thenReturn(customer);

            Customer customer1= customerController.createCustomer(customerDto);
        System.out.println(customer1.getEmail());
        System.out.println(customer.getEmail());

        Assertions.assertEquals(customer.getEmail(),customer1.getEmail());

      /* Customer customer= Customer.builder().email("v@gymail.com")
                .firstName("Riya")
                .buildUnchecked();
       CustomerDto customerDto = CustomerDto.builder().firstName("kyu Riya").build();


        Mockito.when( customerService.createCustomer(any(CustomerDto.class))).thenReturn(customer);
        Customer customer1 =  customerController.createCustomer(customerDto);


        Assertions.assertEquals(customer.getFirstName(),customer1.getFirstName());*/
    }

}
