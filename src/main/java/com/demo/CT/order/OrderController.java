package com.demo.CT.order;

import com.commercetools.api.models.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
   OrderService os;
    @PostMapping("/create-order")
    public Order createOrder(OrderDTO orderDTO)
    {
        return os.createOrder(orderDTO);
    }
}
