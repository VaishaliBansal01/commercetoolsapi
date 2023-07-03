package com.demo.CT.importapi;

import com.commercetools.importapi.client.ProjectApiRoot;
import com.commercetools.importapi.models.importcontainers.ImportContainer;
import com.commercetools.importapi.models.importcontainers.ImportContainerDraft;
import com.commercetools.importapi.models.importrequests.ImportResponse;
import com.commercetools.importapi.models.importrequests.PriceImportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
public class ImportDao {
    @Autowired
    ProjectApiRoot root;
    public ImportContainer createImportContainer(ImportContainerDraft importContainerDraft) {
        return root.importContainers().post(importContainerDraft).executeBlocking().getBody();
    }


    public ImportResponse createPriceImportRequest(String key, PriceImportRequest priceImportRequest) {
        return root.prices().importContainers().withImportContainerKeyValue(key).post(priceImportRequest)
                .executeBlocking().getBody();
    }
}
