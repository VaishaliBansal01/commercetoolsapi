package com.demo.CT.orderedit;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order_edit.OrderEdit;
import com.commercetools.api.models.order_edit.OrderEditApply;
import com.commercetools.api.models.order_edit.OrderEditDraft;
import com.demo.CT.config.CTConfiguration;

public class OrderEditDataProvider {

    ProjectApiRoot apiRoot = CTConfiguration.createApiClient();
    public OrderEdit createOrderEdit(OrderEditDraft orderEditDraft) {
        return apiRoot.orders().edits().post(orderEditDraft).executeBlocking().getBody();
    }

    public OrderEdit applyOrderEdit(OrderEditApply orderEditApply, String id)
    {
       return apiRoot.orders().edits().withId(id).apply().
               post(orderEditApply).executeBlocking().getBody();
    }
}
