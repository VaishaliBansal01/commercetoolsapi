package com.demo.CT.order;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderFromCartDraft;
import com.demo.CT.config.CTConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDataProvider {


    ProjectApiRoot apiRoot = CTConfiguration.createApiClient();
    public  Order createOrder(OrderFromCartDraft orderFromCartDraft) {
        return apiRoot.orders().post(orderFromCartDraft).executeBlocking().getBody();
    }
}
