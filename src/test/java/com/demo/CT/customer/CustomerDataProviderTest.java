package com.demo.CT.customer;

import com.commercetools.api.client.ByProjectKeyCustomersRequestBuilder;
import com.commercetools.api.client.ByProjectKeyLoginRequestBuilder;
import com.commercetools.api.client.ByProjectKeyTypesRequestBuilder;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypeDraft;
import io.vrap.rmf.base.client.ApiHttpClient;
import io.vrap.rmf.base.client.http.HandlerStack;
import io.vrap.rmf.base.client.http.HttpHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerDataProviderTest {

    private CustomerDataProvider customerDataProviderUnderTest;

    @BeforeEach
    void setUp() {
        customerDataProviderUnderTest = new CustomerDataProvider();
        customerDataProviderUnderTest.apiRoot = mock(ProjectApiRoot.class);
    }

    @Test
    void testCreateCustomer() {
        // Setup
        final CustomerDraft customerDraft = CustomerDraft.of();

        // Configure ProjectApiRoot.customers(...).
        final ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder = new ByProjectKeyCustomersRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        // Run the test
        final Customer result = customerDataProviderUnderTest.createCustomer(customerDraft);

        // Verify the results
    }

    @Test
    void testCreateCustom() {
        // Setup
        final TypeDraft typeDraft = TypeDraft.of();

        // Configure ProjectApiRoot.types(...).
        final ByProjectKeyTypesRequestBuilder byProjectKeyTypesRequestBuilder = new ByProjectKeyTypesRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.types()).thenReturn(byProjectKeyTypesRequestBuilder);

        // Run the test
        final Type result = customerDataProviderUnderTest.createCustom(typeDraft);

        // Verify the results
    }

    @Test
    void testCreateCustomerToken() {
        // Setup
        final CustomerCreatePasswordResetToken token = CustomerCreatePasswordResetToken.of();

        // Configure ProjectApiRoot.customers(...).
        final ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder = new ByProjectKeyCustomersRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        // Run the test
        final CustomerToken result = customerDataProviderUnderTest.createCustomerToken(token);

        // Verify the results
    }

    @Test
    void testResetPassword() {
        // Setup
        final CustomerResetPassword crp = CustomerResetPassword.of();

        // Configure ProjectApiRoot.customers(...).
        final ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder = new ByProjectKeyCustomersRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        // Run the test
        final Customer result = customerDataProviderUnderTest.resetPassword(crp);

        // Verify the results
    }

    @Test
    void testRtPass() {
        // Setup
        final CustomerChangePassword ccp = CustomerChangePassword.of();

        // Configure ProjectApiRoot.customers(...).
        final ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder = new ByProjectKeyCustomersRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        // Run the test
        final Customer result = customerDataProviderUnderTest.rtPass(ccp);

        // Verify the results
    }

    @Test
    void testGetCustomerByLogin() {
        // Setup
        final CustomerSignin csi = CustomerSignin.of();

        // Configure ProjectApiRoot.login(...).
        final ByProjectKeyLoginRequestBuilder byProjectKeyLoginRequestBuilder = new ByProjectKeyLoginRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.login()).thenReturn(byProjectKeyLoginRequestBuilder);

        // Run the test
        final CustomerSignInResult result = customerDataProviderUnderTest.getCustomerByLogin(csi);

        // Verify the results
    }

    @Test
    void testVc() {
        // Setup
        // Configure ProjectApiRoot.customers(...).
        final ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder = new ByProjectKeyCustomersRequestBuilder(
                ApiHttpClient.of("baseUri", HandlerStack.create(new HttpHandler(null))), "projectKey");
        when(customerDataProviderUnderTest.apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        // Run the test
        final Customer result = customerDataProviderUnderTest.vc("id");

        // Verify the results
    }
}
