package com.demo.CT.customType;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypeDraft;
import com.demo.CT.config.CTConfiguration;

public class TypeDataProvider {
    ProjectApiRoot apiRoot = CTConfiguration.createApiClient();
    public Type createType(TypeDraft typeDraft) {
        return apiRoot.types().post(typeDraft).executeBlocking().getBody();
    }
}
