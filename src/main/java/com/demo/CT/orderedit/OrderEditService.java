package com.demo.CT.orderedit;

import com.commercetools.api.models.order.StagedOrderUpdateAction;
import com.commercetools.api.models.order_edit.OrderEdit;
import com.commercetools.api.models.order_edit.OrderEditApply;
import com.commercetools.api.models.order_edit.OrderEditDraft;
import org.springframework.stereotype.Service;

@Service
public class OrderEditService {
    OrderEditDataProvider dataProvider = new OrderEditDataProvider();

    public OrderEdit createOrderEdit(OrderEditDto editDto) {
        OrderEditDraft orderEditDraft = OrderEditDraft.builder()
                .key(editDto.getKey())
                .resource(orderReferenceBuilder -> orderReferenceBuilder.id(editDto.getReferenceTypeId()))
                .stagedActions(StagedOrderUpdateAction.setCustomerEmailBuilder().email(editDto.getEmail()).build())

                .build();
        return dataProvider.createOrderEdit(orderEditDraft);
    }

    public OrderEdit applyOrderEdit(OrderEditDto editDto, String id) {
        OrderEditApply orderEditApply = OrderEditApply.builder()
                .editVersion(editDto.getEditVersion())
                .resourceVersion(editDto.getResourceVersion())
                .build();
        return dataProvider.applyOrderEdit(orderEditApply, id);
    }
}