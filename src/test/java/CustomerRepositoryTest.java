import com.commercetools.api.client.ByProjectKeyCustomersPost;
import com.commercetools.api.client.ByProjectKeyCustomersRequestBuilder;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerBuilder;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerSignInResult;
import com.demo.CT.customer.CustomerDataProvider;
import com.demo.CT.dto.CustomerDto;
import io.vrap.rmf.base.client.ApiHttpRequest;
import io.vrap.rmf.base.client.ApiHttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;


@SpringBootTest(classes = CustomerRepositoryTest.class)
public class CustomerRepositoryTest {

    @InjectMocks
// annotation is used to inject the mock object created by @Mock into the target class.
    CustomerDataProvider customerDataProvider;
    @Mock
    //annotation is used to create a mock object of a class or interface, which is used to simulate the behavior of a real object
    ProjectApiRoot apiRoot;

    CustomerDto customerDto;
  /*  @BeforeEach
    void init()
    {
        customerDto= CustomerDto.builder()
                .email("v@gymail.com")
                .firstName("Vaishali Bansal")
                .build();
    }*/
    @Test
    void test_createCustomer()
    {
/*        Customer customer = CustomerBuilder.of().email("ggg@gmail.com").buildUnchecked();

        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder= Mockito.mock(ByProjectKeyCustomersRequestBuilder.class);
        Mockito.when(apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        ByProjectKeyCustomersPost byProjectKeyCustomersPost = Mockito.mock(ByProjectKeyCustomersPost.class);
        Mockito.when(byProjectKeyCustomersRequestBuilder.post(any(CustomerDraft.class))).thenReturn(byProjectKeyCustomersPost);

        ApiHttpResponse<CustomerSignInResult> customerSignInResultApiHttpResponse= Mockito.mock(ApiHttpResponse.class);
        Mockito.when(byProjectKeyCustomersPost.executeBlocking()).thenReturn(customerSignInResultApiHttpResponse);

        CustomerSignInResult customerSignInResult = Mockito.mock(CustomerSignInResult.class);
        Mockito.when(customerSignInResultApiHttpResponse.getBody()).thenReturn(customerSignInResult);
        Mockito.when(customerSignInResult.getCustomer()).thenReturn(customer);

        CustomerDraft customerDraft = CustomerDraft
                .builder()
                .email("ggg@gmail.com")
                .build();
//        Customer actualCustomer = customerDataProvider.createCustomer(customerDraft);
       Assertions.assertEquals(customer.getEmail(),customerDraft.getEmail());*/
       /* CustomerDraft customerDraft = CustomerDraft.builder().email("xyz@gmail.com").firstName("xyz").buildUnchecked();
        Customer customer = Customer.builder().email("xyz@gmail.com").firstName("xyz").buildUnchecked();
        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder = Mockito.mock(ByProjectKeyCustomersRequestBuilder.class);
        Mockito.when(apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        ByProjectKeyCustomersPost byProjectKeyCustomersPost = Mockito.mock(ByProjectKeyCustomersPost.class);
        Mockito.when(byProjectKeyCustomersRequestBuilder.post(customerDraft)).thenReturn(byProjectKeyCustomersPost);

        ApiHttpResponse<CustomerSignInResult> customerSignInResultApiHttpResponse = Mockito.mock(ApiHttpResponse.class);
        Mockito.when(byProjectKeyCustomersPost.executeBlocking()).thenReturn(customerSignInResultApiHttpResponse);

        CustomerSignInResult customerSignInResult = Mockito.mock(CustomerSignInResult.class);
        Mockito.when(customerSignInResultApiHttpResponse.getBody()).thenReturn(customerSignInResult);

        Mockito.when(customerSignInResult.getCustomer()).thenReturn(customer);

        Assertions.assertEquals(customer.getFirstName(),customerDraft.getFirstName());
*/
        Customer customer = Customer.builder().email("h@gmail.com").buildUnchecked();
        CustomerDraft customerDraft = CustomerDraft.builder().email("hn@gmail.com").buildUnchecked();

        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder=Mockito.mock(ByProjectKeyCustomersRequestBuilder.class);
        Mockito.when(apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        ByProjectKeyCustomersPost byProjectKeyCustomersPost = Mockito.mock(ByProjectKeyCustomersPost.class);
        Mockito.when(byProjectKeyCustomersRequestBuilder.post(customerDraft)).thenReturn(byProjectKeyCustomersPost);

        ApiHttpResponse<CustomerSignInResult> customerSignInResultApiHttpResponse = Mockito.mock(ApiHttpResponse.class);
        Mockito.when(byProjectKeyCustomersPost.executeBlocking()).thenReturn(customerSignInResultApiHttpResponse);

        CustomerSignInResult customerSignInResult = Mockito.mock(CustomerSignInResult.class);
        Mockito.when(customerSignInResultApiHttpResponse.getBody()).thenReturn(customerSignInResult);

        Mockito.when(customerSignInResult.getCustomer()).thenReturn(customer);
        Assertions.assertEquals(customer.getEmail(),customerDraft.getEmail());
    }

}
