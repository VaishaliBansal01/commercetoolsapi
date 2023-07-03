/*
package com.demo.CT;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerBuilder;
import com.commercetools.api.models.customer.CustomerDraft;
import com.demo.CT.customer.CustomerDataProvider;
import com.demo.CT.customer.CustomerService;
import com.demo.CT.dto.CustomerDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerDataProviderTest {
    @Mock
    CustomerDataProvider cdp;

    @Test
   public void test_createCustomer()
    {
//        CustomerDraft info = CustomerDraft.builder().firstName("vas").build();

       */
/* Customer expectedCustomer = CustomerBuilder.of().email("v@gmail.com").buildUnchecked();
        Mockito.when(cdp.createCustomer(any())).thenReturn(expectedCustomer);

        CustomerDto dto = Mockito.mock(CustomerDto.class);
        when(dto.getEmail()).thenReturn("vaidali@gmail.com");

        Customer result = cs.createCustomer(dto);
        Assertions.assertEquals("v@gmail.com",result.getEmail());*//*

       Customer customer= Customer.builder().of()
               .email("arvind@gmail.com").password("masdngfk").buildUnchecked();
        CustomerDraft draft= CustomerDraft.builder()
                .email("abhgbsj@gmail.com").password("njkahfkjah")
                .build();
//        cdp.createCustomer(draft) ///customer
//        getPassword();
        OngoingStubbing na=Mockito.when(cdp.createCustomer(any()).g//customer return ho rah arvind@gmail pass
        Assertions.assertEquals("masdngfk",cdp.createCustomer(any()).getPassword());

//        Customer expectedCustomer = Customer.builder().email("vb@gmail.com").buildUnchecked();
//       Mockito.when(cdp.createCustomer(any())).thenReturn(expectedCustomer);
//
////        Customer result =
//        cdp.createCustomer(any()).getEmail();
//        Assertions.assertEquals("vb@gmail.com",cdp.createCustomer(any()).getEmail());

    }
}
*/
