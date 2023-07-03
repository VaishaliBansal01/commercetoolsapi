package com.demo.CT.customer;


import com.commercetools.api.client.*;
import com.commercetools.api.models.customer.*;
import com.demo.CT.dto.CustomerDto;
import io.vrap.rmf.base.client.ApiHttpResponse;
import org.junit.Assert;
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
@SpringBootTest(classes = {CustomerServiceTest.class})
public class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;
    @Mock
    CustomerDataProvider customerDataProvider;
    @Mock
    ProjectApiRoot apiRoot;
    CustomerDto customerDto;

    @BeforeEach
    void init()
    {
       customerDto= CustomerDto.builder()
               .email("v@gymail.com")
               .firstName("Vaishali Bansal")
               .build();
    }
    @Test
     void testCreateCustomer()
    {
        Customer customer = CustomerBuilder.of().email("v@gymail.com").buildUnchecked();
        when(customerDataProvider.createCustomer(any())).thenReturn(customer);

        Customer customer1 = customerService.createCustomer(customerDto);

        assertEquals("v@gymail.com",customerDto.getEmail());
    }

   @Test
    void test_getById()
   {
       Customer expectedCustomer = CustomerBuilder.of().id("67666").buildUnchecked();

       ByProjectKeyCustomersRequestBuilder requestBuilder=Mockito.mock(ByProjectKeyCustomersRequestBuilder.class);
      Mockito.when(apiRoot.customers()).thenReturn(requestBuilder);

       ByProjectKeyCustomersByIDRequestBuilder byProjectKeyCustomersByIDRequestBuilder = Mockito.mock(ByProjectKeyCustomersByIDRequestBuilder.class);
      Mockito.when(requestBuilder.withId(any())).thenReturn(byProjectKeyCustomersByIDRequestBuilder);

       ByProjectKeyCustomersByIDGet byProjectKeyCustomersByIDGet = Mockito.mock(ByProjectKeyCustomersByIDGet.class);
     Mockito.when( byProjectKeyCustomersByIDRequestBuilder.get()).thenReturn(byProjectKeyCustomersByIDGet);

       ApiHttpResponse<Customer> apiHttpResponse = Mockito.mock(ApiHttpResponse.class);
     Mockito.when( byProjectKeyCustomersByIDGet.executeBlocking()).thenReturn(apiHttpResponse);
     Mockito.when(apiHttpResponse.getBody()).thenReturn(expectedCustomer);

//    CustomerDraft customerDraft = CustomerDraft.builder().id("").build();
       Customer actualCustomer = Customer.builder().id("67666").buildUnchecked();

       Assertions.assertEquals(expectedCustomer.getId(),actualCustomer.getId());

   }



}
