package com.demo.CT.config;
import com.commercetools.importapi.client.ProjectApiRoot;
import com.commercetools.importapi.defaultconfig.ImportApiRootBuilder;
import com.commercetools.importapi.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
public class CTConfigurationImport {
    @Bean
    public static ProjectApiRoot createImportApiClient() {
        final ProjectApiRoot importApiRoot = ImportApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("t_bO15QSdTZXoqnuQkpq5ei6")
                                .withClientSecret("hL8kpGc7SH-LYbFVxytif4r_zGdG1_0r")
                                .build(),
                        ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build("myntra-copy");
        return importApiRoot;
    }

}
