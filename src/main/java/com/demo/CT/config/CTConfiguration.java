package com.demo.CT.config;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CTConfiguration {
//   static String client_id = "6Y8G5HQZUZWmjUdjRB9fT7rg";
//   static String client_secret = "C6f4jmhJ3G3CWd8aUly9w010rzlRObBL";
//    static String projectKey = "new-vaishali-ct";

    @Bean
    public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("t_bO15QSdTZXoqnuQkpq5ei6")
                                .withClientSecret("hL8kpGc7SH-LYbFVxytif4r_zGdG1_0r")
                                .build(),
                       ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build("myntra-copy");

        return apiRoot;
    }
}
