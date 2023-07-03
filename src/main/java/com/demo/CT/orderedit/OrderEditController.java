package com.demo.CT.orderedit;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderPagedQueryResponse;
import com.commercetools.api.models.order_edit.OrderEdit;
import com.commercetools.api.models.order_edit.OrderEditApply;
import com.commercetools.api.models.order_edit.OrderEditDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderEditController {
    @Autowired
    OrderEditService orderEditService= new OrderEditService();

    @Autowired
    ProjectApiRoot apiRoot;
    @PostMapping("/create-orderedit")
    public OrderEdit createOrderEdit(@RequestBody OrderEditDto editDto)
    {
        return orderEditService.createOrderEdit(editDto);
    }
    @PostMapping("/edits/{id}")
    public OrderEdit applyOrderEdit(@RequestBody OrderEditDto editDto, @PathVariable String id)
    {
     return orderEditService.applyOrderEdit(editDto,id);
    }

}
