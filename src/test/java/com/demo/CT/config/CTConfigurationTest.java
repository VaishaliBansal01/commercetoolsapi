package com.demo.CT.config;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.project.Project;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CTConfigurationTest {
   @Autowired
    CTConfiguration cTConfiguration;
    @Test
    void createApiClient() {
        ProjectApiRoot projectApiRoot = cTConfiguration.createApiClient();
        Project project = projectApiRoot.get().executeBlocking().getBody();
        assertEquals("hybris-test",project.getKey());
    }
}