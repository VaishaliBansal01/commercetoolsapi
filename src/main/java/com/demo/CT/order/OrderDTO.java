package com.demo.CT.order;

import lombok.Data;

@Data
public class OrderDTO {
    String id;
    Long version;
    private String orderNumber;
}
