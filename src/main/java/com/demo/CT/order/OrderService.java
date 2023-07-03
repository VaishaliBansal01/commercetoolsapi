package com.demo.CT.order;

import com.commercetools.api.models.cart.*;
import com.commercetools.api.models.common.BaseAddress;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderFromCartDraft;
import com.commercetools.api.models.order.ShipmentState;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderDataProvider orderDataProvider = new OrderDataProvider();
    public Order createOrder(OrderDTO orderDTO) {
        BaseAddress ba =BaseAddress.builder()
                .country("IN").key("23").state("Rajasthan").country("IN")

                .build();
//        CartDraft.builder().shippingAddress(ba)
//                .currency("INR")
//                .taxMode(TaxMode.PLATFORM)
//                .country("IN")
//                .build();
        OrderFromCartDraft orderFromCartDraft =  OrderFromCartDraft
                .builder()
              //  .cart(cartResourceIdentifierBuilder -> (CartResourceIdentifierBuilder) cartResourceIdentifierBuilder.id("4dea6a7d-a6a4-43e2-bde6-1e71edadf11f")
               //         .build())
                .cart(CartResourceIdentifier.builder().id("3ff201b6-bd0c-4112-b040-63c400362251").build())
                .version(1l)
                .shipmentState(ShipmentState.READY)
                .orderNumber(orderDTO.getOrderNumber())
                .build();

        return orderDataProvider.createOrder(orderFromCartDraft);
    }
}
