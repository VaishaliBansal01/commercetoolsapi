package com.demo.CT.config;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CTConfiguration {


    @Bean
    public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("client_id")
                                .withClientSecret("client_secret")
                                .build(),
                       ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build("project-key");

        return apiRoot;
    }
}
